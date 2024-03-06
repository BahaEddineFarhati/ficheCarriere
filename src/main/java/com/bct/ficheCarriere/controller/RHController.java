package com.bct.ficheCarriere.controller;
import com.bct.ficheCarriere.model.*;
import com.bct.ficheCarriere.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RHController {
    @Autowired
    TrainingAndCertifRepository trainingAndCertifRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    EmployeeDetailsRepository employeeDetailsRepo;
    @Autowired
    EmployeeDetailsService employeeDetailsService;
    @Autowired
    ResponsabilityRepository responsabilityRepository;
    @Autowired
    RewardRepository rewardRepository;
    @Autowired
    MobilityRepository mobilityRepository;
    @Autowired
    SkillRepository skillRepository;

    @PostMapping("/rh/insertLanguage")
    public String insertLanguage( @ModelAttribute("languageObject") Language language, Model model) {
        model.addAttribute("savedLanguage", language);
        languageRepository.insertLanguage(language);

        return "redirect:/rh/rhForm?id=" + language.getEmployeeID();
    }

    @PostMapping("/rh/updateLanguage")
    public String updateLanguage(Language language) {
        languageRepository.updateLanguage(language);
        return "redirect:/rh/rhForm?id=" + language.getEmployeeID();
    }

    @PostMapping("/rh/deleteLanguage")
    public String deleteLanguage(Language language) {
        languageRepository.deleteLanguage(language.getId());
        return "redirect:/rh/rhForm?id=" + language.getEmployeeID();

    }

    @PostMapping("/rh/insertTraining")
    public String insertTraining( @ModelAttribute("TrainingObject") Training training) {
        trainingAndCertifRepository.postTraining(training);
        return "redirect:/rh/rhForm?id=" + training.getEmployeeId();

    }
    @PostMapping("/rh/updateTraining")
    public String updateTraining(Training training) {
        trainingAndCertifRepository.updateTraining(training);
        return "redirect:/rh/rhForm?id=" + training.getEmployeeId();

    }
    @PostMapping("/rh/deleteTraining")
    public String deleteTraining(Training training) {
        trainingAndCertifRepository.deleteTraining(training.getId());
        return "redirect:/rh/rhForm?id=" + training.getEmployeeId();

    }
    @PostMapping("/rh/insertCertificate")
    public String insertCertificate( @ModelAttribute("CertificateObject") Certificate certificate) {
        trainingAndCertifRepository.postCertificate(certificate);
        return "redirect:/rh/rhForm?id=" + certificate.getEmployeeId();

    }
    @PostMapping("/rh/updateCertificate")
    public String updateCertificate(Certificate certificate) {
        trainingAndCertifRepository.updateCertificate(certificate);
        return "redirect:/rh/rhForm?id=" + certificate.getEmployeeId();

    }
    @PostMapping("/rh/deleteCertificate")
    public String deleteCertificate(Certificate certificate) {
        trainingAndCertifRepository.deleteCertificate(certificate.getId());
        return "redirect:/rh/rhForm?id=" + certificate.getEmployeeId();
    }
    @PostMapping("/rh/insertResponsability")
    public String insertResponsability( @ModelAttribute("ResponsabilityObject") Responsability responsability) {
        Responsability retrievedResponsability = responsabilityRepository.getResponsabilityByEmployeeId(responsability.getEmployeeId());
        if(retrievedResponsability.getDescription() == null){
            responsabilityRepository.insertResponsability(responsability);

        }else {
            responsabilityRepository.updateResponsability(responsability);
        }
        return "redirect:/rh/rhForm?id=" + responsability.getEmployeeId();

    }
    @PostMapping("/rh/insertReward")
    public String insertReward( @ModelAttribute("RewardObject") Reward reward) {
        Reward retrievedReward = rewardRepository.getRewardByEmployeeId(reward.getEmployeeId());
        if(retrievedReward.getDescription() == null){
            rewardRepository.insertReward(reward);

        }else {
            rewardRepository.updateReward(reward);
        }
        return "redirect:/rh/rhForm?id=" + reward.getEmployeeId();

    }
    @PostMapping("/rh/insertMobility")
    public String insertMobility( @ModelAttribute("MobilityObject") Mobility mobility) {
        Mobility retrievedMobility = mobilityRepository.getMobilityByEmployeeId(mobility.getEmployeeId());
        if(retrievedMobility.getEmployeeId() == null){
            mobilityRepository.insertMobility(mobility);

        }else {
            mobilityRepository.updateMobility(mobility);
        }
        return "redirect:/rh/rhForm?id=" + mobility.getEmployeeId();

    }

    @PostMapping("/rh/insertSkill")
    public String insertSkill( @ModelAttribute("SkillObject") Skill skill) {
        skillRepository.insertSkill(skill);
        return "redirect:/rh/rhForm?id=" + skill.getEmployeeId();

    }

    @PostMapping("/rh/deleteSkill")
    public String deleteSkill(Skill skill) {
        skillRepository.deleteSkill(skill.getId());
        return "redirect:/rh/rhForm?id=" + skill.getEmployeeId();

    }


    @GetMapping("/rh/rhForm")
    public String getRhFormByEmployee(@RequestParam("id") String id, Model model) {
        //System.out.println(id);
        List<Language> languageList = languageRepository.getLanguagesListByEmployeeId(id);
        List<Training> TrainingsList = trainingAndCertifRepository.getEmployeeTrainings(id);
        List<Certificate> CertificatesList = trainingAndCertifRepository.getEmployeeCertificates(id);
        List<Skill> skillsList = skillRepository.getSkillByEmployeeId(id);
        List<Skill> iTskillsList = skillRepository.getITSkillByEmployeeId(id);
        model.addAttribute("trainings",TrainingsList);
        model.addAttribute("certificates",CertificatesList);
        model.addAttribute("languages",languageList);
        model.addAttribute("skills",skillsList);
        model.addAttribute("iTskills",iTskillsList);
        model.addAttribute("employeeDetails", employeeDetailsService.getEmployeeDetails(id));
        model.addAttribute("imagePath", employeeDetailsService.getImagePath(id));
        Language language = new Language();
        language.setEmployeeID(id);
        model.addAttribute("languageObject", language);
        Training training = new Training();
        training.setEmployeeId(id);
        model.addAttribute("trainingObject", training);
        Certificate certificate = new Certificate();
        certificate.setEmployeeId(id);
        model.addAttribute("certificateObject",certificate);
        model.addAttribute("responsabilityObject",responsabilityRepository.getResponsabilityByEmployeeId(id));
        model.addAttribute("rewardObject",rewardRepository.getRewardByEmployeeId(id));
        model.addAttribute("mobilityObject",mobilityRepository.getMobilityByEmployeeId(id));
        Skill skill=new Skill();
        skill.setEmployeeId(id);
        model.addAttribute("skillObject",skill);
        return "rhForm";}
}

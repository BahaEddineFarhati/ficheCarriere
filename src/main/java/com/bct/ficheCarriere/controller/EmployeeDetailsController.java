package com.bct.ficheCarriere.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.bct.ficheCarriere.model.*;
import com.bct.ficheCarriere.repository.*;
import com.bct.ficheCarriere.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeDetailsController {
    @Autowired
    EmployeeDetailsRepository employeeDetailsRepo;

    @Autowired
    EmployeeDetailsService employeeDetailsService;
    @Autowired
    TrainingAndCertifRepository trainingAndCertifRepository;
    @Autowired
    StudyRepository studyRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    RewardRepository rewardRepository;
    @Autowired
    ResponsabilityRepository responsabilityRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    MobilityRepository mobilityRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    FunctionsRepository functionsRepository;

    @GetMapping("/employeeDetails")
    public String homePage(@RequestParam("id") String id, Model model) {
        model.addAttribute("employeeDetails", employeeDetailsService.getEmployeeDetails(id));
        model.addAttribute("imagePath", employeeDetailsService.getImagePath(id));
        model.addAttribute("trainings", trainingAndCertifRepository.getEmployeeTrainings(id));
        model.addAttribute("certifs", trainingAndCertifRepository.getEmployeeCertificates(id));
        model.addAttribute("positions", functionsRepository.getEmployeePositions(id));
        model.addAttribute("functions", functionsRepository.getEmployeeFunctions(id));
        model.addAttribute("projects",projectRepository.getProjectListByEmployeeId(id));
        model.addAttribute("conferences",studyRepository.getEmployeeConferences(id));
        model.addAttribute("publications",studyRepository.getEmployeePublications(id));
        model.addAttribute("languages", languageRepository.getLanguagesListByEmployeeId(id));
        model.addAttribute("mobility",mobilityRepository.getMobilityByEmployeeId(id));
        model.addAttribute("responsability",responsabilityRepository.getResponsabilityByEmployeeId(id));
        model.addAttribute("reward", rewardRepository.getRewardByEmployeeId(id));
        model.addAttribute("skills",skillRepository.getSkillByEmployeeId(id));
        model.addAttribute("iTskills",skillRepository.getITSkillByEmployeeId(id));


        return "vide";


    }
}
				
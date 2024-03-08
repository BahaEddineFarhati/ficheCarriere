/*package com.bct.ficheCarriere.controller;

import com.bct.ficheCarriere.model.Conference;
import com.bct.ficheCarriere.model.Publication;
import com.bct.ficheCarriere.repository.EmployeeDetailsRepository;
import com.bct.ficheCarriere.repository.StudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudyController {
    @Autowired
    StudyRepository studyRepository;

    @Autowired
    EmployeeDetailsRepository employeeDetailsRepo;

    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @PostMapping("/study/insertPublication")
    public String insertPublication( @ModelAttribute("publicationObject") Publication publication) {
        studyRepository.postPublication(publication);
        return "redirect:/study/studyForm?id=" + publication.getEmployeeId();

    }
    @PostMapping("/study/updatePublication")
    public String updatePublication(Publication publication) {
        studyRepository.updatePublication(publication);
        return "redirect:/study/studyForm?id=" + publication.getEmployeeId();

    }
    @PostMapping("/study/deletePublication")
    public String deletePublication(Publication publication) {
        studyRepository.deletePublication(publication.getId());
        return "redirect:/study/studyForm?id=" + publication.getEmployeeId();

    }
    @PostMapping("/study/insertConference")
    public String insertConference( @ModelAttribute("conferenceObject") Conference conference) {
        studyRepository.postConference(conference);
        return "redirect:/study/studyForm?id=" + conference.getEmployeeId();

    }
    @PostMapping("/study/updateConference")
    public String updateConference(Conference conference) {
        studyRepository.updateConference(conference);
        return "redirect:/study/studyForm?id=" + conference.getEmployeeId();

    }
    @PostMapping("/study/deleteConference")
    public String deleteConference(Conference conference) {
        studyRepository.deleteConference(conference.getId());
        return "redirect:/study/studyForm?id=" + conference.getEmployeeId();

    }
    @GetMapping("/study/studyForm")
    public String getStudyFormByEmployee(@RequestParam("id") String id, Model model) {
        //System.out.println(id);
        List<Publication> publicationsList = studyRepository.getEmployeePublications(id);
        List<Conference> conferencesList = studyRepository.getEmployeeConferences(id);
        model.addAttribute("publications",publicationsList);
        model.addAttribute("conferences",conferencesList);
        model.addAttribute("employeeDetails", employeeDetailsService.getEmployeeDetails(id));
        model.addAttribute("imagePath", employeeDetailsService.getImagePath(id));
        Publication publication = new Publication();
        publication.setEmployeeId(id);
        model.addAttribute("publicationObject", publication);
        Conference conference = new Conference();
        conference.setEmployeeId(id);
        model.addAttribute("conferenceObject",conference);
        return "studyForm";}
}
*/
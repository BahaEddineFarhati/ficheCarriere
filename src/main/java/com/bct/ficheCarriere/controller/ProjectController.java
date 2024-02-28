package com.bct.ficheCarriere.controller;

import com.bct.ficheCarriere.model.Conference;
import com.bct.ficheCarriere.model.Project;
import com.bct.ficheCarriere.repository.EmployeeDetailsRepository;
import com.bct.ficheCarriere.repository.ProjectRepository;
import com.bct.ficheCarriere.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeDetailsRepository employeeDetailsRepo;
    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @PostMapping("/project/insertProject")
    public String insertProject( @ModelAttribute("projectObject") Project project) {
        projectRepository.insertProject(project);
        return "redirect:/project/projectForm?id=" + project.getEmployeeId();
    }

    @PostMapping("/project/updateProject")
    public String updateProject(Project project) {
        projectRepository.updateProject(project);
        return "redirect:/project/projectForm?id=" + project.getEmployeeId();
    }

    @PostMapping("/project/deleteProject")
    public String deleteProject(Project project) {
        projectRepository.deleteProject(project.getId());
        return "redirect:/project/projectForm?id=" + project.getEmployeeId();

    }

    @GetMapping("/project/projectForm")
    public String getProjectFormByEmployee(@RequestParam("id") String id, Model model) {
        //System.out.println(id);
        List<Project> projectsList = projectRepository.getProjectListByEmployeeId(id);
        model.addAttribute("projects",projectsList);
        model.addAttribute("employeeDetails", employeeDetailsService.getEmployeeDetails(id));
        model.addAttribute("imagePath", employeeDetailsService.getImagePath(id));
        Project project = new Project();
        project.setEmployeeId(id);
        model.addAttribute("projectObject", project);
        Conference conference = new Conference();
        conference.setEmployeeId(id);
        model.addAttribute("conferenceObject",conference);
        return "projectForm";}
}


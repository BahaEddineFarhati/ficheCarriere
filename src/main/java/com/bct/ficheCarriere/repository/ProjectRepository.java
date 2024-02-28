package com.bct.ficheCarriere.repository;

import com.bct.ficheCarriere.model.Project;

import java.util.List;

public interface ProjectRepository {

    List<Project> getProjectListByEmployeeId(String employeeId);
    void insertProject(Project project);
    void updateProject(Project project);
    void deleteProject(Long id);
}

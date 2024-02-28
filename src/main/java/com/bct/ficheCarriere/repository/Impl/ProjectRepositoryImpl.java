package com.bct.ficheCarriere.repository.Impl;

import com.bct.ficheCarriere.model.Project;
import com.bct.ficheCarriere.model.Publication;
import com.bct.ficheCarriere.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Project> getProjectListByEmployeeId(String employeeId) {
        List<Map<String, Object>> projectsRows = jdbcTemplate.queryForList(" select P.ID, P.PROJECTNAME, P.PROJECTDESCRIPTION, P.PROJECTTYPE,P.EMPLOYEEROLE" + " from GRH.FCV_PROJECT P" + " where P.EMPLOYEEID = ?", employeeId);
        List<Project> projects = new ArrayList<Project>();
        for (Map<String, Object> projectsRow : projectsRows) {
            Project project = new Project();
            project.setId(Long.valueOf(String.valueOf(projectsRow.get("id"))));
            project.setProjectName(String.valueOf(projectsRow.get("PROJECTNAME")));
            project.setProjectType(String.valueOf(projectsRow.get("PROJECTTYPE")));
            String description = String.valueOf(projectsRow.get("PROJECTDESCRIPTION"));
            if (description.equals("null")){
                description="";
            }
            project.setProjectDescription(description);
            project.setEmployeeRole(String.valueOf(projectsRow.get("EMPLOYEEROLE")));
            projects.add(project);
        }
        return projects;
    }

    @Override
    public void insertProject(Project project) {
        jdbcTemplate.update("INSERT INTO FCV_PROJECT(PROJECTNAME,PROJECTDESCRIPTION,PROJECTTYPE,EMPLOYEEROLE,EMPLOYEEID)" +
                " values (?,?,?,?,?)",project.getProjectName(),project.getProjectDescription(),project.getProjectType(),project.getEmployeeRole(),project.getEmployeeId());
    }

    @Override
    public void updateProject(Project project) {
        jdbcTemplate.update("Update FCV_PROJECT set PROJECTNAME =? , PROJECTDESCRIPTION=?,PROJECTTYPE=?,EMPLOYEEROLE=? where id = ?"
                ,project.getProjectName(),project.getProjectDescription(),project.getProjectType(),project.getEmployeeRole(),project.getId());
    }

    @Override
    public void deleteProject(Long id) {
        jdbcTemplate.update("delete from FCV_PROJECT where id=?", id);
    }
}

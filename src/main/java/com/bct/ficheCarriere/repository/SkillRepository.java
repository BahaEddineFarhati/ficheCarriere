package com.bct.ficheCarriere.repository;

import com.bct.ficheCarriere.model.Skill;

import java.util.List;

public interface SkillRepository {
    List<Skill> getITSkillByEmployeeId(String employeeId);
    List<Skill> getSkillByEmployeeId(String employeeId);
    void insertSkill(Skill skill);
    void deleteSkill(Long id);
}

package com.bct.ficheCarriere.repository.Impl;

import com.bct.ficheCarriere.model.Skill;
import com.bct.ficheCarriere.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SkillRepositoryImpl implements SkillRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Skill> getITSkillByEmployeeId(String employeeId) {
        List<Map<String, Object>> skillsRows = jdbcTemplate.queryForList("select s.id,s.skilltype,s.skill from FCV_SKILL s where employeeId = ? and skilltype ='informatique'",employeeId);
        List<Skill> skills = new ArrayList<Skill>();
        for (Map<String, Object> skillsRow : skillsRows) {
            Skill skill = new Skill();
            skill.setId(Long.valueOf(String.valueOf(skillsRow.get("id"))));
            skill.setSkill(String.valueOf(skillsRow.get("skill")));
            skill.setSkillType(String.valueOf(skillsRow.get("skillType")));
            skills.add(skill);
        }
        return skills;
    }

    @Override
    public List<Skill> getSkillByEmployeeId(String employeeId) {
        List<Map<String, Object>> skillsRows = jdbcTemplate.queryForList("select s.id,s.skilltype,s.skill from FCV_SKILL s where employeeId = ? and skilltype ='technique'",employeeId);
        List<Skill> skills = new ArrayList<Skill>();
        for (Map<String, Object> skillsRow : skillsRows) {
            Skill skill = new Skill();
            skill.setId(Long.valueOf(String.valueOf(skillsRow.get("id"))));
            skill.setSkill(String.valueOf(skillsRow.get("skill")));
            skill.setSkillType(String.valueOf(skillsRow.get("skillType")));
            skills.add(skill);
        }
        return skills;
    }

    @Override
    public void insertSkill(Skill skill) {
        jdbcTemplate.update("INSERT INTO FCV_SKILL(SKILL,SKILLTYPE,EMPLOYEEID)" +
                " values (?,?,?)",skill.getSkill(),skill.getSkillType(),skill.getEmployeeId());
    }

    @Override
    public void deleteSkill(Long id) {
        jdbcTemplate.update("delete from FCV_SKILL where id=?", id);
    }
}

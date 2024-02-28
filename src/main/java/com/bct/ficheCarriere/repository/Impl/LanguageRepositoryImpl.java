package com.bct.ficheCarriere.repository.Impl;

import com.bct.ficheCarriere.model.Language;
import com.bct.ficheCarriere.model.Project;
import com.bct.ficheCarriere.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Language> getLanguagesListByEmployeeId(String employeeId) {
        List<Map<String, Object>> languagesRows = jdbcTemplate.queryForList("select L.ID, L.LANGUAGE, L.LANGUAGELEVEL from FCV_LANGUAGE L where L.EMPLOYEEID = ?",employeeId);
        List<Language> languages = new ArrayList<Language>();
        for (Map<String, Object> languagesRow : languagesRows) {
            Language language = new Language();
            language.setId(Long.valueOf(String.valueOf(languagesRow.get("id"))));
            language.setLanguage(String.valueOf(languagesRow.get("LANGUAGE")));
            language.setLanguageLevel(String.valueOf(languagesRow.get("LANGUAGELEVEL")));
            languages.add(language);

        }
        return languages;
    }

    @Override
    public void insertLanguage(Language language) {
        jdbcTemplate.update("INSERT INTO FCV_LANGUAGE(LANGUAGE,LANGUAGELEVEL,EMPLOYEEID)" +
                " values (?,?,?)",language.getLanguage(),language.getLanguageLevel(),language.getEmployeeID());
    }

    @Override
    public void updateLanguage(Language language) {
        jdbcTemplate.update("Update FCV_LANGUAGE set LANGUAGE =? , LANGUAGELEVEL=? where id = ?"
                ,language.getLanguage(),language.getLanguageLevel(),language.getId());
    }

    @Override
    public void deleteLanguage(Long id) {
        jdbcTemplate.update("delete from FCV_LANGUAGE where id=?", id);
    }
}

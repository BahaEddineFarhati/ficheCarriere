package com.bct.ficheCarriere.repository;

import com.bct.ficheCarriere.model.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getLanguagesListByEmployeeId(String employeeId);
    void insertLanguage(Language language);
    void updateLanguage(Language language);
    void deleteLanguage(Long id);
}

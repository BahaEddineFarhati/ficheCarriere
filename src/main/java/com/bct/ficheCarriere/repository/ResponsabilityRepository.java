package com.bct.ficheCarriere.repository;

import com.bct.ficheCarriere.model.Responsability;

import java.util.List;

public interface ResponsabilityRepository {

    Responsability getResponsabilityByEmployeeId(String employeeId);
    void insertResponsability(Responsability responsability);
    void updateResponsability(Responsability responsability);

    void deleteResponsability(String employeeId);
}

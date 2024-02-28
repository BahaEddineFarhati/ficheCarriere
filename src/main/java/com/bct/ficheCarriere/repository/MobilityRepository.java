package com.bct.ficheCarriere.repository;

import com.bct.ficheCarriere.model.Mobility;
import com.bct.ficheCarriere.model.Mobility;

import java.util.List;

public interface MobilityRepository {

   Mobility getMobilityByEmployeeId(String employeeId);
    void insertMobility(Mobility mobility);
    void updateMobility(Mobility mobility);
}

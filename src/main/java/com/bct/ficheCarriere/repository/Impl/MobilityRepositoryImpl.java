package com.bct.ficheCarriere.repository.Impl;

import com.bct.ficheCarriere.model.Mobility;
import com.bct.ficheCarriere.repository.MobilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MobilityRepositoryImpl implements MobilityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Mobility getMobilityByEmployeeId(String employeeId) {
        List<Map<String, Object>> mobilitysRows = jdbcTemplate.queryForList(" select R.ABROADDISPO,R.MOVEMENTDISPO,R.CHANGEMENTDISPO  from GRH.FCV_MOBILITY R" + " where R.EMPLOYEEID = ?", employeeId);
        Mobility mobility = new Mobility();
        if (!mobilitysRows.isEmpty()){
            String abroadDispo = String.valueOf(mobilitysRows.get(0).get("ABROADDISPO"));
            String movementDispo = String.valueOf(mobilitysRows.get(0).get("MOVEMENTDISPO"));
            String changementDispo = String.valueOf(mobilitysRows.get(0).get("CHANGEMENTDISPO"));

            if (abroadDispo.equals("null")){
                abroadDispo="";
            }
            if (movementDispo.equals("null")){
                movementDispo="";
            }
            if (changementDispo.equals("null")){
                changementDispo="";
            }
            mobility.setEmployeeId(employeeId);
            mobility.setAbroadDispo(abroadDispo);
            mobility.setChangementDispo(changementDispo);
            mobility.setMovementDispo(movementDispo);
        }
        return mobility;
    }

    @Override
    public void insertMobility(Mobility mobility) {
        jdbcTemplate.update("INSERT INTO FCV_MOBILITY(ABROADDISPO,MOVEMENTDISPO,CHANGEMENTDISPO,EMPLOYEEID)" +
                " values (?,?,?,?)",mobility.getAbroadDispo(),mobility.getMovementDispo(),mobility.getChangementDispo(),mobility.getEmployeeId());
    }

    @Override
    public void updateMobility(Mobility mobility) {
        jdbcTemplate.update("Update FCV_MOBILITY set ABROADDISPO =? , MOVEMENTDISPO=?, CHANGEMENTDISPO=? where EMPLOYEEID = ?"
                ,mobility.getAbroadDispo(),mobility.getMovementDispo(),mobility.getChangementDispo(),mobility.getEmployeeId());
    }
}

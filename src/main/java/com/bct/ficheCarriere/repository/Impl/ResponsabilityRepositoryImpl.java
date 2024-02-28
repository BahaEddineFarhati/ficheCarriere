package com.bct.ficheCarriere.repository.Impl;

import com.bct.ficheCarriere.model.Responsability;
import com.bct.ficheCarriere.model.Responsability;
import com.bct.ficheCarriere.repository.ResponsabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ResponsabilityRepositoryImpl implements ResponsabilityRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Responsability getResponsabilityByEmployeeId(String employeeId) {
        List<Map<String, Object>> responsabilitysRows = jdbcTemplate.queryForList(" select R.DESCRIPTION  from GRH.FCV_RESPONSABILITY R" + " where R.EMPLOYEEID = ?", employeeId);
            Responsability responsability = new Responsability();
            if (!responsabilitysRows.isEmpty()){
                System.out.println(String.valueOf(responsabilitysRows.get(0).get("DESCRIPTION")));
                String description = String.valueOf(responsabilitysRows.get(0).get("DESCRIPTION"));
                if (description.equals("null")){
                    description="";
                }
                responsability.setDescription(description);
            }
        return responsability;
    }

    @Override
    public void insertResponsability(Responsability responsability) {
        jdbcTemplate.update("INSERT INTO FCV_RESPONSABILITY(DESCRIPTION,EMPLOYEEID)" +
                " values (?,?)",responsability.getDescription(),responsability.getEmployeeId());
    }

    @Override
    public void updateResponsability(Responsability responsability) {
        jdbcTemplate.update("Update FCV_RESPONSABILITY set DESCRIPTION =? where EMPLOYEEID = ?"
                ,responsability.getDescription(),responsability.getEmployeeId());
    }

    @Override
    public void deleteResponsability(String employeeId) {
        jdbcTemplate.update("delete from FCV_RESPONSABILITY where EMPLOYEEID=?", employeeId);
    }
}

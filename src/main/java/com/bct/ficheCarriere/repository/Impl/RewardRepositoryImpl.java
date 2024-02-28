package com.bct.ficheCarriere.repository.Impl;

import com.bct.ficheCarriere.model.Reward;
import com.bct.ficheCarriere.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RewardRepositoryImpl implements RewardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Reward getRewardByEmployeeId(String employeeId) {
        List<Map<String, Object>> rewardsRows = jdbcTemplate.queryForList(" select R.DESCRIPTION  from GRH.FCV_REWARD R" + " where R.EMPLOYEEID = ?", employeeId);
        Reward reward = new Reward();
        if (!rewardsRows.isEmpty()){
            String description = String.valueOf(rewardsRows.get(0).get("DESCRIPTION"));
            if (description.equals("null")){
                description="";
            }
            reward.setDescription(description);
        }
        return reward;
    }

    @Override
    public void insertReward(Reward reward) {
        jdbcTemplate.update("INSERT INTO FCV_REWARD(DESCRIPTION,EMPLOYEEID)" +
                " values (?,?)",reward.getDescription(),reward.getEmployeeId());
    }

    @Override
    public void updateReward(Reward reward) {
        jdbcTemplate.update("Update FCV_REWARD set DESCRIPTION =? where EMPLOYEEID = ?"
                ,reward.getDescription(),reward.getEmployeeId());
    }
}

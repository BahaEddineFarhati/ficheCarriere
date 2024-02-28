package com.bct.ficheCarriere.repository;

import com.bct.ficheCarriere.model.Reward;

public interface RewardRepository {
    Reward getRewardByEmployeeId(String employeeId);
    void insertReward(Reward reward);
    void updateReward(Reward reward);

}

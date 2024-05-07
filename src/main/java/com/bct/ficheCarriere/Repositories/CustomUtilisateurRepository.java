package com.bct.ficheCarriere.Repositories;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class CustomUtilisateurRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void executeCustomInsertQuery(String password, String username, Long id, Long roleId) {
        String sql = "INSERT INTO utilisateur (password, username, id, role_id) VALUES (?, ?, ?, ?)";
        entityManager.createNativeQuery(sql)
                .setParameter(1, password)
                .setParameter(2, username)
                .setParameter(3, id)
                .setParameter(4, roleId)
                .executeUpdate();
    }


    @Transactional
    public void executeCustomDeleteQuery(String userId) {
        String sql = "DELETE FROM utilisateur WHERE id = ?";
        entityManager.createNativeQuery(sql)
                .setParameter(1, userId)
                .executeUpdate();
    }

}

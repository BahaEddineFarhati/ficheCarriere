package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Token;
import com.bct.ficheCarriere.ModelPFE.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {


    @Query("""
select t from Token t inner join Utilisateur u on t.user.Id = u.Id
where t.user.Id = :userId and t.loggedOut = false
""")
    List<Token> findAllTokensByUser(Long userId);

    Optional<Token> findByToken(String token);

    boolean existsByToken(String token);


 // This annotation is required for delete queries

    void deleteAllByUserId(Long userId);

    void deleteAllByUser(Utilisateur user);

}

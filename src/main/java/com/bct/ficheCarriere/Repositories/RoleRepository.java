package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Optional<Role> findBynom(String name);
}

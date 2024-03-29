package com.bct.ficheCarriere.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bct.ficheCarriere.ModelPFE.Role;
import com.bct.ficheCarriere.Repositories.RoleRepository;

@RestController
@RequestMapping("/Role")
public class RoleController {
	
	    @Autowired
	    private RoleRepository roleRepository;


	    @GetMapping("/getAll")
	    public List<Role> getAllRoles() {
	        return roleRepository.findAll();
	    }

	  
	    @GetMapping("/getRole/{id}")
	    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
	        return roleRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	
	    @PostMapping("/addRole")
	    public ResponseEntity<Role> createRole(@RequestBody Role role) {
	        Role savedRole = roleRepository.save(role);
	        return ResponseEntity.ok(savedRole);
	    }

	   
	    @PutMapping("/updateRole/{id}")
	    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
	        if (roleRepository.existsById(id)) {
	            role.setId(id);
	            Role updatedRole = roleRepository.save(role);
	            return ResponseEntity.ok(updatedRole);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Delete a role by ID
	    @DeleteMapping("/deleteRole/{id}")
	    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
	        if (roleRepository.existsById(id)) {
	            roleRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}




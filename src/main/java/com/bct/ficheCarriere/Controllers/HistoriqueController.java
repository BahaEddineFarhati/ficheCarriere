package com.bct.ficheCarriere.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bct.ficheCarriere.ModelPFE.Historique;
import com.bct.ficheCarriere.Repositories.HistoriqueRepository;

@RestController
@RequestMapping("/historiques")
public class HistoriqueController {
	
	    @Autowired
	    private HistoriqueRepository historiqueRepository;

	    @PostMapping("/add")
	    public Historique addHistorique(@RequestBody Historique historique) {
	        return historiqueRepository.save(historique);
	    }

	
	    @GetMapping("/all")
	    public List<Historique> getAllHistoriques() {
	        return historiqueRepository.findAll();
	    }

	   
	    @GetMapping("/{id}")
	    public Optional<Historique> getHistoriqueById(@PathVariable Long id) {
	        return historiqueRepository.findById(id);
	    }

	
	    @PutMapping("/{id}")
	    public Historique updateHistorique(@PathVariable Long id, @RequestBody Historique updatedHistorique) {
	        updatedHistorique.setId(id);
	        return historiqueRepository.save(updatedHistorique);
	    }


	    @DeleteMapping("/{id}")
	    public void deleteHistorique(@PathVariable Long id) {
	        historiqueRepository.deleteById(id);
	    }
	}




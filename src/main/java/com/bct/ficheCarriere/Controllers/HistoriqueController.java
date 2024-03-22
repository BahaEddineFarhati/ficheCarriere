package com.bct.ficheCarriere.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bct.ficheCarriere.ModelPFE.Historique;
import com.bct.ficheCarriere.service.HistoriqueService;

@RestController
@RequestMapping("/Historique")
public class HistoriqueController {
	

	    private HistoriqueService historiqueService;

	    @Autowired
	    public HistoriqueController(HistoriqueService historiqueService) {
	        this.historiqueService = historiqueService;
	    }

	    @PostMapping("/addHistorique")
	    public ResponseEntity<Historique> addHistorique(@RequestBody Historique historique) {
	        Historique savedHistorique = historiqueService.createHistorique(historique);
	        return new ResponseEntity<>(savedHistorique, HttpStatus.CREATED);
	    }

	    @GetMapping("/getAllHistoriques")
	    public ResponseEntity<List<Historique>> getAllHistoriques() {
	        List<Historique> historiques = historiqueService.getAllHistoriques();
	        return new ResponseEntity<>(historiques, HttpStatus.OK);
	    }

	    @GetMapping("/getHistorique/{id}")
	    public ResponseEntity<Historique> getHistoriqueById(@PathVariable Long id) {
	        Optional<Historique> historique = historiqueService.getHistoriqueById(id);
	        return historique.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/updateHistorique/{id}")
	    public ResponseEntity<Historique> updateHistorique(@PathVariable Long id, @RequestBody Historique updatedHistorique) {
	        Historique updated = historiqueService.updateHistorique(id, updatedHistorique);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/deleteHistorique/{id}")
	    public ResponseEntity<Void> deleteHistorique(@PathVariable Long id) {
	        historiqueService.deleteHistoriqueById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}

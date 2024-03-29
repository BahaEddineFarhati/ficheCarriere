package com.bct.ficheCarriere.Controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.dto.EmployeBaseInformation;
import com.bct.ficheCarriere.ModelPFE.dto.historiqueDTO;
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
	
	 @Autowired
	    private HistoriqueService historiqueService;

	   
	    public HistoriqueController(HistoriqueService historiqueService) {
	        this.historiqueService = historiqueService;
	    }

	    @PostMapping("/addHistorique")
	    public ResponseEntity<Historique> addHistorique(@RequestBody Historique historique) {
	        Historique savedHistorique = historiqueService.createHistorique(historique);
	        return new ResponseEntity<>(savedHistorique, HttpStatus.CREATED);
	    }

	    @GetMapping("/getHistoriques")
	    public ResponseEntity<List<Historique>> getHistoriques() {
	        List<Historique> historiques = historiqueService.getAllHistoriques();
	        return new ResponseEntity<>(historiques, HttpStatus.OK);
	    }


	@GetMapping("/getAllHistoriques")
	public ResponseEntity<List<historiqueDTO>> getAllHistoriques() {
		List<Historique> historiques = historiqueService.getAllHistoriques();

		List<historiqueDTO> His = historiques.stream()
				.map(this::mapToDTO)
				.toList();

		return new ResponseEntity<>(His, HttpStatus.OK);
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


	private historiqueDTO mapToDTO(Historique his) {
		historiqueDTO hisDto = new historiqueDTO();
		hisDto.setNom(his.getUtilisateur().getNom());
		hisDto.setPrenom(his.getUtilisateur().getPrenom());
		hisDto.setDepartement(his.getUtilisateur().getDepartement().getAbreviation());
		hisDto.setMatricule(his.getUtilisateur().getMatricule());
		hisDto.setAdresseIp(his.getAdresseIp());
		hisDto.setId(his.getId());
		hisDto.setDate(his.getDate());
		hisDto.setRole(his.getUtilisateur().getRole().getNom());
		return hisDto;
	}
	}

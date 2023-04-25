package tn.enicarthage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import tn.enicarthage.model.DemandeAjout;
import tn.enicarthage.model.DemandeMaj;
import tn.enicarthage.model.Diplomee;
import tn.enicarthage.service.demandeMajService;
import tn.enicarthage.service.diplomeeService;

@RestController
@RequestMapping("/demandeMaj")
@CrossOrigin(origins="http://localhost:4200")
public class demandeMajController {
	
	@Autowired
	private demandeMajService demandeMajService;
	@Autowired
	private diplomeeService diplomeeService;
	
	@PostMapping("/create")
    public ResponseEntity<DemandeMaj> createDemandeMaj(@RequestBody Diplomee diplomee) {
		DemandeMaj demandeMaj = new DemandeMaj();
		demandeMaj.setIdDiplomee(diplomee.getId());
		demandeMaj.setTravail(diplomee.getTravail());
		demandeMaj.setNumTel(diplomee.getNumTel());
		demandeMaj.setEmail(diplomee.getEmail());
		DemandeMaj dem = demandeMajService.getDemandeByIdDiplomee(demandeMaj.getIdDiplomee());
		if (dem != null) {
			throw new ResponseStatusException(HttpStatus.FOUND, "Vous avez déjà envoyé une demande !");
			}
        return demandeMajService.createDemandeMaj(demandeMaj);
    }
	
	@GetMapping("/all")
	public List<DemandeMaj> getAllDemandesMaj() {
		List<DemandeMaj> list = demandeMajService.getAllDemandesMaj();
		if (list.isEmpty() ) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas de demande !");
			}
		return list;
	}
	
	@PostMapping("/accept/{id}")
    public ResponseEntity<Diplomee> confirmDemandeMaj(@PathVariable long id, @RequestBody Diplomee diplomee) {
		demandeMajService.deleteDemendeMaj(id);
        return diplomeeService.updateDiplomee(diplomee);
    }
	
	@PostMapping("/reject")
    public void rejectDemandeMaj(@RequestBody long id) {
		demandeMajService.deleteDemendeMaj(id);
    }
	
	

}

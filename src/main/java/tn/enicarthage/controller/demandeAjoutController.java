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
import tn.enicarthage.service.demandeAjoutService;
import tn.enicarthage.service.diplomeeService;

@RestController
@RequestMapping("/demandeAjout")
@CrossOrigin(origins="http://localhost:4200")
public class demandeAjoutController {
	
	@Autowired
	private demandeAjoutService demandeAjoutService;
	@Autowired
	private diplomeeService diplomeeService;
	
	@PostMapping("/create")
    public ResponseEntity<DemandeAjout> createDemandeAjout(@RequestBody DemandeAjout demandeAjout) {
		DemandeAjout dem = demandeAjoutService.getDemandeByNomAndPrenomAndSexeAndDateNaiss(demandeAjout);
		Diplomee dip = diplomeeService.searchDiplomee(demandeAjout);
        if (dip != null) {
        	System.out.println("diplômé existe déjà !");
    		throw new ResponseStatusException(HttpStatus.FOUND, "Diplômé existe déjà !");        	
        }
        if (dem != null) {
        	System.out.println("Vous avez déjà envoyé une demande !");
    		throw new ResponseStatusException(HttpStatus.FOUND, "Vous avez déjà envoyé une demande !");        	
        }
        return demandeAjoutService.createDemandeAjout(demandeAjout);
    }
	
	@GetMapping("/all")
	public List<DemandeAjout> getAllDemandesAjout() {
		List<DemandeAjout> list = demandeAjoutService.getAllDemandesAjout();
		if (list.isEmpty() ) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas de demande !");
			}
		return list;
	}
	
	@PostMapping("/accept/{id}")
    public ResponseEntity<Diplomee> confirmDemandeAjout(@PathVariable long id, @RequestBody Diplomee diplomee) {
		demandeAjoutService.deleteDemendeAjout(id);
        return diplomeeService.createDiplomee(diplomee);
    }
	
	@PostMapping("/reject")
    public void acceptDemandeAjout(@RequestBody Diplomee diplomee) {
		demandeAjoutService.deleteDemendeAjout(diplomee.getId());
    }

}

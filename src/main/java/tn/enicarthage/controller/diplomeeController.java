package tn.enicarthage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import tn.enicarthage.model.ChartData;
import tn.enicarthage.model.Diplome;
import tn.enicarthage.model.Diplomee;
import tn.enicarthage.service.diplomeeService;

@RestController
@RequestMapping("/diplomee")
@CrossOrigin(origins="http://localhost:4200")

public class diplomeeController {
	
	@Autowired
	private diplomeeService diplomeeService;
	
	@PostMapping("/create")
    public ResponseEntity<Diplomee> createDiplomee(@RequestBody Diplomee diplomee) {
		System.out.println(diplomee);
		Diplomee dip = diplomeeService.searchDiplomee(diplomee);
        if (dip != null) {
    		throw new ResponseStatusException(HttpStatus.FOUND, "Diplômé existe déjà !");        	
        }
        return diplomeeService.createDiplomee(diplomee);
    }

	@GetMapping("/all")
	public List<Diplomee> getAllDiplomees() {
		return diplomeeService.getAllDiplomees();
	}
	
	@GetMapping("/promotion/{specialite}")
	public List<String> getPromotion(@PathVariable long specialite) {
		return diplomeeService.getDistinctPromotionBySpecialite(specialite);
	}
	
	@GetMapping("/{specialite}/{promotion}")
	public List<Diplomee> getPromotion(@PathVariable long specialite,@PathVariable String promotion) {
		return diplomeeService.getDiplomeeBySpecialiteAndPromotion(specialite,promotion);
	}
	
	@GetMapping("/{id}")
	public Diplomee getDiplomee(@PathVariable long id) {
		return diplomeeService.getDiplomeeById(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Diplomee> updateDiplomee(@RequestBody Diplomee diplomee) {
        return diplomeeService.updateDiplomee(diplomee);
    }
	
	@PostMapping("/search")
    public Diplomee searchDiplomee(@RequestBody Diplomee diplomee) {
		Diplomee dip = diplomeeService.searchDiplomee(diplomee);
		if (dip == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Diplômé introuvable !");
			}
		return dip;
    }	
	
	//@GetMapping("/statistics/{specialite}/{travail}")
	//public int countDiplomeeParSpecialiteTravail(@PathVariable long specialite, @PathVariable String travail) {
	//	return diplomeeService.countDiplomeeParSpecialiteTravail(specialite,travail);
	//}
	
	@GetMapping("/statistics/chartDiplome/{travail}/{promotion}")
	public List<ChartData> getDiplomeesChartDataDiplome(@PathVariable String travail, @PathVariable String promotion) {
		return diplomeeService.getDiplomeesChartDataDiplome(travail,promotion);
	}
	
	@PostMapping("/statistics/chartSpecialite/{travail}")
	public List<ChartData> getDiplomeesChartDataSpecialite(@RequestBody Diplome diplome, @PathVariable String travail) {
		return diplomeeService.getDiplomeesChartDataSpecialite(diplome, travail);
	}
	
}

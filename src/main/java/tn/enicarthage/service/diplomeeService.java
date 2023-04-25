package tn.enicarthage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import tn.enicarthage.model.ChartData;
import tn.enicarthage.model.DemandeAjout;
import tn.enicarthage.model.DemandeMaj;
import tn.enicarthage.model.Diplome;
import tn.enicarthage.model.Diplomee;
import tn.enicarthage.model.Specialite;
import tn.enicarthage.repo.diplomeeRepo;
import tn.enicarthage.repo.diplomeRepo;
import tn.enicarthage.repo.specialiteRepo;


@Service
public class diplomeeService {

	@Autowired
	private diplomeeRepo repo;
	@Autowired
	private specialiteRepo specialiteRepo;
	@Autowired
	private diplomeRepo diplomeRepo;
	
	public ResponseEntity<Diplomee> createDiplomee(Diplomee diplomee) {
        return ResponseEntity.ok(repo.save(diplomee));
    }
	
	public List<Diplomee> getAllDiplomees() {
		return repo.findAll();
	}
	
	public List<String> getDistinctPromotionBySpecialite(long specialite) {
        return repo.findDistinctPromotionBySpecialite(specialite);
    }
	
	public List<Diplomee> getDiplomeeBySpecialiteAndPromotion(long specialite, String promotion) {
        return repo.findDiplomeeBySpecialiteAndPromotion(specialite,promotion);
    }
	
	public Diplomee getDiplomeeById(long id) {
        return repo.findDiplomeeById(id);
    }
	
	public ResponseEntity<Diplomee> updateDiplomee(Diplomee diplomee) {
		Optional<Diplomee> optionalDiplomee = repo.findById(diplomee.getId());
        if (optionalDiplomee.isPresent()) {
        	Diplomee existingDiplomee = optionalDiplomee.get();
            existingDiplomee.setTravail(diplomee.getTravail());
            existingDiplomee.setEmail(diplomee.getEmail());
            existingDiplomee.setNumTel(diplomee.getNumTel());
            repo.save(existingDiplomee);
            return new ResponseEntity<>(existingDiplomee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	public Diplomee searchDiplomee(Diplomee diplomee) {
        return repo.findDiplomeeByNomAndPrenomAndSexeAndDateNaiss(diplomee.getNom(), diplomee.getPrenom(), diplomee.getSexe(), diplomee.getDateNaiss());
    }
	
	public Diplomee searchDiplomee(DemandeAjout demande) {
        return repo.findDiplomeeByNomAndPrenomAndSexeAndDateNaiss(demande.getNom(), demande.getPrenom(), demande.getSexe(), demande.getDateNaiss());
    }
	
	public int countDiplomeeParSpecialitesTravail(List<Specialite> specialites, String travail, String promotion) {
		List<Long> specs = new ArrayList<>();
		for (Specialite spec : specialites) {
		specs.add(spec.getId());
		}
		return repo.countDiplomeeParDiplomeTravail(specs,travail,promotion);
	}
	
	public int countDiplomeeParSpecialite(long specialite) {
		return repo.countDiplomeeParSpecialite(specialite);
	}
	
	
	public List<ChartData> getDiplomeesChartDataDiplome(String travail, String promotion) {
        List<Diplome> dips = new ArrayList<>();
        //List<String> diplomes = new ArrayList<>();
        //List<Integer> nbDiplomees = new ArrayList<>();
        List<ChartData> chartData = new ArrayList<>();
        dips.addAll(diplomeRepo.findAll());
        for (Diplome diplome : dips) {
        	ChartData chart = new ChartData();
        	List<Specialite> specialites = new ArrayList<>();
        	chart.setDiplome(diplome.getNom());
        	specialites.addAll(specialiteRepo.findSpecialiteByDiplome(diplome.getId()));
            chart.setNbDiplomees(countDiplomeeParSpecialitesTravail(specialites,travail,promotion));
            chartData.add(chart);
        }
        return chartData;
    }
	
	public List<ChartData> getDiplomeesChartDataSpecialite(Diplome diplome, String travail) {
		List<ChartData> chartData = new ArrayList<>();
		List<Specialite> specialites = new ArrayList<>();
		specialites.addAll(specialiteRepo.findSpecialiteByDiplome(diplome.getId()));
		for(Specialite specialite : specialites) {
			ChartData chart = new ChartData();
			chart.setDiplome(specialite.getNom());
			chart.setNbDiplomees(repo.countDiplomeeParSpecialiteTravail(specialite.getId(), travail));
			chartData.add(chart);
		}
		return chartData;
    }
	

}

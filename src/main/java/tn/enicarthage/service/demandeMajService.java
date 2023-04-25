package tn.enicarthage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.enicarthage.model.DemandeAjout;
import tn.enicarthage.model.DemandeMaj;
import tn.enicarthage.repo.demandeMajRepo;

@Service
public class demandeMajService {

	@Autowired
	private demandeMajRepo demandeMajRepo;
	
	public ResponseEntity<DemandeMaj> createDemandeMaj(DemandeMaj demandeMaj) {
        return ResponseEntity.ok(demandeMajRepo.save(demandeMaj));
    }

	public List<DemandeMaj> getAllDemandesMaj() {
		return demandeMajRepo.findAll();
	}
	
	public void deleteDemendeMaj(Long id) {
		demandeMajRepo.deleteById(id);
    }
	
	public DemandeMaj getDemandeByIdDiplomee(long idDiplomee) {
		return demandeMajRepo.findDemandeMajByIdDiplomee(idDiplomee);		
	}

}

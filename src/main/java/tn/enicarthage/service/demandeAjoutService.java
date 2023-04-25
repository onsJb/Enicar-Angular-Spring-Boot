package tn.enicarthage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.enicarthage.model.DemandeAjout;
import tn.enicarthage.repo.demandeAjoutRepo;

@Service
public class demandeAjoutService {
	
	@Autowired
	private demandeAjoutRepo demandeAjoutRepo;
	
	
	public ResponseEntity<DemandeAjout> createDemandeAjout(DemandeAjout demandeAjout) {
        return ResponseEntity.ok(demandeAjoutRepo.save(demandeAjout));
    }
	
	public List<DemandeAjout> getAllDemandesAjout() {
		return demandeAjoutRepo.findAll();
	}
	
	public void deleteDemendeAjout(Long id) {
		demandeAjoutRepo.deleteById(id);
    }
	
	public DemandeAjout getDemandeByNomAndPrenomAndSexeAndDateNaiss(DemandeAjout demande) {
		return demandeAjoutRepo.findDemandeByNomAndPrenomAndSexeAndDateNaiss(demande.getNom(),demande.getPrenom(),demande.getSexe(),demande.getDateNaiss());
	}

}

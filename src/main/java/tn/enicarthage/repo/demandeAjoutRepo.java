package tn.enicarthage.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.model.DemandeAjout;

@Repository
public interface demandeAjoutRepo extends JpaRepository<DemandeAjout, Long> {

	DemandeAjout findDemandeByNomAndPrenomAndSexeAndDateNaiss(String nom, String prenom,String sexe,Date dateNaiss);
}

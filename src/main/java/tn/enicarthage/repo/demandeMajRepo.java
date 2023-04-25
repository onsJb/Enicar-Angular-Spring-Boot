package tn.enicarthage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.model.DemandeMaj;

@Repository
public interface demandeMajRepo extends JpaRepository<DemandeMaj, Long> {
	
	DemandeMaj findDemandeMajByIdDiplomee(long idDiplomee);	

}

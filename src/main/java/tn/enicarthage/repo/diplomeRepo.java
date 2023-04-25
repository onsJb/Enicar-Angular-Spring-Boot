package tn.enicarthage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.model.Diplome;

@Repository
public interface diplomeRepo extends JpaRepository<Diplome, Long> {
	
	Diplome findDiplomeById(long id);

}

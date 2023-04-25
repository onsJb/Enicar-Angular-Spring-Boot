package tn.enicarthage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.enicarthage.model.Specialite;

@Repository
public interface specialiteRepo extends JpaRepository<Specialite, Long> {
	
	List<Specialite> findAll();
	
	List<Specialite> findSpecialiteByDiplome(long id);
	
	Specialite findSpecialiteById(long id);
	
}

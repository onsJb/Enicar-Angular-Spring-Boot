package tn.enicarthage.repo;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.enicarthage.model.Diplomee;
import tn.enicarthage.model.Specialite;

@Repository
public interface diplomeeRepo extends JpaRepository<Diplomee, Long>{
	
	@Query("SELECT DISTINCT d.promotion FROM Diplomee d WHERE d.specialite = ?1")
    List<String> findDistinctPromotionBySpecialite(long specialite);
	
	List<Diplomee> findDiplomeeBySpecialiteAndPromotion(long specialite, String promotion);
	
	Diplomee findDiplomeeById(long id);
	
	Diplomee findDiplomeeByNomAndPrenomAndSexeAndDateNaiss(String nom, String prenom, String sexe, Date dateNaiss);
	
	@Query("SELECT count(d) FROM Diplomee d WHERE d.specialite = ?1 AND d.travail = ?2")
	int countDiplomeeParSpecialiteTravail(long specialite, String travail);
	
	@Query("SELECT count(d) FROM Diplomee d WHERE d.specialite = ?1")
	int countDiplomeeParSpecialite(long specialite);
	
	@Query("SELECT count(d) FROM Diplomee d WHERE d.specialite IN ?1 AND d.travail = ?2 AND d.promotion =?3")
	int countDiplomeeParDiplomeTravail(List<Long> specialite,String travail,String promotion);
	
	
}

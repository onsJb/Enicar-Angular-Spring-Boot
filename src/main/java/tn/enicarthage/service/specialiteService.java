package tn.enicarthage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.model.Specialite;
import tn.enicarthage.repo.specialiteRepo;

@Service
public class specialiteService {
	
	@Autowired
	private specialiteRepo repo;
	
	public List<Specialite> getSpecialite(Long id) {
		 return (List<Specialite>) repo.findSpecialiteByDiplome(id);
	 }
	
	public Specialite getSpecialiteById(Long id) {
		 return (Specialite) repo.findSpecialiteById(id);
	 }

}

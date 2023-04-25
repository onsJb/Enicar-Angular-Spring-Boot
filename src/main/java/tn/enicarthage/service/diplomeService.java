package tn.enicarthage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.model.Diplome;
import tn.enicarthage.repo.diplomeRepo;

@Service
public class diplomeService {
	
	@Autowired
	private diplomeRepo repo;

	
	public List<Diplome> getAllDiplomes() {
		return repo.findAll();
	}

	public Diplome getDiplomeById(Long id) {
		 return (Diplome) repo.findDiplomeById(id);
	 }
}

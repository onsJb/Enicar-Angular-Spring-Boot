package tn.enicarthage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Specialite;
import tn.enicarthage.service.specialiteService;

@RestController
@RequestMapping("/specialite")
@CrossOrigin(origins="http://localhost:4200")
public class specialiteController {

	@Autowired
	private specialiteService specialiteService;
	
	 @GetMapping("/diplome/{id}")
	 public List<Specialite> getSpecialite(@PathVariable Long id) {
		 return specialiteService.getSpecialite(id);
	 }
	 
	 @GetMapping("/{id}")
	 public Specialite getSpecialiteById(@PathVariable Long id) {
		 return specialiteService.getSpecialiteById(id);
	 }
	 
}

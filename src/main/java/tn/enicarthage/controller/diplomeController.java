package tn.enicarthage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Diplome;
import tn.enicarthage.service.diplomeService;

@RestController
@RequestMapping("/diplome")
@CrossOrigin(origins="http://localhost:4200")
public class diplomeController {
	
	@Autowired
	private diplomeService diplomeService;
	
	@GetMapping("/all")
	public List<Diplome> getAllDiplomes() {
		return diplomeService.getAllDiplomes();
	}
	
	 @GetMapping("/{id}")
	 public Diplome getDiplomeById(@PathVariable Long id) {
		 return diplomeService.getDiplomeById(id);
	 }

}

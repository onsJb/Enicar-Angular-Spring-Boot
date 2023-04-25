package tn.enicarthage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import tn.enicarthage.model.Diplomee;
import tn.enicarthage.model.User;
import tn.enicarthage.service.userService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
@AllArgsConstructor
@NoArgsConstructor

public class userController {
	
	@Autowired
	private userService userService;
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User userData){
		User user = userService.loginUser(userData);
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "username et/ou mot de passe incorrect(s)");
			}
		return user;

	}

}

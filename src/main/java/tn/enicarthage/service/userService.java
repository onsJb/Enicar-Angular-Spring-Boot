package tn.enicarthage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import tn.enicarthage.model.User;
import tn.enicarthage.repo.userRepo;

@Service
public class userService {
	
	@Autowired
	private userRepo repo;
	
	public User loginUser(User userData){
		User user = repo.findUserByUsername(userData.getUsername());
		if ((user == null)||!(user.getPassword().equals(userData.getPassword()))) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "username et/ou mot de passe incorrect(s)!");
		return user;			
		}	 		
}

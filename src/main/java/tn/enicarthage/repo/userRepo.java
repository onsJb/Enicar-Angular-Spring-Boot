package tn.enicarthage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.model.User;

@Repository
public interface userRepo extends JpaRepository<User, Long>{

	User findUserByUsername(String username);
	
}

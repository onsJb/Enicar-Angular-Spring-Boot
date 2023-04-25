package tn.enicarthage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter

public class User {
	@Id
	private long id_user;
	private String nom_user;
	private String prenom_user;
	private String username;
	private String password;

}

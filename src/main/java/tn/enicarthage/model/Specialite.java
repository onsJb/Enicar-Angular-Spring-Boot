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
@Table(name="specialite")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class Specialite {
	@Id
	private long id;
	private String nom;
	private long diplome;
	
}

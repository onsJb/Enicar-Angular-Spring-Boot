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
@Table(name="diplome")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class Diplome {

	@Id
	private long id;
	private String nom;
}

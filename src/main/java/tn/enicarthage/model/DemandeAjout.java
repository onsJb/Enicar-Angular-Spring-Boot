package tn.enicarthage.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="demande_ajout")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class DemandeAjout {
	
	@Id
	private long id;
	private String nom;
	private String prenom;
	private String sexe;
	private Date dateNaiss;
	private String lieuNaiss;
	private String promotion;
	private long specialite;
	private String session;
	private String travail;
	private String email;
	private String numTel;
	
	

}

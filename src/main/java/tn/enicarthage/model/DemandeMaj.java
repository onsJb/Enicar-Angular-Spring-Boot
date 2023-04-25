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
@Table(name="demande_maj")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class DemandeMaj {
	@Id
	long id;
	long idDiplomee;
	private String travail;
	private String email;
	private String numTel;
}

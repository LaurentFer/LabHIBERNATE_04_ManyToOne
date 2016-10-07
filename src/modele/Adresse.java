package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
	
	private Long id;
	
	private String codePostal;

	private String rue;

	private String ville;

	// Constructeurs
	public Adresse() {
	}

	public Adresse(String codePostal, String rue, String ville) {
		this.codePostal = codePostal;
		this.rue = rue;
		this.ville = ville;
	}
	
	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String pCodePostal) {
		this.codePostal = pCodePostal;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String pRue) {
		this.rue = pRue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String pVille) {
		this.ville = pVille;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
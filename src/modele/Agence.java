package modele;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToOne(cascade={CascadeType.PERSIST})
	private Adresse adresse;

	private String nom;
	
	@OneToMany(mappedBy="agence", cascade={CascadeType.PERSIST})
	private Set<Client> client = new HashSet<Client>();

	@OneToMany(mappedBy="agence", cascade={CascadeType.PERSIST})
	private Set<Banquier> banquier = new HashSet<Banquier>();	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String pNom) {
		this.nom = pNom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse pAdresse) {
		this.adresse = pAdresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		this.id = pId;
	}

	public void addClient(Client pClient) {
		pClient.setAgence(this);
		this.client.add(pClient);
	}
	
	public void addEmploye(Banquier pBanquier) {
		//Le banquier reçu en paramétre a pour agence cette agence
		pBanquier.setAgence(this);
		//Ajout à la collection
		this.banquier.add(pBanquier);
	}	
	
}
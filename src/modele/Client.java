package modele;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_client;

	private String description;

	private String nom;

	private String prenom;

	@OneToOne(cascade={CascadeType.PERSIST})
	private Adresse adresse;
	
	@OneToMany(mappedBy="client",cascade={CascadeType.PERSIST})
	private Set<CompteInterne> comptesInt = new HashSet<CompteInterne>();

	@OneToMany(mappedBy="client",cascade={CascadeType.PERSIST})
	private Set<CompteExterne> comptesExt = new HashSet<CompteExterne>();;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="agence_id")
	private	Agence	agence;
	
	@SuppressWarnings("unused")
	private Client() {
	}

	public Client(String pNom, String pPrenom, String pDescription) {
		this.nom = pNom;
		this.prenom = pPrenom;
		this.description = pDescription;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse pAdresse) {
		this.adresse = pAdresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		this.description = pDescription;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String pNom) {
		this.nom = pNom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String pPrenom) {
		this.prenom = pPrenom;
	}

	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long pId) {
		this.id_client = pId;
	}

	public void addCompteInterne(CompteInterne pComptesInt) {
		pComptesInt.setClient(this);
		this.comptesInt.add(pComptesInt);
	}
	
	public void addCompteExterne(CompteExterne pComptesExt) {
		pComptesExt.setClient(this);
		this.comptesExt.add(pComptesExt);
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence pAgence) {
		this.agence = pAgence;
	}
	
	
	public void setComptesInt(CompteInterne pComptesInt) {
		this.comptesInt.add(pComptesInt);
	}	
	
	
}
package modele;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Banquier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long 	id_banquier;
	private String 	mail;
	private String	nom;
	private String 	prenom;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="agence_id")
	private	Agence	agence;	
	
	@SuppressWarnings("unused")
	private Banquier(){}
	
	public Banquier(String pNom, String pPrenom, String pMail){
		this.nom 	= pNom;
		this.prenom = pPrenom;
		this.mail 	= pMail;
	}

	public Long getId_banquier() {
		return id_banquier;
	}

	public void setId_banquier(Long pId) {
		this.id_banquier = pId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String pMail) {
		this.mail = pMail;
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

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence pAgence) {
		this.agence = pAgence;
	}
	
}

package modele;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operation {
	
	private Long 	id;
	private String 	intitule;
	private Long	montant;
	private	Date	date_op;
	

	private	CompteInterne	compteInt;	
	
	@SuppressWarnings("unused")
	private Operation(){}
	
	public Operation(String pIntitule, Long pMontant, Date pDate){
		this.intitule	=	pIntitule;
		this.montant	=	pMontant;
		this.date_op	=	pDate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String pIntitule) {
		this.intitule = pIntitule;
	}

	public Long getMontant() {
		return montant;
	}

	public void setMontant(Long pMontant) {
		this.montant = pMontant;
	}

	public Date getDate_op() {
		return date_op;
	}

	public void setDate_op(Date pDate_op) {
		this.date_op = pDate_op;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_CpteInt")
	public CompteInterne getCompteInt() {
		return compteInt;
	}

	public void setCompteInt(CompteInterne pCompteInt) {
		this.compteInt = pCompteInt;
	}
	
	
}

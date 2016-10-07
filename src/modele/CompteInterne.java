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

@Entity
public class CompteInterne {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long	id_CpteInt;
	private String	numero;
	private	String	description;
	private float	solde;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_client")	
	private	Client	client;
	
	@OneToMany(mappedBy="compteInt", cascade={CascadeType.PERSIST})
	private Set<Operation> operations = new HashSet<Operation>();	
	
	@SuppressWarnings("unused")
	private CompteInterne(){}
	
	public CompteInterne(String pNumero, String pDescription, float pSolde){
		this.numero			=	pNumero;
		this.description	=	pDescription;
		this.solde 			= 	pSolde;
	}

	public Long getId_CpteInt() {
		return id_CpteInt;
	}

	public void setId(Long pId_CpteInt) {
		this.id_CpteInt = pId_CpteInt;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String pNumero) {
		this.numero = pNumero;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		this.description = pDescription;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float pSolde) {
		this.solde = pSolde;
	}
	

	public Client getClient() {
		return client;
	}
	
	public void setClient(Client pClient) {
		this.client = pClient;
	}

	public void addOperation(Operation pOperation) {
		pOperation.setCompteInt(this);
		this.operations.add(pOperation);
	}
	
	public void delOperation(Operation pOperation){
		this.operations.remove(pOperation);
	}
		
}

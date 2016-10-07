package modele;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompteExterne {

	private Long 	id;
	private String	numeroRib;
	private String	description;
	

	private	Client	client;
	
	@SuppressWarnings("unused")
	private CompteExterne(){}
	
	public CompteExterne(String pNumeroRib, String pDescription){
		this.numeroRib		=	pNumeroRib;
		this.description	=	pDescription;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		this.id = pId;
	}

	public String getNumeroRib() {
		return numeroRib;
	}

	public void setNumeroRib(String pNumeroRib) {
		this.numeroRib = pNumeroRib;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		this.description = pDescription;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_client")
	public Client getClient() {
		return client;
	}

	public void setClient(Client pClient) {
		this.client = pClient;
	}
	
	
}

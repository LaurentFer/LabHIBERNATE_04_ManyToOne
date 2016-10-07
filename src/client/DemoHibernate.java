package client;

import java.util.Date;
import org.hibernate.classic.Session;
import org.hibernate.stat.Statistics;
import org.hibernate.Transaction;
import modele.*;
import modele.util.HibernateUtil;

public class DemoHibernate {

	public static void main(String[] args) {
		
		Statistics stats = HibernateUtil.getSessionFactory().getStatistics();
		
		// 1 : Ouverture unité de travail hibernate
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// 2 : Ouverture transaction 
		Transaction tx = session.beginTransaction();
		
		try {

			tx.begin();

			Client c1 = new Client("Davis", "Miles", "Jazzman");
			Adresse a1 = new Adresse("75000", "Champs elysees", "Paris");
			c1.setAdresse(a1);

			c1.addCompteExterne(new CompteExterne("010101", "Compte A"));
			c1.addCompteExterne(new CompteExterne("020202", "Compte B"));

			CompteInterne ci1 = new CompteInterne("1", "desc1", 1000);
			CompteInterne ci2 = new CompteInterne("2", "desc2", 2000);

			ci1.addOperation(new Operation("Boucher", (long) 10, new Date()));
			ci1.addOperation(new Operation("Charcutier", (long) 12, new Date()));

			ci2.addOperation(new Operation("Plasma", (long) 10000, new Date()));
			ci2.addOperation(new Operation("Ipod", (long) 450, new Date()));
			ci2.addOperation(new Operation("Nounou", (long) 700, new Date()));

			c1.addCompteInterne(ci1);
			c1.addCompteInterne(ci2);

			Client c2 = new Client("Parker", "Tony", "Basketeur");
			Adresse a2 = new Adresse("XXXX", "Parc privé", "San Antonio");
			c2.setAdresse(a2);

			c2.addCompteExterne(new CompteExterne("88888", "Compte de Denis"));
			c2.addCompteExterne(new CompteExterne("77777",
					"Compte epargne en suisse"));

			CompteInterne ci3 = new CompteInterne("3", "desc3", 3000);
			ci3.addOperation(new Operation("Boite de nuit", (long) 10000, new Date()));
			ci3.addOperation(new Operation("Prada", (long) 1000, new Date()));

			c2.addCompteInterne(ci3);

			Agence a = new Agence();
			a.setNom("Agence des ammandiers");
			a.addClient(c1);
			a.addClient(c2);

			Banquier b1 = new Banquier("Alexandre", "Jardin",
					"un faux banquier ecrivain");
			Banquier b2 = new Banquier("Marguerite", "Durras",
					"Une vraie écrivain");

			a.addEmploye(b1);
			a.addEmploye(b2);

			Adresse a3 = new Adresse("01", "A coté du lac leman", "Lausanne");
			a.setAdresse(a3);

			//Test d'update, OK la nouvelle adresse écrase la précédente
			c1.setAdresse(new Adresse("81000", "Test", "Albi"));
			//Test de suppression d'operation
			/*
			 * TODO : la date en paramètre...
			ci3.delOperation(new Operation("Boite de nuit", (long) 10000, new Date("07/10/2016")));
			*/
			
			session.persist(a);
			session.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 5 : Fermeture transaction 
		tx.commit();
		
		// 6 : Fermeture unité de travail hibernate 
		session.close();
		
		// Afficher les statistiques
		stats.logSummary();
	}
}
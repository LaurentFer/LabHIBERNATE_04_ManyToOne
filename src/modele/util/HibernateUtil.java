package modele.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Créer une SessionFactory à partir de hibernate.cfg.xml--> utilisation des fichiers XML
            // sessionFactory = new Configuration().configure().buildSessionFactory();
        	
        	// Créer une SessionFactory à partir de hibernate.cfg.xml --> utilisation des annotations
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Gestion exception
            System.err.println("Echec création SessionFactory" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}
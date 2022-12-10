package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*import etudiant_orm.BaseEntity;
import etudiant_orm.Etudiant;
import etudiant_orm.Personne;*/
import orm_mapping.Joueur;
import orm_mapping.Match;
 
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
 
	private static SessionFactory buildSessionFactory() {
	 SessionFactory sessionFactory = null;
	 try {
	   //Create the session factory object.
	   Configuration nouveau= new  Configuration();
	   nouveau.addAnnotatedClass(Joueur.class);
	   nouveau.addAnnotatedClass(Match.class);
	   
	   return nouveau.configure().buildSessionFactory(); 
	   
	 }
	 catch (Exception e) {
	  e.printStackTrace();
	 }
	 return sessionFactory;
	}
 
	public static SessionFactory getSessionFactory() {
	  return sessionFactory;
	}
 
}

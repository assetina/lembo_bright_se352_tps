package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import etudiant_orm.BaseEntity;
import etudiant_orm.Cours;
import etudiant_orm.Departement;
import etudiant_orm.Etudiant;
import etudiant_orm.Personne;
import etudiant_orm.Professeur;
 
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
 
	private static SessionFactory buildSessionFactory() {
	 SessionFactory sessionFactory = null;
	 try {
	   //Create the session factory object.
	   Configuration nouveau= new  Configuration();
	   nouveau.addAnnotatedClass(BaseEntity.class);
	   nouveau.addAnnotatedClass(Personne.class);
	   nouveau.addAnnotatedClass(Departement.class);
	   nouveau.addAnnotatedClass(Professeur.class);
	   nouveau.addAnnotatedClass(Cours.class);
	   nouveau.addAnnotatedClass(Etudiant.class);
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

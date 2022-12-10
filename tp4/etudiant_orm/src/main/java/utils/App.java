package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

//import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import etudiant_orm.Departement;
import etudiant_orm.Etudiant;
//import utils.HibernateUtil;
public class App 
{
    public static void main( String[] args ) {
    	//Create the student object.
    	
    	Set<Etudiant> ets= new HashSet<>();
    	Departement departement1= new Departement("biologie","url", ets);
    	Departement departement2= new Departement("informatique","url", ets);
    	Etudiant etudiant1 = new Etudiant("Vivek","abalo","vivek@123","azerty","99176425",departement2);
    	Etudiant etudiant2 = new Etudiant("afi","Vivek","vivek@123","azerty","92156425",departement1);
    	
 
    	
 
    	Transaction tx = null;
    	//Get the session object.
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	try{
              //Start hibernate session.
    	      tx = session.beginTransaction();
 
              //Insert a new student record in the database.
    	      /*session.save(etudiant1); 
    	      session.save(etudiant2); */
    	      /*Departement d1= session.find(Departement.class, 1L);
    	      d1.setNom("developpement");
    	      Departement d2= session.find(Departement.class, 2L);
    	      session.remove(d2);
    	      System.out.println(d1.toString());*/
    	      Query query =session.createQuery("FROM departments");
    	      List<Departement> liste_departements= query.getResultList();
    	      for(Departement dep: liste_departements) {
    	    	  System.out.println(dep.toString());
    	      }
 
              //Commit hibernate transaction if no exception occurs.
    	      tx.commit();
    	      System.out.println("Saved Successfully.");
    	  }catch (HibernateException e) {
    	     if(tx!=null){
                 //Roll back if any exception occurs. 
    	         tx.rollback();
    	     }
    	     e.printStackTrace(); 
    	  }finally {
             //Close hibernate session.
    	     session.close(); 
    	  }
    }
}
package utils;

//import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import etudiant_orm.Etudiant;
import orm_mapping.Joueur;
//import utils.HibernateUtil;
public class App 
{
    public static void main( String[] args ) {
    	//Create the student object.
    	Joueur etudiant = new Joueur("Vivek","Vivek",92156425);
 
    	
 
    	Transaction tx = null;
    	//Get the session object.
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	try{
              //Start hibernate session.
    	      tx = session.beginTransaction();
 
              //Insert a new student record in the database.
    	      session.save(etudiant); 
 
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
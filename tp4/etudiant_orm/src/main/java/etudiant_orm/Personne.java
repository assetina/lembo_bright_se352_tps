
package etudiant_orm;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;



//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type")

public class Personne extends BaseEntity{ 
	
    @Column(length = 60,nullable = false)
    protected String nom;
    
    @Column(length = 60,nullable = false)
    protected String prenom;
    
    @Column(length = 60)
    protected String email;

    public Personne() {
    }

	public Personne(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
    
      
}

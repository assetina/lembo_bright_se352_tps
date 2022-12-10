
package etudiant_orm;


import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professeurs")
//@DiscriminatorValue(value = "PROFESSEUR")
public class Professeur extends Personne{
    @Column(length = 30,nullable = true)
    private String grade;
    
    @ManyToMany()
    @JoinTable(name = "interventions", 
            joinColumns = @JoinColumn(name = "professeur_id"),
            inverseJoinColumns = @JoinColumn(name = "departement_id")
    )
    private Set<Departement> departements;
    
    public Professeur() {
    }

    public Professeur(String grade, String nom, String prenom, String email) {
        super(nom, prenom, email);
        this.grade = grade;
    }
          
}

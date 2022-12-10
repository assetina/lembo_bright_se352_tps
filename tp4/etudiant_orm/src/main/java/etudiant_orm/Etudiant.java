
package etudiant_orm;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "etudiants")
//@DiscriminatorValue(value = "ETUDIANT")

public class Etudiant extends Personne{
    @Column(nullable = true)
    private String adresse;
    
    @Column(nullable = true)
    private String telephone;
    
    @ManyToOne
    @JoinColumn(name = "departement_id" ,nullable = true)
    private Departement departement;
    
    @ManyToMany(mappedBy = "etudiants")
    private Set<Cours> cours;

    public Etudiant(String nom, String prenom, String email, String adresse, String telephone, Departement departement) {
        super(nom, prenom, email);
        this.adresse = adresse;
        this.telephone = telephone;
        this.departement = departement;
    }
    
    

    public Etudiant(String adresse, String telephone, Departement departement, Set<Cours> cours) {
		super();
		this.adresse = adresse;
		this.telephone = telephone;
		this.departement = departement;
		this.cours = cours;
	}



	public Etudiant() {
    }
    
    
}

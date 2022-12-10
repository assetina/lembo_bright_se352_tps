
package etudiant_orm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "departments")
public class Departement extends BaseEntity{
	
	@Column(length = 60,nullable = false, unique = true)
    private String nom;
	
	@Column(length = 60,nullable = false, unique = true)
    private String adresseWeb;
    
    @OneToMany(mappedBy = "departement",fetch = FetchType.LAZY)
    private Set<Etudiant> etudiants;

   
	public Departement(String nom, String adresseWeb, Set<Etudiant> etudiants) {
		super();
		this.nom = nom;
		this.adresseWeb = adresseWeb;
		this.etudiants = etudiants;
	}
	
	public Departement() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseWeb() {
		return adresseWeb;
	}

	public void setAdresseWeb(String adresseWeb) {
		this.adresseWeb = adresseWeb;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
      
    
}

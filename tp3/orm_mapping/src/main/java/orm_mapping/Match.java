package orm_mapping;

import java.util.ArrayList;
import javax.persistence.*;



import java.util.List;
import java.util.Set;



@Entity
@Table(name ="match")
public class Match {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name= "joueur1_id",nullable=true)
	
	private Joueur joueur1;

	@OneToOne
	@JoinColumn(name= "joueur2_id",nullable=true)
	private Joueur joueur2;


	@OneToOne
	@JoinColumn(name= "vainqueur_id",nullable=true)
	private Joueur vainceur;

	public Joueur getJoueur1() {
		return joueur1;
	}
	public int getId() {
		return id;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public Joueur getVainceur() {
		return vainceur;
	}

	public void setVainceur(Joueur vainceur) {
		this.vainceur = vainceur;
	}
	
	

}

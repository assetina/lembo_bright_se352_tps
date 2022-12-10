package joueurs;


public class Joueur  implements Comparable<Joueur>{
	private String nom;
	private String prenom;
	private String numero_licence;
	private Integer nombre_points;
	public Joueur(String nom, String prenom, /*String numero_licence,*/ Integer nombre_points) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero_licence = fabriquerNumero();
		this.nombre_points = nombre_points;
	}
	private String fabriquerNumero() {
		return this.nom+this.prenom;}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumero_licence() {
		return numero_licence;
	}
	public void setNumero_licence(String numero_licence) {
		this.numero_licence = numero_licence;
	}
	public Integer getNombre_points() {
		return nombre_points;
	}
	public void setNombre_points(Integer nombre_points) {
		this.nombre_points = nombre_points;
	}
	//to string
	
	
	public String toString() {
		return "informations: Nom:"+this.getNom()+"prenom:"+this.getPrenom()+"Numero de licence:"+this.getNumero_licence()+"Nombre de points"+this.getNombre_points();
		
	}
	
	//equals
	
	public boolean equals(Joueur a) {
		if(a.getNom()==this.getNom() && a.getPrenom()==this.getPrenom() && a.getNumero_licence()==this.getNumero_licence() && a.getNombre_points()==this.getNombre_points()){
			return true;
				}else {
					return false;
					
				}
		
		
	}

	//ajouter points
	public void ajouter_points(int nombredepoints) {
		if(nombredepoints<0) {
			System.out.println("impossible");
			
		}else {
			this.nombre_points+=nombredepoints;
		}
	}
	//comparaison
	//@Override
	/*public int compareTo(Object o) {
		if(((Joueur) o).getNombre_points()<this.getNombre_points()) {
		return 0;
		}else {
			return -1;
		}
	}*/
	
	@Override
	public int compareTo(Joueur o) {
		if((o.getNombre_points()>this.getNombre_points()){
			return -1;
			}else if(o.getNombre_points()== this.getNombre_points()){
				return 0;
			}else{
				return -1;
			}
	}
	
	
}

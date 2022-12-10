/**
 * Joueur
 */
public class Joueur implements Comparable {

    private String nom;
    private String prenom;
    private String numeroLicence;
    private int nombrePoint=0;

    public Joueur(String nom, String prenom, String numeroLicence, int nombrePoint) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroLicence = numeroLicence;
        this.nombrePoint = nombrePoint;
    }

    
    public String toString() {
        return "Joueur \nnom:" + nom + "\nprenom:" + prenom + " \nnumeroLicence:" + numeroLicence + " \nnombrePoint:"
                + nombrePoint;
    }

    
    public void ajouterPoint(int nombrePointAjoutes) {
        this.nombrePoint+=nombrePointAjoutes;
    }

    @Override
    public int compareTo(Object o) {
        Joueur joueur=(Joueur)o;
        if (this.nombrePoint<=joueur.getNombrePoint()) {
            return -1;
        }else if(this.nombrePoint>=joueur.getNombrePoint()) {
            return 1;
        }
        return 0;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Joueur other = (Joueur) obj;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (prenom == null) {
            if (other.prenom != null)
                return false;
        } else if (!prenom.equals(other.prenom))
            return false;
        if (numeroLicence == null) {
            if (other.numeroLicence != null)
                return false;
        } else if (!numeroLicence.equals(other.numeroLicence))
            return false;
        if (nombrePoint != other.nombrePoint)
            return false;
        return true;
    }

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

    public String getNumeroLicence() {
        return numeroLicence;
    }

    public void setNumeroLicence(String numeroLicence) {
        this.numeroLicence = numeroLicence;
    }

    public int getNombrePoint() {
        return nombrePoint;
    }

    public void setNombrePoint(int nombrePoint) {
        this.nombrePoint = nombrePoint;
    }




}
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JoueurJDBC {
    private Connection con = Connexion.getConnection();

    public void add(Joueur joueur) throws SQLException {
        String requete = "INSERT INTO joueur (nom, prenom, numero_licence, nombre_point) VALUES (?, ?, ?, ?)";
 
        PreparedStatement statement = con.prepareStatement(requete);
        statement.setString(1, joueur.getNom());
        statement.setString(2, joueur.getPrenom());
        statement.setString(3, joueur.getNumeroLicence());
        statement.setInt(4, joueur.getNombrePoint());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Nouveau joueur ajoute!");
        }
    }

    public List<Joueur> findAll() throws SQLException {
        String requete = "SELECT * FROM joueur";
 
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(requete);
        List<Joueur> listeJoueur= new ArrayList<>();
        
        
        int count = 0;
        
        while (result.next()){
            String nom = result.getString(2);
            String prenom = result.getString(3);
            String numeroLicence = result.getString(4);
            int nombrePoint = result.getInt(5);

            Joueur joueur=new Joueur(nom, prenom, numeroLicence, nombrePoint);
            listeJoueur.add(joueur);
        
            String output = "Joueur #%d: %s - %s - %s - %s\n";
            System.out.println(String.format(output, ++count, nom, prenom, numeroLicence, nombrePoint));
           
        }
        return listeJoueur;
        
    }

    public List<Joueur> searchByNombrePoint(int nombrePointRecherche) throws SQLException {
        String requete = "SELECT * FROM joueur WHERE nombre_point="+nombrePointRecherche;
 
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(requete);
        List<Joueur> listeJoueurRecherche= new ArrayList<>();
        
        
        int count = 0;
        
        while (result.next()){
            String nom = result.getString(2);
            String prenom = result.getString(3);
            String numeroLicence = result.getString(4);
            int nombrePoint = result.getInt(5);

            Joueur joueur=new Joueur(nom, prenom, numeroLicence, nombrePoint);
            listeJoueurRecherche.add(joueur);
        
            String output = "Joueur #%d: %s - %s - %s - %s\n";
            System.out.println(String.format(output, ++count, nom, prenom, numeroLicence, nombrePoint));
           
        }
        return listeJoueurRecherche;
        
    }

    public void edit(Joueur joueur) throws SQLException {
        String requete = "UPDATE joueur SET nom=?, prenom=?, nombre_point=? WHERE numero_licence=?";
 
        PreparedStatement statement = con.prepareStatement(requete);
        statement.setString(1, joueur.getNom());
        statement.setString(2, joueur.getPrenom());
        statement.setInt(3, joueur.getNombrePoint());
        statement.setString(4, joueur.getNumeroLicence());
        
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Les informations du joueur ont été mis à jour!");
        }
            }

    public void delete(String numero_licence) throws SQLException {
        String requete = "DELETE FROM joueur WHERE numero_licence=?";
 
        PreparedStatement statement = con.prepareStatement(requete);
        statement.setString(1, numero_licence);
        
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Ce joueur ne fait plus partie de la fédération!");
        }
            }
}

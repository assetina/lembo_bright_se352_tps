import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    static String dbURL = "jdbc:mysql://localhost:3306/federation";
    static String username = "root";
    static String password = "";

    public static Connection getConnection() {
        Connection con=null;
        try {
    
         con = DriverManager.getConnection(dbURL, username, password);
    
        if (con != null) {
            return con;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return con;
    }
 
    
}

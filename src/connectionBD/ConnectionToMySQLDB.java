package connectionBD;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToMySQLDB extends ConnectionToDB {
    public ConnectionToMySQLDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBKennedy"
                    , "root", "ReachTwenty");
            System.out.println("Connection réussie");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection écchouée");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC non trouvé");
            System.out.println(e.getMessage());
        }
    }
}

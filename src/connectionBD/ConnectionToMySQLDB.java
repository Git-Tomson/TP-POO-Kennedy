package connectionBD;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToMySQLDB extends ConnectionToDB {
    public ConnectionToMySQLDB(){

    }
    @Override
    public void createConnection(){
        try {
            if(this.connection == null || this.connection.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBKennedy"
                        , "root", "ReachTwenty");
                System.out.println("Connection réussie");
            }else{
                System.out.println("Connection déjà ouverte");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection écchouée");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC non trouvé");
            System.out.println(e.getMessage());
        }
    }
}

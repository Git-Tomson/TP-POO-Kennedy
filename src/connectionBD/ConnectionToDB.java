package connectionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Cette classe abstraite gère la connection aux bases de données et sera étendue par une classe qui gèrera
la connection à une BD utilisant un SGBD spécifique, Ceci permet à la classe Login du package gestionDesComptes
ne dépendre que d'une classe abstraite car cette classe doit instancier un objet d'une classe gérant le connection
à la BD afin de s'assurer que l'ouverture et la fermeture de la fenêtre Login assurent celles de la connection
BD*/

public abstract class ConnectionToDB {
    protected static Connection connection;
    public ConnectionToDB(){
    }

    public void createConnection(){

    }

    public Connection getConnection(){
        return this.connection;
    }

    public void closeConnection(){
        try{
            if(!(this.connection == null || this.connection.isClosed())){
                this.connection.close();
                System.out.println("Fermeture réussie");
            }else{
                System.out.println("Connection non ouverte");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Fermeture échouée");
        }
    }
}

package gestionInterfaceGraphique;

import connectionBD.ConnectionToDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMySQL extends User{
    public UserMySQL(){
        super();
    }
    public UserMySQL(String Name, String Firstname, int Tel, String Password){
        super(Name, Firstname, Tel, Password);
    }

    public void insertUser(ConnectionToDB connectionToDB){
        String sql = "INSERT INTO userMySQL (Name, Firstname, Tel, Password)"+
                " VALUES (?, ?, ?, ?)";
        try {
            connectionToDB.createConnection();
            PreparedStatement stmt = connectionToDB.getConnection().prepareStatement(sql);
            stmt.setString(1,this.getName());
            stmt.setString(2,this.getFirstname());
            stmt.setInt(3, this.getTel());
            stmt.setString(4, this.getPassword());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Un nouvel utilisateur a été inséré !");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Échec de l'insertion");
        }finally {
            connectionToDB.closeConnection();
        }
    }
    public String searchAndGetPassword (ConnectionToDB connectionToDB){
        String sql = "SELECT* from userMySQL";
        String Name, Firstname, Password;
        try{
            connectionToDB.createConnection();
            PreparedStatement stmt = connectionToDB.getConnection().prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()){
                Name = res.getString("Name");
                Firstname = res.getString("Firstname");
                if(Name.equals(this.getName()) && Firstname.equals(this.getFirstname())){
                    Password = res.getString("Password");
                    connectionToDB.closeConnection();
                    return Password;
                }
            }
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
            System.out.println("Recherche échouée");
        }finally {
            connectionToDB.closeConnection();
        }
        return null;
    }

}

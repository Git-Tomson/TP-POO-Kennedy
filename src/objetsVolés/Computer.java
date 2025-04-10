package objetsVolés;

import connectionBD.ConnectionToDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Computer extends Thing{
    public Computer(){
        super();
    }
    public Computer(String Id, String nameThing, String type, int telProprio){
        super(Id, nameThing, type, telProprio);
    }

    @Override
    public void insertThing (ConnectionToDB connectionToDB) {
        String sql = "INSERT INTO Computer (IdComputer, NameComputer, TelProprioComputer)"+
                " VALUES (?, ?, ?)";
        try {
            connectionToDB.createConnection();
            PreparedStatement stmt = connectionToDB.getConnection().prepareStatement(sql);
            stmt.setString(1,this.Id);
            stmt.setString(2,this.NameThing);
            stmt.setInt(3, this.TelProprio);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Un nouvel Ordinateur a été inséré !");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Échec de l'insertion");
        }finally {
            connectionToDB.closeConnection();
        }
    }

    @Override
    public boolean searchThing(ConnectionToDB connectionToDB){
        String sql = "SELECT* from Computer";
        String ID;
        try{
            connectionToDB.createConnection();
            PreparedStatement stmt = connectionToDB.getConnection().prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()){
                ID= res.getString("IdComputer");
                if(ID.equals(this.Id)){
                    connectionToDB.closeConnection();
                    return true;
                }
            }
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
            System.out.println("Recherche échouée");
        }finally {
            connectionToDB.closeConnection();
        }
        return false;
    }
}

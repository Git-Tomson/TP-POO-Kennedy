package gestionInterfaceGraphique;

import connectionBD.ConnectionToDB;

public abstract class User {
    protected String Name;
    protected String Firstname;
    protected int Tel;
    protected String Password;

    public User() {
    }
    public User(String Name, String Firstname, int Tel, String Password){
        this.Password = Password;
        this.Tel = Tel;
        this.Firstname = Firstname;
        this.Name = Name;
    }

    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFirstname(){
        return this.Firstname;
    }
    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public int getTel(){
        return this.Tel;
    }
    public void setTel(int Tel){
        this.Tel=Tel;
    }

    public String getPassword(){
        return this.Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }

    public void insertUser(ConnectionToDB connectionToDB){

    }
    public String searchAndGetPassword(ConnectionToDB connectionToDB){
        return null;
    }

}

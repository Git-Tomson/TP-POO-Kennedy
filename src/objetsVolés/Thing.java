package objetsVolés;


import connectionBD.ConnectionToDB;

public abstract class Thing {
    protected String Id;
    protected String NameThing;
    protected String Type;
    protected int TelProprio;

    public Thing(){

    }
    public Thing(String Id, String nameThing, String type, int telProprio){
        this.Id = Id;
        this.NameThing = nameThing;
        this.TelProprio = telProprio;
        this.Type = type;
    }

    public String getId(){
        return this.Id;
    }
    public void setId(String Id){
        this.Id = Id;
    }

    public String getNameThing(){
        return this.NameThing;
    }
    public void setNameThing(String nameThing){
        this.NameThing = nameThing;
    }

    public String getType(){
        return this.Type;
    }
    public void setType(String type ){
        this.Type = type;
    }

    public int getTelProprio(){
        return this.TelProprio;
    }
    public void setTelProprio(int telProprio){
        this.TelProprio = telProprio;
    }

    public void insertThing(ConnectionToDB connectionToDB){

    }
    public boolean searchThing(ConnectionToDB connectionToDB){
        return false;
    }
}

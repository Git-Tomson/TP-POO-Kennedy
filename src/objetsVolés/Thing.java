package objetsVolés;


public abstract class Thing {
    private String Id;
    private String nameThing;
    private String type;
    private int telProprio;

    public Thing(){

    }
    public Thing(String Id, String nameThing, String type, int telProprio){
        this.Id = Id;
        this.nameThing = nameThing;
        this.telProprio = telProprio;
        this.type = type;
    }
}

package gestionInterfaceGraphique;



import javax.swing.*;

public abstract class SignUp extends JPanel{
    protected JPanel previous;//Conteneur précédent de la fenêtre
    public SignUp(JPanel previous){
        super();
        if(this.previous != null){
            this.previous.removeAll();
        }
        this.previous = previous;
    }

   /* public JPanel getActual(){
        return this.actual;
    }
    public void setActual(JPanel actual) {
        this.actual.removeAll();
        this.actual.add(actual);
    }

    public JPanel getPrevious(){
        return this.previous;
    }
    public void setPrevious(JPanel previous){
        this.previous.removeAll();
        this.previous.add(previous);
    }*/
}

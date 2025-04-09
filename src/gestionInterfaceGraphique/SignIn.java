package gestionInterfaceGraphique;
import javax.swing.*;

public abstract class SignIn extends JPanel {
    protected JPanel previous;
    public SignIn(JPanel previous){
        super();
        this.previous = previous;
    }
}

package gestionInterfaceGraphique;
import connectionBD.ConnectionToDB;

import javax.swing.*;

public abstract class SignIn extends JPanel {
    protected JPanel previous;
    protected ConnectionToDB connectionToDB;
    public SignIn(JPanel previous, ConnectionToDB connectionToDB){
        super();
        this.previous = previous;
    }
}

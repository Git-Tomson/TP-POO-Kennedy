package gestionInterfaceGraphique;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class Login extends JPanel {
    protected JPanel previous;
    protected JPanel actual;
    public Login(JPanel previous){
        super();
        this.previous = previous;
        this.actual = this;
    }
}

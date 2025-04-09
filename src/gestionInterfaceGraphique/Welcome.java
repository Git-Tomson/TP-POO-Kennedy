package gestionInterfaceGraphique;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import connectionBD.ConnectionToDB;
import connectionBD.ConnectionToMySQLDB;


public class Welcome extends JFrame{

    public Welcome() {
        //Image de fond
        ImageIcon imageIcon = new ImageIcon("/home/tomson/Thomas/"+
                "Cours_3GI/S2/POO2/TP_POO_Kennedy/font.jpg");
        Image image = imageIcon.getImage();
        JPanel pane1 = new JPanel() { //panneau de fond
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        pane1.setLayout(new BoxLayout(pane1, BoxLayout.Y_AXIS));
        pane1.setOpaque(false); // important si tu ajoutes ce panel dans un autre


        JLabel l1 = new JLabel("Welcome on Kennedy");
        l1.setForeground(Color.WHITE); // Pour que ce soit lisible
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel l2 = new JLabel("This application help you to save informations about stole things and verify" +
                " if some things are stolen");
        setForeground(Color.WHITE);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane1.add(Box.createRigidArea(new Dimension(0, 10)));
        pane1.add(l1);
        pane1.add(Box.createRigidArea(new Dimension(0, 10)));
        pane1.add(l2);
        pane1.add(Box.createRigidArea(new Dimension(0, 20)));
        // Ajout d'une ligne de séparation
        pane1.add(new JSeparator(SwingConstants.HORIZONTAL));
        pane1.add(Box.createRigidArea(new Dimension(0, 10)));
        //Création des boutons
        JButton B1 = new JButton("Login");
        JButton B2 = new JButton("Sign in");
        //Panneau des boutons
        JPanel pane2 = new JPanel(new GridLayout(1, 2));
        pane2.setOpaque(false);
        JPanel pane2G = new JPanel(new FlowLayout(FlowLayout.CENTER));//Panel pour le bouton placé à gauche
        pane2G.setOpaque(false);
        //ajout des boutons aux panneau
        pane2G.add(B1);
        pane2.add(pane2G);
        JPanel pane2D = new JPanel(new FlowLayout(FlowLayout.CENTER));// Panel pour le bouton placé à droite
        pane2D.setOpaque(false);
        pane2D.add(B2);
        //finalisation du panneau de la fenêtre
        pane2.add(pane2D);
        pane1.add(pane2);
        this.setContentPane(pane1);

        ConnectionToDB connect = new ConnectionToMySQLDB();
        this.setTitle("Kennedy");
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //définissons l'action des boutons
        //Action du bouton B1 (Login)
        B1.addActionListener(e -> {
            Login loginMySQL = new LoginMySQL(pane1);
            this.setContentPane(loginMySQL);
        });
        //Action du Bouton B2 (sign in)
        B2.addActionListener(e ->{
            SignIn signInMySQL = new SignInMySQL(pane1);
            this.setContentPane(signInMySQL);
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent e) {
                connect.closeConnection();
                dispose();
            }
        });
    }
}

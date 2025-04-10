package gestionInterfaceGraphique;

import connectionBD.ConnectionToDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SignInMySQL extends SignIn {
    public SignInMySQL(JPanel previous, ConnectionToDB connectionToDB){
        super(previous, connectionToDB);
        // Image de fond
        ImageIcon imageIcon = new ImageIcon("/home/tomson/Thomas/Cours_3GI/S2/POO2/TP-POO-Kennedy/fontSignIn.jpg");
        Image image = imageIcon.getImage();

        JPanel pane = new JPanel() { // panneau de fond
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        pane.setLayout(new GridLayout(6, 2, 10, 10)); // utiliser GridLayout directement ici
        pane.setOpaque(false);  // important pour rendre le fond transparent

        // Composants du formulaire
        UIManager.put("Label.foreground", Color.WHITE);//Couleur des Labels
        JLabel labelNom = new JLabel("Nom :");
        JTextField champNom = new JTextField(20);

        JLabel labelPrenom = new JLabel("Prénom :");
        JTextField champPrenom = new JTextField(20);

        JLabel labelMdp1 = new JLabel("Mot de passe :");
        JPasswordField champMdp1 = new JPasswordField(20);


        JButton boutonValider = new JButton("Valider");
        JButton boutonBack = new JButton("Back");

        // Action du bouton Valider
        boutonValider.addActionListener((ActionEvent e) -> {
            // Récupérer les valeurs des champs
            String nom = champNom.getText();
            String prenom = champPrenom.getText();
            String mdp1 = new String(champMdp1.getPassword());

            // Vérification des champs obligatoires
            if (nom.isEmpty() || mdp1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tous les champs obligatoires doivent être remplis.");
                return;
            }else {
                UserMySQL userMySQL = new UserMySQL();
                userMySQL.setName(nom);
                userMySQL.setFirstname(prenom);
                userMySQL.setPassword(mdp1);
                String mdp2 = userMySQL.searchAndGetPassword(connectionToDB);
                if(mdp2 == null){
                    JOptionPane.showMessageDialog(null, "Account not found"
                    +" let's back and SignUp");
                }else{
                    //Vérification des mots de passe
                    if (!mdp1.equals(mdp2)) {
                        JOptionPane.showMessageDialog(null, "Incorrect Password");
                        return;
                    }else {
                        // Affichage des données saisies (ou traitement de l'inscription)
                        JOptionPane.showMessageDialog(null, "Connection réussie :\n" +
                                "Bienvennue Mr/Mme"+ nom+" "+prenom);
                        ThingsManagement thingsManagement = new ThingsManagement(connectionToDB);
                        this.removeAll();
                        this.add(thingsManagement);
                        this.revalidate();
                        this.repaint();
                    }
                }
            }
        });

        boutonBack.addActionListener(e->{
            this.removeAll();
            this.add(this.previous);
            this.revalidate();
            this.repaint();
        });

        // Ajouter les composants au panneau
        pane.add(labelNom);
        pane.add(champNom);
        pane.add(labelPrenom);
        pane.add(champPrenom);
        pane.add(labelMdp1);
        pane.add(champMdp1);
        pane.add(boutonValider);
        pane.add(boutonBack);

        this.setLayout(new BorderLayout()); // Utilisation du BorderLayout
        this.add(pane, BorderLayout.CENTER);
    }
}

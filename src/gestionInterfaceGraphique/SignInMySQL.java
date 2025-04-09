package gestionInterfaceGraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SignInMySQL extends SignIn {
    public SignInMySQL(JPanel previous){
        super(previous);
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
            String mdp2="123456";

            // Vérification des champs obligatoires
            if (nom.isEmpty() || mdp1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tous les champs obligatoires doivent être remplis.");
                return;
            }
            // Vérification des mots de passe
            if (!mdp1.equals(mdp2)) {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
                return;
            }

            // Affichage des données saisies (ou traitement de l'inscription)
            JOptionPane.showMessageDialog(null, "Connection réussie :\n" +
                    "Bienvennue Mr/Mme"+ nom+" "+prenom);
            GestionObjets gestionObjets = new GestionObjets();
            this.removeAll();
            this.add(gestionObjets);
        });

        boutonBack.addActionListener(e->{
            this.removeAll();
            this.add(this.previous);
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

package gestionInterfaceGraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SignInMySQL extends SignIn{
    public SignInMySQL(JPanel previous){
        super(previous);
        // Image de fond
        ImageIcon imageIcon = new ImageIcon("/home/tomson/Thomas/Cours_3GI/S2/POO2/TP_POO_Kennedy/font.jpg");
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
        JLabel labelNom = new JLabel("Nom :");
        JTextField champNom = new JTextField(20);

        JLabel labelPrenom = new JLabel("Prénom :");
        JTextField champPrenom = new JTextField(20);

        JLabel labelTel = new JLabel("Numéro de téléphone :");
        JTextField champTel = new JTextField(20);

        JLabel labelMdp1 = new JLabel("Mot de passe :");
        JPasswordField champMdp1 = new JPasswordField(20);

        JLabel labelMdp2 = new JLabel("Confirmer le mot de passe :");
        JPasswordField champMdp2 = new JPasswordField(20);

        JButton boutonValider = new JButton("Valider");
        JButton boutonBack = new JButton("Back");

        // Action du bouton Valider
        boutonValider.addActionListener((ActionEvent e) -> {
            // Récupérer les valeurs des champs
            String nom = champNom.getText();
            String prenom = champPrenom.getText();
            String telephone = champTel.getText();
            String mdp1 = new String(champMdp1.getPassword());
            String mdp2 = new String(champMdp2.getPassword());

            //User user = new UserMySQL(nom, prenom, telephone, mdp1);

            // Vérification des champs obligatoires
            if (nom.isEmpty() || telephone.isEmpty() || mdp1.isEmpty() || mdp2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tous les champs obligatoires doivent être remplis.");
                return;
            }

            // Vérification des mots de passe
            if (!mdp1.equals(mdp2)) {
                JOptionPane.showMessageDialog(null, "Les mots de passe ne correspondent pas.");
                return;
            }

            // Vérification du numéro de téléphone (9 chiffres)
            if (!telephone.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(null, "Le numéro de téléphone doit être un entier de 9 chiffres.");
                return;
            }

            // Affichage des données saisies (ou traitement de l'inscription)
            JOptionPane.showMessageDialog(null, "Inscription réussie :\n" +
                    "Nom : " + nom + "\n" +
                    "Prénom : " + prenom + "\n" +
                    "Téléphone : " + telephone);
            User userMySQL = new UserMySQL(nom, prenom, Integer.parseInt(telephone), mdp1);
            GestionObjets gestionObjets = new GestionObjets(this.actual);
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
        pane.add(labelTel);
        pane.add(champTel);
        pane.add(labelMdp1);
        pane.add(champMdp1);
        pane.add(labelMdp2);
        pane.add(champMdp2);
        pane.add(boutonValider);
        pane.add(boutonBack);

        this.setLayout(new BorderLayout()); // Utilisation du BorderLayout
        this.add(pane, BorderLayout.CENTER);
    }
}

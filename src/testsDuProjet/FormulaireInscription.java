package testsDuProjet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FormulaireInscription {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame fenetre = new JFrame("Formulaire d'inscription");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setSize(400, 300);
            fenetre.setLocationRelativeTo(null);
            fenetre.setLayout(new GridLayout(6, 2, 10, 10)); // grille avec 2 colonnes

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

            // Action du bouton Valider
            boutonValider.addActionListener((ActionEvent e) -> {
                // Récupérer les valeurs des champs
                String nom = champNom.getText();
                String prenom = champPrenom.getText();
                String telephone = champTel.getText();
                String mdp1 = new String(champMdp1.getPassword());
                String mdp2 = new String(champMdp2.getPassword());

                // Vérification des champs obligatoires
                if (nom.isEmpty() || telephone.isEmpty() || mdp1.isEmpty() || mdp2.isEmpty()) {
                    JOptionPane.showMessageDialog(fenetre, "Tous les champs obligatoires doivent être remplis.");
                    return;
                }

                // Vérification des mots de passe
                if (!mdp1.equals(mdp2)) {
                    JOptionPane.showMessageDialog(fenetre, "Les mots de passe ne correspondent pas.");
                    return;
                }

                // Vérification du numéro de téléphone (9 chiffres)
                if (!telephone.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(fenetre, "Le numéro de téléphone doit être un entier de 9 chiffres.");
                    return;
                }

                // Affichage des données saisies (ou traitement de l'inscription)
                JOptionPane.showMessageDialog(fenetre, "Inscription réussie :\n" +
                        "Nom : " + nom + "\n" +
                        "Prénom : " + prenom + "\n" +
                        "Téléphone : " + telephone);
            });

            // Ajouter les composants à la fenêtre
            fenetre.add(labelNom);
            fenetre.add(champNom);
            fenetre.add(labelPrenom);
            fenetre.add(champPrenom);
            fenetre.add(labelTel);
            fenetre.add(champTel);
            fenetre.add(labelMdp1);
            fenetre.add(champMdp1);
            fenetre.add(labelMdp2);
            fenetre.add(champMdp2);
            fenetre.add(boutonValider);

            fenetre.setVisible(true);
        });
    }
}

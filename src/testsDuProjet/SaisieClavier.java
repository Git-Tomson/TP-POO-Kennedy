package testsDuProjet;

import javax.swing.*;
import java.awt.*;

public class SaisieClavier {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame fenetre = new JFrame("Saisie au clavier");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setSize(300, 150);
            fenetre.setLocationRelativeTo(null);
            fenetre.setLayout(new FlowLayout());

            JLabel label = new JLabel("Entrez votre nom :");
            JTextField champTexte = new JTextField(15);
            JButton bouton = new JButton("Valider");

            // Action du bouton : récupérer la saisie
            bouton.addActionListener(e -> {
                String saisie = champTexte.getText();
                JOptionPane.showMessageDialog(fenetre, "Bonjour " + saisie + " !");
            });

            fenetre.add(label);
            fenetre.add(champTexte);
            fenetre.add(bouton);
            fenetre.setVisible(true);
        });
    }
}


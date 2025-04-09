package testsDuProjet;

import javax.swing.*;
import java.awt.*;

public class FenetreBienvenueAvecImage {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame fenetre = new JFrame("Bienvenue avec fond");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setSize(500, 300);
            fenetre.setLocationRelativeTo(null);

            // === Chargement de l'image de fond ===
            ImageIcon imageIcon = new ImageIcon("/home/tomson/Thomas/"+
                    "Cours_3GI/S2/POO2/TP_POO_Kennedy/font.jpeg");
            Image image = imageIcon.getImage();

            // === Panel avec fond personnalisé ===
            JPanel panneauFond = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            };
            panneauFond.setLayout(new BoxLayout(panneauFond, BoxLayout.Y_AXIS));
            panneauFond.setOpaque(false); // important si tu ajoutes ce panel dans un autre

            // === Composants à afficher au-dessus de l'image ===
            JLabel bienvenue = new JLabel("Bienvenue dans l'application !");
            bienvenue.setForeground(Color.WHITE); // Pour que ce soit lisible
            bienvenue.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel consignes = new JLabel("Veuillez lire attentivement les consignes avant de continuer.");
            consignes.setForeground(Color.WHITE);
            consignes.setAlignmentX(Component.CENTER_ALIGNMENT);

            panneauFond.add(Box.createRigidArea(new Dimension(0, 20)));
            panneauFond.add(bienvenue);
            panneauFond.add(Box.createRigidArea(new Dimension(0, 10)));
            panneauFond.add(consignes);
            panneauFond.add(Box.createRigidArea(new Dimension(0, 20)));

            // === Ligne de séparation ===
            JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
            separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
            panneauFond.add(separator);
            panneauFond.add(Box.createRigidArea(new Dimension(0, 10)));

            // === Zone des boutons ===
            JPanel panneauBoutons = new JPanel(new GridLayout(1, 2));
            panneauBoutons.setOpaque(false); // transparent pour voir l'image derrière

            JPanel gauche = new JPanel(new FlowLayout(FlowLayout.CENTER));
            gauche.setOpaque(false);
            JButton boutonGauche = new JButton("Retour");
            gauche.add(boutonGauche);

            JPanel droite = new JPanel(new FlowLayout(FlowLayout.CENTER));
            droite.setOpaque(false);
            JButton boutonDroite = new JButton("Continuer");
            droite.add(boutonDroite);

            panneauBoutons.add(gauche);
            panneauBoutons.add(droite);

            panneauFond.add(panneauBoutons);

            // === Ajout dans la fenêtre ===
            fenetre.setContentPane(panneauFond);
            fenetre.setVisible(true);
        });
    }
}

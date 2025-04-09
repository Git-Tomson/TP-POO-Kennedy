package testsDuProjet;
import javax.swing.*;
import java.awt.*;
public class testInterfaceLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame fenetre = new JFrame("Bienvenue");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setSize(400, 200);
            fenetre.setLocationRelativeTo(null);

            JPanel panneauPrincipal = new JPanel();
            panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));

            JLabel bienvenue = new JLabel("Bienvenue dans l'application !");
            bienvenue.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel consignes = new JLabel("Veuillez lire attentivement les consignes avant de continuer.");
            consignes.setAlignmentX(Component.CENTER_ALIGNMENT);

            panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
            panneauPrincipal.add(bienvenue);
            panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
            panneauPrincipal.add(consignes);
            panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

            // Ajout d'une ligne de séparation
            panneauPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
            panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));

            // === Zone des boutons ===
            JPanel panneauBoutons = new JPanel(new GridLayout(1, 2));

            // Sous-panneau gauche avec bouton centré
            JPanel gauche = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton boutonGauche = new JButton("Retour");
            gauche.add(boutonGauche);

            // Sous-panneau droit avec bouton centré
            JPanel droite = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton boutonDroite = new JButton("Continuer");
            droite.add(boutonDroite);

            panneauBoutons.add(gauche);
            panneauBoutons.add(droite);

            panneauPrincipal.add(panneauBoutons);

            fenetre.setContentPane(panneauPrincipal);
            fenetre.setVisible(true);
        });
    }
}

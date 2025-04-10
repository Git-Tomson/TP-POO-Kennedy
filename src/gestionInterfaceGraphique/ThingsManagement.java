package gestionInterfaceGraphique;
import connectionBD.ConnectionToDB;
import objetsVolés.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ThingsManagement extends JPanel{
    protected ConnectionToDB connectionToDB;
    public ThingsManagement(ConnectionToDB connectionToDB){

        // Image de fond
        ImageIcon imageIcon = new ImageIcon("/home/tomson/Thomas/Cours_3GI/S2/POO2/TP-POO-Kennedy/fontThingsManagement.jpg");
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
        UIManager.put("Label.foreground", Color.BLACK);//Couleur des Labels
        JLabel labelId = new JLabel("Identifiant de l'objet (Adresse MAC ou autre):");
        JTextField champId = new JTextField(20);

        JLabel labelNom = new JLabel("Nom de l'objet :");
        JTextField champNom = new JTextField(20);

        JLabel labelType = new JLabel("Type de l'objet :");
        String[] typesDisponibles = {"Téléphone", "Ordinateur"};
        JComboBox<String> champType = new JComboBox<>(typesDisponibles);


        JLabel labelTelProprio = new JLabel("Tel du proprétaire :");
        JTextField champTelProprio = new JTextField(20);

        JButton boutonEnregistrer = new JButton("Enregistrer");
        JButton boutonVérifier = new JButton("Vérifier");
        JButton boutonBack = new JButton("Back");

        // Action du bouton Enregistrer
        boutonEnregistrer.addActionListener((ActionEvent e) -> {
            // Récupérer les valeurs des champs
            String Id = champId.getText();
            String Nom = champNom.getText();
            String Type = (String) champType.getSelectedItem();
            String Telephone = champTelProprio.getText();

            //User user = new UserMySQL(nom, prenom, telephone, mdp1);

            // Vérification des champs obligatoires
            if (Id.isEmpty() || Telephone.isEmpty() || Type.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tous les champs obligatoires doivent être remplis.");
                return;
            }

            // Vérification du numéro de téléphone (9 chiffres)
            if (!Telephone.matches("\\d{9}") || Telephone.charAt(0)!='6') {
                JOptionPane.showMessageDialog(null, "Le numéro de téléphone doit être un entier de 9 chiffres"
                +" sans espace commençant par le chiffre 6");
                return;
            }
            //Insertion de l'objet dans la BD
            Thing thing = null;
            if(Type == "Téléphone"){
                thing = new Phone(Id, Nom, Type,Integer.parseInt(Telephone));
            } else if (Type == "Ordinateur") {
                thing = new Computer(Id, Nom, Type,Integer.parseInt(Telephone));
            }
            thing.insertThing(connectionToDB);
            // Affichage des données saisies (ou traitement de l'inscription)
            JOptionPane.showMessageDialog(null, "Enregistrement réussie :\n" +
                    "Identifiant : " + Id + "\n" +
                    "Nom : " + Nom + "\n" +
                    "Numéro du Proprio : " + Telephone);
            Thing phone = new Phone(Id, Nom, Type, Integer.parseInt(Telephone));
        });

        //Action du bouton Vérifier
        boutonVérifier.addActionListener((ActionEvent e) -> {
            // Récupérer les valeurs des champs
            String Id = champId.getText();
            String Nom = null;
            Nom = champNom.getText();
            String Type = (String) champType.getSelectedItem();
            String Telephone = null;
            Telephone = champTelProprio.getText();

            //User user = new UserMySQL(nom, prenom, telephone, mdp1);

            // Vérification des champs obligatoires
            if (Id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La vérification nécessite l'identifiant");
                return;
            }
            //Vérification de l'objet
            Thing thing = null;
            if(Type == "Téléphone"){
                thing = new Phone();
                thing.setId(Id);
            }
            if(Type == "Ordinateur"){
                thing = new Computer();
                thing.setId(Id);
            }
            if(thing.searchThing(connectionToDB)){
                JOptionPane.showMessageDialog(null, "Objet enregistré comme volé!\n"
                +" Ne surtout pas l'acheter!\n"+
                " Nous venons d'alerter le véritable propriétaire!");
            }else {
                JOptionPane.showMessageDialog(null, "Objet ne figurant pas dans la"+
                        " liste de ceux enregistrés chez nous comme volés");
            }
        });
        boutonBack.addActionListener(e->{
            this.removeAll();
            Welcome welcome = new Welcome();
            Window thisWindow = SwingUtilities.getWindowAncestor(this);
            if(thisWindow != null){
                thisWindow.dispose();
            }

        });

        // Ajouter les composants au panneau
        pane.add(labelId);
        pane.add(champId);
        pane.add(labelNom);
        pane.add(champNom);
        pane.add(labelType);
        pane.add(champType);
        pane.add(labelTelProprio);
        pane.add(champTelProprio);
        pane.add(boutonEnregistrer);
        pane.add(boutonVérifier);
        pane.add(boutonBack);

        this.setLayout(new BorderLayout()); // Utilisation du BorderLayout
        this.add(pane, BorderLayout.CENTER);
    }
}
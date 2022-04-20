import javax.swing.*;
import java.awt.*;

public class Test {
  public static void main (String[] args){
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    fenetre.setSize(800, 500);
    fenetre.setLocation(50, 50);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //création des boutons
    JRadioButton bouton1 = new JRadioButton("Gryffondor");
    JRadioButton bouton2 = new JRadioButton("Serdaigle");
    JRadioButton bouton3 = new JRadioButton("Serpentard");
    JRadioButton bouton4 = new JRadioButton("Poufsouffle");

    //configuration des boutons
    bouton1.setHorizontalAlignment(SwingConstants.CENTER);
    bouton2.setHorizontalAlignment(SwingConstants.CENTER);
    bouton3.setHorizontalAlignment(SwingConstants.CENTER);
    bouton4.setHorizontalAlignment(SwingConstants.CENTER);

    ButtonGroup groupBouton = new ButtonGroup();
    groupBouton.add(bouton1);
    groupBouton.add(bouton2);
    groupBouton.add(bouton3);
    groupBouton.add(bouton4);

    //configuration de la mise en page
    GridLayout gestionnaire = new GridLayout(4, 1);
    fenetre.setLayout(gestionnaire);

    // on ajoute le composant dans la fenetre
    fenetre.add(bouton1);
    fenetre.add(bouton2);
    fenetre.add(bouton3);
    fenetre.add(bouton4);

    // et on montre le resultat
    fenetre.setVisible(true);
  }
}

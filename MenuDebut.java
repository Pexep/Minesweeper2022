import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 * La classe <code>MenuDebut</code> est la disposition du menu d'accueil.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class MenuDebut extends Disposition{
  /**
   * Le constructeur. Crée un nouveau menu d'accueil.
   * @param fenetre la fenêtre dans laquelle se trouve le menu
  */
  public MenuDebut(JFrame fenetre){
    super(fenetre);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setSize(700,400);
    this.setLayout(new GridLayout(3,3));
    JPanel panneau = new JPanel(new GridLayout(5,1));
    JButton bouttonJouer = new JButton("Jouer");
    JButton bouttonReprendre = new JButton("Reprendre");
    JButton bouttonQuitter = new JButton("Quitter");
    bouttonJouer.addActionListener(new ActionChoix(this));
    bouttonReprendre.addActionListener(new ActionReprendre(this));
    bouttonQuitter.addActionListener(new ActionQuitDebut(this));
    panneau.add(bouttonJouer);
    panneau.add(new JPanel());
    panneau.add(bouttonReprendre);
    panneau.add(new JPanel());
    panneau.add(bouttonQuitter);
    for (int i = 0; i<9;i++){
      if (i!=4){
        this.add(new JPanel());
      }else{
        this.add(panneau);
      }
    }
    try{
      FileInputStream fichier = new FileInputStream("save.bin");
      DataInputStream fis = new DataInputStream(fichier);
      try{
        if (fis.readBoolean()){
        }else{
          bouttonReprendre.setEnabled(false);

        }
      }catch (IOException e){
        System.err.println("Erreur d'écriture de la grille !");
      }
      try{
        fis.close();
      }catch (IOException e){
        System.err.println("Erreur de fermeture !");
      }
    }catch (IOException e){
      System.err.println("Erreur d'ouverture !");
      bouttonReprendre.setEnabled(false);
    }
  }
}

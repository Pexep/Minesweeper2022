import javax.swing.*;
import java.awt.*;
/**
* La classe <code>Demineur</code> contient le main.
* @version 1.1
* @author Mathis Chaigneau
*/
public class Demineur {
  /**
   * Le main. Crée la fenêtre et initialise un nouveau menu d'accueil.
  */
  public static void main(String[] args) {
    JFrame fenetre = new JFrame();
    fenetre.setLocation(50,50);
    MenuDebut menu = new MenuDebut(fenetre);
    fenetre.add(menu);
    fenetre.setVisible(true);
  }
}

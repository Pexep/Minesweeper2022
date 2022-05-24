import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * La classe <code>ActionReprendre</code> permet de faire d'un bouton un observateur qui renvoie vers une partie sauvegardée.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class ActionReprendre implements ActionListener{
  /**
   * Le menu d'accueil dans lequel le bouton se trouve.
  */
  private MenuDebut menu;

  /**
   * Le constructeur.
   * @param menu le menu d'accueil dans lequel le bouton se trouve.
  */
  public ActionReprendre(MenuDebut menu){
    this.menu=menu;
  }

  /**
   * En cas de clic sur l'observateur, cette classe est appellée et affiche une partie sauvegardée.
   * @param evenement le context du clic
  */
  public void actionPerformed(ActionEvent evenement){
    this.menu.getFenetre().setVisible(false);
    JFrame fenetre = this.menu.getFenetre();
    fenetre.remove(menu);
    fenetre.revalidate();
    fenetre.add(new Partie(fenetre));
    this.menu.getFenetre().setVisible(true);
  }
}

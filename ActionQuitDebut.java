import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * La classe <code>ActionQuitDebut</code> permet de faire d'un bouton un observateur qui quitte un menu d'accueil.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class ActionQuitDebut implements ActionListener{
  /**
   * Le menu d'accueil dans lequel le bouton se trouve.
  */
  private MenuDebut menu;

  /**
   * Le constructeur.
   * @param menu le menu d'accueil dans lequel le bouton se trouve
  */
  public ActionQuitDebut(MenuDebut menu){
    this.menu=menu;
  }

  /**
   * En cas de clic sur l'observateur, cette classe est appellée et quitte le menu d'accueil.
   * @param evenement le context du clic
  */
  public void actionPerformed(ActionEvent evenement){
    menu.getFenetre().dispose();
  }
}

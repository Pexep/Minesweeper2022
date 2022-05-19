import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * La classe <code>ActionChoix</code> permet de faire d'un bouton un observateur qui renvoie vers le menu de choix pour une nouvelle partie.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class ActionChoix implements ActionListener{
  /**
   * La Disposition dans laquelle le bouton se trouve.
  */
  private Disposition menu;

  /**
   * Le constructeur.
   * @param menu la Disposition dans laquelle le bouton se trouve
  */
  public ActionChoix(Disposition menu){
    this.menu=menu;
  }

  /**
   * En cas de clic sur l'observateur, cette classe est appellée et crée et affiche un nouveau menu de choix.
   * @param evenement le context du clic
  */
  public void actionPerformed(ActionEvent evenement){
    this.menu.getFenetre().setVisible(false);
    JFrame fenetre = this.menu.getFenetre();
    fenetre.remove(menu);
    fenetre.revalidate();
    fenetre.add(new MenuChoix(fenetre));
    this.menu.getFenetre().setVisible(true);
  }
}

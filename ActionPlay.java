import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * La classe <code>ActionPlay</code> permet de faire d'un bouton un observateur qui renvoie vers une nouvelle partie.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class ActionPlay implements ActionListener{
  /**
   * Le menu de choix dans lequel le bouton se trouve.
  */
  private MenuChoix menu;

  /**
   * Le constructeur.
   * @param menu le menu de choix dans lequel le bouton se trouve
  */
  public ActionPlay(MenuChoix menu){
    this.menu=menu;
  }

  /**
   * En cas de clic sur l'observateur, cette classe est appellée et crée et affiche une nouvelle partie.
   * @param evenement le context du clic
  */
  public void actionPerformed(ActionEvent evenement){
    int[] choix = menu.getChoix();
    if (choix[0]!=0 && choix[1]!=0 && choix[2]!=0){
      this.menu.getFenetre().setVisible(false);
      JFrame fenetre = this.menu.getFenetre();
      fenetre.remove(menu);
      fenetre.revalidate();
      fenetre.add(new Partie(fenetre, choix));
      this.menu.getFenetre().setVisible(true);
    }

  }
}

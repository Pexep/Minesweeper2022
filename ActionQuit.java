import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * La classe <code>ActionQuit</code> permet de faire d'un bouton un observateur qui quitte une partie. Si cette partie n'est pas finie, elle est enregistrée.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class ActionQuit implements ActionListener{
  /**
   * La partie dans laquelle le bouton se trouve.
  */
  private Partie partie;

  /**
   * Le constructeur.
   * @param partie la partie dans laquelle le bouton se trouve
  */
  public ActionQuit(Partie partie){
    this.partie=partie;
  }

  /**
   * En cas de clic sur l'observateur, cette classe est appellée et quitte la partie. Si cette partie n'est pas finie, elle est enregistrée.
   * @param evenement le context du clic
  */
  public void actionPerformed(ActionEvent evenement){
    if (this.partie.getGrille().getGrilleFinie()){
    }else{
    this.partie.getGrille().sauverGrille();
    }
    partie.getFenetre().dispose();
  }
}

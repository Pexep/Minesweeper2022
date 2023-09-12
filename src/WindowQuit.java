import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * La classe <code>WindowQuit</code> permet de faire d'une fenêtre un observateur quand une partie est affichée, qui femre la fenêtre et sauvegarde la partie si elle n'est pas finie.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class WindowQuit implements WindowListener{
  /**
   * La partie qui est affichée.
  */
  private Partie partie;

  /**
   * Le constructeur. Un objet de cette classe ne devra être ajouté qu'à une fenêtre affichant une partie et devra être supprimé en cas de suppression de la partie.
   * @param partie la partie qui est affichée
  */
  public WindowQuit(Partie partie){
    this.partie=partie;
  }

  /**
   * Quand la fenêtre devient la fenêtre active, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void windowActivated(WindowEvent event){}

  /**
   * Quand la fenêtre a été fermée, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void windowClosed(WindowEvent event){}


  /**
   * En cas de fermeture de la fnêtre, cette classe est appellée et femre la fenêtre et sauvegarde la partie si elle n'est pas finie.
   * @param event le context du clic
  */
  @Override
  public void windowClosing(WindowEvent event){
    if (this.partie.getGrille().getGrilleFinie()){
    }else{
      this.partie.getGrille().sauverGrille();
    }
    event.getWindow().dispose();
  }

  /**
   * Quand la fenêtre n'est plus la fenêtre active, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void windowDeactivated(WindowEvent event){}

  /**
   * Quand la fenêtre sort de l'état de minimisation, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void windowDeiconified(WindowEvent event){}

  /**
   * Quand la fenêtre entre dans l'état de minimisation, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void windowIconified(WindowEvent event){}

  /**
   * Quand la fenêtre s'ouvre, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void windowOpened(WindowEvent event){}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
/**
 * La classe <code>ClickOnCase</code> permet de faire d'une case un observateur, selon le clic, l'état de la grille et l'état de la case, modifie la case, les cases adjacentes et/ou la grille.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class ClickOnCase implements MouseListener{
  /**
   * La partie dans laquelle la case se trouve.
  */
  private Partie partie;

  /**
   * Le constructeur.
   * @param partie la partie dans laquelle la case se trouve
  */
  public ClickOnCase (Partie partie){
    this.partie=partie;
  }

  /**
   * En cas de clic sur l'observateur, cette classe est appellée et modifie la case, les cases adjacentes et/ou la grille selon l'état de la grille.
   * @param event le context de l'événement
  */
  @Override
  public void mouseClicked (MouseEvent event){
    Case case1 = (Case) event.getComponent();
    if (case1.getGrille().getGrilleFinie()){
    }else{
      if (event.getButton()==MouseEvent.BUTTON1){
        if (case1.getHideStatus()!=0){
          while(case1.getHideStatus()!=0){
            case1.switchHideStatus();
            this.partie.changeNombreSuppose();
          }
        }else {
          if (case1.getBombe()){
            case1.getGrille().revelationDefaite(case1);
            this.partie.partieFinie(false);
          }else{
            case1.setCaseVisible();
            if (case1.getGrille().getNombreCaseCachee()==case1.getGrille().getNombreBombe()){
              case1.getGrille().revelationVictoire();
              this.partie.partieFinie(true);
            }
          }
        }
      }else if (event.getButton()==MouseEvent.BUTTON3){
        case1.switchHideStatus();
        this.partie.changeNombreSuppose();
      }
      SwingUtilities.updateComponentTreeUI(this.partie.getFenetre());
    }
  }

  /**
   * Quand la souris entre sur l'observateur, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void mouseEntered (MouseEvent event){

  }

  /**
   * Quand la souris sort de l'observateur, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void mouseExited (MouseEvent event){

  }

  /**
   * Quand la pression d'un clic commence, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void mousePressed (MouseEvent event){

  }

  /**
   * Quand la pression d'un clic prend fin, cette classe est appellée et ne fait rien.
   * @param event le context de l'événement
  */
  @Override
  public void mouseReleased (MouseEvent event){

  }
}

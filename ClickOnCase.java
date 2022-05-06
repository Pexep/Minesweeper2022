import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class ClickOnCase implements MouseListener{
  private Partie partie;
  public ClickOnCase (Partie partie){
    this.partie=partie;
  }

  public void mouseClicked (MouseEvent event){
    Case case1 = (Case) event.getComponent();
    if (case1.getGrille().getGrilleFinie()){
    }else{
      if (event.getButton()==MouseEvent.BUTTON1){
        if (case1.getHideStatus()!=0){
          while(case1.getHideStatus()!=0){
            case1.switchHideStatus();
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
  public void mouseEntered (MouseEvent event){

  }
  public void mouseExited (MouseEvent event){

  }
  public void mousePressed (MouseEvent event){

  }
  public void mouseReleased (MouseEvent event){

  }
}

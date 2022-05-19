import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowQuit implements WindowListener{
  private Partie partie;
  public WindowQuit(Partie partie){
    this.partie=partie;
  }

  @Override
  public void windowActivated(WindowEvent event){}

  @Override
  public void windowClosed(WindowEvent event){}

  @Override
  public void windowClosing(WindowEvent event){
    if (this.partie.getGrille().getGrilleFinie()){
    }else{
      this.partie.getGrille().sauverGrille();
    }
    event.getWindow().dispose();
  }

  @Override
  public void windowDeactivated(WindowEvent event){}

  @Override
  public void windowDeiconified(WindowEvent event){}

  @Override
  public void windowIconified(WindowEvent event){}

  @Override
  public void windowOpened(WindowEvent event){}
}

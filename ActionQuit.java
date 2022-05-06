import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionQuit implements ActionListener{
  private Partie partie;
  public ActionQuit(Partie partie){
    this.partie=partie;
  }
  public void actionPerformed(ActionEvent evenement){
    if (this.partie.getGrille().grilleFinie()){
    }else{
    this.partie.getGrille().sauverGrille();
    }
    System.out.println("Quit");
    partie.getFenetre().dispose();
  }
}

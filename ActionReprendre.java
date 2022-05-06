import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionReprendre implements ActionListener{
  private MenuDebut menu;
  public ActionReprendre(MenuDebut menu){
    this.menu=menu;
  }
  public void actionPerformed(ActionEvent evenement){
    System.out.println("Reprendre");
  }
}

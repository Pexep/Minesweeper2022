import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionQuitDebut implements ActionListener{
  private MenuDebut menu;
  public ActionQuitDebut(MenuDebut menu){
    this.menu=menu;
  }
  public void actionPerformed(ActionEvent evenement){
    menu.getFenetre().dispose();
  }
}

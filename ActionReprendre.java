import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionReprendre implements ActionListener{
  private MenuDebut menu;
  public ActionReprendre(MenuDebut menu){
    this.menu=menu;
  }
  public void actionPerformed(ActionEvent evenement){
    this.menu.getFenetre().setVisible(false);
    JFrame fenetre = this.menu.getFenetre();
    fenetre.remove(menu);
    fenetre.revalidate();
    fenetre.add(new Partie(fenetre));
    this.menu.getFenetre().setVisible(true);
    System.out.println("Reprendre");
  }
}

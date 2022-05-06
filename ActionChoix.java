import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionChoix implements ActionListener{
  private Disposition menu;
  public ActionChoix(Disposition menu){
    this.menu=menu;
  }
  public void actionPerformed(ActionEvent evenement){
    this.menu.getFenetre().setVisible(false);
    JFrame fenetre = this.menu.getFenetre();
    fenetre.remove(menu);
    fenetre.revalidate();
    fenetre.add(new MenuChoix(fenetre));
    this.menu.getFenetre().setVisible(true);
  }
}

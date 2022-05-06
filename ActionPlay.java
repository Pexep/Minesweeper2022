import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionPlay implements ActionListener{
  private MenuChoix menu;
  public ActionPlay(MenuChoix menu){
    this.menu=menu;
  }
  public void actionPerformed(ActionEvent evenement){
    int[] choix = menu.getChoix();
    if (choix[0]!=0 && choix[1]!=0 && choix[2]!=0){
      this.menu.getFenetre().setVisible(false);
      JFrame fenetre = this.menu.getFenetre();
      fenetre.remove(menu);
      fenetre.revalidate();
      fenetre.add(new Partie(fenetre, choix));
      this.menu.getFenetre().setVisible(true);
    }

  }
}

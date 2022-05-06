import javax.swing.*;
import java.awt.*;

public class Demineur {
  public static void main(String[] args) {
    JFrame fenetre = new JFrame();
    fenetre.setLocation(50,50);
    MenuDebut menu = new MenuDebut(fenetre);
    fenetre.add(menu);
    fenetre.setVisible(true);
  }
}

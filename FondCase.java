import java.awt.*;
import javax.swing.*;

public class FondCase extends JComponent {
  public FondCase(){
    super();
  }
  public void setFondCase (Graphics pinceau, Color couleur){
    pinceau.setColor(couleur);
    pinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
  }
}

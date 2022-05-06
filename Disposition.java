import javax.swing.*;
import java.awt.*;

public class Disposition extends JPanel{
  protected JFrame fenetre;

  public Disposition(JFrame fenetre){
    this.fenetre=fenetre;
  }

  public JFrame getFenetre(){
    return this.fenetre;
  }
}

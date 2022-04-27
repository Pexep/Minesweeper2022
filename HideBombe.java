import java.awt.*;
import javax.swing.*;

public class HideBombe extends HideCase {
  public HideBombe(){
    super();
  }
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.paintCase(secondPinceau,"★");
  }
}

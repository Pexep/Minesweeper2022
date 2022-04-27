import java.awt.*;
import javax.swing.*;

public class HideVoid extends HideCase {
  public HideVoid(){
    super();
  }
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.paintCase(secondPinceau,"");
  }
}

import java.awt.*;
import javax.swing.*;

public class HideSuppose extends HideCase {
  public HideSuppose(){
    super();
  }
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.paintCase(secondPinceau," ?");
  }
}

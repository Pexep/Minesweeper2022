import java.awt.*;
import javax.swing.*;

public class Visible extends FondCase {
  private int nombreBombe;
  public Visible (int nombreBombe){
    super();
    this.nombreBombe=nombreBombe;
  }
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.setFondCase(secondPinceau,new Color(211,211,211));
    if (this.nombreBombe!=0){
      int min = Math.min(this.getWidth(),this.getHeight());
      int max = Math.max(this.getWidth(),this.getHeight());
      int fontSize = (int) Math.round(min/1.5);
      secondPinceau.setFont(new Font("style",Font.PLAIN,fontSize));
      secondPinceau.setColor(new Color(240,230,140));
      int x =(int) Math.round(this.getWidth()*0.3);
      int y =(int) Math.round(this.getHeight()*0.75);
      if (this.getWidth()>this.getHeight()){
        x =(int) Math.round(this.getWidth()*0.3+(max-min)*0.25);
        y =(int) Math.round(this.getHeight()*0.75);
      }
      if (this.getWidth()<this.getHeight()){
        x =(int) Math.round(this.getWidth()*0.3);
        y =(int) Math.round(this.getHeight()*0.75-(max-min)*0.25);
      }
      secondPinceau.drawString(""+this.nombreBombe,x,y);
    }
  }
}

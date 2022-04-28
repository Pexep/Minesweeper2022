import java.awt.*;
import javax.swing.*;

public class DefaiteOrigine extends FondCase {
  public DefaiteOrigine (){
    super();
  }
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.setFondCase(secondPinceau,new Color(255,0,0));
    int min = Math.min(this.getWidth(),this.getHeight());
    int max = Math.max(this.getWidth(),this.getHeight());
    secondPinceau.setFont(new Font("style",Font.PLAIN,Math.round(min/2)));
    secondPinceau.setColor(new Color(0,0,0));
    int x =(int) Math.round(this.getWidth()*0.3);
    int y =(int) Math.round(this.getHeight()*0.7);
    if (this.getWidth()>this.getHeight()){
      x =(int) Math.round(this.getWidth()*0.3+(max-min)*0.25);
      y =(int) Math.round(this.getHeight()*0.7);
    }
    if (this.getWidth()<this.getHeight()){
      x =(int) Math.round(this.getWidth()*0.3);
      y =(int) Math.round(this.getHeight()*0.7-(max-min)*0.25);
    }
    secondPinceau.drawString("💣",x,y);
  }
}

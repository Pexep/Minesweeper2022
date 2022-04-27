import java.awt.*;
import javax.swing.*;

public class HideCase extends FondCase {
  public HideCase (){
    super();
  }
  public void paintCase (Graphics pinceau, String caractere){
    this.setFondCase(pinceau,new Color(128,128,128));
    int min = Math.min(this.getWidth(),this.getHeight());
    int max = Math.max(this.getWidth(),this.getHeight());
    pinceau.setFont(new Font("style",Font.PLAIN,Math.round(min/2)));
    pinceau.setColor(new Color(255,0,255));
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
    pinceau.drawString(caractere,x,y);
  }
}

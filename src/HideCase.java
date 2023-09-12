import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>HideCase</code> est un composant graphique qui sert de base pour les cases cachées.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class HideCase extends FondCase {
  /**
   * Le constructeur. Une nouvelle base de case cachée.
  */
  public HideCase (){
    super();
  }

  /**
   * Dessine une case cachée.
   * @param pinceau le context graphique
   * @param caractere le marqueur à afficher sur la case cachée. 
  */
  public void paintCase (Graphics pinceau, String caractere){
    this.setFondCase(pinceau,new Color(105,105,105));
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

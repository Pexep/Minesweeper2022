import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>Visible</code> est un composant graphique qui sert à dessiner une case. Ici, une case révélée contenant le nombre de cases environnantes minées.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class Visible extends FondCase {
  /**
   * Le nombre de cases environnantes minées.
  */
  private int nombreBombe;

  /**
   * Le constructeur. Un nouveau dessin de case révélée.
   * @param nombreBombe le nombre de cases environnantes minées
  */
  public Visible (int nombreBombe){
    super();
    this.nombreBombe=nombreBombe;
  }

  /**
   * Dessine une case révélée contenant le nombre de cases environnantes minées.
   * @param pinceau le context graphique
  */
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.setFondCase(secondPinceau,new Color(169,169,169));
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

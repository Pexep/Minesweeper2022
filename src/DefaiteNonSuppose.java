import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>DefaiteNonSuppose</code> est un composant graphique qui sert à dessiner une case. Ici, une case minée et non supposée minée, après révélation d'une grille.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class DefaiteNonSuppose extends FondCase {
  /**
   * Le constructeur. Un nouveau dessin de case minée et non supposée minée.
  */
  public DefaiteNonSuppose (){
    super();
  }

  /**
   * Dessine une case minée et non supposée minée à la révélation d'une grille.
   * @param pinceau le context graphique
  */
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.setFondCase(secondPinceau,new Color(255,165,0));
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

import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>DefaiteOrigine</code> est un composant graphique qui sert à dessiner une case. Ici, la case minée qui est à l'origine de la défaite.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class DefaiteOrigine extends FondCase {
    /**
   * Le constructeur. Un nouveau dessin de case minée à l'origine de la défaite.
  */
  public DefaiteOrigine (){
    super();
  }

  /**
   * Dessine une case minée qui est à l'origine de la défaite.
   * @param pinceau le context graphique
  */
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

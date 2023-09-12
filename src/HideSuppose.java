import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>HideSuppose</code> est un composant graphique qui sert à dessiner une case. Ici, une case cachée contenant le marqueur de suspicion de bombe.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class HideSuppose extends HideCase {
  /**
   * Le constructeur. Un nouveau dessin de case cachée contenant le marqueur de suspicion de bombe.
  */
  public HideSuppose(){
    super();
  }

  /**
   * Dessine une case cachée contenant le marqueur de suspicion de bombe.
   * @param pinceau le context graphique
  */
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.paintCase(secondPinceau," ?");
  }
}

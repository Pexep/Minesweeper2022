import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>HideBombe</code> est un composant graphique qui sert à dessiner une case. Ici, une case cachée contenant le marqueur de supposition de bombe.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class HideBombe extends HideCase {
  /**
   * Le constructeur. Un nouveau dessin de case cachée contenant le marqueur de supposition de bombe.
  */
  public HideBombe(){
    super();
  }

  /**
   * Dessine une case cachée contenant le marqueur de supposition de bombe.
   * @param pinceau le context graphique
  */
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.paintCase(secondPinceau,"★");
  }
}

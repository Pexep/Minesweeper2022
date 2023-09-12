import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>HideVoid</code> est un composant graphique qui sert à dessiner une case. Ici, une case cachée ne contenant aucun marqueur.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class HideVoid extends HideCase {
  /**
   * Le constructeur. Un nouveau dessin de case cachée ne contenant aucun marqueur.
  */
  public HideVoid(){
    super();
  }

  /**
   * Dessine une case cachée ne contenant aucun marqueur.
   * @param pinceau le context graphique
  */
  @Override
  protected void paintComponent (Graphics pinceau){
    Graphics secondPinceau = pinceau.create();
    this.paintCase(secondPinceau,"");
  }
}

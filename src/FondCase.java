import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>FondCase</code> est un composant graphique qui sert de base pour les cases. C'est le fond de la case.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class FondCase extends JComponent {
  /**
   * Le constructeur. Un nouveau fond de case.
  */
  public FondCase(){
    super();
  }

  /**
   * Dessine le fond d'une case.
   * @param pinceau le context graphique
   * @param couleur la couleur de fond souhaitée
  */
  public void setFondCase (Graphics pinceau, Color couleur){
    pinceau.setColor(couleur);
    pinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
  }
}

import javax.swing.*;
import java.awt.*;
/**
 * La classe <code>Disposition</code> est une base pour la disposition dans la fenêtre des différentes étapes du jeu.
 * @version 1.1
 * @author Mathis Chaigneau
*/
public class Disposition extends JPanel{
  /**
   * La fenêtre dans laquelle se trouve la disposition.
  */
  protected JFrame fenetre;

  /**
   * Le constructeur. Une nouvelle base de disposition.
   * @param fenetre la fenêtre dans laquelle se trouve la disposition
  */
  public Disposition(JFrame fenetre){
    this.fenetre=fenetre;
  }

  /**
   * Renvoie la fenêtre dans laquelle se trouve la disposition.
   * @return JFrame la fenêtre dans laquelle se trouve la disposition
  */
  public JFrame getFenetre(){
    return this.fenetre;
  }
}

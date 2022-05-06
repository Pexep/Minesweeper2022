import javax.swing.*;
import java.awt.*;

public class MenuChoix extends Disposition{
  private JLabel erreurLignes;
  private JLabel erreurColonnes;
  private JLabel erreurBombes;
  private JTextField nombreLignes;
  private JTextField nombreColonnes;
  private JTextField nombreBombes;

  public MenuChoix(JFrame fenetre){
    super(fenetre);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setSize(700,400);
    this.setLayout(new GridLayout(3,3));
    JPanel panneauChoix = new JPanel(new GridLayout(8,1));
    JPanel panneauErreur = new JPanel(new GridLayout(8,1));
    JPanel panneauBoutton = new JPanel(new GridLayout(3,3));
    JLabel lignes = new JLabel("Nombre de lignes :");
    lignes.setBackground(panneauChoix.getBackground());
    this.nombreLignes= new JTextField();
    JLabel colonnes = new JLabel("Nombre de colonnes :");
    colonnes.setBackground(panneauChoix.getBackground());
    this.nombreColonnes= new JTextField();
    JLabel bombes = new JLabel("Nombre de bombes :");
    bombes.setBackground(panneauChoix.getBackground());
    this.nombreBombes= new JTextField();
    JButton bouttonJouer = new JButton("Jouer");
    bouttonJouer.addActionListener(new ActionPlay(this));
    panneauChoix.add(lignes);
    panneauChoix.add(this.nombreLignes);
    panneauChoix.add(new JPanel());
    panneauChoix.add(colonnes);
    panneauChoix.add(this.nombreColonnes);
    panneauChoix.add(new JPanel());
    panneauChoix.add(bombes);
    panneauChoix.add(this.nombreBombes);
    this.erreurLignes = new JLabel("Saisissez un nombre entre 4 et 30");
    this.erreurLignes.setVisible(false);
    this.erreurColonnes = new JLabel("Saisissez un nombre entre 4 et 30");
    this.erreurColonnes.setVisible(false);
    this.erreurBombes = new JLabel("Saisissez un nombre raisonnable");
    this.erreurBombes.setVisible(false);
    panneauErreur.add(new JPanel());
    panneauErreur.add(this.erreurLignes);
    panneauErreur.add(new JPanel());
    panneauErreur.add(new JPanel());
    panneauErreur.add(this.erreurColonnes);
    panneauErreur.add(new JPanel());
    panneauErreur.add(new JPanel());
    panneauErreur.add(this.erreurBombes);
    for (int i = 0; i<9; i++){
      if (i!=4){
        panneauBoutton.add(new JPanel());
      }else{
        panneauBoutton.add(bouttonJouer);
      }
    }
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(new JPanel());
    this.add(panneauChoix);
    this.add(panneauErreur);
    this.add(new JPanel());
    this.add(panneauBoutton);
    this.add(new JPanel());
  }
  public int[] getChoix(){
    int[] choix = new int [3];
    int nombreLignes;
    int nombreColonnes;
    int nombreBombes;

    this.erreurLignes.setVisible(false);
    try {
      nombreLignes=Integer.parseInt(this.nombreLignes.getText());
    }catch (NumberFormatException e1){
      nombreLignes=0;
      this.erreurLignes.setVisible(true);
    }
    if (nombreLignes<4 || nombreLignes>30) {
      nombreLignes=0;
      this.erreurLignes.setVisible(true);
    }
    choix[0]=nombreLignes;

    this.erreurColonnes.setVisible(false);
    try {
      nombreColonnes=Integer.parseInt(this.nombreColonnes.getText());
    }catch (NumberFormatException e2){
      nombreColonnes=0;
      this.erreurColonnes.setVisible(true);
    }
    if (nombreColonnes<4 || nombreColonnes>30) {
      nombreColonnes=0;
      this.erreurColonnes.setVisible(true);
    }
    choix[1]=nombreColonnes;

    this.erreurBombes.setVisible(false);
    try {
      nombreBombes=Integer.parseInt(this.nombreBombes.getText());
    }catch (NumberFormatException e3){
      nombreBombes=0;
      this.erreurBombes.setVisible(true);
    }
    if ((nombreLignes!=0 && nombreColonnes!=0) && (nombreBombes<0 || nombreBombes>nombreLignes*nombreColonnes)){
      nombreBombes=0;
      this.erreurBombes.setVisible(true);
    }
    choix[2]=nombreBombes;

    return choix;
  }


}

import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class Partie extends Disposition{
  private Grille grille;
  private JLabel nombreSuppose;
  private JLabel messageFin;
  private JButton bouttonRejouer;
  public Partie (JFrame fenetre, int[] choix){
    super (fenetre);
    this.grille = new Grille(choix[0],choix[1],choix[2],this);
    this.initialisationPartie();
  }
  public Partie (JFrame fenetre){
    super (fenetre);
    this.grille = new Grille(this);
    this.initialisationPartie();

  }
  public void initialisationPartie (){
    this.fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.fenetre.setSize(800,800);
    this.fenetre.addWindowListener(new WindowQuit(this));
    this.setLayout(new GridBagLayout());
  	GridBagConstraints gridConstraints = new GridBagConstraints();
  	gridConstraints.fill = GridBagConstraints.BOTH;
    gridConstraints.gridx = 0;
    gridConstraints.weightx = 1;

    gridConstraints.weighty = 0.1;
  	gridConstraints.gridy = 0;
    JPanel panneauBouttons = new JPanel();
  	this.add(panneauBouttons, gridConstraints);

    gridConstraints.weighty = 0.80;
  	gridConstraints.gridy = 1;
    JPanel panneauGrille = new JPanel();
  	this.add(panneauGrille, gridConstraints);

    gridConstraints.weighty = 0.1;
  	gridConstraints.gridy = 2;
    JPanel panneauFin = new JPanel();
  	this.add(panneauFin, gridConstraints);

    panneauBouttons.setLayout(new GridLayout(2,4,20,0));

    JButton bouttonSauverQuitter = new JButton("Sauver et Quitter");
    bouttonSauverQuitter.addActionListener(new ActionQuit(this));

    this.bouttonRejouer = new JButton("Rejouer");
    this.bouttonRejouer.addActionListener(new ActionChoix(this));
    this.bouttonRejouer.setVisible(false);

    this.nombreSuppose = new JLabel("Bombes restantes : "+(this.grille.getNombreBombe()-this.grille.getNombreBombeSuppose()));
    this.nombreSuppose.setHorizontalTextPosition(JLabel.CENTER);
    this.nombreSuppose.setVerticalTextPosition(JLabel.CENTER);
    this.nombreSuppose.setHorizontalAlignment(JLabel.CENTER);
    this.nombreSuppose.setVerticalAlignment(JLabel.CENTER);

    for (int i = 0;i<8;i++){
      if (i==1){
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridLayout(2,1));
        panneau.add(new JPanel());
        panneau.add(bouttonSauverQuitter);
        panneauBouttons.add(panneau);
      }else if (i==2) {
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridLayout(2,1));
        panneau.add(new JPanel());
        panneau.add(this.bouttonRejouer);
        panneauBouttons.add(panneau);
      }else if (i==7) {
        panneauBouttons.add(this.nombreSuppose);
      }else {
        panneauBouttons.add(new JPanel());
      }
    }
    panneauBouttons.setSize(new Dimension(1,1));

    panneauGrille.setLayout(new GridBagLayout());
    gridConstraints.weighty = 1;
  	gridConstraints.gridy = 0;

    gridConstraints.gridx = 0;
    gridConstraints.weightx = 0.1;
  	panneauGrille.add( new JPanel(), gridConstraints);

    gridConstraints.gridx = 1;
    gridConstraints.weightx = 0.8;
    panneauGrille.add(this.grille, gridConstraints);

    gridConstraints.gridx = 2;
    gridConstraints.weightx = 0.1;
  	panneauGrille.add(new JPanel(), gridConstraints);

    panneauFin.setLayout(new GridLayout(3,1));

    this.messageFin = new JLabel();
    this.messageFin.setHorizontalTextPosition(JLabel.CENTER);
    this.messageFin.setHorizontalAlignment(JLabel.CENTER);

    panneauFin.add(new JPanel());
    panneauFin.add(this.messageFin);
    panneauFin.add(new JPanel());

  }
  public Grille getGrille(){
    return this.grille;
  }
  public void partieFinie(boolean victoire){
    this.bouttonRejouer.setVisible(true);
    if (victoire){
      this.messageFin.setText("Bien joué, vous avez trouvé toutes les bombes !");
    }else {
      this.messageFin.setText("Vous avez échoué en faisant exploser une bombe !");
    }
  }
  public void changeNombreSuppose(){
    this.nombreSuppose.setText("Bombes restantes : "+(this.grille.getNombreBombe()-this.grille.getNombreBombeSuppose()));
  }
}

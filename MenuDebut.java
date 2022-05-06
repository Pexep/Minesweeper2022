import javax.swing.*;
import java.awt.*;

public class MenuDebut extends Disposition{
  public MenuDebut(JFrame fenetre){
    super(fenetre);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setSize(700,400);
    this.setLayout(new GridLayout(3,3));
    JPanel panneau = new JPanel(new GridLayout(5,1));
    JButton bouttonJouer = new JButton("Jouer");
    JButton bouttonReprendre = new JButton("Reprendre");
    JButton bouttonQuitter = new JButton("Quitter");
    bouttonJouer.addActionListener(new ActionChoix(this));
    bouttonReprendre.addActionListener(new ActionReprendre(this));
    bouttonQuitter.addActionListener(new ActionQuitDebut(this));
    panneau.add(bouttonJouer);
    panneau.add(new JPanel());
    panneau.add(bouttonReprendre);
    panneau.add(new JPanel());
    panneau.add(bouttonQuitter);
    for (int i = 0; i<9;i++){
      if (i!=4){
        this.add(new JPanel());
      }else{
        this.add(panneau);
      }
    }
  }
}

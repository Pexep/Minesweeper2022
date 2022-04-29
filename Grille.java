import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grille extends JPanel{
  private int nombreLigne;
  private int nombreColonne;
  private Case[][] grille;
  private int nombreBombe;
  private int nombreCaseCachee;
  private int nombreBombeSuppose;
  private boolean grilleFinie;
  public Grille (int nombreLigne, int nombreColonne, int nombreBombe, JFrame fenetre){
    super();
    this.nombreLigne=nombreLigne;
    this.nombreColonne=nombreColonne;
    this.nombreBombe=nombreBombe;
    this.nombreCaseCachee=nombreLigne*nombreColonne;
    this.grille=new Case[nombreLigne][nombreColonne];
    GridLayout pause = new GridLayout(nombreLigne,nombreColonne,3,3);
    this.setLayout(pause);
    for (int i=0;i<nombreLigne;i++){
      for (int j=0;j<nombreColonne;j++){
        this.grille[i][j]=new Case(this,i,j,fenetre);
        this.add(grille[i][j]);
      }
    }
    for (int i = 0; i<nombreBombe;){
      Random n = new Random();
      int ligne = n.nextInt(nombreLigne);
      int colonne = n.nextInt(nombreColonne);
      if (this.grille[ligne][colonne].getBombe()){
      }else{
        this.grille[ligne][colonne].setBombe();
        i++;
      }
    }
    this.nombreBombeSuppose=0;
    this.grilleFinie=false;

  }
  public int getNombreLigne(){
    return this.nombreLigne;
  }
  public int getNombreColonne(){
    return this.nombreColonne;
  }
  public Case getCase(int ligne, int colonne){
    return this.grille[ligne][colonne];
  }
  public int getNombreBombe(){
    return this.nombreBombe;
  }
  public int getNombreCaseVisible(){
    return this.nombreLigne*this.nombreColonne-this.nombreCaseCachee;
  }
  public int getNombreCaseCachee(){
    return this.nombreCaseCachee;
  }
  public void moinsNombreCaseCachee(){
    this.nombreCaseCachee--;
  }
  public void incrementeNombreBombeSuppose(int plus){
    this.nombreBombeSuppose+=plus;
  }
  public void sauverGrille(){
    System.out.println("Grille sauvée");
  }
  public void revelationDefaite(Case origine){
    this.grilleFinie=true;
    for (int i=0;i<nombreLigne;i++){
      for (int j=0;j<nombreColonne;j++){
        if (this.grille[i][j].getVisible()){
        }else{
          if (this.grille[i][j]==origine){
            this.grille[i][j].setCaseVisibleDefaite(true);
          }else{
            this.grille[i][j].setCaseVisibleDefaite(false);
          }
        }
      }
    }
  }
  public void revelationVictoire(){
    this.grilleFinie=true;
    for (int i=0;i<nombreLigne;i++){
      for (int j=0;j<nombreColonne;j++){
        if (this.grille[i][j].getVisible()){
        }else{
          this.grille[i][j].setCaseVisibleVictoire();
        }
      }
    }
  }
  public boolean getGrilleFinie(){
    return this.grilleFinie;
  }
}

import javax.swing.*;
import java.awt.*;

public class Grille extends JPanel{
  private int nombreLigne;
  private int nombreColonne;
  private Case[][] grille;
  private int nombreBombe;
  private int nombreCaseCachee;

  public Grille (int nombreLigne, int nombreColonne, int nombreBombe){
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
        this.grille[i][j]=new Case(this,i,j);
        this.add(grille[i][j]);
      }
    }
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
  public void setNombrCaseCachee(int nombreCaseCachee){
    this.nombreCaseCachee=nombreCaseCachee;
  }
}

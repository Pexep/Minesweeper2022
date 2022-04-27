import javax.swing.*;
import java.awt.*;

public class Case extends JPanel{
  private Grille grille;
  private int ligne;
  private int colonne;
  private boolean visible;
  private boolean bombe;
  /*-1 : compte non effectué*/
  private int nombreBombe;
  /*0 : void; 1 : suppose; 2 : bombe*/
  private int hideStatut;

  public Case (Grille grille, int ligne, int colonne){
    super();
    this.grille=grille;
    this.ligne=ligne;
    this.colonne=colonne;
    this.visible=false;
    this.bombe=false;
    this.nombreBombe=-1;
    this.hideStatut=0;
    GridLayout pause = new GridLayout(1,1);
    this.setLayout(pause);
    this.add(new HideVoid());
  }
  public Grille getGrille (){
    return this.grille;
  }
  public int getLigne (){
    return this.ligne;
  }
  public int getColonne (){
    return this.colonne;
  }
  public boolean getVisible (){
    return this.visible;
  }
  public void setCaseVisible (){
    this.visible=true;
    this.remove(0);
    this.add(new Visible(this.getNombreBombe()));
  }
  public boolean getBombe (){
    return this.bombe;
  }
  public void setBombe (){
    this.bombe=true;
  }
  public int getNombreBombe (){
    if (this.nombreBombe==-1 && this.bombe==false){
      this.nombreBombe=this.countNombreBombe();
    }
    return this.nombreBombe;
  }
  public int countNombreBombe (){
    int count = 0;
    int ligneAvant = this.ligne-1;
    int ligneApres = this.ligne+1;
    int colonneAvant = this.colonne-1;
    int colonneApres = this.colonne+1;
    if (ligneAvant>=0 && colonneAvant>=0){
      if (this.grille.getCase(ligneAvant,colonneAvant).getBombe()){
        count++;
      }
    }
    if (ligneAvant>=0){
      if (this.grille.getCase(ligneAvant,this.colonne).getBombe()){
        count++;
      }
    }
    if (ligneAvant>=0 && colonneApres<this.grille.getNombreColonne()){
      if (this.grille.getCase(ligneAvant,colonneApres).getBombe()){
        count++;
      }
    }
    if (colonneApres<this.grille.getNombreColonne()){
      if (this.grille.getCase(this.ligne,colonneApres).getBombe()){
        count++;
      }
    }
    if (ligneApres<this.grille.getNombreLigne() && colonneApres<this.grille.getNombreColonne()){
      if (this.grille.getCase(ligneApres,colonneApres).getBombe()){
        count++;
      }
    }
    if (ligneApres<this.grille.getNombreLigne()){
      if (this.grille.getCase(ligneApres,this.colonne).getBombe()){
        count++;
      }
    }
    if (ligneApres<this.grille.getNombreLigne() && colonneAvant>=0){
      if (this.grille.getCase(ligneApres,colonneAvant).getBombe()){
        count++;
      }
    }
    if (colonneAvant>=0){
      if (this.grille.getCase(this.ligne,colonneAvant).getBombe()){
        count++;
      }
    }
    return count;
  }
  public int getHideStatus (){
    return this.hideStatut;
  }
  public void switchStatus (){
    if (this.hideStatut==0){
      this.remove(0);
      this.add(new HideSuppose());
      this.hideStatut++;
    }else if (this.hideStatut==1) {
      this.remove(0);
      this.add(new HideBombe());
      this.hideStatut++;
    }else{
      this.remove(0);
      this.add(new HideVoid());
      this.hideStatut=0;
    }
  }
}

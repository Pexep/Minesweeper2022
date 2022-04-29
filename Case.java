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
  private ClickOnCase caseListener;

  public Case (Grille grille, int ligne, int colonne, JFrame fenetre){
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
    this.caseListener=new ClickOnCase(fenetre);
    this.addMouseListener(this.caseListener);
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
    this.nombreBombe=this.countNombreBombe();
    this.add(new Visible(this.nombreBombe));
    this.grille.moinsNombreCaseCachee();
    this.removeMouseListener(this.caseListener);
    if (this.nombreBombe==0){
      int[][] tab = this.getCasesVoisines();
      for (int i=1; i<=tab[0][0];i++){
        if (this.grille.getCase(tab[i][0],tab[i][1]).getVisible()){
        }else{
          this.grille.getCase(tab[i][0],tab[i][1]).setCaseVisible();
        }
      }
    }
  }
  public void setCaseVisibleDefaite(boolean origine){
    if (origine){
      this.remove(0);
      this.add(new DefaiteOrigine());
      this.visible=true;
      this.removeMouseListener(this.caseListener);
    }else if (this.bombe && this.hideStatut==0){
      this.remove(0);
      this.add(new DefaiteNonSuppose());
      this.visible=true;
      this.removeMouseListener(this.caseListener);
    }else if (this.bombe==false && this.hideStatut!=0){
      this.remove(0);
      this.add(new DefaiteSuppose());
      this.visible=true;
      this.removeMouseListener(this.caseListener);
    }else if (this.bombe && this.hideStatut!=0) {
      this.remove(0);
      this.add(new GoodSuppose());
      this.visible=true;
      this.removeMouseListener(this.caseListener);
    }
  }
  public void setCaseVisibleVictoire(){
    this.remove(0);
    this.add(new GoodSuppose());
    this.visible=true;
    this.removeMouseListener(this.caseListener);
  }
  public boolean getBombe (){
    return this.bombe;
  }
  public void setBombe (){
    this.bombe=true;
  }
  public int getNombreBombe (){
    return this.nombreBombe;
  }
  public int countNombreBombe (){
    int count = 0;
    int [][] tab = this.getCasesVoisines();
    for (int i = 1; i<=tab[0][0];i++){
      if (this.grille.getCase(tab[i][0],tab[i][1]).getBombe()){
        count++;
      }
    }
    return count;
  }
  public int getHideStatus (){
    return this.hideStatut;
  }
  public void switchHideStatus (){
    if (this.hideStatut==0){
      this.remove(0);
      this.add(new HideSuppose());
      this.hideStatut++;
    }else if (this.hideStatut==1) {
      this.remove(0);
      this.add(new HideBombe());
      this.hideStatut++;
      this.grille.incrementeNombreBombeSuppose(1);
    }else{
      this.remove(0);
      this.add(new HideVoid());
      this.hideStatut=0;
      this.grille.incrementeNombreBombeSuppose(-1);
    }
  }
  public int[][] getCasesVoisines(){
    int[][] tab = new int[9][2];
    int count = 0;
    int ligneAvant = this.ligne-1;
    int ligneApres = this.ligne+1;
    int colonneAvant = this.colonne-1;
    int colonneApres = this.colonne+1;
    if (ligneAvant>=0 && colonneAvant>=0){
      count++;
      tab[count][0]=ligneAvant;
      tab[count][1]=colonneAvant;
    }
    if (ligneAvant>=0){
        count++;
        tab[count][0]=ligneAvant;
        tab[count][1]=this.colonne;
    }
    if (ligneAvant>=0 && colonneApres<this.grille.getNombreColonne()){
        count++;
        tab[count][0]=ligneAvant;
        tab[count][1]=colonneApres;
    }
    if (colonneApres<this.grille.getNombreColonne()){
        count++;
        tab[count][0]=this.ligne;
        tab[count][1]=colonneApres;
    }
    if (ligneApres<this.grille.getNombreLigne() && colonneApres<this.grille.getNombreColonne()){
        count++;
        tab[count][0]=ligneApres;
        tab[count][1]=colonneApres;
    }
    if (ligneApres<this.grille.getNombreLigne()){
        count++;
        tab[count][0]=ligneApres;
        tab[count][1]=this.colonne;
    }
    if (ligneApres<this.grille.getNombreLigne() && colonneAvant>=0){
        count++;
        tab[count][0]=ligneApres;
        tab[count][1]=colonneAvant;
    }
    if (colonneAvant>=0){
        count++;
        tab[count][0]=this.ligne;
        tab[count][1]=colonneAvant;
    }
    tab[0][0]=count;
    tab[0][1]=0;
    return tab;
  }
}

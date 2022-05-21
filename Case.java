import javax.swing.*;
import java.awt.*;
/**
* La classe <code>Case</code> est une case du démineur.
* @version 1.1
* @author Mathis Chaigneau
*/
public class Case extends JPanel{
  /**
   * La grille dans laquelle se trouve la case.
  */
  private Grille grille;

  /**
   * La ligne de la grille sur laquelle se trouve la case.
  */
  private int ligne;

  /**
   * La colonne de la grille dans laquelle se trouve la case.
  */
  private int colonne;

  /**
   * La case est visible.
  */
  private boolean visible;

  /**
   * La case est minée.
  */
  private boolean bombe;

  /**
   * Le nombre de cases minées autour de cette case. A -1 si le compte n'a pas été effectué.
  */
  private int nombreBombe;

  /**
   * Le marqueur sur la case (dans son état caché). 0 : pas de marqueur; 1 : marqueur de suspicion; 2 : marqueur de supposition.
  */
  private int hideStatut;

  /**
   * Le listener qui fait de la case un observateur.
  */
  private ClickOnCase caseListener;

  /**
   * Le constructeur. Crée une nouvelle case dans la cas d'une nouvelle partie.
   * @param grille la grille dans laquelle se trouve la case
   * @param ligne la ligne de la grille sur laquelle se trouve la case
   * @param colonne la colonne de la grille dans laquelle se trouve la case
   * @param partie la disposition de partie dans laquelle se trouve la case
  */
  public Case (Grille grille, int ligne, int colonne, Partie partie){
    super();
    this.grille=grille;
    this.ligne=ligne;
    this.colonne=colonne;
    this.visible=false;
    this.bombe=false;
    this.nombreBombe=-1;
    this.hideStatut=0;
    GridLayout pose = new GridLayout(1,1);
    this.setLayout(pose);
    this.add(new HideVoid());
    this.caseListener=new ClickOnCase(partie);
    this.addMouseListener(this.caseListener);
  }

  /**
   * Le constructeur. Crée une nouvelle case dans la cas de la reprise d'une partie sauvegardée.
   * @param grille la grille dans laquelle se trouve la case
   * @param ligne la ligne de la grille sur laquelle se trouve la case
   * @param colonne la colonne de la grille dans laquelle se trouve la case
   * @param visible un boolean, à vrai si la case est visible, à faux dans le cas constraire
   * @param bombe un boolean, à vrai si la case est minée, à faux dans le cas constraire
   * @param nombreBombe le nombre de cases minées autour de cette case
   * @param hideStatut le marqueur sur la case
   * @param partie la disposition de partie dans laquelle se trouve la case
  */
  public Case (Grille grille, int ligne, int colonne, boolean visible, boolean bombe, int nombreBombe, int hideStatut, Partie partie){
    super();
    this.grille=grille;
    this.ligne=ligne;
    this.colonne=colonne;
    this.visible=visible;
    this.bombe=bombe;
    this.nombreBombe=nombreBombe;
    this.hideStatut=hideStatut;
    GridLayout pose = new GridLayout(1,1);
    this.setLayout(pose);
    if (visible){
      this.add(new Visible(nombreBombe));
    }else{
      if (hideStatut==0){
        this.add(new HideVoid());
      }
      if (hideStatut==1){
        this.add(new HideSuppose());
      }
      if (hideStatut==2){
        this.add(new HideBombe());
      }
    }
    this.caseListener=new ClickOnCase(partie);
    this.addMouseListener(this.caseListener);
  }

  /**
   * Renvoie la grille dans laquelle se trouve la case.
   * @return Grille la grille dans laquelle se trouve la case
  */
  public Grille getGrille (){
    return this.grille;
  }

  /**
   * Renvoie la ligne de la grille sur laquelle se trouve la case.
   * @return ligne la ligne de la grille sur laquelle se trouve la case
  */
  public int getLigne (){
    return this.ligne;
  }

  /**
   * Renvoie la colonne de la grille dans laquelle se trouve la case.
   * @return colonne la colonne de la grille dans laquelle se trouve la case
  */
  public int getColonne (){
    return this.colonne;
  }

  /**
   * Renvoie vrai si la case est visible et faux dans le cas contraire.
   * @return boolean vrai si la case est visible et faux dans le cas contraire
  */
  public boolean getVisible (){
    return this.visible;
  }

  /**
   * Révèle la case dans un contexte de partie.
  */
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

  /**
   * Révèle la case dans un contexte de défaite.
  */
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

  /**
   * Révèle la case dans un contexte de victoire.
  */
  public void setCaseVisibleVictoire(){
    this.remove(0);
    this.add(new GoodSuppose());
    this.visible=true;
    this.removeMouseListener(this.caseListener);
  }

  /**
   * Renvoie vrai si la case est minée et faux dans le cas contraire.
   * @return boolean vrai si la case est minée et faux dans le cas contraire
  */
  public boolean getBombe (){
    return this.bombe;
  }

  /**
   * Fait de cette case une case minée.
  */
  public void setBombe (){
    this.bombe=true;
  }

  /**
   * Renvoie le nombre de cases minées autour de cette case. Appelé quand le compte a déjà été fait.
   * @return int le nombre de cases minées autour de cette case
  */
  public int getNombreBombe (){
    return this.nombreBombe;
  }

  /**
   * Renvoie le nombre de cases minées autour de cette case. Appelé quand le compte n'a pas été fait.
   * @return int le nombre de cases minées autour de cette case
  */
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

  /**
   * Renvoie le marqueur présent sur la case.
   * @return int le marqueur présent sur la case
  */
  public int getHideStatus (){
    return this.hideStatut;
  }

  /**
   * Passe au marqueur suivant.
  */
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

  /**
   * Renvoie les cases voisines à la case.
   * @return int[][] les cases voisines à la case. A l'indice 0 0, le nombre de cases voisines. A l'indice 0 1, une valeur par défaut. Le reste est sous la forme d'un tableau à deux dimensions, la deuxième dimension comporte les coordonnées ligne et colonne des cases dans la grille
  */
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

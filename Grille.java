import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.io.*;
/**
* La classe <code>Grille</code> est la grille de case du démineur.
* @version 1.1
* @author Mathis Chaigneau
*/
public class Grille extends JPanel{
  /**
   * Le nombre de cases sur une ligne de la grille.
  */
  private int nombreLigne;

  /**
   * Le nombre de cases sur une colonne de la grille.
  */
  private int nombreColonne;

  /**
   * Un tableau à deux dimensions contenant toutes les cases de la grille.
  */
  private Case[][] grille;

  /**
   * Le nombre de bombes dans la grille.
  */
  private int nombreBombe;

  /**
   * Le nombre de cases cachées dans la grille.
  */
  private int nombreCaseCachee;

  /**
   * Le nombre de marqueurs de supposition de la présence d'une bombe.
  */
  private int nombreBombeSuppose;

  /**
   * La grille est finie.
  */
  private boolean grilleFinie;

  /**
   * La fenêtre dans laquelle se trouve la grille.
  */
  private JFrame fenetre;

  /**
   * Le constructeur. Crée une nouvelle grille avec les choix de l'utilisateur.
   * @param nombreLigne le nombre de cases sur une ligne de la grille
   * @param nombreColonne le nombre de cases sur une colonne de la grille
   * @param nombreBombe le nombre de bombes dans la grille
   * @param partie la disposition de partie dans laquelle se trouve la grille
  */
  public Grille (int nombreLigne, int nombreColonne, int nombreBombe, Partie partie){
    super();
    this.nombreLigne=nombreLigne;
    this.nombreColonne=nombreColonne;
    this.nombreBombe=nombreBombe;
    this.nombreCaseCachee=nombreLigne*nombreColonne;
    this.grille=new Case[nombreLigne][nombreColonne];
    GridLayout pose = new GridLayout(nombreLigne,nombreColonne,3,3);
    this.setLayout(pose);
    for (int i=0;i<nombreLigne;i++){
      for (int j=0;j<nombreColonne;j++){
        this.grille[i][j]=new Case(this,i,j,partie);
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
    this.fenetre=partie.getFenetre();
  }

  /**
   * Le constructeur. Crée une nouvelle grille avec la sauvegarde de la dernière partie.
   * @param partie la disposition de partie dans laquelle se trouve la grille
  */
  public Grille (Partie partie){
    super();
    try{
    	FileInputStream fichier = new FileInputStream("save.bin");
    	DataInputStream fis = new DataInputStream(fichier);
    	try{
        boolean bool = fis.readBoolean();
        this.nombreLigne = fis.readInt();
        this.nombreColonne = fis.readInt();
        this.nombreBombe = fis.readInt();
        this.nombreCaseCachee = fis.readInt();
        this.nombreBombeSuppose = fis.readInt();
        this.grille=new Case[this.nombreLigne][this.nombreColonne];
        for (int i = 0; i<this.nombreLigne;i++){
          for (int j = 0; j<this.nombreColonne;j++){
            this.grille[i][j] = new Case (this, i, j, fis.readBoolean(), fis.readBoolean(), fis.readInt(), fis.readInt(),partie);
            this.add(grille[i][j]);
          }
        }
    	}catch (IOException e){
    		System.err.println("Erreur de lecture !");
    	}

    	try{
    		fis.close();
    	}catch (IOException e){
    		System.err.println("Erreur de fermeture !");
    	}
    }catch (IOException e){
    	System.err.println("Erreur d'ouverture !");
    }
    GridLayout pose = new GridLayout(this.nombreLigne,this.nombreColonne,3,3);
    this.setLayout(pose);
    this.grilleFinie=false;
    this.fenetre=partie.getFenetre();
    try{
    	FileOutputStream fichier = new FileOutputStream("save.bin");
    	DataOutputStream fos = new DataOutputStream(fichier);
    	try{
        fos.writeBoolean(false);

    	}catch (IOException e){
    		System.err.println("Erreur d'écriture de la grille !");
    	}
    	try{
    		fos.close();
    	}catch (IOException e){
    		System.err.println("Erreur de fermeture !");
    	}
    }catch (IOException e){
    	System.err.println("Erreur d'ouverture !");
    }

  }

  /**
   * Renvoie le nombre de cases sur une ligne de la grille.
   * @return int le nombre de cases sur une ligne de la grille
  */
  public int getNombreLigne(){
    return this.nombreLigne;
  }

  /**
   * Renvoie le nombre de cases sur une colonne de la grille.
   * @return int le nombre de cases sur une colonne de la grille
  */
  public int getNombreColonne(){
    return this.nombreColonne;
  }

  /**
   * Renvoie la case sur la ligne <code>ligne</code> et dans la colonne <code>colonne</code> de la grille.
   * @return Case la case sur la ligne <code>ligne</code> et dans la colonne <code>colonne</code> de la grille
  */
  public Case getCase(int ligne, int colonne){
    return this.grille[ligne][colonne];
  }

  /**
   * Renvoie le nombre de bombes dans la grille.
   * @return int le nombre de bombes dans la grille
  */
  public int getNombreBombe(){
    return this.nombreBombe;
  }

  /**
   * Renvoie le nombre de cases révélées dans la grille.
   * @return int le nombre de cases révélées dans la grille
  */
  public int getNombreCaseVisible(){
    return this.nombreLigne*this.nombreColonne-this.nombreCaseCachee;
  }

  /**
   * Renvoie le nombre de cases cachées dans la grille.
   * @return int le nombre de cases cachées dans la grille
  */
  public int getNombreCaseCachee(){
    return this.nombreCaseCachee;
  }

  /**
   * Décrémente de 1 le nombre de cases cachées.
  */
  public void moinsNombreCaseCachee(){
    this.nombreCaseCachee--;
  }

  /**
   * Renvoie le nombre de marqueurs de supposition de la présence d'une bombe.
   * @return int le nombre de marqueurs de supposition de la présence d'une bombe
  */
  public int getNombreBombeSuppose(){
    return this.nombreBombeSuppose;
  }

  /**
   * Incrémente le nombre de marqueurs de supposition de la présence d'une bombe.
   * @param plus le nombre à incrémenter
  */
  public void incrementeNombreBombeSuppose(int plus){
    this.nombreBombeSuppose+=plus;
  }

  /**
   * Sauvegarde la grille dans son état actuel dans un fichier.
  */
  public void sauverGrille(){
    try{
    	FileOutputStream fichier = new FileOutputStream("save.bin");
    	DataOutputStream fos = new DataOutputStream(fichier);
    	try{
        fos.writeBoolean(true);
        fos.writeInt(this.nombreLigne);
        fos.writeInt(this.nombreColonne);
        fos.writeInt(this.nombreBombe);
        fos.writeInt(this.nombreCaseCachee);
        fos.writeInt(this.nombreBombeSuppose);

    	}catch (IOException e){
    		System.err.println("Erreur d'écriture de la grille !");
    	}
      try{
        for (int i = 0; i<this.nombreLigne;i++){
          for (int j = 0; j<this.nombreColonne;j++){
            fos.writeBoolean(this.grille[i][j].getVisible());
            fos.writeBoolean(this.grille[i][j].getBombe());
            fos.writeInt(this.grille[i][j].getNombreBombe());
            fos.writeInt(this.grille[i][j].getHideStatus());
          }
        }
      }catch (IOException e){
        System.err.println("Erreur d'écriture des cases !");
      }


    	try{
    		fos.close();
    	}catch (IOException e){
    		System.err.println("Erreur de fermeture !");
    	}
    }catch (IOException e){
    	System.err.println("Erreur d'ouverture !");
    }
  }

  /**
   * Révèle la grille en cas de défaite.
   * @param origine la case à l'origine de la défaite
  */
  public void revelationDefaite(Case origine){
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
    this.grilleFinie=true;
    SwingUtilities.updateComponentTreeUI(this.fenetre);
  }

  /**
   * Révèle les cases minées en cas de victoire.
  */
  public void revelationVictoire(){
    for (int i=0;i<nombreLigne;i++){
      for (int j=0;j<nombreColonne;j++){
        if (this.grille[i][j].getVisible()){
        }else{
          this.grille[i][j].setCaseVisibleVictoire();
        }
      }
    }
    this.grilleFinie=true;
    SwingUtilities.updateComponentTreeUI(this.fenetre);
  }

  /**
   * Renvoie vrai si la grille est finie et faux dans le cas contraire.
   * @return boolean la grille est finie
  */
  public boolean getGrilleFinie(){
    return this.grilleFinie;
  }
}

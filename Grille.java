import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.io.*;

public class Grille extends JPanel{
  private int nombreLigne;
  private int nombreColonne;
  private Case[][] grille;
  private int nombreBombe;
  private int nombreCaseCachee;
  private int nombreBombeSuppose;
  private boolean grilleFinie;
  private JFrame fenetre;
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
  public int getNombreBombeSuppose(){
    return this.nombreBombeSuppose;
  }
  public void incrementeNombreBombeSuppose(int plus){
    this.nombreBombeSuppose+=plus;
  }
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
  public boolean getGrilleFinie(){
    return this.grilleFinie;
  }
}

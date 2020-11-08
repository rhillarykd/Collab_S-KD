/* SOUIDI, KAMENI DOUDIE
 * TPC2
 * 23/10/2020
 * Main
 */
package superpuissance4_souidi_kamenidoudie;

//import java.util.Random;

import java.util.Scanner;

/**
 *
 * @author osouidi
 */
public class SuperPuissance4_SOUIDI_KAMENIDOUDIE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Début d'une partie
        Partie partie1 = new Partie();
        Joueur joueur1 = new Joueur("Souidi");
        Joueur joueur2 = new Joueur("KD");
        partie1.ListeJoueurs[0] = joueur1;
        partie1.ListeJoueurs[1] = joueur2;
        partie1.attribuerCouleursAuxJoueurs();
        partie1.initialiserPartie();
        partie1.debuterPartie();
        
        //Scanner monObjet = new Scanner(System.in);
        //String NomJoueur;
        //System.out.println("Pour jouer, entrer votre nom :"); 
        //NomJoueur = monObjet.nextLine();   
       
    }
    
}

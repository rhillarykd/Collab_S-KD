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
        Scanner pseudo = new Scanner(System.in);
        //Joueur joueur1 = new Joueur("Souidi");
        System.out.println("Joueur 1: Entrez votre pseudo ");
        Joueur joueur1 = new Joueur(pseudo.nextLine());
        //Joueur joueur2 = new Joueur("KD");
        System.out.println("Joueur 2: Entrez votre pseudo ");
        Joueur joueur2 = new Joueur(pseudo.nextLine());
        partie1.ListeJoueurs[0] = joueur1;
        partie1.ListeJoueurs[1] = joueur2;
        partie1.attribuerCouleursAuxJoueurs();
        //System.out.println(joueur1.couleur);
        //partie1.grillePartie.tabCellule = null;
        partie1.initialiserPartie();
        partie1.debuterPartie();
        
        //Scanner monObjet = new Scanner(System.in);
        //String NomJoueur;
        //System.out.println("Pour jouer, entrer votre nom :"); 
        //NomJoueur = monObjet.nextLine();   
       
    }
    
}

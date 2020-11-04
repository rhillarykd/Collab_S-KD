/* SOUIDI, KAMENI DOUDIE
 * TPC2
 * 23/10/2020
 * Classe Partie
 */
package superpuissance4_souidi_kamenidoudie;

import java.util.Random;
/**
 *
 * @author osouidi
 */
public class Partie {
    // Une partie met en relation 2 joueurs.
    // Une partie utilise 1 grille.
    
    //Attributs
    Joueur [] ListeJoueurs = new Joueur[2]; //tableau contenant les deux joueurs de la partie
    Joueur joueurCourant; //désigne le joueur	courant	à tout	moment	de la partie
    Grille grillePartie = new Grille();//Grille [] tabGrille = new Grille[1]
    
    //Méthodes
    public void attribuerCouleursAuxJoueurs() {
        //attribue des	couleurs aux joueurs
        Random r = new Random();// r pour random
        int nCouleur = r.nextInt(3);//nCouleur pour numéro de couleur, nombre aléatoire compris entre 0 et 2.
        if (nCouleur == 2 || nCouleur == 0) {
            ListeJoueurs[1].affecterCouleur("R");
            ListeJoueurs[0].affecterCouleur("J");
        } else {
            ListeJoueurs[0].affecterCouleur("R");
            ListeJoueurs[1].affecterCouleur("J");
        }
    }
    public void	initialiserPartie() {
        //crée la grille, la vide si elle existait déjà, place les trous noirs et les téléporteurs, crée les jetons et les attribue aux joueurs correspondants.
        if (grillePartie != null) {
            grillePartie.viderGrille();
        }
        grillePartie.afficherGrilleSurConsole();
        Random nAlea = new Random();//r pour random
        for (int nTrouNoir = 0; nTrouNoir < 5; nTrouNoir++) {//nTrouNoir est le nombre de trous noirs, y en a 5
            int iAlea = nAlea.nextInt(6);
            int jAlea = nAlea.nextInt(7);
            if (grillePartie.tabCellule[iAlea][jAlea].trouNoir == false) {
                grillePartie.tabCellule[iAlea][jAlea].jetonCourant.couleur = "t";
                grillePartie.tabCellule[iAlea][jAlea].trouNoir = true;
            }
        }
        for (int indice=0; indice<ListeJoueurs[0].ListeJetons.length; indice++) {
            Jetons jetonJ1 = new Jetons(ListeJoueurs[0].couleur);
            ListeJoueurs[0].ListeJetons[indice] = jetonJ1;
        }
        for (int indice=0; indice<ListeJoueurs[1].ListeJetons.length; indice++) {
            Jetons jetonJ2 = new Jetons(ListeJoueurs[1].couleur);
            ListeJoueurs[1].ListeJetons[indice] = jetonJ2;
        }
        
        //int x;
        //x=1;
        //int y;
        //y=2;
        //Random rand = new Random();
        //int z;
        //z= rand.nextInt(2);
        //System.out.println(z);
        //if z==0 
               
    }
    public void debuterPartie() {
        //lance	la partie
    }
}

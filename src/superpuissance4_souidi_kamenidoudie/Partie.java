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
    Joueur [] ListeJoueurs = new Joueur[2]; //tableaudes deux joueurs de la partie
    Joueur joueurCourant; //désigne le joueur	courant	à tout	moment	de la partie
    Grille [] grille = new Grille[1];
    
    //Méthodes
    public void attribuerCouleursAuxJoueurs() {
        //attribue des	couleurs aux joueurs
        Random r = new Random();// r pour random
        int nCouleur = r.nextInt(2);//nCouleur pour numéro de couleur
        if (nCouleur == 2 || nCouleur == 0) {
            ListeJoueurs[1].couleur = "rouge";
            ListeJoueurs[0].couleur = "jaune";
        } else {
            ListeJoueurs[0].couleur = "rouge";
            ListeJoueurs[1].couleur = "jaune";
        }
    }
    public void debuterPartie() {
        //lance	la partie
    }
    public void	initialiserPartie() {
        //int x;
        //x=1;
        //int y;
        //y=2;
        //Random rand = new Random();
        //int z;
        //z= rand.nextInt(2);
        //System.out.println(z);
        //if z==0 
               
        //crée la grille, la vide si elle existait déjà, place	les trous noirs	et le téléporteurs, crée les jetons et les attribue aux joueurs correspondants.
    }
}

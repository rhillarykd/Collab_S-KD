/* SOUIDI, KAMENI DOUDIE
 * TPC2
 * 23/10/2020
 * Classe Jetons
 */
package superpuissance4_souidi_kamenidoudie;

/**
 *
 * @author osouidi
 */
public class Jetons {
    // Un jeton est contenu par au plus 1 cellule.
    // Un jeton est possédé par 1 joueur.
    
    //Attributs :	
    //• Couleur : couleur affectée au joueur
    String couleur;
    
    //Méthodes :
//• Jeton (String) : constructeur initialisant la couleur du jeton avec le paramètre
    public Jetons (String color) {
        couleur = color;
    }
    
//• lireCouleur():renvoie la couleur du jeton
    public String lireCouleur() {
        return couleur;
    }
}

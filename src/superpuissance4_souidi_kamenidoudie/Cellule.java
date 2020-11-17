/* SOUIDI, KAMENI DOUDIE
 * TPC2
 * 23/10/2020
 * Classe Cellule
 */
package superpuissance4_souidi_kamenidoudie;

/**
 *
 * @author osouidi
 */
public class Cellule {
    // Une cellule contient au plus 1 jeton.
    // Une cellule appartient à 1 grille.
    
    //Attributs :	
//• jetonCourant : référence vers le jeton occupant la cellule, ou null
    Jetons jetonCourant;
//• trouNoir : indique ou non la	présence d’un trou noir
    boolean trouNoir;
//• desintegrateur : indique ou	non la présence	d’un désintégrateur
    boolean desintegrateur; 
    
    
    //Méthodes :
//• + Cellule() : construteur initialisant les attributs avec des valeurs par défaut
    public Cellule() {
        jetonCourant = null;
        trouNoir = false;
        desintegrateur = false;
    } 
    
//• + affecterJeton(Jeton): ajoute le jeton en paramètre à la cellule, et retourne vrai	si l’ajout s’est bien passé, ou	faux sinon (ex : jeton déjà présent)
    public boolean affecterJeton(Jetons jeton) {
        if (jetonCourant == null) {
            jetonCourant = jeton;
            return true;
        } else {
            return false;
        }
    }
//• + recupererJeton() : renvoie	une référence vers le jeton de la cellule
    public Jetons recupererJeton() {
        return jetonCourant;
    }
//• + supprimerJeton(): supprime le jeton et renvoie vrai si la	suppression s’est bien passée, ou faux autrement (ex : pas de jeton présent)
    public boolean supprimerJeton() {
        if (jetonCourant == null) {
            return false;
        }
        return true;
    }
//• + placerTrouNoir():	ajoute un trou noir à l’endroit indiqué et retourne vrai si l’ajout s’est bien	passé, ou faux sinon (exemple :	trou noir déjà présent)
    public boolean placerTrouNoir() {
        if (trouNoir != false) {
            return false;
        } else {
            trouNoir = true;
            return true;
        }
    }
//• + placerDesintegrateur(): ajoute un	désintégrateur à l’endroit indiqué et retourne vrai si l’ajout s’est bien passé, ou faux sinon (exemple : désintégrateur déjà présent)
    public boolean placerDesintegrateur() {
        if (desintegrateur == true) {
            return false;
        } else {
            desintegrateur = true;
            return true;
        }
    }
//• + presenceTrouNoir(): renvoie vrai si un trou noir est présent sur la cellule
    public boolean presenceTrouNoir() {
        if (trouNoir == true) {
            return true;
        }
        return false;
    }
//• + presenceDesintegrateur(): renvoie vrai si	un desintégrateur est présent sur la cellule
    public boolean presenceDesintegrateur() {
        if (desintegrateur == true) {
            return true;
        }
        return false;
    }
//• + lireCouleurDuJeton(): renvoie la couleur du jeton	occupant la cellule
    public String lireCouleurDuJeton() {
        if (jetonCourant != null) {
            return jetonCourant.lireCouleur();
        }
        return "-";
    }
//• + recupererDesintegrateur(): supprime le désintégrateur présent de la cellule, et renvoie vrai, ou faux sinon (exemple : pas de désintégrateur présent)
    public boolean recupererDesintegrateur() {
        if (desintegrateur == true) {
            desintegrateur = false;
            return true;
        }
        return false;
    }
//• + activerTrouNoir(): active le trou	noir : le trou noir engloutit le jeton et disparait. Retourne vrai si tout s’est correctement déroulé, ou faux sinon (pas de trou noir)
    public boolean activerTrouNoir() {
        if (trouNoir == false) {
            jetonCourant = null;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString () {
        return trouNoir +" "+ desintegrateur +" "+ jetonCourant;
    }
}
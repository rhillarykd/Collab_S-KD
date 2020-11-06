/* SOUIDI, KAMENI DOUDIE
 * TPC2
 * 23/10/2020
 * Classe Grille
 */
package superpuissance4_souidi_kamenidoudie;

/**
 *
 * @author osouidi
 */
public class Grille {
    // Une grille est utilisée par une partie.
    // Une grille est composée de 42 cellules.
     
    //Attributs :	
    //• Cellules: grille de 42 cellules
    Cellule [][] tabCellule = new Cellule[6][7];
        
        
    //Méthodes :
//• + ajouterJetonDansColonne(Jeton, int): ajoute le jeton dans la colonne ciblée, sur la cellule vide la plus basse. Renvoie faux si la colonne était pleine.
    public boolean ajouterJetonDansColonne(Jetons jeton, int j) {
        for (int i = tabCellule.length - 1; i >= 0; i--) {
            if (tabCellule[i][j].jetonCourant == null) {
                tabCellule[i][j].jetonCourant = jeton;
                return true;
            }
        }
        return false;
    }
//• + etreRemplie(): renvoie vrai si la grille est pleine
    public boolean etreRemplie() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (tabCellule[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }
//• + viderGrille(): vide la grille
    public void viderGrille() {
        tabCellule = null;
    }
//• + afficherGrilleSurConsole(): fonction d’affichage de la grille sur la console. Doit faire apparaitre les couleurs, et les trous noirs.
    public void afficherGrilleSurConsole() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (tabCellule[i][j].trouNoir == true || tabCellule[i][j].desintegrateur == true) {
                    if (tabCellule[i][j].trouNoir == true) {
                        System.out.println("n");
                    }
                    if (tabCellule[i][j].desintegrateur == true) {
                        System.out.println("d");
                    }
                } else {
                    if (tabCellule[i][j].jetonCourant == null) {
                        System.out.println("-");
                    }
                    System.out.println(tabCellule[i][j].jetonCourant.couleur);
                }
            }
        }
    }
//• +	celluleOccupee(int,int): renvoie vrai si la cellule de coordonnées données est occupée par un jeton.
    public boolean celluleOccupee(int i, int j) {
        if (tabCellule[i][j].jetonCourant == null) {
            return false;
        }
        return true;
    }
//• +	lireCouleurDuJeton(int,	int): renvoie la couleur du jeton de la cellule ciblée.
    public String lireCouleurDuJeton(int i, int j) {
        return tabCellule[i][j].jetonCourant.couleur;
    }
//• +	etreGagnantePourJoueur(Joueur): renvoie	vrai si	la grille est gagnante pour le joueur passé en paramètre, c’est-à-dire que 4 pions de sa couleur sont alignés en ligne, en colonne ou en diagonale.
    public boolean etreGagnantePourJoueur(Joueur Jr) {
        for (int i = 0; i < tabCellule.length - 5; i++) {
            for (int j = 0; j < tabCellule[i].length - 5; j++) {
                if (tabCellule[i][j].jetonCourant.couleur == tabCellule[i][j+1].jetonCourant.couleur && tabCellule[i][j+1].jetonCourant.couleur == tabCellule[i][j+2].jetonCourant.couleur && tabCellule[i][j+2].jetonCourant.couleur == tabCellule[i][j+3].jetonCourant.couleur && tabCellule[i][j+3].jetonCourant.couleur == tabCellule[i][j+4].jetonCourant.couleur && tabCellule[i][j+4].jetonCourant.couleur == Jr.couleur) {
                    return true;
                }
                if (tabCellule[i][j].jetonCourant.couleur == tabCellule[i+1][j].jetonCourant.couleur && tabCellule[i+1][j].jetonCourant.couleur == tabCellule[i+2][j].jetonCourant.couleur && tabCellule[i+2][j].jetonCourant.couleur == tabCellule[i+3][j].jetonCourant.couleur && tabCellule[i+3][j].jetonCourant.couleur == tabCellule[i+4][j].jetonCourant.couleur && tabCellule[i+4][j].jetonCourant.couleur == Jr.couleur) {
                    return true;
                }
                if (tabCellule[i][j].jetonCourant.couleur == tabCellule[i+1][j+1].jetonCourant.couleur && tabCellule[i+1][j+1].jetonCourant.couleur == tabCellule[i+2][j+2].jetonCourant.couleur && tabCellule[i+2][j+2].jetonCourant.couleur == tabCellule[i+3][j+3].jetonCourant.couleur && tabCellule[i+3][j+3].jetonCourant.couleur == tabCellule[i+4][j+4].jetonCourant.couleur && tabCellule[i+4][j+4].jetonCourant.couleur == Jr.couleur) {
                    return true;
                }
            }
        }
        return false;
    }
//• +tasserGrille(int): lorsqu’un jeton	est capturé ou détruit, tasse la grille en décalant de une ligne les jetons situés au dessus de la cellule libérée.
    public void tasserGrille(int i, int j){//coordonnées de la cellules libérée
        for (int k = i; k > 0 ; k--) {
            if (tabCellule[k][j].jetonCourant == null && tabCellule[k-1][j].jetonCourant != null) {
                tabCellule[k][j].jetonCourant = tabCellule[k-1][j].jetonCourant;
                tabCellule[k-1][j].jetonCourant = null;
            }
        }
    }
    //public void tasserGrille(){
        //for (int i = 5; i > 0 ; i--) {
            //for (int j = 0; j <= 6; j++) {
                //if (tabCellule[i][j].jetonCourant == null && tabCellule[i-1][j].jetonCourant != null) {
                    //tabCellule[i][j].jetonCourant = tabCellule[i-1][j].jetonCourant;
                    //tabCellule[i-1][j].jetonCourant = null;  
                //}
            //}
        //}
    //}
//• +colonneRemplie: renvoie vrai si la	colonne	est remplie (on	ne peut	y jouer	un Jeton)
    public boolean colonneRemplie(int j) {
        if (tabCellule[0][j].jetonCourant != null) {
            return true;
        }
        return false;
    }
//• +placerTrouNoir(int, int): ajoute un trou noir à l’endroit indiqué et retourne vrai si l’ajout s’est bien passé, ou faux sinon (exemple : trou noir déjà présent)
    public boolean  placerTrouNoir(int i, int j) {
        if (tabCellule[i][j].trouNoir == true) {
            return false;
        } else {
            tabCellule[i][j].trouNoir = true;
            //tabCellule[i][j].jetonCourant.couleur = "n";
            return true;
        }
    }
//• +placerDesintegrateur(int,int): ajoute un désintégrateur à l’endroit	indiqué	et retourne vrai si l’ajout s’est bien passé, ou faux sinon (exemple : désintégrateur déjà présent)
    public boolean placerDesintegrateur(int i, int j) {
        if (tabCellule[i][j].desintegrateur == true) {
            return false;
        } else {
            tabCellule[i][j].desintegrateur = true;
            //tabCellule[i][j].jetonCourant.couleur = "d";
            return true;
        }
    }
//• +supprimerJeton(int, int): supprime le jeton de la cellule visée. Renvoie vrai si la suppression s’est bien déroulée, ou faux autrement (jeton absent)
    public boolean supprimerJeton(int i, int j){
        if (tabCellule[i][j].jetonCourant == null) {
            return false;
        }
        tabCellule[i][j].jetonCourant = null;
        return true;
    }	 
//• +recupererJeton(int, int): enlève le	 jeton de la cellule visée et renvoie une référence vers ce jeton.
    public void recupererJeton(int i, int j) {
        Jetons jeton = tabCellule[i][j].jetonCourant;
        tabCellule[i][j].jetonCourant = null;
    }
}

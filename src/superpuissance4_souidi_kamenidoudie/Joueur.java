/* SOUIDI, KAMENI DOUDIE
 * TPC2
 * 23/10/2020
 * Classe Joueur
 */
package superpuissance4_souidi_kamenidoudie;

/**
 *
 * @author osouidi
 */
public class Joueur {
    // Un joueur possède un nombre indéfinis de jetons, initialement 21.
    // Un joueur participe à 1 partie.
    
    //Attributs
    String nom;
    String couleur;
    Jetons [] ListeJetons = new Jetons[21];
    int nombreDesintegrateurs;
    int nombreJetonsRestant;
    
    //Méthodes
    public Joueur(String nomJ) {
        //constructeur initialisant le nom du joueur avec son paramètre
        nom = nomJ;
        nombreDesintegrateurs = 0;
        nombreJetonsRestant = 21;
    }
    
    public void affecterCouleur(String couleurJ) {
        //affecte la couleur en	paramètre au joueur
        couleur = couleurJ;
    }
    public boolean ajouterJeton(Jetons jeton) {
        //ajoute le jeton passé	en paramètre à la liste	des jetons
        //ListeJetons = new Jetons[ListeJetons.length + 1];
        //ListeJetons[ListeJetons.length] = jeton;
        if (jeton != null && ListeJetons[ListeJetons.length - 1].couleur == jeton.lireCouleur()) {
            Jetons [] ListeIntermediaire = ListeJetons;
            ListeJetons = new Jetons[ListeIntermediaire.length + 1];
            for (int i = 0; i < ListeIntermediaire.length; i++) {
                ListeJetons[i] = ListeIntermediaire[i];
            }
            ListeJetons[ListeIntermediaire.length] = jeton;
            nombreJetonsRestant++;
            return true;
        }
        return false;
    }
    /*
    public boolean soustraireJeton() {
        //Soustrait le jeton passé en paramètre à la liste des jetons
        ListeJetons = new Jetons[ListeJetons.length - 1];
        //ListeJetons[ListeJetons.length - 2] = jeton;
        return true;
    }
    */
    public void obtenirDesintegrateur() {
        //incrémente le	nombre	de désintégrateurs du joueur
        
        nombreDesintegrateurs++;
    }
    public boolean utiliserDesintegrateur() {
        //décrémente le nombre de désintégrateurs et confirme l’utilisation de ce dernier, ou renvoie faux s’il	ne restait plus	de désintégrateurs.
        if (nombreDesintegrateurs == 0) {
            return false;
        } else {
            nombreDesintegrateurs--;
            return true;
        }
    }
}
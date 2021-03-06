/* SOUIDI, KAMENI DOUDIE
 * TPC2
 * 23/10/2020
 * Classe Partie
 */
package superpuissance4_souidi_kamenidoudie;

import java.util.Random;

import java.util.Scanner;

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
    Grille grillePartie = new Grille();
    //Grille [] tabGrille = new Grille[1];
    
    
    //Méthodes
    public void attribuerCouleursAuxJoueurs() {
        //attribue des	couleurs aux joueurs
        Random r = new Random();// r pour random
        int nCouleur = r.nextInt(3);//nCouleur pour numéro de couleur, nombre aléatoire compris entre 0 et 2 inclus.
        if (nCouleur == 2 || nCouleur == 0) {
            ListeJoueurs[1].affecterCouleur("R");
            ListeJoueurs[0].affecterCouleur("J");
        } else {
            ListeJoueurs[0].affecterCouleur("R");
            ListeJoueurs[1].affecterCouleur("J");
        }
    }
    public void	initialiserPartie() {
        //crée la grille, la vide si elle existait déjà, place les trous noirs et les désintégrateurs, crée les jetons et les attribue aux joueurs correspondants.
        //grillePartie.afficherGrilleSurConsole();
        if (grillePartie != null) {
            grillePartie = new Grille();
            grillePartie.viderGrille();
        }
        Random nAlea = new Random();//r pour random
        for (int nTrouNoir = 0; nTrouNoir < 5; nTrouNoir++) {//nTrouNoir est le nombre de trous noirs -1, il y en a 5 et finalement nombre de désintégrateurs -1
            int iAlea = nAlea.nextInt(6);
            int jAlea = nAlea.nextInt(7);
            
            if (grillePartie.placerTrouNoir(iAlea,jAlea) == true) {
                //grillePartie.tabCellule[iAlea][jAlea].trouNoir = true;
                if (nTrouNoir < 2 && grillePartie.placerDesintegrateur(iAlea,jAlea) == true) {
                    //grillePartie.tabCellule[iAlea][jAlea].desintegrateur = true;
                    continue;
                }
                if (nTrouNoir > 1 && grillePartie.tabCellule[(iAlea+6)/3][(jAlea+7)/3].desintegrateur == false && grillePartie.tabCellule[(iAlea+6)/3][(jAlea+7)/3].trouNoir == false) {
                    //grillePartie.tabCellule[(iAlea+6)/3][(jAlea+7)/3].jetonCourant.couleur = "d";
                    if (grillePartie.placerDesintegrateur(((iAlea+6)/3),((jAlea+7)/3)) == true) {
                        //grillePartie.tabCellule[(iAlea+6)/3][(jAlea+7)/3].desintegrateur = true;
                        continue;
                    }
                }
            }
        }
        for (int indice=0; indice < ListeJoueurs[0].ListeJetons.length; indice++) {
            Jetons jetonJ1 = new Jetons(ListeJoueurs[0].couleur);
            ListeJoueurs[0].ListeJetons[indice] = jetonJ1;
        }
        for (int indice=0; indice < ListeJoueurs[1].ListeJetons.length; indice++) {
            Jetons jetonJ2 = new Jetons(ListeJoueurs[1].couleur);
            ListeJoueurs[1].ListeJetons[indice] = jetonJ2;
        }
        /*
        if (grillePartie != null) {
            grillePartie.viderGrille();
        }
        grillePartie.afficherGrilleSurConsole();
        Random nAlea = new Random();//r pour random
        for (int nTrouNoir = 0; nTrouNoir < 5; nTrouNoir++) {//nTrouNoir est le nombre de trous noirs -1, il y en a 5 et finalement nombre de désintégrateurs -1
            int iAlea = nAlea.nextInt(6);
            int jAlea = nAlea.nextInt(7);
            if (grillePartie.tabCellule[iAlea][jAlea].trouNoir == false) {
                //grillePartie.tabCellule[iAlea][jAlea].jetonCourant.couleur = "n";
                grillePartie.tabCellule[iAlea][jAlea].trouNoir = true;
                if (nTrouNoir < 2) {
                    grillePartie.tabCellule[iAlea][jAlea].desintegrateur = true;
                }
                
            }
            if (nTrouNoir > 1 && grillePartie.tabCellule[(iAlea+6)/3][(jAlea+7)/3].desintegrateur == false && grillePartie.tabCellule[(iAlea+6)/3][(jAlea+7)/3].trouNoir == false) {
                //grillePartie.tabCellule[(iAlea+6)/3][(jAlea+7)/3].jetonCourant.couleur = "d";
                grillePartie.tabCellule[(iAlea+6)/3][(jAlea+7)/3].desintegrateur = true;
            }
        }
        for (int indice=0; indice < ListeJoueurs[0].ListeJetons.length; indice++) {
            Jetons jetonJ1 = new Jetons(ListeJoueurs[0].couleur);
            ListeJoueurs[0].ListeJetons[indice] = jetonJ1;
        }
        for (int indice=0; indice < ListeJoueurs[1].ListeJetons.length; indice++) {
            Jetons jetonJ2 = new Jetons(ListeJoueurs[1].couleur);
            ListeJoueurs[1].ListeJetons[indice] = jetonJ2;
        }
        */
    }
    public void debuterPartie() {
        //lance	la partie
        String dCouleur;//JdCouleur pour la couleur du joueur qui débute la partie, 
        Random eAlea = new Random();// eAlea pour entier aléatoire
        int JdCouleur = eAlea.nextInt(11);//Nombre aléatoire compris entre 0 et 10 inclus.
        if (JdCouleur % 2 == 0) {
            dCouleur = "R";
        } else {
            dCouleur = "J";
        }
        if (ListeJoueurs[0].ListeJetons[0].lireCouleur() == dCouleur) {
            joueurCourant = ListeJoueurs[0];
        } else {
            joueurCourant = ListeJoueurs[1];
        }
        //ListeJoueurs[0].nombreDesintegrateurs = 0;
        //ListeJoueurs[1].nombreDesintegrateurs = 0;
        //ListeJoueurs[0].nombreJetonsRestant = 21;
        //ListeJoueurs[1].nombreJetonsRestant = 21;
        
        boolean condition = false;
        while(condition == false) {
            grillePartie.afficherGrilleSurConsole();
            Scanner c = new Scanner(System.in);
            int choix = 0;
            while (choix == 0) {
                System.out.println("\nIl vous reste "+joueurCourant.nombreJetonsRestant+" jetons et "+joueurCourant.nombreDesintegrateurs+" désintégrateurs.\n"+joueurCourant.nom+", JOUEZ ! \n1 - Ajouter un jeton dans une colonne \n2 - Utiliser un désintégrateur \n3 - Récupérer un jeton ");//Menu, choix des méthodes pour jouer
                choix = c.nextInt();
                Scanner ligneI = new Scanner(System.in);
                Scanner colonneJ = new Scanner(System.in);
                if (choix == 1) {//Ajout d'un jeton dans une colonne
                    //int numeroJeton = 0;
                    System.out.println("Choisissez la colonne: "); 
                    int j = colonneJ.nextInt();
                    if (grillePartie.colonneRemplie(j) == false && grillePartie.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.ListeJetons.length - joueurCourant.nombreJetonsRestant], j) == true) {
                        //grillePartie.ajouterJetonDansColonne(joueurCourant.ListeJetons[numeroJeton], j);
                        joueurCourant.nombreJetonsRestant--;
                        //System.out.println("Pour savoir si vous avez gagné un désintégrateur, entrez le numéro de la ligne de votre jeton: ");
                        //int i = ligneI.nextInt();
                        //int i = grillePartie.retrouverLigneJeton(j);
                        if (grillePartie.tabCellule[grillePartie.retrouverLigneJeton(j)][j].recupererDesintegrateur() == true) {
                            joueurCourant.obtenirDesintegrateur();
                        }
                        break;
                    }
                } else if (choix == 2) {//Utilisation d'un désintégrateur
                    if (joueurCourant.utiliserDesintegrateur() == true) {
                        System.out.println("Choisissez la ligne du désintégrateur à placer: "); 
                        int i = ligneI.nextInt();//numéro de ligne
                        System.out.println("Choisissez la colonne du désintégrateur à placer: "); 
                        int j = colonneJ.nextInt();//numéro de colonne
                        if (grillePartie.lireCouleurDuJeton(i, j) != joueurCourant.couleur && grillePartie.supprimerJeton(i, j) == true) {
                            grillePartie.tasserGrille(i, j);
                            break;
                        }
                    }
                } else if (choix == 3) {//Récupération d'un jeton
                    System.out.println("Choisissez la ligne du jeton à récupérer");
                    int i = ligneI.nextInt();//numéro de ligne
                    System.out.println("Choisissez la colonne du jeton à recupérer");
                    int j = colonneJ.nextInt();//numéro de colonne
                    if (joueurCourant.ajouterJeton(grillePartie.recupererJeton(i, j)) == true) {
                        grillePartie.tasserGrille(i, j);
                        break;
                    }
                }
                System.out.println("\n  Veuillez choisir à nouveau parmi les propositions ci-dessous.");
                choix = 0;
            }
            if (grillePartie.nbJetonMMcouleur(joueurCourant) >= 4) { 
                if (grillePartie.etreGagnantePourJoueur(ListeJoueurs[0]) == true && grillePartie.etreGagnantePourJoueur(ListeJoueurs[1]) == true) {
                    System.out.println("Le "+joueurCourant+" a perdu en provoquant une faute de jeu");
                    break;
                }
                
                condition = grillePartie.etreGagnantePourJoueur(joueurCourant);//Le nombre de jetons du joueur courant se trouvant dans la grille doit au moins être égal à 4.
            }
            
            if (grillePartie.etreRemplie() == true) {
                System.out.println("Match nul !");
                break;
            }
            
            if (joueurCourant == ListeJoueurs[0]) {
                joueurCourant = ListeJoueurs[1];
            } else {
                joueurCourant = ListeJoueurs[0];
            }
        }
        System.out.println("L'adversaire de "+joueurCourant+" a gagné !");
        //boolean condition1 = false;
        //boolean condition2 = false;
        //condition1 = grillePartie.etreGagnantePourJoueur(ListeJoueurs[0]);
        //condition2 = grillePartie.etreGagnantePourJoueur(ListeJoueurs[1]);
    }
}
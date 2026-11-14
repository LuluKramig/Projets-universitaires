package biosphere7;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Joueur implémentant les actions possibles à partir d'un plateau, pour un
 * niveau donné.
 */
public class JoueurBiosphere7 implements IJoueurBiosphere7 {

    /**
     * Cette méthode renvoie, pour un plateau donné et un joueur donné, toutes
     * les actions possibles pour ce joueur.
     *
     * @param plateau le plateau considéré
     * @param couleurJoueur couleur du joueur
     * @param niveau le niveau de la partie à jouer
     * @return l'ensemble des actions possibles
     */
    @Override
    public String[] actionsPossibles(Case[][] plateau, char couleurJoueur, int niveau) {
        // afficher l'heure de lancement
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        System.out.println("actionsPossibles : lancement le " + format.format(new Date()));
        // se préparer à stocker les actions possibles
        ActionsPossibles actions = new ActionsPossibles();
        // calculer les vitalités sur le plateau initial
        Vitalites vitalites = vitalitesPlateau(plateau);
        // création du catalogue des espèces
        char[] lesEspeces = {'P', 'S', 'B', 'D', 'T', 'H'};
        // ajout des actions
        ajoutActionOmbre(actions, vitalites, plateau);
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                Case caseCourante = plateau[lig][col];
                Coordonnees coord = new Coordonnees(lig, col);
                if (!caseCourante.plantePresente()) {
                    if (nbVoisinesPleines(voisines(coord, plateau), plateau) < 4) {
                        for (char espece : lesEspeces) {
                            ajoutActionPlanter(coord, actions, vitalites, couleurJoueur, plateau, espece);
                        }
                    }      
                }
                else {
                    ajoutActionCouper(coord, actions, vitalites, plateau);
                    ajoutActionFertiliser(coord, actions, vitalites, plateau);
                    if ((caseCourante.espece != 'T' && caseCourante.espece != 'H') || autosterile(plateau, coord)) {
                        ajoutActionDisseminer(coord, actions, vitalites, plateau, couleurJoueur);
                    }
                }
            }
        }
        System.out.println("actionsPossibles : fin");
        return actions.nettoyer();
    }

    /**
     * Somme des vitalités des plantes de chaque joueur sur le plateau.
     *
     * @param plateau le plateau
     * @return la somme des vitalités des plantes de chaque joueur
     */
    static Vitalites vitalitesPlateau(Case[][] plateau) {
        Vitalites v = new Vitalites();
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                if (plateau[lig][col].couleur == 'R') {
                    v.vitalitesRouge += plateau[lig][col].vitalite;
                } else {
                    if (plateau[lig][col].couleur == 'B') {
                        v.vitalitesBleu += plateau[lig][col].vitalite;
                    }
                }
            }
        }
        return v;
    }

    /**
     * Ajout d'une action de plantation de plante dans l'ensemble des actions
     * possibles: 6 espèces possibles, règles d'étouffement des plantes voisines,
     * symbiose entre les plantes
     *
     * @param coord coordonnées de la case où planter le végétal
     * @param actions l'ensemble des actions possibles (en construction)
     * @param vitalites la somme des vitalités sur le plateau avant de jouer l'action
     * @param couleur la couleur du végétal à ajouter
     * @param p le plateau de jeu (un tableau de Case à 2 dimensions)
     * @param espece l'espèce plantée par l'action
     */
    void ajoutActionPlanter(Coordonnees coord, ActionsPossibles actions,
            Vitalites vitalites, char couleur, Case[][] p, char espece) {
        int modifRouge = 0;
        int modifBleu = 0;
        if (couleur == 'R') {
            modifRouge = 1;
        }
        if (couleur == 'B') {
            modifBleu = 1;
        }
        Coordonnees[] voisines = voisines(coord, p);
        for (Coordonnees vois : voisines) {
            Case caseVois = p[vois.ligne][vois.colonne];
            if (caseVois.plantePresente()) {
                if (caseVois.couleur == couleur) {
                    if (couleur == 'R') {
                        modifRouge++;
                    }
                    if (couleur == 'B') {
                        modifBleu++;
                    }
                }
                if (nbVoisinesPleines(voisines(vois, p), p) == 3) {
                    if (caseVois.couleur == 'R') {
                        modifRouge -= caseVois.vitalite;
                    }
                    if (caseVois.couleur == 'B') {
                        modifBleu -= caseVois.vitalite;
                    }
                }
            }
        }
        String action = "" + espece + coord.carLigne() + coord.carColonne() + "," 
            + (vitalites.vitalitesRouge + modifRouge) + ","
            + (vitalites.vitalitesBleu + modifBleu);
        actions.ajouterAction(action);
        
    }
    
    /**
     * Ajout d'une action de coupage de plante dans l'ensemble des actions
     * possibles: améliore les plantes voisines
     *
     * @param coord coordonnées de la case où couper le végétal
     * @param actions l'ensemble des actions possibles (en construction)
     * @param vitalites la somme des vitalités sur le plateau avant de jouer l'action
     * @param p le plateau de jeu (un tableau de Case à 2 dimensions)
     */
    void ajoutActionCouper(Coordonnees coord, ActionsPossibles actions,
            Vitalites vitalites, Case[][] p) {
        Case c = p[coord.ligne][coord.colonne];
        int modifRouge = 0;
        int modifBleu = 0;
        if (c.couleur == 'R') {
            modifRouge -= c.vitalite;
        }
        if (c.couleur == 'B') {
            modifBleu -= c.vitalite;
        }
        for (Coordonnees vois : voisines(coord, p)) {
            Case caseVois = p[vois.ligne][vois.colonne];
            if (caseVois.plantePresente() && caseVois.vitalite < 9 ) {
                if (caseVois.couleur == 'R') {
                    modifRouge++;
                } else {
                    modifBleu++;
                }
            }
        }
        String action = "C" + coord.carLigne() + coord.carColonne() + "," 
            + (vitalites.vitalitesRouge + modifRouge) + ","
            + (vitalites.vitalitesBleu + modifBleu);
        actions.ajouterAction(action);
    }
    
    /**
     * Ajout d'une action de fertilisation de plante dans l'ensemble des actions
     * possibles: augmente la vitalité, dans une limite de 9, d'une plante, et
     * la quantité dépend des espèces
     * @param coord coordonnées de la case où fertiliser le végétal
     * @param actions l'ensemble des actions possibles (en construction)
     * @param vitalites la somme des vitalités sur le plateau avant de jouer l'action
     * @param p le plateau de jeu (un tableau de Case à 2 dimensions)
     */
    void ajoutActionFertiliser(Coordonnees coord, ActionsPossibles actions,
            Vitalites vitalites, Case[][] p) {
        Case c = p[coord.ligne][coord.colonne];
        int modifRouge = 0;
        int modifBleu = 0;
        int engraisMax = switch (c.espece) {
            case 'P', 'S' -> 1;
            case 'B' -> 2;
            default -> 3;
        };
        if (c.couleur == 'R') {
            while (p[coord.ligne][coord.colonne].vitalite + modifRouge < 9 && modifRouge < engraisMax) {
                modifRouge++;
            }
        }
        if (c.couleur == 'B') {
            while (p[coord.ligne][coord.colonne].vitalite + modifBleu < 9 && modifBleu < engraisMax) {
                modifBleu++;
            }
        }
        String action = "F" + coord.carLigne() + coord.carColonne() + "," 
            + (vitalites.vitalitesRouge + modifRouge) + ","
            + (vitalites.vitalitesBleu + modifBleu);
        actions.ajouterAction(action);
    }
    
    /**
     * Ajout d'une action de dissémination de plante dans l'ensemble des actions
     * possibles: crée des plantes dans les cases voisines vides
     * d'une plante, n'importe quand si elle est autoféconde, ssi elle a une 
     * voisine de la meme espece si elle est autostérile
     * @param coord coordonnées de la case où planter le végétal
     * @param actions l'ensemble des actions possibles (en construction)
     * @param vitalites la somme des vitalités sur le plateau avant de jouer l'action
     * @param p le plateau de jeu (un tableau de Case à 2 dimensions)
     * @param couleur la couleur du joueur qui joue le tour
     */
    void ajoutActionDisseminer(Coordonnees coord, ActionsPossibles actions,
            Vitalites vitalites, Case[][] p, char couleur) {
        Case c = p[coord.ligne][coord.colonne];
        int modifRouge = 0;
        int modifBleu = 0;
        int aj = c.vitalite;
        if (c.espece == 'T' || c.espece == 'H') {
            for (Coordonnees v : voisines(coord, p)) {
                if (p[v.ligne][v.colonne].plantePresente()) {
                    if (p[v.ligne][v.colonne].espece == c.espece && p[v.ligne][v.colonne].vitalite < aj) {
                        aj = p[v.ligne][v.colonne].vitalite;
                    }
                } 
            }
        } else {
            aj = 1;
        }
        for (Coordonnees v : voisines(coord, p)) {
            if (!p[v.ligne][v.colonne].plantePresente()) {
                if (couleur == 'R') {
                    modifRouge += aj;
                }
                if (couleur == 'B') {
                    modifBleu += aj;
                }
            }
        }
        String action = "I" + coord.carLigne() + coord.carColonne() + "," 
            + (vitalites.vitalitesRouge + modifRouge) + ","
            + (vitalites.vitalitesBleu + modifBleu);
        actions.ajouterAction(action);
    }
    
    /**
     * Ajout de l'action d'ombrage dans l'ensemble des actions possibles:
     * Fait une ombre qui active les panneaux d'ombre sur le terrain:
     * Chaque arbre projette une ombre sur les plantes à son nord, ce qui,
     * en fonction des vitalités et des distances peut leur faire perdre
     * de la vitalité
     * @param actions l'ensemble des actions possibles (en construction)
     * @param vitalites la somme des vitalités sur le plateau avant de jouer l'action
     * @param p le plateau de jeu (un tableau de Case à 2 dimensions)
     */
    void ajoutActionOmbre(ActionsPossibles actions,
            Vitalites vitalites, Case[][] p) {
        int modifRouge = 0;
        int modifBleu = 0;
        int[][] vitaliteTemp = new int[Coordonnees.NB_LIGNES][Coordonnees.NB_COLONNES];
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                if (p[lig][col].plantePresente()) {
                    vitaliteTemp[lig][col] = p[lig][col].vitalite;
                }
            }
        }
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                if (p[lig][col].espece == 'S' || p[lig][col].espece == 'P') {
                    int vArb = p[lig][col].vitalite;
                    for (int ord = lig - 1; ord >= 0; ord--) {
                        int ombre = (vArb - lig + ord)/2;
                        if (p[ord][col].plantePresente() && ombre >= 0) {
                            if (p[ord][col].couleur == 'R') {
                                if (ombre > vitaliteTemp[ord][col]) {
                                    modifRouge -= vitaliteTemp[ord][col];
                                    vitaliteTemp[ord][col] = 0;
                                } else {
                                    modifRouge -= ombre;
                                    vitaliteTemp[ord][col] -= ombre;
                                }
                            }
                            if (p[ord][col].couleur == 'B') {
                                if (ombre > vitaliteTemp[ord][col]) {
                                    modifBleu -= vitaliteTemp[ord][col];
                                    vitaliteTemp[ord][col] = 0;
                                } else {
                                    modifBleu -= ombre;
                                    vitaliteTemp[ord][col] -= ombre;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (modifBleu != 0 || modifRouge != 0) {
            String action = "O" + "," 
                + (vitalites.vitalitesRouge + modifRouge) + ","
                + (vitalites.vitalitesBleu + modifBleu);
            actions.ajouterAction(action);
        }
    }
        
    /**
     * Renvoie les coordonnées de la case suivante, en suivant une direction
     * donnée.
     *
     * @param c coordonnées de la case d'origine
     * @param d la direction à suivre
     * @return les coordonnées de la case suivante
     */
    static Coordonnees suivante(Coordonnees c, Direction d) {
        return new Coordonnees(c.ligne + Direction.mvtVertic(d), 
                c.colonne + Direction.mvtHoriz(d));
    }

    /**
     * Retourne les coordonnées de toutes les cases voisines.
     * 
     * @param coord coordonnées de la case considérée
     * @param plateau le plateau de jeu
     * @return les coordonnées de toutes les cases voisines
     */
    static Coordonnees[] voisines(Coordonnees coord, Case[][] plateau) {
        Coordonnees[] voisines = new Coordonnees[4];
        int nbVoisines = 0;
        Direction[] dir = Direction.cardinales();
        for (Direction dir1 : dir) {
            if (suivante(coord, dir1).estDansPlateau()) {
                voisines[nbVoisines] = suivante(coord, dir1);
                nbVoisines++;
            }
        }
        return Arrays.copyOf(voisines, nbVoisines);
    }
    
    /**
     * Retourne le nombre de plantes voisines à une case
     * @param voisines les voisines d'une case
     * @param p le plateau de jeu
     * @return combien parmi les voisines ont une plante
     */
    static int nbVoisinesPleines(Coordonnees[] voisines, Case[][] p) {
        int sommeVoisinesPleines = 0;
        for (Coordonnees voisVois : voisines) {
            if (p[voisVois.ligne][voisVois.colonne].plantePresente()) {
                sommeVoisinesPleines++;
            }
        }
        return sommeVoisinesPleines;
    }
    
    /**
     * Retourne vrai si la case de coordonnées c du plateau p, autostérile,
     * a au moins une voisine de la meme espèce
     * @param p le plateau de jeu
     * @param c les coordonnées de la case
     * @return vrai si la plante autostérile de la case peut se disséminer
     */
    static boolean autosterile(Case[][] p, Coordonnees c) {
        boolean auto = false;
        Coordonnees[] v = voisines(c, p);
        int i = 0;
        while(!auto && i < v.length) {
            if (p[v[i].ligne][v[i].colonne].plantePresente()) {
                if (p[v[i].ligne][v[i].colonne].espece == p[c.ligne][c.colonne].espece) {
                    auto = true;
                }
            }
            i++;
        }
        return auto;
    }
}


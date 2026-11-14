package biosphere7;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests unitaires de la classe JoueurBiosphere7.
 */
public class JoueurBiosphere7Test {

    /**
     * Test de la fonction actionsPossibles. Commentez les appels aux tests des
     * niveaux inférieurs, n'activez que le test du niveau à valider.
     */
    @Test
    public void testActionsPossibles() {
        // testActionsPossibles_niveau1();
        // testActionsPossibles_niveau2();
        // testActionsPossibles_niveau3();
        // testActionsPossibles_niveau4();
        // testActionsPossibles_niveau5();
        // testActionsPossibles_niveau6();
        // testActionsPossibles_niveau7();
        // testActionsPossibles_niveau8();
        // testActionsPossibles_niveau9();
        testActionsPossibles_niveau10();
    }
    
    /**
     * Ecrit les actions possibles calculées
     */
    static void afficherActions(ActionsPossibles actionsPossibles) {
        for (String act : actionsPossibles.actions) {
            System.out.print(act);
        }
    }

    /**
     * Test de la fonction actionsPossibles, au niveau 1.
     */
    public void testActionsPossibles_niveau1() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // un plateau sur lequel on veut tester actionsPossibles()
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_VIDE);
        // on choisit la couleur du joueur
        char couleur = 'R';
        // on choisit le niveau
        int niveau = 1;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        // on peut afficher toutes les actions possibles calculées :
        actionsPossibles.afficher();
        // on peut aussi tester si une action est dans les actions possibles :
        assertTrue(actionsPossibles.contient("PaB,1,0"));
        // on peut aussi tester si une action n'est pas dans les actions 
        // possibles :
        assertFalse(actionsPossibles.contient("PaO,1,0"));
        assertFalse(actionsPossibles.contient("PaA,0,0"));
        // testons les 4 coins :
        assertTrue(actionsPossibles.contient("PaA,1,0"));
        assertTrue(actionsPossibles.contient("PnA,1,0"));
        assertTrue(actionsPossibles.contient("PaN,1,0"));
        assertTrue(actionsPossibles.contient("PnN,1,0"));
        // vérifions s'il y a le bon nombre d'actions possibles :
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES,
                actionsPossiblesDepuisPlateau.length);
    }

    /**
     * Test de la fonction actionsPossibles, au niveau 2.
     */
    public void testActionsPossibles_niveau2() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        char couleur = 'B';
        int niveau = 2;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        // testons les 4 coins :
        assertTrue(actionsPossibles.contient("PaA,2,3"));
        assertTrue(actionsPossibles.contient("PnA,2,3"));
        assertFalse(actionsPossibles.contient("PaN,2,3"));
        assertTrue(actionsPossibles.contient("PnN,2,3"));
        // on peut poser sur une case quelconque vide :
        assertTrue(actionsPossibles.contient("PkD,2,3"));
        // on ne peut pas poser sur une case occupée :
        assertFalse(actionsPossibles.contient("PfA,2,3"));
        assertFalse(actionsPossibles.contient("PeI,2,3"));
        assertFalse(actionsPossibles.contient("PhJ,2,3"));
        // nombre correct d'actions possibles :
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES - 4,
                actionsPossiblesDepuisPlateau.length);
    }

    /**
     * Test de la fonction actionsPossibles, au niveau 3.
     */
    public void testActionsPossibles_niveau3() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU3);
        char couleur = 'B';
        int niveau = 3;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        // testons les 4 coins :
        assertFalse(actionsPossibles.contient("CaA,2,2"));
        assertFalse(actionsPossibles.contient("CnA,2,2"));
        assertTrue(actionsPossibles.contient("CaN,3,1"));
        assertFalse(actionsPossibles.contient("CaN,2,2"));
        assertFalse(actionsPossibles.contient("CnN,3,1"));
        // on peut couper une case quelconque pleine :
        assertTrue(actionsPossibles.contient("CeI,1,2"));
        // mais il faut tout couper :
        assertFalse(actionsPossibles.contient("CeI,2,2"));
        // on ne peut pas couper sur une case vide :
        assertFalse(actionsPossibles.contient("CfB,2,2"));
        assertFalse(actionsPossibles.contient("CeH,3,1"));
        assertFalse(actionsPossibles.contient("ChK,2,2"));
        // nombre correct d'actions possibles :
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES,
                actionsPossiblesDepuisPlateau.length);
    }

    /**
     * Test de la fonction actionsPossibles, au niveau 4.
     */
    public void testActionsPossibles_niveau4() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU4);
        char couleur = 'B';
        int niveau = 4;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        assertTrue(actionsPossibles.contient("ClE,21,18"));
        assertTrue(actionsPossibles.contient("CnB,22,17"));
        // mais il faut tout couper :
        assertTrue(actionsPossibles.contient("CmB,22,16"));
        // on ne peut pas couper sur une case vide :
        assertFalse(actionsPossibles.contient("CfB,22,17"));
        // on n'incrémente que les 4 voisines directes :
        assertTrue(actionsPossibles.contient("CdD,22,16"));
        assertFalse(actionsPossibles.contient("CdD,24,17"));
        // on ne peut pas dépasser 9 :
        assertFalse(actionsPossibles.contient("CbG,23,16"));
        // nombre correct d'actions possibles :
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES,
                actionsPossiblesDepuisPlateau.length);
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 5.
     */
    public void testActionsPossibles_niveau5() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU4);
        char couleur = 'B';
        int niveau = 5;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        assertTrue(actionsPossibles.contient("PaA,22,19"));
        assertTrue(actionsPossibles.contient("PnA,22,19"));
        assertTrue(actionsPossibles.contient("PaN,22,18"));
        assertTrue(actionsPossibles.contient("PnN,22,18"));
        // on peut poser sur une case quelconque vide entourée :
        assertTrue(actionsPossibles.contient("PlH,22,21"));
        // on ne prend pas en compte les diagonales :
        assertTrue(actionsPossibles.contient("PdB,22,18"));
        // nombre correct d'actions possibles :
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES,
                actionsPossiblesDepuisPlateau.length);
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 6.
     */
    public void testActionsPossibles_niveau6() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU4);
        char couleur = 'B';
        int niveau = 6;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        assertTrue(actionsPossibles.contient("PaA,22,19"));
        assertTrue(actionsPossibles.contient("PnA,22,19"));
        assertTrue(actionsPossibles.contient("PaN,22,18"));
        assertTrue(actionsPossibles.contient("PnN,22,18"));
        // on peut poser sur une case quelconque vide entourée :
        assertTrue(actionsPossibles.contient("PbF,22,20"));
        // on ne fait pas symbiose avec l'adversaire :
        assertTrue(actionsPossibles.contient("PlH,22,19"));
        // on ne prend pas en compte les diagonales :
        assertTrue(actionsPossibles.contient("PdB,22,18"));
        // nombre correct d'actions possibles :
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES,
                actionsPossiblesDepuisPlateau.length);
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 7.
     */
    public void testActionsPossibles_niveau7() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU7);
        char couleur = 'B';
        int niveau = 7;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        assertTrue(actionsPossibles.contient("PaA,24,20"));
        // on ne peut pas poser sur une case vide complètement entourée :
        assertFalse(actionsPossibles.contient("PdL,24,20"));
        // on ne peut pas etre étouffé si on est sur les bords :
        assertTrue(actionsPossibles.contient("PdN,24,21"));
        // on peut étouffer les voisines :
        assertTrue(actionsPossibles.contient("PbM,23,19"));
        // nombre correct d'actions possibles :
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES - 1,
                actionsPossiblesDepuisPlateau.length);
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 8.
     */
    public void testActionsPossibles_niveau8() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU8);
        char couleur = 'B';
        int niveau = 8;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        // test de base de planter un pommier
        assertTrue(actionsPossibles.contient("PaA,15,11"));
        // on essaie les autres espèces
        assertTrue(actionsPossibles.contient("SaA,15,11"));
        assertTrue(actionsPossibles.contient("BaA,15,11"));
        assertTrue(actionsPossibles.contient("DaA,15,11"));
        assertTrue(actionsPossibles.contient("TaA,15,11"));
        assertTrue(actionsPossibles.contient("HaA,15,11"));
        // on peut fertiliser un arbre
        assertTrue(actionsPossibles.contient("FaJ,16,10"));
        assertFalse(actionsPossibles.contient("FaJ,15,11"));
        // on peut fertiliser un arbuste/buisson
        assertTrue(actionsPossibles.contient("FlB,17,10"));
        assertFalse(actionsPossibles.contient("FaJ,17,10"));
        // on peut fertiliser un plant de légumes
        assertTrue(actionsPossibles.contient("FnL,18,10"));
        assertFalse(actionsPossibles.contient("FnL,15,13"));
        // on ne fertilise pas une case vide
        assertFalse(actionsPossibles.contient("FgJ,15,11"));
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES * 6 - 4 * 23 - 6,
                actionsPossiblesDepuisPlateau.length);
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 9.
     */
    public void testActionsPossibles_niveau9() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU9);
        char couleur = 'B';
        int niveau = 9;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        // test de base de planter un pommier
        assertTrue(actionsPossibles.contient("PaA,18,20"));
        // on essaie les autres espèces
        assertTrue(actionsPossibles.contient("SaA,18,20"));
        assertTrue(actionsPossibles.contient("BaA,18,20"));
        assertTrue(actionsPossibles.contient("DaA,18,20"));
        assertTrue(actionsPossibles.contient("TaA,18,20"));
        assertTrue(actionsPossibles.contient("HaA,18,20"));
        // on peut fertiliser
        assertTrue(actionsPossibles.contient("FbF,18,22"));
        // test de base de disséminer une plante autoféconde
        assertTrue(actionsPossibles.contient("IeD,18,23"));
        // on dissémine sur des cases vides
        assertTrue(actionsPossibles.contient("IbJ,18,22"));
        assertFalse(actionsPossibles.contient("IbJ,18,23"));
        // on ne peut pas disséminer une plante autostérile isolée
        assertFalse(actionsPossibles.contient("ImI,18,23"));
        // on peut disséminer une plante autostérile avec une voisine de la meme espèce
        assertTrue(actionsPossibles.contient("IjG,18,22"));
        assertFalse(actionsPossibles.contient("IjG,18,23"));
        // une plante autostérile se dissémine avec le minimum des vitalités du groupe
        assertFalse(actionsPossibles.contient("IhA,18,21"));
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES * 6 - 3 * 35 - 9,
                actionsPossiblesDepuisPlateau.length);
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 10.
     */
    public void testActionsPossibles_niveau10() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        // plateau, couleur et niveau
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU10);
        char couleur = 'B';
        int niveau = 9;
        // on lance actionsPossibles
        String[] actionsPossiblesDepuisPlateau
                = joueur.actionsPossibles(plateau, couleur, niveau);
        ActionsPossibles actionsPossibles
                = new ActionsPossibles(actionsPossiblesDepuisPlateau);
        // test de base de planter un pommier
        assertTrue(actionsPossibles.contient("PaA,23,28"));
        // on essaie les autres espèces
        assertTrue(actionsPossibles.contient("SaA,23,28"));
        assertTrue(actionsPossibles.contient("BaA,23,28"));
        assertTrue(actionsPossibles.contient("DaA,23,28"));
        assertTrue(actionsPossibles.contient("TaA,23,28"));
        assertTrue(actionsPossibles.contient("HaA,23,28"));
        // on peut fertiliser
        assertTrue(actionsPossibles.contient("FbD,26,27"));
        // test de base de disséminer une plante autoféconde
        assertTrue(actionsPossibles.contient("IgI,23,31"));
        // on ne peut pas disséminer une plante autostérile isolée
        assertFalse(actionsPossibles.contient("ImI,23,27"));
        // une plante autostérile se dissémine avec le minimum des vitalités du groupe
        assertFalse(actionsPossibles.contient("InF,23,30"));
        // on peut faire de l'ombre
        assertTrue(actionsPossibles.contient("O,16,22"));
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES * 6 - 3 * 22 - 5,
                actionsPossiblesDepuisPlateau.length);
    }

    /**
     * Test de la fonction ajoutActionPlanter.
     */
    @Test
    public void testAjoutActionPlanter() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        ActionsPossibles actions = new ActionsPossibles();
        Vitalites vitalites = new Vitalites(0, 0);
        // pour l'instant pas d'action possible
        assertEquals(0, actions.nbActions);
        // on crée le tableau d'actions et on en ajoute une
        joueur.ajoutActionPlanter(Coordonnees.depuisCars('d', 'F'), actions,
                vitalites, Case.CAR_ROUGE, Utils.plateauDepuisTexte(PLATEAU_VIDE), 'P');
        // l'action est devenue possible
        assertTrue(actions.contient("PdF,1,0"));
        // une action possible mais qui n'a pas encore été ajoutée
        assertFalse(actions.contient("PhB,1,0"));
        // pour l'instant une seule action possible
        assertEquals(1, actions.nbActions);
        // ajout d'une deuxième action possible
        joueur.ajoutActionPlanter(Coordonnees.depuisCars('h', 'B'), actions,
                vitalites, Case.CAR_ROUGE, Utils.plateauDepuisTexte(PLATEAU_VIDE), 'P');
        // l'action a bien été ajoutée
        assertTrue(actions.contient("PhB,1,0"));
        // désormais, deux actions possibles
        assertEquals(2, actions.nbActions);
    }

    /**
     * Test de la fonction ajoutActionCouper.
     */
    @Test
    public void testAjoutActionCouper() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        ActionsPossibles actions = new ActionsPossibles();
        Vitalites vitalites = new Vitalites(1, 1);
        // pour l'instant pas d'action possible
        assertEquals(0, actions.nbActions);
        // on crée le tableau d'actions et on en ajoute une
        joueur.ajoutActionCouper(Coordonnees.depuisCars('f', 'D'), actions,
                vitalites, Utils.plateauDepuisTexte(PLATEAU_TEST_COUPER));
        // l'action est devenue possible
        assertTrue(actions.contient("CfD,0,1"));
        // une action possible mais qui n'a pas encore été ajoutée
        assertFalse(actions.contient("CbH,0,1"));
        // pour l'instant une seule action possible
        assertEquals(1, actions.nbActions);
        // ajout d'une deuxième action possible
        joueur.ajoutActionCouper(Coordonnees.depuisCars('b', 'H'), actions,
                vitalites, Utils.plateauDepuisTexte(PLATEAU_TEST_COUPER));
        // l'action a bien été ajoutée
        assertTrue(actions.contient("CbH,1,0"));
        // désormais, deux actions possibles
        assertEquals(2, actions.nbActions);
    }
    
    /**
     * Test de la fonction ajoutActionFertiliser.
     */
    @Test
    public void testAjoutActionFertiliser() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        ActionsPossibles actions = new ActionsPossibles();
        Vitalites vitalites = new Vitalites(3, 9);
        // pour l'instant pas d'action possible
        assertEquals(0, actions.nbActions);
        // on crée le tableau d'actions et on en ajoute une
        joueur.ajoutActionFertiliser(Coordonnees.depuisCars('f', 'D'), actions,
                vitalites, Utils.plateauDepuisTexte(PLATEAU_TEST_FERTILISER));
        // l'action est devenue possible
        assertTrue(actions.contient("FfD,4,9"));
        // une action possible mais qui n'a pas encore été ajoutée
        assertFalse(actions.contient("CbH,3,10"));
        // pour l'instant une seule action possible
        assertEquals(1, actions.nbActions);
        // ajout d'une deuxième action possible
        joueur.ajoutActionFertiliser(Coordonnees.depuisCars('k', 'D'), actions,
                vitalites, Utils.plateauDepuisTexte(PLATEAU_TEST_FERTILISER));
        // l'action a bien été ajoutée
        assertTrue(actions.contient("FkD,6,9"));
        // désormais, deux actions possibles
        assertEquals(2, actions.nbActions);
        // ajout d'une troisième action possible
        joueur.ajoutActionFertiliser(Coordonnees.depuisCars('h', 'H'), actions,
                vitalites, Utils.plateauDepuisTexte(PLATEAU_TEST_FERTILISER));
        // l'action a bien été ajoutée
        assertTrue(actions.contient("FhH,3,10"));
    }
    
    /**
     * Test de la fonction ajoutActionCouper.
     */
    @Test
    public void testAjoutActionDisseminer() {
        JoueurBiosphere7 joueur = new JoueurBiosphere7();
        ActionsPossibles actions = new ActionsPossibles();
        Vitalites vitalites = new Vitalites(6,10);
        // pour l'instant pas d'action possible
        assertEquals(0, actions.nbActions);
        // on crée le tableau d'actions et on en ajoute une
        joueur.ajoutActionDisseminer(Coordonnees.depuisCars('f', 'D'), actions,
                vitalites, Utils.plateauDepuisTexte(PLATEAU_TEST_DISSEMINER), 'B');
        // l'action est devenue possible
        assertTrue(actions.contient("IfD,6,14"));
        // une action possible mais qui n'a pas encore été ajoutée
        assertFalse(actions.contient("IkI,6,13"));
        // pour l'instant une seule action possible
        assertEquals(1, actions.nbActions);
        // ajout d'une deuxième action possible
        joueur.ajoutActionDisseminer(Coordonnees.depuisCars('k', 'I'), actions,
                vitalites, Utils.plateauDepuisTexte(PLATEAU_TEST_DISSEMINER), 'B');
        // l'action a bien été ajoutée
        assertTrue(actions.contient("IkI,6,13"));
        // désormais, deux actions possibles
        assertEquals(2, actions.nbActions);
    }

    @Test
    public void testVitalitesPlateau() {
        // à décommenter le moment venu...

        // plateau : rouge 0, bleu 0
        Case[][] plateau1 = Utils.plateauDepuisTexte(PLATEAU_VIDE);
        Vitalites vita1 = JoueurBiosphere7.vitalitesPlateau(plateau1);
        assertEquals(0, vita1.vitalitesRouge);
        assertEquals(0, vita1.vitalitesBleu);
        // plateau : rouge 2, bleu 2
        Case[][] plateau2 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        Vitalites vita2 = JoueurBiosphere7.vitalitesPlateau(plateau2);
        assertEquals(2, vita2.vitalitesRouge);
        assertEquals(2, vita2.vitalitesBleu);

    }

    /**
     * Un plateau de base, sous forme de chaîne. Pour construire une telle
     * chaîne depuis votre sortie.log, déclarez simplement : final String
     * MON_PLATEAU = ""; puis copiez le plateau depuis votre sortie.log, et
     * collez-le entre les guillemets. Puis Alt+Shift+f pour mettre en forme.
     */
    final String PLATEAU_VIDE
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;

    /**
     * Un plateau de base, sous forme de chaîne. Pour construire une telle
     * chaîne depuis votre sortie.log, déclarez simplement : final String
     * MON_PLATEAU = ""; puis copiez le plateau depuis votre sortie.log, et
     * collez-le entre les guillemets. Puis Alt+Shift+f pour mettre en forme.
     */
    final String PLATEAU_TEST_COUPER
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |   |   |   |PB1|   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|   |   |   |PR1|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;
    
    /**
     * Un plateau de base, sous forme de chaîne. Pour construire une telle
     * chaîne depuis votre sortie.log, déclarez simplement : final String
     * MON_PLATEAU = ""; puis copiez le plateau depuis votre sortie.log, et
     * collez-le entre les guillemets. Puis Alt+Shift+f pour mettre en forme.
     */
    final String PLATEAU_TEST_FERTILISER
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |   |   |   |PB1|   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|   |   |   |PR1|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |   |   |   |   |   |BB8|   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |DR2|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;
    
    /**
     * Un plateau de base, sous forme de chaîne. Pour construire une telle
     * chaîne depuis votre sortie.log, déclarez simplement : final String
     * MON_PLATEAU = ""; puis copiez le plateau depuis votre sortie.log, et
     * collez-le entre les guillemets. Puis Alt+Shift+f pour mettre en forme.
     */
    final String PLATEAU_TEST_DISSEMINER
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |   |   |   |PB1|   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |   |   |   |   |   |   |TB1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|   |   |   |PR1|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |   |   |   |   |   |BB8|   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |DR2|   |   |   |HR1|HR2|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;

    /**
     * Un plateau pour tester le niveau 2.
     */
    final String PLATEAU_NIVEAU2
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |   |   |   |   |   |   |   |   |   |   |PB1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |   |   |   |   |   |PR1|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|PR1|   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |   |   |   |   |   |   |   |PB1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;

    /**
     * Un plateau pour tester le niveau 3.
     */
    final String PLATEAU_NIVEAU3
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |   |   |   |   |   |   |   |   |   |   |PB1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |   |   |   |   |   |PR2|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|PR1|   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |   |   |   |   |   |   |   |PB1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;

    /**
     * Un plateau pour tester le niveau 3.
     */
    final String PLATEAU_NIVEAU4
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |PB2|   |   |   |   |PR9|   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |PB1|   |PB1|   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |PR1|   |   |   |   |   |   |   |   |PR1|PR1|PB1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |PB1|   |   |   |   |   |   |PB1|   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |PB1|   |PR1|   |   |   |   |   |   |PR1|   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|PR1|   |   |   |   |   |PR1|   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |PB1|   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |PR1|   |   |   |   |   |   |   |PR1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |PR1|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |   |   |   |   |   |PB1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |PR1|PB1|PR1|   |PR1|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |PB2|   |PB1|   |   |   |PB1|   |   |PB1|   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |PB1|   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;
    
    /**
     * Un plateau pour tester le niveau 7.
     */
    final String PLATEAU_NIVEAU7
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |PB2|   |   |   |   |PR9|   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |PB1|   |PB1|   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |PR1|   |   |   |   |   |   |   |   |PR1|PR1|PB1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |PB1|   |   |   |   |   |   |PB1|   |PR2|   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |PB1|   |PR1|   |   |   |   |   |   |PR1|   |PB1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|PR1|   |   |   |   |   |PR1|   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |PB1|   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |PR1|   |   |   |   |   |   |   |PR1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |PR1|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |   |   |   |   |   |PB1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |PR1|PB1|PR1|   |PR1|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |PB2|   |PB1|   |   |   |PB1|   |   |PB1|   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |PB1|   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;
    
    /**
     * Un plateau pour tester le niveau 8.
     */
    final String PLATEAU_NIVEAU8
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |   |HB1|   |TR1|   |   |PR1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |   |   |   |   |   |   |   |SR2|PR1|   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |BR1|   |   |   |   |SB1|   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |   |   |   |   |   |PB1|   |PR1|   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|   |   |   |   |   |   |   |   |   |PR1|   |SB1|   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|   |PB1|   |   |   |   |   |   |   |   |   |   |   |SB1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |SB1|   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |   |   |   |   |   |   |PB1|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |BR1|   |HR1|   |   |   |   |HB1|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |   |SR1|   |TR1|   |   |   |SB1|BR1|TR2|   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+""";
    
    /**
     * Un plateau pour tester le niveau 9.
     */
    final String PLATEAU_NIVEAU9
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |   |   |HB1|   |   |DR1|PB1|   |TR1|   |PB1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|   |   |   |   |   |   |   |   |   |   |   |   |HR1|   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |   |SR1|   |   |   |   |SR1|   |   |TR1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |BB1|   |   |   |   |   |   |   |   |SR1|   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|SB1|   |   |   |DR1|   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|HB2|   |PR1|   |   |   |   |TB1|   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|HB1|   |   |   |   |   |   |   |PR1|   |   |   |SB1|   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|TB1|   |   |   |   |   |TR1|   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |DB1|   |DR1|   |TB1|   |   |   |   |   |   |PR1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |DB1|   |   |   |   |BR1|   |   |DB1|TB2|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |TR1|   |SR1|   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|DR1|   |   |   |PB1|   |   |   |HR1|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |SB1|   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              """;
    
    /**
     * Un plateau pour tester le niveau 9.
     */
    final String PLATEAU_NIVEAU10
            = """
                 A   B   C   D   E   F   G   H   I   J   K   L   M   N 
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              a|   |   |   |SB1|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              b|   |   |   |HR2|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              c|PR1|   |   |SR1|   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              d|   |   |   |   |BR1|   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              e|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              f|   |   |   |PR2|HB1|   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              g|   |   |   |DB8|   |   |   |   |PB1|   |DR1|   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              h|   |   |   |   |   |   |TR1|   |   |   |TB1|   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              i|   |   |   |PR5|   |   |   |   |   |   |   |   |BR1|   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              j|   |   |HB1|   |   |   |   |   |BB4|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              k|   |   |   |   |   |   |   |   |PR3|   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              l|   |   |   |   |   |   |   |   |SR4|   |   |PR1|   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
              n|   |   |   |   |   |HB1|   |   |SB8|   |   |   |   |DB1|
               +---+---+---+---+---+---+---+---+---+---+---+---+---+---+""";
}

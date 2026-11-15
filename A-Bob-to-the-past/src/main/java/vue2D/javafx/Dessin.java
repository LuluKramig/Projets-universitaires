package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.AVue;
import vue2D.sprites.ISprite;
import labyrinthe.IEtage;
import vue2D.sprites.HerosSprite;

/**
 * Classe qui représente un dessin, la toile sur laquelle représenter le jeu
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private Collection<ISprite> sprites;
    private int unite;

    // donnees labyrinthe labyrinthe
    private ILabyrinthe labyrinthe;
    private ISalle entree;
    private ISalle sortie;
    private int largeur;
    private int hauteur;

    private GraphicsContext tampon;
    private Image murImage;
    private Image solImage;
    private Image escalierD;
    private Image escalierM;
    private Image solSalleImage;
    private Image sortieImage;
    private Image entreeImage;

    private int tailleLinkH = 6;
    private int tailleLinkL = 2;
    
    /**
     * Le constructeur du dessin
     * @param labyrinthe le labyrinthe du jeu
     * @param sprites les sprites du jeu
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.labyrinthe = labyrinthe;
        this.sprites = sprites;
        this.unite = AVue.UNITE;
        entree = labyrinthe.getEntree();
        sortie = labyrinthe.getSortie();
        largeur = labyrinthe.getEtageCourant().getLargeur();
        hauteur = labyrinthe.getEtageCourant().getHauteur();
        setWidth(largeur * unite);
        setHeight(hauteur * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
    }
    
    /**
     * Charge les images depuis les fichiers
     */
    public void chargementImages() {
        murImage = new Image("file:icons/mur0.gif");
        solImage = new Image("file:icons/pyramide.png");
        escalierM = new Image("file:icons/up.gif");
        escalierD = new Image("file:icons/down.gif");
        solSalleImage = new Image("file:icons/ground.gif");
        sortieImage = new Image("file:icons/sortie.gif");
        entreeImage = new Image("file:icons/groundP.gif");
    }
    
    /**
     * Dessine l'image de fond
     */
    public void dessinFond() {// ...
        tampon.drawImage(solImage, 0, 0, unite * largeur,
                unite * hauteur);
    }
    
    /**
     * Dessine toutes les salles d'un étage
     * @param etage l'étage correspondant
     */
    public void dessinSalles(IEtage etage) {
        for (ISalle s : etage) {
            Color c = Color.rgb(200, 200, 200);
            dessinSalle(s, c);
        }
    }
    
    /**
     * Dessine une salle
     * @param s la salle
     * @param c la couleur
     */
    public void dessinSalle(ISalle s, Color c) {
        Image salle = null;
        switch (s.getType()) {
            case NORMALE : {salle = solSalleImage; break;}
            case ESCALIER_MONTANT : {salle = escalierM; break;}
            case ESCALIER_DESCENDANT : {salle = escalierD; break;}
            case SORTIE : {salle = sortieImage; break;}
            case ENTREE : {salle = entreeImage; break;}
        }
        tampon.drawImage(salle, s.getX()*unite, s.getY()*unite, unite,
                unite);
    }
    
    /**
     * Dessine tous les sprites de l'étage courant
     */
    public void dessinSprites() {
        for (ISprite s : sprites) {
            if (s.getPosition().getEtage().equals(labyrinthe.getEtageCourant())) {
                s.dessiner(tampon);
            }
        }
    }

    public void dessinPlusCourtChemin(ISprite p) {
        // ...
    }

}

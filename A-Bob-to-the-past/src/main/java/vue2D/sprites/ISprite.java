package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import personnages.IPersonnage;

/**
 * Interface représentant un sprite de personnage.
 * un sprite est un personnage, que l'on peut dessiner
*
* @author INFO Professors team
*/
// un sprite est un personnage, que l'on peut dessiner
public interface ISprite extends IPersonnage{
    /**
     * Dessine le sprite sur l'interface graphique
     * @param g l'interface graphique
     */
	public void dessiner(GraphicsContext g);
    /**
     * Change les coordonnées en pixels du CSG du sprite
     * @param xpix la valeur d'abscisses en pixels
     * @param ypix la valeur d'ordonnées en pixels
     */
	public void setCoordonnees(int xpix, int ypix);
}

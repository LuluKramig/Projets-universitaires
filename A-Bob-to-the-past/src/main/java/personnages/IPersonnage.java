package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Interface représentant un personnage.
 * un personnage peut choisir une salle parmi les salles adjacentes a sa position 
 */
// un personnage peut choisir une salle parmi les salles adjacentes a sa position 
public interface IPersonnage {
    /**
     * Renvoie la salle dans laquelle le personnage souhaite aller, parmi les accessibles 
     * 
     * @param sallesAccessibles les salles accessibles au personnage
     * @return la salle voulue
     */
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles); // renvoie une salle parmi sallesAccesibles
    /**
     * Renvoie la position courante du personnage sur la grille
     * 
     * @return la position
     */
    public ISalle getPosition(); // renvoie sa position courante
    /**
     * Change la position courante du personnage par une autre salle
     * 
     * @param s une autre salle
     */
    public void setPosition( ISalle s); // definit sa position courante
}

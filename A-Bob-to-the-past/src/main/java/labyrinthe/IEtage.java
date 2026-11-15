package labyrinthe;

import java.io.IOException;
import java.util.Collection;

/**
 * Interface représentant les étages.
 * un etage est une collection de salles disposees sur une grille
 * @author INFO Professors team
 */
// un etage est une collection de salles disposees sur une grille
public interface IEtage extends Collection<ISalle>{
    /**
     * Renvoie la largeur de la grille de l'étage.
     * 
     * @return la largeur
     */
    public int getLargeur(); // largeur de la grille
    /**
     * Renvoie la hauteur de la grille de l'étage.
     * 
     * @return la hauteur
     */
    public int getHauteur(); // hauteur de la grille  
    /**
     * Renvoie le numéro de l'étage
     * 
     * @return le numéro
     */
    public int getNum(); // numero de l'etage
    /**
     * Récupère les données des salles d'un fichier pour les instancier
     * 
     * @param file
     * @throws IOException 
     */
    public void charger(String file) throws IOException; // charger les salles d'un fichier
}

package labyrinthe;

import java.util.Collection;

import personnages.IPersonnage;

/**
 * Interface représentant un Labyrinthe.
 * un labyrinthe est une collection de salles, reparties sur plusieurs etages
 *
 * @author INFO Professors team
 */
// un labyrinthe est une collection de salles, reparties sur plusieurs etages
public interface ILabyrinthe extends Collection<ISalle>{ 
    /**
     * Renvoie les salles accessibles pour le heros
     * 
     * @param heros le héros/personnage dont on demande les salles accessibles
     * @return la collection des salles accessibles
     */
    public Collection<ISalle> sallesAccessibles(IPersonnage heros);  // renvoie les salles accessibles pour le heros
    /**
     * Renvoie la salle d'entrée du labyrinthe
     * 
     * @return l'entrée
     */
    public ISalle getEntree(); // accesseur sur l'entree 
    /**
     * Renvoie la salle de sortie du labyrinthe
     * 
     * @return la sortie
     */
    public ISalle getSortie(); // accesseur sur la sortie
    /**
     * Renvoie l'étage où se trouve le héros
     * 
     * @return l'étage courant
     */
    public IEtage getEtageCourant(); // accesseurs sur l'etage affiche
    /**
     * Redéfinit l'étage courant
     * 
     * @param etage le nouvel étage courant
     */
    public void setEtageCourant(IEtage etage);
    public Collection<ISalle> chemin(ISalle u, ISalle v); // un plus court chemin entre u et v
}

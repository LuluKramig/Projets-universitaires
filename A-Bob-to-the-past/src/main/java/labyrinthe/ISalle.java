package labyrinthe;

/**
 * Interface représentant une salle d'un labyrinthe
 * une salle a des coordonnees dans la grille de son etage
 * @author INFO Professors team
 */
// une salle a des coordonnees dans la grille de son etage
public interface ISalle {
    /**
     * Renvoie la coordonnée d'abscisse de la salle
     * 
     * @return les abscisses
     */
    public int getX(); // abcisse
    /**
     * Renvoie la coordonnée d'ordonnée de la salle
     * 
     * @return les ordonnées
     */
    public int getY(); // ordonnee
    /**
     * Renvoie le type de la salle
     * 
     * @return le type
     */
    public ESalle getType(); // type
    /**
     * Renvoie l'étage de la salle
     * 
     * @return l'étage
     */
    public IEtage getEtage(); // etage de la salle
    /**
     * Renvoie vrai ssi la salle est dite adjacente à une autre salle donnée
     * 
     * @param autre l'autre salle
     * @return vrai si adjacentes, faux sinon
     */
    public boolean estAdjacente( ISalle autre); // indique si une salle est adjacente a une autre
}

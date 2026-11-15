/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

import java.util.Objects;

/**
 * Classe représentant une salle d'un labyrinthe
 *
 * @author lupauly
 */
public class Salle implements ISalle {
    private final int x;
    private final int y;
    private final ESalle type;
    private final IEtage etage;
    
    /**
     * Constructeur d'une salle
     * @param _x la valeur en abscisses de la grille
     * @param _y la valeur en ordonnées de la grille
     * @param _type le type de la salle
     * @param _etage l'étage dans laquelle la salle se trouve
     */
    public Salle(int _x, int _y, ESalle _type, IEtage _etage) {
        x = _x;
        y = _y;
        type = _type;
        etage = _etage;
    }
    
    
    @Override
    public int getX() {
        return x;
    } 
    @Override
    public int getY() {
        return y;
    }
    @Override
    public ESalle getType() {
        return type;
    }
    @Override
    public IEtage getEtage() {
        return etage;
    }
    @Override
    public boolean estAdjacente(ISalle autre) {
        boolean adj = ((autre.getX() == x + 1 || 
                autre.getX() == x - 1) && autre.getY() == y ||
                (autre.getY() == y + 1 || 
                autre.getY() == y - 1) && autre.getX() == x)
                && etage.equals(autre.getEtage());
        adj |= (type == ESalle.ESCALIER_MONTANT 
                && etage.getNum()-autre.getEtage().getNum() == -1 
                && autre.getType() == ESalle.ESCALIER_DESCENDANT 
                && x == autre.getX()
                && y == autre.getY());
        adj |= (type == ESalle.ESCALIER_DESCENDANT 
                && etage.getNum()-autre.getEtage().getNum() == 1 
                && autre.getType() == ESalle.ESCALIER_MONTANT 
                && x == autre.getX()
                && y == autre.getY());
        return adj;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        hash = 53 * hash + Objects.hashCode(this.etage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return Objects.equals(this.etage, other.etage);
    }
    
    
}

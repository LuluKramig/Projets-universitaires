/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Classe abstraite représentant un personnage
 *
 * @author lupauly
 */
public abstract class APersonnage implements IPersonnage {
    
    public ISalle salleChoisie;
    protected ISalle position;
    

    @Override
    public ISalle getPosition() {
        return position;
    }

    @Override
    public void setPosition(ISalle s) {
        position = s;
    }
    
}

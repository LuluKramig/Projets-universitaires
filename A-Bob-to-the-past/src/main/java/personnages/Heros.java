/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Classe représentant un héros
 *
 * @author lupauly
 */
public class Heros extends APersonnage {
    
    /**
     * Constructeur d'un héros
     * @param debut la salle de départ du héros
     */
    public Heros(ISalle debut) {
        super.position = debut;
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return sallesAccessibles.contains(salleChoisie)?salleChoisie:super.position;
    }
    
}

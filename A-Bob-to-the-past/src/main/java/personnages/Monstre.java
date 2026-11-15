/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.Collection;
import java.util.Random;
import labyrinthe.ISalle;
import vue2D.AVue;

/**
 * Classe représentant un monstre
 *
 * @author lupauly
 */
public class Monstre extends APersonnage {
    
    /**
     * Constructeur d'un monstre
     * @param debut la salle d'apparition du monstre
     */
    public Monstre(ISalle debut) {
        super.position = debut;
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        Random r = new Random();
        salleChoisie = sallesAccessibles.stream().skip(r.nextInt(sallesAccessibles.size())).findFirst().orElse(position);
        return sallesAccessibles.contains(salleChoisie)?salleChoisie:super.position;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import personnages.Monstre;

/**
 * Classe représentant le sprite d'un monstre
 *
 * @author lupauly
 */
public class MonstreSprite extends ASprite{
    
    /**
     * Constructeur d'un monstre
     * @param labyrinthe le labyrinthe dans lequel se déplace le monstre
     * @param monstre le monstre associé
     */
    public MonstreSprite(ILabyrinthe labyrinthe, Monstre monstre) {
        super(monstre);
        super.image = new Image("file:icons/monstre0.gif");
    }
   
}

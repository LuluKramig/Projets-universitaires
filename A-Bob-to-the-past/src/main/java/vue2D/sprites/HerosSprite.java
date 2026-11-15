/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.Etage;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 * Classe représentant le sprite d'un héros
 *
 * @author lupauly
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent>{
    
    private final ILabyrinthe labyrinthe;
    private final Heros heros;
    
    /**
     * Constructeur d'un sprite de héros
     * @param labyrinthe le labyrinthe dans lequel se déplace le héros
     * @param heros le héros associé
     */
    public HerosSprite(ILabyrinthe labyrinthe, Heros heros) {
        super(heros);
        this.heros = heros;
        super.image = new Image("file:icons/link/LinkRun" + direction + (animation%6+1) + ".gif");
        this.labyrinthe = labyrinthe;
    }

    @Override
    public void handle(KeyEvent t) {
        switch (t.getCode()) {
            case LEFT : {
                heros.salleChoisie = labyrinthe.sallesAccessibles(heros).stream()
                        .filter(s -> s.getX() < heros.getPosition().getX())
                        .findFirst()
                        .orElse(heros.getPosition());
                direction = 'L';
                break;
            }
            case UP : {
                heros.salleChoisie = labyrinthe.sallesAccessibles(heros).stream()
                        .filter(s -> s.getY() < heros.getPosition().getY())
                        .findFirst()
                        .orElse(heros.getPosition());
                direction = 'U';
                break;
            }
            case DOWN : {
                heros.salleChoisie = labyrinthe.sallesAccessibles(heros).stream()
                        .filter(s -> s.getY() > heros.getPosition().getY())
                        .findFirst()
                        .orElse(heros.getPosition());
                direction = 'D';
                break;
            }
            case RIGHT : {
                heros.salleChoisie = labyrinthe.sallesAccessibles(heros).stream()
                        .filter(s -> s.getX() > heros.getPosition().getX())
                        .findFirst()
                        .orElse(heros.getPosition());
                direction = 'R';
                break;
            }
            case M : {
                heros.salleChoisie = labyrinthe.sallesAccessibles(heros).stream()
                        .filter(s -> s.getEtage().getNum() > heros.getPosition().getEtage().getNum())
                        .findFirst()
                        .orElse(heros.getPosition());
                break;
            }
            case D : {
                heros.salleChoisie = labyrinthe.sallesAccessibles(heros).stream()
                        .filter(s -> s.getEtage().getNum() < heros.getPosition().getEtage().getNum())
                        .findFirst()
                        .orElse(heros.getPosition());
                break;
            }
        }
    }
    
    
}

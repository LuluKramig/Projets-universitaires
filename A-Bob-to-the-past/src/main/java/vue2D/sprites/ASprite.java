/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import vue2D.AVue;

/**
 * Classe abstraite représentant un sprite de personnage
 *
 * @author lupauly
 */
public abstract class ASprite implements ISprite {
    
    protected IPersonnage perso;
    protected Image image;
    private final int UNITE = AVue.UNITE;
    private int x;
    private int y;
    protected char direction;
    protected int animation;

    /**
     * Constructeur d'un sprite
     * @param p le personnage associé
     */
    public ASprite(IPersonnage p){
        perso = p;
        this.direction = 'D';
        animation = 0;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(image, x, y, UNITE, UNITE);
        if (this instanceof HerosSprite) {
            Image ombreImage = new Image("file:icons/darkness.png");
            g.drawImage(ombreImage, 
                    x-800+UNITE/2, 
                    y-800+UNITE/2, 
                    1600, 
                    1600);
        }
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        x = xpix;
        y = ypix;
        switch (direction) {
            case 'D': {y -= (UNITE-animation)%20; break;}
            case 'U': {y += (UNITE-animation)%20; break;}
            case 'R': {x -= (UNITE-animation)%20; break;}
            case 'L': {x += (UNITE-animation)%20; break;}
        }
        
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        ISalle choix = perso.getPosition();
        if (animation == 0) {
            choix = perso.faitSonChoix(sallesAccessibles);
        }
        return choix;
    }
    
    /**
     * Change les attributs d'animation et de direction dans une itération de mouvement
     * 
     * @param s la salle de destination
     */
    private void setAnimation(ISalle s) {
        int dx = s.getX()*UNITE - x;
        int dy = s.getY()*UNITE - y;
        if (dx == 0) {
            if (dy != 0) {
                direction = (dy < 0)?'U':'D';
            }
        } else if (dy == 0) {
            if (dx != 0) {
                direction = (dx < 0)?'L':'R';
            }
        }
        if (dx != 0 || dy != 0) {
            animation++;
            animation%=20;
        }
        if (this instanceof HerosSprite) {
            image = new Image("file:icons/link/LinkRun" + direction + (animation%6+1) + ".gif");
        }
    }

    @Override
    public ISalle getPosition() {
        return perso.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        perso.setPosition(s);
        setAnimation(s);
        setCoordonnees(perso.getPosition().getX()*UNITE, perso.getPosition().getY()*UNITE);
    }
    
}

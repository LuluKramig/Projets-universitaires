package vue2D.javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;

/**
 * Classe représentant une vue
 *
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {

    Dessin dessin;
    ILabyrinthe labyrinthe;
    public Scene scene;
    
    /**
     * Constructeur d'une vue
     * 
     * @param labyrinthe le labyrinthe associé
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    @Override
    public void dessiner() {
        // recopie du fond (image); murs + salles
        dessin.dessinFond();
        // dessin des salles
        dessin.dessinSalles(labyrinthe.getEtageCourant());
        // dessin des sprites
        dessin.dessinSprites();
    }
    
    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        // si le sprite est controle par le clavier
        if (sprite instanceof EventHandler){
            System.out.println ("registering keylistener");
            // association de l'ecouteur sur le clavier avec le
            //composant graphique principal
            this.scene.setOnKeyPressed ((EventHandler) sprite );
        }
        return true;
    }

}

package vue2D;

import java.util.Collection;

import vue2D.sprites.ISprite;

/**
 * Interface représentant une vue
 * une vue est une collection de sprites
*
* @author INFO Professors team
*/
// une vue est une collection de sprites
public interface IVue extends Collection<ISprite>{
    /**
     * Action de dessiner les sprites et images sur la partie graphique
     */
    public void dessiner();   
}

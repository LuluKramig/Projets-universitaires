package application;

import java.util.Collection;
import java.util.Random;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.Heros;
import personnages.Monstre;
import vue2D.IVue;
import vue2D.sprites.HerosSprite;
import vue2D.sprites.ISprite;
import vue2D.sprites.MonstreSprite;

/**
 * Classe gérant le déroulé du jeu
 * 
 * @author arpecher
 */
public class Core {
    ISprite heros;
    ILabyrinthe labyrinthe;
    
    /**
     * Creation du labyrinthe.
     */
    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
    }
    
    /**
     * Creation des sprites, c'est-à-dire celui du héros et ceux des monstres.
     * 
     * @param vue La vue dans laquelle ajouter les sprites créés
     */
    protected void initSprites(IVue vue) {
        // creation du heros 
        Heros h = new personnages.Heros(labyrinthe.getEntree());
        this.heros = new HerosSprite(labyrinthe, h);
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            ISalle spawn = labyrinthe.stream().skip(r.nextInt(labyrinthe.size())).findFirst().orElse(labyrinthe.getSortie());
            Monstre m = new personnages.Monstre(spawn);
            vue.add(new MonstreSprite(labyrinthe, m));
        }
        vue.add(this.heros);
    }
    
    /**
     * Boucle principale du déroulé du jeu
     * 
     * @param vue la vue qui regroupe les sprites nécessaires au jeu
     */
    protected void jeu(IVue vue) {
        // boucle principale
        ISalle destination = null;
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // ajustement etage courant: celui du héros
            labyrinthe.setEtageCourant(heros.getPosition().getEtage());
            // choix et deplacements de chaque sprite
            for (ISprite s : vue) {
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(s);
                destination = s.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                s.setPosition(destination); // deplacement
            }
            
            // detection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite s : vue) {
                if (s != heros) {
                    if (s.getPosition() == heros.getPosition()) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = s;
                    }
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
            }

            temporisation(10);
        }
        System.out.println("Gagné!");
    }

    /**
     * Fonction d'attente d'un délai pour temporiser les itérations de la boucle.
     * 
     * @param nb le nombre de millisecondes à attendre
     */
    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        }
    }
}

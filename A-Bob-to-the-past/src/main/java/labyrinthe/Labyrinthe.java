package labyrinthe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import personnages.IPersonnage;

/**
 * Classe représentant un Labyrinthe dans lequel se déplacer.
 * un labyrinthe est une collection de salles, reparties sur plusieurs etages
 *
 * @author professor team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {
    
    private IEtage etageCourant = new Etage();
    
    public Labyrinthe() {
        int[] etages = {1,2};
        try {
            for (int i : etages) {
                IEtage e = new Etage(i);
                if (i == 1) {
                    etageCourant = e;
                }
                e.charger("etages/etage" + i + "N.txt");
                this.addAll(e);
            }
        } catch (IOException e) {}
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage heros) {
        Collection<ISalle> resultat = new ArrayList<>();
        for (ISalle s : this) {
            if (s.estAdjacente(heros.getPosition())) {
                resultat.add(s);
            }
        }
        return resultat;
    }

    @Override
    public ISalle getEntree() {
        return this.stream()
                .filter(s -> s.getType() == ESalle.ENTREE)
                .findAny()
                .orElse(null);
    }

    @Override
    public ISalle getSortie() {
        return this.stream()
                .filter(s -> s.getType() == ESalle.SORTIE)
                .findAny()
                .orElse(null);   
    }

    @Override
    public IEtage getEtageCourant() {
        return this.etageCourant;
    }

    @Override
    public void setEtageCourant(IEtage etage) {
        this.etageCourant = etage;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }
    
}

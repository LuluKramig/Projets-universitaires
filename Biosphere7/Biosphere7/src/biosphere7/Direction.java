package biosphere7;

/**
 * Les 4 directions cardinales, ainsi que les 4 directions intermédiaires.
 */
enum Direction {

    NORD,
    SUD,
    EST,
    OUEST,
    NORD_EST,
    NORD_OUEST,
    SUD_EST,
    SUD_OUEST;

    /**
     * Renvoie les quatre directions cardinales dans un tableau.
     *
     * @return tableau contenant les quatre directions cardinales.
     */
    static Direction[] cardinales() {
        Direction[] directions = {NORD, SUD, EST, OUEST};
        return directions;
    }

    /**
     * Renvoie le nombre de cases parcourues horizontalement lorsqu'on suit
     * cette direction (0 pour Nord et Sud, -1 pour Ouest, 1 pour Est).
     *
     * @param dir la direction à considérer
     * @return nombre de cases horizontales de cette direction
     */
    static int mvtHoriz(Direction dir) {
        return switch (dir) {
            case NORD, SUD -> 0;
            case EST, NORD_EST, SUD_EST -> 1;
            case OUEST, NORD_OUEST, SUD_OUEST -> -1;
        };
    }

    /**
     * Renvoie le nombre de cases parcourues verticalement lorsqu'on suit cette
     * direction (0 pour Est et Ouest, -1 pour Nord, 1 pour Sud).
     *
     * @param dir la direction à considérer
     * @return nombre de cases verticales de cette direction
     */
    static int mvtVertic(Direction dir) {
        return switch (dir) {
            case EST, OUEST -> 0;
            case NORD, NORD_EST, NORD_OUEST -> -1;
            case SUD, SUD_EST, SUD_OUEST -> 1;
        };
    }
}

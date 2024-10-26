/**
 * This class is used to create a new instance of an Orc
 */
public class Orc extends Monster {
    /**
     * Constructor for the Orc class to set all of its attributes
     *
     * @param clan     The clan of the Orc
     * @param ferocity The ferocity of the Orc
     * @param defense  The defense of the Orc
     * @param magic    The magic of the Orc
     * @param health   The health of the Orc
     * @param treasure The treasure of the Orc
     */
    public Orc(String clan, double ferocity, double defense, double magic, double health, int treasure) {
        super(clan, ferocity, defense, magic, health, treasure);
    }

    /**
     * Constructor for the Orc class to set its clan
     *
     * @param clan The clan of the Orc
     */
    public Orc(String clan) {
        super(clan);
    }
}

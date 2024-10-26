/**
 * This class is used to create a new instance of a Manticore
 */
public class Manticore extends Monster {
    /**
     * Constructor for the Manticore class to set all of its attributes
     *
     * @param clan     The clan of the Manticore
     * @param ferocity The ferocity of the Manticore
     * @param defense  The defense of the Manticore
     * @param magic    The magic of the Manticore
     * @param health   The health of the Manticore
     * @param treasure The treasure of the Manticore
     */
    public Manticore(String clan, double ferocity, double defense, double magic, double health, int treasure) {
        super(clan, ferocity, defense, magic, health, treasure);
    }

    /**
     * The constructor for the Manticore class to set its clan
     * @param clan The clan of the Manticore
     */
    public Manticore(String clan) {
        super(clan);
    }

    /**
     * The method to change the clan of the Manticore
     * @param clan The clan of the Manticore
     */
    public void setClan(String clan) {
        this.clan = clan;
    }

}

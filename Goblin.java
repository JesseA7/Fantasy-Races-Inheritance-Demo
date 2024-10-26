/**
 * This class is used to create a new instance of a Goblin
 */
public class Goblin extends Monster {
    /**
     * The sworn enemy of the Goblin
     */
    private Goblin swornEnemy;

    /**
     * Constructor for the Goblin class to set all of its attributes
     *
     * @param clan     The clan of the Goblin
     * @param ferocity The ferocity of the Goblin
     * @param defense  The defense of the Goblin
     * @param magic    The magic of the Goblin
     * @param health   The health of the Goblin
     * @param treasure The treasure of the Goblin
     */
    public Goblin(String clan, double ferocity, double defense, double magic, double health, int treasure, Goblin swornEnemy) {
        super(clan, ferocity, defense, magic, health, treasure);
        this.swornEnemy = swornEnemy;
    }

    /**
     * The constructor for the Goblin class to set its clan and sworn enemy
     * @param clan The clan of the Goblin
     * @param swornEnemy The sworn enemy of the Goblin
     */
    public Goblin(String clan, Goblin swornEnemy) {
        super(clan);
        this.swornEnemy = swornEnemy;
    }

    /**
     * Get the sworn enemy of the Goblin
     * @return The sworn enemy of the Goblin
     */
    public Goblin getEnemy() {
        return swornEnemy;
    }

    /**
     * String representation for displaying the Goblin class and its attributes
     *
     * @return The string representation of the Goblin
     */
    @Override
    public String toString() {
        return String.format("Goblin: \nStatus: %s \nClan: %s \nEnemy: %s \nHealth: %.1f \nFerocity: %.1f \nDefense: %.1f \nMagic: %.1f \nTreasure: %d",
                isAlive() ? "Alive" : "Dead", getClan(), getEnemy() != null ? getEnemy().getName() : "none",
                getHealth(), getFerocity(), getDefense(), getMagic(), getTreasure());
    }


}

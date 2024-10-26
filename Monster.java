import java.text.DecimalFormat;
import java.util.Random;

/**
 * This program is used to create the monsters and defines their attributes
 * March 10, 2023
 *
 * @author Jesse Atkinson, John Creaghan
 */
public class Monster {
    /**
     * The clan of the monster
     */
    public String clan;
    /**
     * The attributes of the monster
     */
    public double ferocity, defense, magic, health;
    /**
     * The treasure of the monster
     */
    protected int treasure;

    /**
     * Constructor for the monster class
     *
     * @param clan     The clan of the monster
     * @param ferocity The ferocity of the monster
     * @param defense  The defense of the monster
     * @param magic    The magic of the monster
     * @param health   The health of the monster
     * @param treasure The treasure of the monster
     */
    public Monster(String clan, double ferocity, double defense, double magic, double health, int treasure) {
        this.clan = clan;
        this.ferocity = ferocity;
        this.defense = defense;
        this.magic = magic;
        this.health = health;
        this.treasure = treasure;
    }

    /**
     * Monster constructor to set the clan, and attributes of the monster
     *
     * @param clan The clan of the monster
     */
    public Monster(String clan) {
        this.clan = clan;
        this.ferocity = randomInt(0, 20);
        this.defense = randomInt(0, 20);
        this.magic = randomInt(0, 20);
        this.health = randomInt(1, 20);
        this.treasure = randomInt(0, 5);
    }

    /**
     * Method to determine if the monster is alive based on health
     *
     * @return True if the monster's health is greater than 0
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Method to calculate the battle score of the monster
     *
     * @return The battle score of the monster
     */
    public double getBattleScore() {
        if (!isAlive()) {
            return 0;
        }
        double factor = 1;
        if (this instanceof Manticore || this instanceof Warlord) {
            factor = 1.5;
        }
        DecimalFormat df = new DecimalFormat("#.#");
        factor = factor * (ferocity + defense + magic) / 3.0;
        return Double.parseDouble(df.format(factor));
    }

    /**
     * Method to add treasure to the monster
     *
     * @param amount The amount of treasure to add
     */
    public void addTreasure(int amount) {
        if (health > 0) {
            treasure += amount;
        }
    }

    /**
     * Get the ferocity stat of the monster
     *
     * @return The ferocity stat of the monster
     */
    public double getFerocity() {
        return ferocity;
    }

    /**
     * Get the magic stat of the monster
     *
     * @return The magic stat of the monster
     */
    public double getMagic() {
        return magic;
    }

    /**
     * Get the defense stat of the monster
     *
     * @return The defense stat of the monster
     */
    public double getDefense() {
        return defense;
    }

    /**
     * Get the health rating of the monster
     *
     * @return The health rating of the monster
     */
    public String getClan() {
        return clan;
    }


    /**
     * Get the amount of treasure the monster has
     *
     * @return The amount of treasure the monster has
     */
    public int getTreasure() {
        return treasure;
    }

    /**
     * Get the health value of the monster
     *
     * @return The health value of the monster
     */
    public double getHealth() {
        return health;
    }

    /**
     * Method to increase the ferocity stat of the monster
     */
    public void increaseFerocity() {
        if (ferocity < 20) {
            ferocity++;
        }
    }

    /**
     * Method to decrease the ferocity stat of the monster
     */
    public void decreaseFerocity() {
        if (ferocity > 0) {
            ferocity--;
        }
    }

    /**
     * Method to increase the defense stat of the monster
     */
    public void increaseDefense() {
        if (defense < 20) {
            defense++;
        }
    }

    /**
     * Method to decrease the defense stat of the monster
     */
    public void decreaseDefense() {
        if (defense > 0) {
            defense--;
        }
    }

    /**
     * Method to increase the magic stat of the monster
     */
    public void increaseMagic() {
        if (magic < 20) {
            magic++;
        }
    }

    /**
     * Method to decrease the magic stat of the monster
     */
    public void decreaseMagic() {
        if (magic > 0) {
            magic--;
        }
    }

    /**
     * Method used to generate random stats for the monster
     *
     * @param min The minimum stat value
     * @param max The maximum stat vlalue
     * @return A random stat value between min and max
     */
    public static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Get the class name of the monster
     *
     * @return The class name of the monster
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * Method for simulating combat between two monsters
     *
     * @param monster1 The first monster
     * @param monster2 The second monster
     */
    public static void combat(Monster monster1, Monster monster2) {
        if (!monster1.isAlive()) {
            System.out.println(monster1 + "is dead and cannot fight!");
        }
        if (!monster2.isAlive()) {
            System.out.println(monster2 + "is dead and cannot fight!");
        }
        double score1 = monster1.getBattleScore();
        double score2 = monster2.getBattleScore();
        while (monster1.isAlive() && monster1.isAlive()) {
            if (score1 > score2) {
                double damage = Math.round((score1 - score2) * 10.0) / 10.0;
                monster2.health -= damage;
                System.out.println(monster1.getName() + " inflicts " + damage + " damage to " + monster2.getName());
                if (monster2.health <= 0) {
                    monster2.health = 0;
                    monster2.treasure = 0;
                    monster1.addTreasure(monster2.treasure);
                    System.out.println(monster1.getName() + " has won by killing " + monster2.getName());
                    break;
                }
            } else if (score2 > score1) {
                double damage = Math.round((score2 - score1) * 1);
                monster1.health -= damage;
                System.out.println(monster2.getName() + " inflicts " + damage + " damage to " + monster1.getName());
                if (monster1.health <= 0) {
                    monster1.health = 0;
                    monster1.treasure = 0;
                    monster2.addTreasure(monster1.treasure);
                    System.out.println(monster2.getName() + " has won by killing " + monster1.getName());
                    break;
                }
            } else {
                System.out.println("An unstoppable force meets an immovable 1object (nobody can win)");
                break;
            }
        }

    }

    /**
     * String representation for displaying the monster and its attributes
     *
     * @return The string representation of the monster
     */
    public String toString() {
        return String.format("Monster: %s \nStatus: %s \nClan: %s \nFerocity: %.1f \nDefense: %.1f \nMagic: %.1f \nHealth: %.1f \nBattleScore: %.1f \nTreasure: %d \n",
                this.getName(), isAlive() ? "Alive" : "Dead", this.getClan(), this.getFerocity(), this.getDefense(), this.getMagic(), this.getHealth(), this.getBattleScore(), this.getTreasure());
    }
}


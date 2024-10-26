import java.util.ArrayList;
import java.util.List;

public class Warlord extends Monster {
    private int leadershipRating;
    private List<Infantry> infantryList;

    public Warlord(String clan, double ferocity, double defense, double magic, double health, int treasure, int leadershipRating) {
        super(clan, ferocity, defense, magic, health, treasure);
        this.leadershipRating = leadershipRating;
        this.infantryList = new ArrayList<Infantry>();
    }

    public Warlord(Orc orc) {
        super(orc.getClan(), orc.getFerocity(), orc.getDefense(), orc.getMagic(), orc.getHealth(), orc.getTreasure());
        this.leadershipRating = randomInt(1, 5);
        this.infantryList = new ArrayList<Infantry>();
    }

    @Override
    public void addTreasure(int amount) {
        for (int i = 0; i <= treasure; i += 10) {
            this.leadershipRating++;
        }
        super.addTreasure(amount);
    }

    public int getLeadershipRating() {
        return leadershipRating;
    }

    public void setLeadershipRating(int leadershipRating) {
        this.leadershipRating = leadershipRating;
    }

    public List<Infantry> getInfantryList() {
        return infantryList;
    }

    public void addInfantry(Infantry infantry) {
        infantryList.add(infantry);
        infantry.setWarlord(this);
    }

    public double warCry() {
        return leadershipRating * 5;
    }



    public void soundBattleCry() {
        if (isAlive()) {
            int healthBoost = leadershipRating * 5;
            for (Infantry infantry : infantryList) {
                infantry.health += healthBoost;
            }
        }
    }

    /**
     * String representation for displaying the Warlord class and its attributes
     *
     * @return The string representation of the Warlord
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Monster: Orc \nRank: Warlord \nStatus: %s \nClan: %s \nHealth: %.1f \nFerocity: %.1f \nDefense: %.1f \nMagic: %.1f \nTreasure: %d \nLeadership: %d \nInfantry: \n \n",
                isAlive() ? "Alive" : "Dead", this.getClan(),this.getHealth(), this.getFerocity(), this.getDefense(), this.getMagic(), this.getTreasure(), this.getLeadershipRating()));
        for (Infantry infantry : infantryList) {
            sb.append(infantry.toString()).append("\n");
        }
        return sb.toString();
    }
}


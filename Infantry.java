public class Infantry extends Monster {
    private Warlord warlord;

    public Infantry(String clan, double ferocity, double defense, double magic, double health, int treasure) {
        super(clan, ferocity, defense, magic, health, treasure);
        this.warlord = null;
    }

    public Infantry(Orc orc, Warlord warlord) {
        super(orc.getClan(), orc.getFerocity(), orc.getDefense(), orc.getMagic(), orc.getHealth(), orc.getTreasure());
        this.warlord = null;
    }

    public Warlord getWarlord() {
        return warlord;
    }

    public void setWarlord(Warlord warlord) {
        this.warlord = warlord;
    }

    /**
     * String representation for displaying the Infantry class and its attributes
     *
     * @return The string representation of the Infantry
     */
    @Override
    public String toString() {
        return String.format("Monster: Orc \nRank: Infantry \nStatus: %s \nClan: %s \nHealth: %.1f \nFerocity: %.1f \nDefense: %.1f \nMagic: %.1f \nTreasure: %d \n",
                isAlive() ? "Alive" : "Dead", this.getClan(),this.getHealth(), this.getFerocity(), this.getDefense(), this.getMagic(), this.getTreasure());

    }

}
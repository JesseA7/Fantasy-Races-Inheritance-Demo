import static assignment6_000886545.Monster.combat;

/**
 * Class for testing and implementing all monster classes
 */
public class Foon {
    public static void main(String[] args) {
        // Goblin implementation
        Goblin goblin1 = new Goblin("Chuckle Club", null);
        System.out.println(goblin1);
        Goblin goblin2 = new Goblin("Feather Gang", 5, 8, 5 ,20, 5, goblin1);
        System.out.println("\n"+goblin2);

        // Manticore implementation
        Manticore manticore1 = new Manticore("Nightshade");
        System.out.println("\n"+manticore1);
        manticore1.setClan("Big Boys");
        System.out.println("\n"+manticore1);
        Manticore manticore2 = new Manticore("Dark Bringers", 20, 15, 8, 10, 5);
        System.out.println("\n"+manticore2);

        Orc orc1 = new Orc("Smorc Gang");
        Orc orc2 = new Orc("Club Clan", 20, 15, 7, 11, 3);

        // Warlord and infantry implementation
        Warlord warlord1 = new Warlord(orc1);
        Infantry infantry1 = new Infantry(orc2, warlord1);
        Infantry infantry2 = new Infantry(orc2, warlord1);
        Infantry infantry3 = new Infantry(orc2, warlord1);
        Infantry infantry4 = new Infantry(orc2, warlord1);
        Infantry infantry5 = new Infantry(orc2, warlord1);
        warlord1.addInfantry(infantry1);
        warlord1.addInfantry(infantry2);
        warlord1.addInfantry(infantry3);
        warlord1.addInfantry(infantry4);
        warlord1.addInfantry(infantry5);
        System.out.println("\n"+warlord1);
        warlord1.soundBattleCry();
        System.out.println("\n"+warlord1);

        // Combat test
        combat(goblin1, manticore1);
        System.out.println("\n"+goblin1);
        System.out.println("\n"+manticore1);
    }
}

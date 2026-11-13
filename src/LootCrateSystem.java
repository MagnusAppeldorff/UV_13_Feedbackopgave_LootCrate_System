import exceptions.NegativeAmountException;
import exceptions.NotEnoughCreditsException;
import exceptions.PlayerNotFoundException;
import models.LootCrate;
import models.Player;

public class LootCrateSystem {
    public static void main(String[] args) {

        Player player1 = new Player("Gamer123", 100);
        Player player2 = new Player("Noob999", 50);
        Player player3 = new Player("Rich", 200);

        LootCrate bronzeCrate = new LootCrate("Bronze Crate", 25);
        LootCrate silverCrate = new LootCrate("Silver Crate", 50);
        LootCrate goldCrate = new LootCrate("Gold Crate", 75);
        LootCrate diamondCrate = new LootCrate("Diamond Crate", 100);

        System.out.println("=== STARTER LOOTCRATE SYSTEM-TESTS ===");

        openCrateTestSuccess(diamondCrate, player3);
        openCrateTestFail(goldCrate, player2);
        testNegativCredits(player1);
        testPlayerNotFound(bronzeCrate);

        System.out.println("\n=== ALLE TESTS ER NU FÆRDIGE ===");
    }

    private static void testPlayerNotFound(LootCrate bronzeCrate) {
        try {
            Player ghostPlayer = null;
            bronzeCrate.open(ghostPlayer);
        } catch (PlayerNotFoundException e) {
            System.out.println("\n[Fanget specifik fejl - Scenarie 4]: " + e.getMessage());
        } catch (NotEnoughCreditsException e) {
            System.out.println("Uventet fejl i Scenarie 4: " + e.getMessage());
        }
    }

    private static void testNegativCredits(Player player1) {
        try {
            player1.addCredits(-50);
        } catch (NegativeAmountException e) {
            System.out.println("\n[Fanget specifik fejl - Scenarie 3]: " + e.getMessage());
        }
    }

    private static void openCrateTestFail(LootCrate goldCrate, Player player2) {
        try {
            goldCrate.open(player2);
        } catch (NotEnoughCreditsException e) {
            System.out.println("\n[Fanget specifik fejl - Scenarie 2]: " + e.getMessage());
        } catch (PlayerNotFoundException e) {
            System.out.println("Uventet fejl i Scenarie 2: " + e.getMessage());
        }
    }

    private static void openCrateTestSuccess(LootCrate diamondCrate, Player player3) {
        try {
            diamondCrate.open(player3);
            player3.displayDetails();
        } catch (NotEnoughCreditsException e) {
            System.out.println("Uventet fejl i Scenarie 1: " + e.getMessage());
        } catch (PlayerNotFoundException e) {
            System.out.println("Uventet fejl i Scenarie 2: " + e.getMessage());
        }
    }
}



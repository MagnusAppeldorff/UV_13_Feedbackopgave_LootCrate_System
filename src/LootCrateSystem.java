import exceptions.NegativeAmountException;
import exceptions.NotEnoughCreditsException;
import exceptions.PlayerNotFoundException;
import models.LootCrate;
import models.Player;

import java.util.ArrayList;
import java.util.List;

public class LootCrateSystem {
    public static void main(String[] args) {
        List<Player> players = createTestPlayers();
        List<LootCrate> crates = createTestCrates();

        runAlltest(players, crates);
    }

    private static List<Player> createTestPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Gamer123", 100)); // index 0
        players.add(new Player("Noob999", 50));   // index 1
        players.add(new Player("Rich", 200));     // index 2
        return players;
    }

    private static List<LootCrate> createTestCrates() {
        List<LootCrate> crates = new ArrayList<>();
        crates.add(new LootCrate("Bronze Crate", 25));   // index 0
        crates.add(new LootCrate("Silver Crate", 50));   // index 1
        crates.add(new LootCrate("Gold Crate", 75));     // index 2
        crates.add(new LootCrate("Diamond Crate", 100)); // index 3
        return crates;
    }

    private static void runAlltest(List<Player> players, List<LootCrate> crates) {
        System.out.println("=== STARTER LOOTCRATE SYSTEM-TESTS ===");

        openCrateTestSuccess(crates.get(3), players.get(2)); // Diamond + Rich
        openCrateTestFail(crates.get(2), players.get(1));    // Gold + Noob999
        testNegativCredits(players.get(0));                  // Gamer123
        testPlayerNotFound(crates.get(0));                   // Bronze

        System.out.println("\n=== ALLE TESTS ER NU FÆRDIGE ===");
    }

    private static void testPlayerNotFound(LootCrate bronzeCrate) {
        try {
            Player ghostPlayer = null;
            bronzeCrate.open(ghostPlayer);
        } catch (PlayerNotFoundException e) {
            System.out.println("[Fanget specifik fejl - Scenarie 4]: " + e.getMessage());
        } catch (NotEnoughCreditsException e) {
            System.out.println("Uventet fejl i Scenarie 4: " + e.getMessage());
        }
    }

    private static void testNegativCredits(Player player1) {
        try {
            player1.addCredits(-50, player1);
        } catch (NegativeAmountException e) {
            System.out.println("[Fanget specifik fejl - Scenarie 3]: " + e.getMessage());
        }
    }

    private static void openCrateTestFail(LootCrate goldCrate, Player player2) {
        try {
            goldCrate.open(player2);
        } catch (NotEnoughCreditsException e) {
            System.out.println("[Fanget specifik fejl - Scenarie 2]: " + e.getMessage());
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



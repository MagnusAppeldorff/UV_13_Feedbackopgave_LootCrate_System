package models;

import exceptions.NotEnoughCreditsException;
import exceptions.PlayerNotFoundException;

public class LootCrate {
    private String id;
    private int price;

    public LootCrate(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public void open(Player player) throws PlayerNotFoundException, NotEnoughCreditsException {


        if (player == null) {
            System.out.println("\n --- Prøver at åbne en crate ---");
            throw new PlayerNotFoundException("Fejl: Kan ikke åbne crate, fordi spilleren ikke findes!");
        }

        System.out.println("\n--- Prøver at åbne " + id + " for " + player.getName() + " ---");

        if (player.getCredits() < this.price) {
            throw new NotEnoughCreditsException("Fejl: Spilleren " + player.getName() + " har ikke nok credits!");
        }

        player.buyCrate(this.price);
        System.out.println("Succes! " + player.getName() + " åbnede " + id + " og fik et fedt item!");

    }
}

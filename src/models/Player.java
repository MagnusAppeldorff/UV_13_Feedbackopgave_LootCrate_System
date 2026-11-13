package models;

import exceptions.NegativeAmountException;

public class Player {
    private String name;
    private int credits;

    public Player(String name, int startCredits) {
        this.name = name;
        this.credits = startCredits;
    }

    public void addCredits(int amount, Player player) {
        System.out.println("\n--- Prøver at tilføje credits " + player.getName() + " ---");
        if (amount < 0) {
            throw new NegativeAmountException("Fejl: Du kan ikke tilføje et negativt beløb!");
        }
        this.credits += amount;
        System.out.println(amount + " credits tilføjet til " + name);
    }

    public boolean buyCrate(int cratePrice) {
        if (this.credits >= cratePrice) {
            this.credits -= cratePrice;
            System.out.println("[System]: " + name + " betalte " + cratePrice + " credits.");
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
            return name;
    }

    public int getCredits() {
            return credits;
    }

    public void displayDetails() {
            System.out.println("Spiller: " + name + " | Credits: " + credits);
    }
}


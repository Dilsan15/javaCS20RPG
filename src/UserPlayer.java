import java.util.*;
import java.util.HashMap;


public class UserPlayer extends CharPlayer {


    private HashMap<String, int[]> playerInventory;
    private int playerExp;

    public UserPlayer(String playerName, String playerSpecial) {
        super(playerName, new int[]{150, 500, 100, 300, 1, 20});

        this.playerInventory = new HashMap<>();

        if (Objects.equals(playerSpecial, "attack")) {
            this.characterAttack += 150;
        } else if (Objects.equals(playerName, "health")) {
            this.characterHealth += 150;
        } else if (Objects.equals(playerName, "defense")) {
            this.characterDefense += 10;
        }

        this.playerExp = 0;
    }


    void playerInventoryStats() {
        System.out.println("You have the following elements in your inventory:");

        for (Map.Entry<String, int[]> entry : this.playerInventory.entrySet()) {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
        }


        System.out.println("Your current stats are: " +
                this.characterHealth + " health, "
                + this.characterAttack + " attack, "
                + this.characterDefense + " defense.");
    }


    // Getters and setters for changing/viewing playerExp
    void setPlayerExp() {
        this.playerExp += 1;
    }

    int getPlayerExp() {
        return this.playerExp;
    }

    // Getters and Setters for the playerInventory
    void playerInventoryAdd(String item, int[] value) {
        this.playerInventory.put(item, value);
        this.recalculateDefense();
    }

    HashMap<String, int[]> viewPlayerInventory() {
        return this.playerInventory;
    }


    private void recalculateDefense() {
        for (Map.Entry<String, int[]> entry : this.playerInventory.entrySet()) {
            this.characterDefense += entry.getValue()[0];
        }
    }

    void checkLiving() {
        if (this.characterHealth <= 0) {
            System.out.println("💀 Death has landed upon you. We are sending you back -- make wiser choices!");
            Main.main(null);
        }
    }


}




import java.util.*;
import java.util.HashMap;


public class userPlayer extends charPlayer {


    HashMap<String, Integer> playerInventory;


    public userPlayer(String playerName, String playerSpecial) {
        super(playerName, new int[]{150, 500, 100, 300, 1, 20});

        this.playerInventory = new HashMap<>();

        if (Objects.equals(playerSpecial, "attack")) {
            this.CharacterAttack += 150;
        } else if (Objects.equals(playerName, "health")) {
            this.CharacterHealth += 150;
        } else if (Objects.equals(playerName, "defense")) {
            this.CharacterDefense += 10;
        }
    }

    public void playerInventoryStats() {
        System.out.println("You have the following items in your inventory: " + this.playerInventory);
        System.out.println("Your current stats are: " +
                this.CharacterHealth + " health, "
                + this.CharacterAttack + " attack, "
                + this.CharacterDefense + " defense.");
    }


    public void playerInventoryAdd(String item, int value) {
        this.playerInventory.put(item, value);
    }

    public void playerInventoryRemove(String item) {
        this.playerInventory.remove(item);
    }


}




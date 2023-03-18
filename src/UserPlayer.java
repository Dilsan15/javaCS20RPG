import java.util.*;
import java.util.HashMap;


public class userPlayer extends charPlayer {


    private HashMap<String, int[]> playerInventory;
    private int playerExp;

    UserPlayer(String playerName, String playerSpecial) {
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
        System.out.println("You have the following items in your inventory: " + this.playerInventory);
        System.out.println("Your current stats are: " +
                this.characterHealth + " health, "
                + this.characterAttack + " attack, "
                + this.characterDefense + " defense.");
    }


    // Getters and setters for changing/viewing playerExp
    void setPlayerExp(){
        this.playerExp += 1;
    }

    int getPlayerExp(){
        return this.playerExp;
    }

    // Getters and Setters for the playerInventory
    void playerInventoryAdd(String item, int[] value) {
        this.playerInventory.put(item, value);
    }
    void playerInventoryRemove(String item) {
        this.playerInventory.remove(item);
    }

    void viewPlayerInventory(){
        assert true;
    }



    private void checkLiving() {
        if (this.characterHealth <= 0) {
            System.out.println("💀 Death has landed upon you. We are sending you back -- make wiser choices!");
            Main.main(null);
        }
    }




}




//Plan for EVERYTHING:
// We are doing an RPG where the user is run through a story, and is given options to ensure user-engagement through the "choose your adventure type"

// Randomness through a DiceRroll for the damage that the opponents do, along with whether you get to use your special or not?
// Each character has


import java.lang.reflect.Array;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
      //  Scanner UserInput = new Scanner(System.in);

        System.out.println("You wake up un a dark forrest, glimpse of sunlight shines through the draping canopies, there's a stick within reach ");
        System.out.println("Ahh, you leap backwards as a bright beam of light dashes into your eye. In the corner of a near tree, you notice a silver sword glistening in the sunlight.");
        // Now add code on whether you take the tree or sword
        System.out.println("Now it's your turn: CHOOSE YOUR DESTINY! ");
        System.out.print("The ancient wooden stick? OR The Newly-Polished Silver Sword?");

       // String StickOrSword = UserInput.nextLine();

        int playerNum = 2;

        ArrayList<userPlayer> gamePlayers = new ArrayList<userPlayer>();

        for (int i = 0; playerNum != i; i++) {
            gamePlayers.add(new userPlayer("Dilshaan" + i, "attack"));
        }

        System.out.println(gamePlayers);

         String[] choices = new String[]{"23", "3"};
         System.out.println(gameControl.inputValidation(choices, "1"));

    }
}
//Plan for EVERYTHING:
// We are doing an RPG where the user is run through a story, and is given options to ensure user-engagement through the "choose your adventure type"

// Randomness through a DiceRroll for the damage that the opponents do, along with whether you get to use your special or not?
// Each character has


import java.lang.reflect.Array;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        //ask input for how many players are needed

        System.out.println("How many players would be like -- 1,2, or 3:");
        int playerNum = UserInput.nextInt();



        ArrayList<userPlayer> gamePlayers = new ArrayList<userPlayer>();

        for (int i = 1; playerNum != i + 1; i++) {


            // Ask player for name and attack using scanner copilot
            System.out.println("Player " + i + " what is your name?");
            String userName = UserInput.nextLine();

            System.out.println("Player " + i + " what is your special? (attack, health, defense)");
            String userSpecial = UserInput.nextLine();

            gamePlayers.add(new userPlayer(userName, userSpecial));

            System.out.println("Hello " + userName + " your special is " + userSpecial);

        }


        System.out.println("You wake up un a dark forrest, glimpse of sunlight shines through the draping canopies, there's a stick within reach ");
        System.out.println("Ahh, you leap backwards as a bright beam of light dashes into your eye. In the corner of a near tree, you notice a silver sword glistening in the sunlight.");
        System.out.println("Now it's your turn: CHOOSE YOUR DESTINY! ");
        System.out.print("The ancient wooden stick? OR The Newly-Polished Silver Sword?");

        // String StickOrSword = UserInput.nextLine();



    }
}
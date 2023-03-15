//Plan for EVERYTHING:
// We are doing an RPG where the user is run through a story, and is given options to ensure user-engagement through the "choose your adventure type"

// Randomness through a DiceRroll for the damage that the opponents do, along with whether you get to use your special or not?
// Each characte

import java.io.FileNotFoundException;
import java.util.Objects;

class Main {

    static userPlayer uPlayer;

    public static void main(String[] args) {

        uPlayer = userIntro();




        if (Objects.equals(directionChoose(), "N")) {
            northStory();

        } else if (Objects.equals(directionChoose(), "E")) {
            eastStory();
        } else if (Objects.equals(directionChoose(), "S")) {
            southStory();
        } else if (Objects.equals(directionChoose(), "W")) {
            westStory();
        }




    }

    public static userPlayer userIntro() {

        String rawUserName = gameControl.strInputValidation(new String[]{""}, "What is your name?");
        String userName = rawUserName.substring(0, 1).toUpperCase() + rawUserName.substring(1).toLowerCase();
        String userSpecial = gameControl.strInputValidation(new String[]{"attack", "health", "defense"}, "Player what is your special? (attack, health, defense)");

        System.out.println("Hello " + userName + " your special is " + userSpecial);

        return new userPlayer(userName, userSpecial);

    }

    public static void storyIntro() throws FileNotFoundException {
        uPlayer.playerInventoryStats();
        System.out.println("You wake up un a dark forrest, glimpse of sunlight shines through the draping canopies, there's a stick within reach ");
        System.out.println("Ahh, you leap backwards as a bright beam of light dashes into your eye. In the corner of a near tree, you notice a silver sword glistening in the sunlight.");
        System.out.println("Now it's your turn: CHOOSE YOUR DESTINY! ");
        System.out.println("The ancient wooden stick? OR The Newly-Polished Silver Sword?");

        String stickOrSword = gameControl.strInputValidation(new String[]{"Stick", "Sword"}, "Player " + uPlayer.CharacterName + ", what is your ultimate choice? (Stick, OR Sword)");
        if (stickOrSword.equals("stick")) {
            System.out.println("You feel the power of the ancient wooden stick, feeling its power surge through your hands!");
            uPlayer.playerInventoryAdd("Stick", 50);
            System.out.println("Becoming one with this strength, you decide to continue searching for more.");
        } else {
            System.out.println("You gain 200 attack!");
            System.out.println("... But you accidentally cut yourself -- losing 150 health!");

            uPlayer.playerInventoryAdd("Attack Sword", 200);
            uPlayer.damageTaken(150);
            uPlayer.playerInventoryStats();
        }


    }

    public static void northStory() {
        assert true;
        if (uPlayer.playerExp >= 2) {
            System.out.println("You ______________");
        }
    }

    public static void eastStory() {
        assert true;
        uPlayer.playerExp +=1
    }

    public static void westStory() {
        assert true;
        uPlayer.playerExp +=1;

    }

    public static void southStory() {
        if (uPlayer.playerExp >= 3) {
            assert true;
        } else {
            System.out.println("You head a loud growling sound, frightened, you stumble back an instinctively run");
        }
    }

    private static String directionChoose() {

        String userCDirection = gameControl.strInputValidation(new String[]{"N", "E", "S", "W"}, uPlayer.CharacterName + ", Which direction would you like to go? (N,E,S,W)");

    }

}
}
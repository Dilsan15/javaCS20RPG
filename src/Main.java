//Plan for EVERYTHING:
// We are doing an RPG where the user is run through a story, and is given options to ensure user-engagement through the "choose your adventure type"

// Randomness through a DiceRroll for the damage that the opponents do, along with whether you get to use your special or not?
// Each character has

class Main {

    static userPlayer uPlayer;

    public static void main(String[] args) {

        uPlayer = userIntro();
        storyIntro();
    }

    public static userPlayer userIntro() {

        String userName = gameControl.strInputValidation(new String[]{""}, "What is your name?");
        userName= userName.substring(0,1).toUpperCase()+userName.substring(1).toLowerCase();
        String userSpecial = gameControl.strInputValidation(new String[]{"attack", "health", "defense"}, "Player what is your special? (attack, health, defense)");

        System.out.println("Hello " + userName + " your special is " + userSpecial);

        return new userPlayer(userName, userSpecial);

    }

    public static void storyIntro() {
        uPlayer.playerInventoryStats();
        System.out.println("You wake up un a dark forrest, glimpse of sunlight shines through the draping canopies, there's a stick within reach ");
        System.out.println("Ahh, you leap backwards as a bright beam of light dashes into your eye. In the corner of a near tree, you notice a silver sword glistening in the sunlight.");
        System.out.println("Now it's your turn: CHOOSE YOUR DESTINY! ");
        System.out.println("The ancient wooden stick? OR The Newly-Polished Silver Sword?");

        String stickOrSword = gameControl.strInputValidation(new String[]{"Stick", "Sword"}, "Player " + uPlayer.CharacterName + ", what is your ultimate choice? (Stick, OR Sword)");
         if (stickOrSword.equals("stick")){
             System.out.println("You feel the power of the ancient wooden stick in your hard, feeling its power surge" +
                     "thourgh your hands");
             uPlayer.playerInventoryAdd("Stick", 50);
         } else {
            System.out.println ("You gain 200 attack!");
            System.out.println ("... But you accidentally cut yourself -- losing 150 health!");

            uPlayer.playerInventoryAdd("Attack Sword", 200);
            uPlayer.damageTaken(150);
            uPlayer.playerInventoryStats();
        }


    }


}
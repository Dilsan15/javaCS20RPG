//Plan for EVERYTHING:
// We are doing an RPG where the user is run through a story, and is given options to ensure user-engagement through the "choose your adventure type"

// Randomness through a DiceRroll for the damage that the opponents do, along with whether you get to use your special or not?
// Each characte

class Main {

    static userPlayer uPlayer;

    public static void main(String[] args) {

        uPlayer = userIntro();
        storyIntro();
    }

    public static userPlayer userIntro() {

        String rawUserName = gameControl.strInputValidation(new String[]{""}, "What is your name?");
        String userName = rawUserName.substring(0, 1).toUpperCase() + rawUserName.substring(1).toLowerCase();
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

    public static String storyIntroPart2() {
        String direction1 = direction();
        switch (direction1) {
            case "N" -> {
                System.out.println("This direction is blocked by a massive boulder -- you cannot go there.");
                direction();
            }
            case "E" -> {
                System.out.println("This direction is blocked by a massive tree -- you cannot go there.");
                direction();
            }
            case "S" -> {
                System.out.println("Testing your luck, you walk into a slime-infested dark valley!");
                System.out.println("Blob! Blob! A mini slime approaches -- will he attack you or not?");
                String friendOrKill = gameControl.strInputValidation(new String[]{"Befriend", "Attack"}, uPlayer.CharacterName + ", Would you like to befriend or attack the slime? (Befriend,Attack)");
                if (friendOrKill.equals("befriend")) {
                    System.out.println("He ignores your invitation, smirks and leaves!");
                } else {
                    System.out.println("Starting the ambush, you throw out your D&D dice -- rolling a " + );
                    //   bruh how i join from the hub again gl figuring out. Bye <3
                    //Ima say if you roll higher than 8 -- you get to do your regular attack stat to the slime + you get to
                    // use your special for this round (so if special is attack -- add damage bonus, if special is health given
                    // them extra health for this round, defense same thing but for defense)
                }
            }
            default -> {
                System.out.println("No land lays ahead -- this was the one direction you couldn't choose.");
                direction();
            }
        }
        return direction1;
    }
        // gameControl.randomNum()
        private static String direction() {
        String direction1 = gameControl.strInputValidation(new String[]{"N", "E", "S", "W"}, uPlayer.CharacterName + ", Which direction would you like to go? (N,E,S,W)");
        return direction1;
    }
}
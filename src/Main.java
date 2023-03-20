//Plan for EVERYTHING:
// We are doing an RPG where the user is run through a story, and is given options to ensure user-engagement through the "choose your adventure type"

// Randomness through a DiceRroll for the damage that the opponents do, along with whether you get to use your special or not?
// Each characte

import java.io.FileNotFoundException;
import java.util.Objects;

class Main {

    private static UserPlayer uPlayer;

    public static void main(String[] args) {
        uPlayer = userIntro();



        while (true) {

            String directionChosen = directionChoose();

            if (directionChosen.equals("N")) {
                if (northStory()) {
                    break;
                }
            } else if (directionChosen.equals("E")) {
                eastStory();
            } else if (directionChosen.equals("S")) {
                southStory();
            } else if (directionChosen.equals("W")) {
                westStory();
            }

        }


    }

    public static UserPlayer userIntro() {

        String rawUserName = GameControl.strInputValidation(new String[]{""}, "What is your name: ");
        String userName = rawUserName.substring(0, 1).toUpperCase() + rawUserName.substring(1).toLowerCase();
        String userSpecial = GameControl.strInputValidation(new String[]{"attack", "health", "defense"}, "Player what is your special? (attack, health, defense): ");

        System.out.println("Hello " + userName + " your special is " + userSpecial);
        return new UserPlayer(userName, userSpecial);

    }

    public static void storyIntro() throws FileNotFoundException {
        uPlayer.playerInventoryStats();

        System.out.println("You wake up un a dark forrest, glimpse of sunlight shines through the draping canopies, there's a stick within reach ");
        System.out.println("Ahh, you leap backwards as a bright beam of light dashes into your eye. In the corner of a near tree, you notice a silver sword glistening in the sunlight.");
        System.out.println("Now it's your turn: CHOOSE YOUR DESTINY! ");
        System.out.println("The ancient wooden stick? OR The Newly-Polished Silver Sword: ");

        String stickOrSword = GameControl.strInputValidation(new String[]{"Stick", "Sword"}, "Player " + uPlayer.characterName + ", what is your ultimate choice? (Stick, OR Sword): ");

        if (stickOrSword.equals("Stick")) {
            System.out.println("You feel the power of the ancient wooden stick, feeling its power surge through your hands!");
            uPlayer.playerInventoryAdd("Stick", new int[]{10, 50});
            System.out.println("Becoming one with this strength, you decide to continue searching for more.");
        } else {
            System.out.println("You gain 200 attack!");
            System.out.println("... But you accidentally cut yourself -- losing 150 health!");

            uPlayer.playerInventoryAdd("Attack Sword", 200);
            uPlayer.damageTaken(150);
            uPlayer.checkLiving();
            uPlayer.playerInventoryStats();
        }


    }

    public static boolean northStory() {
        if (uPlayer.getPlayerExp() >= 3) {
            System.out.println(":) you fall of the edge of a giant cliff, get better luck!");
            System.out.println("Looks like no amount of experience can cure stupidly. You have died.");
            uPlayer.damageTaken(1000);
            uPlayer.checkLiving();

        } else {
            System.out.println("You walk North, and notice a huge cliff. In fright you back off");
        }
        return false;
    }

    public static void eastStory() {
        uPlayer.setPlayerExp();
        System.out.println("Welcome to the Aqua Realm. Gazing around you notice a school of mermaids, leaving a yellowish "
                + "trail. Leading your hand into the yellowish stream, the water surges into your veins -- offering you 1XP!");
        System.out.println("Realizing you don't know how to swim, you flail your arms in the empty space.");
        System.out.println("Losing 15 health gradually, a seashell swiftly lays your body on it's surface, and glides you to safety.");
        System.out.println("Grabbing this shell as a shield -- You gain 2% more Defense!");
        uPlayer.damageTaken(15);
        uPlayer.checkLiving();

        uPlayer.playerInventoryAdd("Rigid Seashell Shield", new int[]{2, 1});
        uPlayer.playerInventoryStats();
        System.out.println("You place the chestplate on your body, feeling strong as ever");

    }

    public static void westStory() {
        uPlayer.setPlayerExp();
        System.out.println("As you head West the terrain flattens, drier. The smothering hot sun slowly drying your skin out.");
        System.out.println("Your sweat and panting attracted some movement, a swarm of snakes rise out of the sand.");


        UserEnemy[] snakeList = new UserEnemy[]{new UserEnemy("Dhvanny The Snake", new int[]{0, 100, 0, 100, 0, 29}),
                new UserEnemy("Damien The Snake", new int[]{0, 100, 0, 100, 0, 29}),
                new UserEnemy("Dilshaan The Snake", new int[]{0, 100, 0, 100, 0, 29}),
        };

        for (UserEnemy enemy : snakeList) {

            String weaponOfChoice = GameControl.strInputValidation(uPlayer.viewPlayerInventory().keySet().toArray(new String[0]),
                    uPlayer.characterName + " which weapon would you like to choose for the next snake: ");

            System.out.println(enemy.characterName + " lunges at you");
            enemy.attackChar(uPlayer, 0);
            uPlayer.checkLiving();

            System.out.println(weaponOfChoice);

            uPlayer.attackChar(enemy, uPlayer.viewPlayerInventory().get(weaponOfChoice)[0]);
            System.out.println(uPlayer.characterName + " kills " + enemy.characterName + " with " + weaponOfChoice);


        }

        System.out.println("Power surges through your body, and your confidence grows, examining the dead snakes");
    }

    public static void southStory() {

        if (uPlayer.getPlayerExp() >= 2) {
            uPlayer.setPlayerExp();
            System.out.println("You've gained 1 XP! Welcome to the biome of the rocky giants!" +
                    "Here you'll meet the beautiful ranges of the Mount Alps, and all the mythical creatures they enclose.");

            System.out.println("AVALANCHE! RUN,RUN,RUN!");
            System.out.println("You sprint away from the mountain, dodging around the trees swiftly, adrenaline rushing" +
                    "With your life on the line, you run into a  deep dark cave, nearly getting swept under the snow of the" +
                    "avalanche.");

            System.out.println("You step forward, to see a giant sleeping bear right in front of you.");

            UserEnemy buffBear = new UserEnemy("Buff Bear", new int[]{0, 420, 0, 125, 0, 21});


            String bearScene = GameControl.strInputValidation(new String[]{"attack", "run", "feed"}, "Player " + uPlayer.characterName + " what would you like to do? (attack, run or feed)");

            switch (bearScene) {
                case "Attack":


                    while (!buffBear.enemyCheckLiving()) {

                        String weaponOfChoice = GameControl.strInputValidation(uPlayer.viewPlayerInventory().keySet().toArray(new String[0]), uPlayer.characterName + " Which weapon would you like to choose. ");
                        System.out.println(weaponOfChoice);

                        uPlayer.attackChar(buffBear, uPlayer.viewPlayerInventory().get(weaponOfChoice)[0]);
                        uPlayer.playerInventoryStats();


                        buffBear.attackChar(uPlayer, 0);
                        System.out.println("The bear towering over you, and slashes its giant claw, dealing immense damage");

                    }

                    break;
                case "Run":
                    System.out.println("You try running away, planning to dig out the tunnel as fast as possible," +
                            "but the bear notices and hits you in the back of the head with its claw. You fall to your knees" +
                            "and watch in horror as the bear starts ripping your limbs off of your body with its teeth");
                    uPlayer.damageTaken(1000);

                    break;
                case "Feed":
                    System.out.println("You frantically take out a small piece of leftover candy in your pocket, sliding" +
                            "the food over to the animal. Good decision of waking it up and" +
                            "feeding it, its currently in the process of pulling your leg of and eating it");
                    uPlayer.damageTaken(1000);
                    break;
            }

            System.out.println("You defeat the bear, and start digging your way out of the cave, glancing back occasionaly" +
                    "for any challengers");

        } else {
            System.out.println("You head a loud growling sound, frightened, you stumble back an instinctively run");
        }


    }

    private static String directionChoose() {
        String userCDirection = GameControl.strInputValidation(new String[]{"N", "E", "S", "W"}, uPlayer.characterName +
                ", Which direction would you like to go? (N,E,S,W): ");
        return userCDirection.toUpperCase();
    }

}

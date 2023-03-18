//Plan for EVERYTHING:
// We are doing an RPG where the user is run through a story, and is given options to ensure user-engagement through the "choose your adventure type"

// Randomness through a DiceRroll for the damage that the opponents do, along with whether you get to use your special or not?
// Each characte

import java.io.FileNotFoundException;
import java.util.Objects;

class Main {

    static UserPlayer uPlayer;

    public static void main(String[] args) {
        uPlayer = userIntro();


        label:
        while (true) {

            String directionChosen = directionChoose();

            switch (directionChosen) {
                case "N":
                    if (northStory()) {
                        break label;
                    }
                    break;
                case "E":
                    eastStory();
                    break;
                case "S":
                    southStory();
                    break;
                case "W":
                    westStory();
                    break;
            }

        }


    }

    public static UserPlayer userIntro() {

        String rawUserName = GameControl.strInputValidation(new String[]{""}, "What is your name?");
        String userName = rawUserName.substring(0, 1).toUpperCase() + rawUserName.substring(1).toLowerCase();
        String userSpecial = GameControl.strInputValidation(new String[]{"attack", "health", "defense"}, "Player what is your special? (attack, health, defense)");

        System.out.println("Hello " + userName + " your special is " + userSpecial);

        return new UserPlayer(userName, userSpecial);

    }

    public static void storyIntro() throws FileNotFoundException {
        uPlayer.playerInventoryStats();
        System.out.println("You wake up un a dark forrest, glimpse of sunlight shines through the draping canopies, there's a stick within reach ");
        System.out.println("Ahh, you leap backwards as a bright beam of light dashes into your eye. In the corner of a near tree, you notice a silver sword glistening in the sunlight.");
        System.out.println("Now it's your turn: CHOOSE YOUR DESTINY! ");
        System.out.println("The ancient wooden stick? OR The Newly-Polished Silver Sword?");

        String stickOrSword = GameControl.strInputValidation(new String[]{"Stick", "Sword"}, "Player " + uPlayer.characterName + ", what is your ultimate choice? (Stick, OR Sword)");

        if (stickOrSword.equals("stick")) {
            System.out.println("You feel the power of the ancient wooden stick, feeling its power surge through your hands!");
            uPlayer.playerInventoryAdd("Stick", new int[]{10, 50});
            System.out.println("Becoming one with this strength, you decide to continue searching for more.");
        } else {
            System.out.println("You gain 200 attack!");
            System.out.println("... But you accidentally cut yourself -- losing 150 health!");

            uPlayer.playerInventoryAdd("Attack Sword", 200);
            uPlayer.damageTaken(150);
            uPlayer.playerInventoryStats();
        }


    }

    public static boolean northStory() {
        if (uPlayer.getPlayerExp() >= 2) {
            System.out.println("You walk North until the humid jungle slowly changes into a cold iceland, raindrops slowly freeze into snowfall.");
            System.out.println("You notice shadows in the corner of your eyes. What do you do?");
            System.out.println("You encounter a white creature. It flails a claws at you.");

            UserEnemy whiteMonster = new UserEnemy("White Monster", new int[]{0, 100, 0,100, 0,29});
            whiteMonster.attackChar(uPlayer);


            return true;
        } else
            System.out.println("You don't have enough XP to enter this realm. Visit other biomes and enter when you have " +
                    "gained wising experiences!");
        return false;
    }

    public static void eastStory() {
        uPlayer.setPlayerExp();
        System.out.println("Welcome to the Aqua Realm. Gazing around you notice a school of mermaids, leaving a yellowish "
                + "trail. Leading your hand into the yellowish stream, the water surges into your veins -- offering you 1XP!");
        System.out.println("Realizing you don't know how to swim, you flail your arms in the empty space.");
        System.out.println("Losing 15 health gradually, a seashell swiftly lays your body on it's surface, and glides you to safety.");
        System.out.println("Grabbing this shell as a shield -- You gain 35 Defense!");
        uPlayer.damageTaken(15);

        uPlayer.playerInventoryStats();

        uPlayer.playerInventoryAdd("Rigid Seashell Shield", new int[]{35, 1});

    }

    public static void westStory() {
        uPlayer.setPlayerExp();
        System.out.println("As you head West the terrain flattens, drier. The smothering hot sun slowly drying your skin out.");
        System.out.println("Your sweat and panting attractted some movement, a swarm of snakes rise out of the sand.");


        UserEnemy[] snakeList = new UserEnemy[]{new UserEnemy("sandSnake1", new int[]{0, 100, 0,100, 0,29}),
                new UserEnemy("sandSnake2", new int[]{0, 100, 0,100, 0,29}),
                new UserEnemy("sandSnake3", new int[]{0, 100, 0,100, 0,29}), new UserEnemy("sandSnake4", new int[]{0, 100, 0,100, 0,29}),
                new UserEnemy("sandSnake5", new int[]{0, 100, 0,100, 0,29})};

        for (UserEnemy enemy: snakeList) {
            System.out.println(enemy);
            enemy.attackChar(uPlayer);
        }

        UserEnemy whiteMonster  = new UserEnemy("White Monster", new int[]{0, 100, 0,100, 0,29});



    }

    public static void southStory() {
        if (uPlayer.getPlayerExp() >= 3) {
            uPlayer.setPlayerExp();
            System.out.println("You've gained 1 XP! Welcome to the biome of the rocky giants!" +
                    "Here you'll meet the beautiful ranges of the Mount Alps, and all the mythical creatures they enclose.");
            System.out.println("AVALANCHE! RUN,RUN,RUN!");
            System.out.println("You sprint away from the mountain, dodging around the trees swiftly, adrenaline rushing" +
                    "With your life on the line, you run into a  deep dark cave, nearly getting swept under the snow of the" +
                    "avalanche.");

            System.out.println("You step forward, to see a giant sleeping bear right in front of you.");

            String bearScene = GameControl.strInputValidation(new String[]{"attack", "run", "feed"}, "Player" + uPlayer.characterName +  "what would you like to do? (attack, run or feed)");
            UserEnemy buffBear = new UserEnemy("Buff Bear",new int[]{0, 420, 0,125, 0,21});

            if (bearScene.equals("attack")){

                while (buffBear.enemyCheckLiving()){

                    uPlayer.attackChar(buffBear);
                    System.out.println("You hit the bear for ");
                }

             } else if (bearScene.equals("run")){

             } else if (bearScene.equals ("feed")){

             }


        } else {
            System.out.println("You head a loud growling sound, frightened, you stumble back an instinctively run");
        }
    }

    private static String directionChoose() {
        String userCDirection = GameControl.strInputValidation(new String[]{"N", "E", "S", "W"}, uPlayer.characterName +
                ", Which direction would you like to go? (N,E,S,W)");
        return userCDirection.toUpperCase();
    }

}

import java.util.Objects;
import java.util.Random;

public class userPlayer extends gameControl{


    String playerName;

    String playerSpecial;

    int playerHealth;
    int playerAttack;
    int playerDefense;

    public userPlayer(String playerName, String playerSpecial) {

        this.playerName = playerName;

        this.playerHealth = randomNum(100,300);
        this.playerAttack = randomNum(100,500);
        this.playerDefense = randomNum(1,20);

        if (Objects.equals(playerSpecial, "attack")) {
            this.playerAttack += 150;
        } else if (Objects.equals(playerSpecial, "health")) {
            this.playerHealth += 150;
        } else if (Objects.equals(playerSpecial, "defense")) {
            this.playerDefense += 10;
        }

    }

}

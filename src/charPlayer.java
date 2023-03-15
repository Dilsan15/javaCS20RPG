import java.io.FileNotFoundException;

public class charPlayer extends gameControl {

    String CharacterName;
    String CharacterSpecial;
    int CharacterHealth;
    int CharacterAttack;
    int CharacterDefense;

    public charPlayer(String CharacterName, int[] ranges) {

        this.CharacterName = CharacterName;
        this.CharacterHealth = randomNum(ranges[0], ranges[1]);
        this.CharacterAttack = randomNum(ranges[2], ranges[3]);
        this.CharacterDefense = randomNum(ranges[4], ranges[5]);

    }

    public String[] getCharacterStats() {
        return new String[]{this.CharacterName, String.valueOf(this.CharacterHealth), String.valueOf(this.CharacterAttack), String.valueOf(this.CharacterDefense)};
    }

    public void damageTaken(int damage) throws FileNotFoundException {
        this.CharacterHealth -= damage * (1 - +(this.CharacterDefense / 100));
        checkLiving();
    }

    public void checkLiving() throws FileNotFoundException {
        if (this.CharacterHealth <= 0) {
            System.out.println("💀 Death has landed upon you. We are sending you back -- make wiser choices!");
            Main.main(null);
        }


    }


}

























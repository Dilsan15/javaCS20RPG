
import java.util.Random;


public class gameControl {

    static Random rand = new Random();

    public static boolean inputValidation(String[] userInputOp, String userInput, String typeVal) {

        if (typeVal == "int") {
            try {
                Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        if (typeVal == "str") {
            for (String posInput : userInputOp) {
                if (posInput.toLowerCase().strip().equals(userInput)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int randomNum(int min, int max) {
        return rand.nextInt(max - min) + min;
    }


}

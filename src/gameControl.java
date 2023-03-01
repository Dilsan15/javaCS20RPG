import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Random;


public class gameControl {

    static Random rand = new Random();

    public static boolean inputValidation(String[] userInputOp, String userInput) {

        for (String posInput : userInputOp) {
            if (posInput.toLowerCase().strip().equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    public static int randomNum(int min, int max) {
        return rand.nextInt(max - min) + min;
    }


}

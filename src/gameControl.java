import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;


public class gameControl {

    final static Scanner scanInput = new Scanner(System.in);
    static Random rand = new Random();

    public static String strInputValidation(String[] userInputOp, String inputPrompt) {
        System.out.println(inputPrompt);
        String userInput = scanInput.nextLine().strip().toLowerCase();

        for (String posInput : userInputOp) {
            if (posInput.toLowerCase().strip().equals(userInput.toLowerCase().strip()) || (userInputOp[0].equals(""))) {
                return userInput;
            }
        }

        System.out.println("Please enter valid input, the choices are: " + String.join(", ", userInputOp));
        return gameControl.strInputValidation(userInputOp, inputPrompt);
    }

    public static int intInputValidation(int[] userInputOp, String inputPrompt) {

        System.out.println(inputPrompt);
        int userInput;

        try {
            userInput = scanInput.nextInt();
            for (int posInput : userInputOp) {
                if (posInput == userInput) {
                    scanInput.nextLine();
                    return userInput;
                }
            }
        } catch (InputMismatchException e) {
            scanInput.nextLine();
        }

        System.out.println("Please enter a number, from the range of, " + userInputOp[0] + "-" + userInputOp[userInputOp.length - 1] + ":");
        return gameControl.intInputValidation(userInputOp, inputPrompt);

    }

    public static int randomNum(int min, int max) {
        return rand.nextInt(max - min) + min;
    }




}

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        playGameGuessNumber();
        playGameGuessWord();
    }

    private static void playGameGuessNumber(){
        Random random = new Random();
        System.out.println("Let's play game Guess Number from 0 to 9. You have 3 trying");
        do {
            int number = random.nextInt(10);
            for (int i = 0; i < 3; i++){
                int guessedNumber = getInputInt("Try to guess...");
                if (guessedNumber == number){
                    System.out.println("It's right answer. You won!");
                    break;
                }
                else if( i == 2){
                    System.out.println("Defeat");
                }
                else if (guessedNumber < number){
                    System.out.println("Guessed number is bigger");
                }
                else{
                    System.out.println("Guessed number is smaller");
                }
            }
        }while (getInputYesNo("Do you want to play again? (Y/N)"));
    }

    private static int getInputInt(String message){
        System.out.println(message);
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        do {
            try {
                res = scanner.nextInt();
                success = true;
            }
            catch (InputMismatchException ignored){
                System.out.println("Write right number");
            }
        }while (!success);
        return res;
    }

    private static boolean getInputYesNo(String message){
        System.out.println(message);
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        String res = "N";
        do {
            try {
                res = scanner.next();
                if (res.equals("Y") || res.equals("N")) {
                    success = true;
                }
            }
            catch (InputMismatchException ignored){
                System.out.println("Write Y or N");
            }
        }while (!success);
        return res.equals("Y");
    }

    private static void playGameGuessWord(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play game Guess Word. We choice one of this words:");
        String[] options = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println(Arrays.toString(options));
        int wordIndex = random.nextInt(options.length);
        String word = options[wordIndex];
        do {
            System.out.println("Write word");
            String guessedWord = scanner.next().toLowerCase();
            if (word.equals(guessedWord)){
                System.out.println("It's right answer. You won!");
                break;
            }
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < 15; i++){
                if (i < word.length() && i < guessedWord.length() && word.charAt(i) == guessedWord.charAt(i)){
                    res.append(word.charAt(i));
                }
                else{
                    res.append('#');
                }
            }
            System.out.println("Words convergence:");
            System.out.println(res.toString());
        }while (true);
    }
}

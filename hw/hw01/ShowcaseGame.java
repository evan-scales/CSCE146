/**
 * written by Evan Scales
 */
import java.util.Scanner;
public class ShowcaseGame {
    private static Showcase showCase = new Showcase();
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        boolean playAgain = true;

        while(playAgain){
            printGreetings();
            Prize[] randomPrizes = showCase.getFivePrizes();
            double sum = 0;

            for(int i=0;i<randomPrizes.length;i++){
                System.out.println(randomPrizes[i].getName());
                sum = sum + randomPrizes[i].getPrizePrice();
            }
            guessPrompt();

            double guessValue = keyboard.nextDouble();
            keyboard.nextLine();
            System.out.println("You guessed " + guessValue + " the actual price is "+ sum);

            //see if player wins or not
            if((guessValue < sum) && (sum - guessValue) <= 2000)
                System.out.println("Your guess was under! You win! ");
            else if(guessValue > sum)
                System.out.println("I'm sorry but that was over... You get nothing");
            else if(guessValue == sum)
                System.out.println("You guessed correctly! You win!");
            else 
                System.out.println("I'm sorry but that guess was bad.  You lose for being bad.");

            //see if player would like to play again
            System.out.println("Would you like to play again? Enter 'no' to quit");
            if(keyboard.nextLine().equalsIgnoreCase("no")){
                System.out.println("Goodbye");
                playAgain = false;
            }
        }
    }

    public static void printGreetings(){
        System.out.println("Welcome to the showcase show down!");
        System.out.println("Your prizes are:");
    }
    public static void guessPrompt(){
        System.out.println("You must guess the total cost of all without going over!");
        System.out.println("Enter your guess:");
    }
}
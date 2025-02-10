import java.util.Scanner;
import java.util.Random;
public class NumberGame{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random ra=new Random();
        int totalScore=0;
        System.out.println("Welcome to the number game!");
        boolean playAgain=true;
        while(playAgain){
            int numGuess=ra.nextInt(100)+1;
            int attemptsLeft=5;
            boolean guessedCorrectly=false;
            System.out.println("\n I have selected a number between 1 to 100.Try to guess it!");
            while (attemptsLeft>0){
                System.out.println("Enter your guess:");
                int userGuess=sc.nextInt();
                if (userGuess==numGuess){
                    System.out.println("Congratulations! You guessed the correct number:");
                    guessedCorrectly=true;
                    totalScore+=attemptsLeft;
                    break;
                }
                else if(userGuess>numGuess){
                    System.out.println("Too high!Try again");
                }
                else{
                    System.out.println("Too low!Try again");
                }
                attemptsLeft--;
                System.out.println("Attempts left:"+attemptsLeft);
            }
            if(!guessedCorrectly){
                System.out.println("Sorry,you're out of attempts the correct number was:"+numGuess);
            }
            System.out.println("Your total score:"+totalScore);
            System.out.println("\n Do you want to play another round?(yes/no):");
            String response=sc.next();
            playAgain=response.equalsIgnoreCase("yes");
        }
        System.out.println("Thank you for playing! Your final score:"+totalScore);
        sc.close();
    }
}
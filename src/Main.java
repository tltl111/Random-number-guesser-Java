import java.util.Scanner;
import java.util.Random;


class RandomNumberGuesser{
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        String game = "running";

        while(game.equals("running"))
        {
            Random rand = new Random();
            int randNum = rand.nextInt(10);
            int guess = -1;
            int attempts = 0;

            while(guess != randNum)
            {
                System.out.print("Guess a number between 1 and 1000: ");
                guess = reader.nextInt();
                attempts++;

                if(guess == randNum)
                {
                    System.out.println("Congraulations! You Win!");
                    System.out.println("It took you " + attempts + " attempts to win the game.");
                    System.out.print("Would you like to play again? Yes or No: ");
                    game = reader.next().toLowerCase();
                }
                else if(guess > randNum)
                {
                    System.out.println("You guessed to high, try again.");
                }
                else
                {
                    System.out.println("You guessed to low, try again.");
                }
            }
        }
        reader.close();
    }
}

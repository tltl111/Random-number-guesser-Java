import java.util.Scanner;
import java.util.Random;


class RandomNumberGuesser{
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        String game = "running";

        while(game.equals("running"))
        {
            int lowest_number = 1;
            int highest_number = 1000;
            Random rand = new Random();
            int randNum = rand.nextInt(1000);
            int guess = -1;
            int attempts = 0;
            int max_attempts = 10;

            while(guess != randNum && attempts != max_attempts)
            {
                int attempts_left = max_attempts - attempts;
                System.out.println("\nYou have " + attempts_left + " attempts left.");
                System.out.print("Guess a number between " + lowest_number + " and " + highest_number + " : ");
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
                    highest_number = guess;
                }
                else
                {
                    System.out.println("You guessed to low, try again.");
                    lowest_number = guess;
                }
            }
        }
        reader.close();
    }
}

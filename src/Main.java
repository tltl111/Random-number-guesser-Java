import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;


class RandomNumberGuesser {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String game = "yes";

        while(game.equals("yes") || game.equals("y")) {
            int lowest_number = 1;
            int highest_number = 1000;
            Random rand = new Random();
            int randNum = rand.nextInt(highest_number - lowest_number + 1) + lowest_number;
            int guess = -1;
            int attempts = 0;
            int max_attempts = 10;

            while(guess != randNum && attempts != max_attempts) {
                int attempts_left = max_attempts - attempts;
                System.out.println("You have " + attempts_left + " attempts left.");
                System.out.print("Guess a number between " + lowest_number + " and " + highest_number + " : ");

                try {
                    guess = input.nextInt();
                    input.nextLine();
                }
                catch (InputMismatchException e) {
                    System.out.println("You can only input a number.");
                    input.nextLine();
                    continue;
                }

                if(guess < lowest_number || guess > highest_number) {
                    System.out.println("\nYou can only guess between " + lowest_number + " and " + highest_number + ".");
                    continue;
                }
                else {
                    attempts++;

                    if(guess == randNum) {
                        System.out.println("\nCongratulations! You Win!");
                        System.out.println("It took you " + attempts + " attempts to win the game.");
                        System.out.print("\nWould you like to play again? Yes or No: ");
                        game = input.next().toLowerCase();
                    }
                    else if(guess > randNum) {
                        System.out.print("\nYou guessed to high.");
                        if(attempts < max_attempts) {
                            System.out.println(" Try again.");
                            highest_number = guess;
                        }
                        else {
                            System.out.println("\nYou lost!");
                            System.out.println("The correct number was " + randNum);
                            System.out.print("\nWould you like to play again? Yes or No: ");
                            game = input.next().toLowerCase();
                        }
                    }
                    else {
                        System.out.print("\nYou guessed to low. ");
                        if(attempts < max_attempts) {
                            System.out.println(" Try again.");
                            lowest_number = guess;
                        }
                        else {
                            System.out.println("\nYou lost!");
                            System.out.println("The correct number was " + randNum);
                            System.out.print("\nWould you like to play again? Yes or No: ");
                            game = input.next().toLowerCase();
                        }
                    }
                }
            }
        }

        input.close();

    }
}

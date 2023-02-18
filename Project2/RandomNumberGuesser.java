/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Generate a random integer between 0 and 100 and ask the user to guess until they guess correctly or exceed 7 guesses. 
 * Due: 02/24/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */
import java.util.Scanner;

/**
 * The RandomNumberGuesser class generates a random integer between 0 and 100 and ask the user to guess until they guess correctly or exceed 7 guesses. 
 * @author Alim Saidkhodjaev
 *
 */
public class RandomNumberGuesser {

	/**
	 * The main method is responsible for printing the application header, running the game through the runGame method until the user no longer wants to try again, and printing the ending message
	 */
    public static void main(String[] args) {
       
    	Scanner input = new Scanner(System.in);
    	
    	String playAgain = ""; //Initialize playAgain string as empty so while loop runs initially
    	
    	System.out.println("This application generates a random integer between 0 and 100 and asks the user to guess repeatedly until they guess correctly."); //Print application header
    	
    	while (!playAgain.equalsIgnoreCase("no")) {
    		
    		runGame(); //call runGame method to start game
    		
    		if (RNG.getCount() == 7) { //terminate program if guess count is 7
                System.out.println("You have reached the maximum number of guesses, 7.");
                break;
            }
    		System.out.println("Try Again? (yes or no) "); //After game ends ask user if they would like to play again
    		playAgain = input.next();
    		//Input validation to make sure user enters yes or no
    		while (!playAgain.equalsIgnoreCase("no") && !playAgain.equalsIgnoreCase("yes")) {
    			System.out.println("Invalid input, please enter yes or no ");
        		playAgain = input.next();
    		}
        
    	}

    	//ending message
        System.out.println("Thanks for playing!");
        System.out.println("");
        System.out.println("Programmer: Alim Saidkhodjaev");
        
        input.close(); // close scanner
    }
    
    /**
     * The runGame game is responsible for running the number guessing game
     */
    public static void runGame() {
    	Scanner input = new Scanner(System.in);
        int lowGuess = 0; //Low guess starts at 0
        int highGuess = 100; //High guess starts at 100
        int secretNumber = RNG.rand(); //Generated random number
        int guess;
        
        RNG.resetCount();

        do {
            
        	if (RNG.getCount() == 0) {
        		System.out.print("Enter your first guess: ");
                guess = input.nextInt();
        	}
        	else {
        		System.out.print("Enter your guess between " + lowGuess + " and " + highGuess + ": ");
        		guess = input.nextInt();
        	}

            if (RNG.inputValidation(guess, lowGuess, highGuess)) {
                if (guess == secretNumber) {
                    System.out.println("Congratulations, you guessed correctly");
                    return;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low.");
                    lowGuess = guess;
                } else {
                    System.out.println("Your guess is too high.");
                    highGuess = guess;
                }
            }
              
            System.out.println("Number of guesses is: " + RNG.getCount());
            
        } while (RNG.getCount() < 7);
        
        input.close(); // close scanner
    }
}

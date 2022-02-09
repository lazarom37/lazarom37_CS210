// CS210 Assignment #5 "GuessingGame"
// Marcus Lazaro
// This project is a Guessing Game program in java
// Records Total Games, Guesses altogther, Avg. # of
// guesses made per game, and the best overall game when
// the program ends.
import java.util.*;

public class GuessingGame {
    // Resets final score every time the program runs
    public static int guessTotal = 0; // Total # of guesses made altogether
    public static int games = 0; // Total games played
    public static int bestGame = 0; // Game with the least # of attempts
    public static String avgGuess = "x"; // Average # of guesses per game
    public static int currentGame = 0; // Current game number
    public static int bestGameGuess = 0; // # of guesses made during best game

    public static void main(String[] args) {
        String a = "Happy Valentine's Day!";
        String b = "Winter Break";
        String c = "Go Ski!";
        String d = "Twinkle TWINKLE";
        System.out.println(a.length());
        System.out.println(a.charAt(10));
        System.out.println(a.indexOf("Day"));
        System.out.println(a.toLowerCase());
        b = b.Substring(4, 11);
        char b1 = b.charAt(3);
        System.out.println(CHaracter.isLowerCase(b1));
        c = c.toUpperCase();
        System.out.println(c);
        c = substring(3);
        System.out.println(c);
        System.out.println(c.length());
        System.out.println(d.charAt(d.indexOf("k")-2));
        System.out.println(d.charAt(d.indexOf("W")+2));
    }

    public static void newGame() {
        // Restarts all temporary values
        int attempts = 0;
        String highLow = "na";
        Random random = new Random();
        int botGuess = random.nextInt(99) + 1; // Winning number per new game
        // Updates final score
        currentGame++;
        guessTotal = guessTotal + attempts;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("I just picked a number between 1-100");
        System.out.println("What do you think that number is? Enter ##: ");

        Scanner guessPrompt = new Scanner(System.in);
        int playerGuess = guessPrompt.nextInt(); // Turns scanner input into an integer

        while (playerGuess != botGuess) {
            attempts++;
            if (playerGuess < botGuess) {
                highLow = "higher";
            } else {
                highLow = "lower";
            }
            System.out.println("This is attempt # " + attempts);
            System.out.print("My guess is " + highLow + " than that. Try another!  ");
            guessPrompt = new Scanner(System.in);
            playerGuess = guessPrompt.nextInt();
        }
        if (playerGuess == botGuess) {
            attempts++;
            // Changes made to cumulative score when game is won
            guessTotal = guessTotal + attempts;
            currentGame++;
            if (bestGame == 0) {
                bestGame++;
            }
            if (attempts < bestGameGuess) {
                bestGame = currentGame;
                bestGameGuess = attempts;
            }
        }
            int avgGuessWhole = 0;
            int avgGuessRem = 0;
            avgGuessWhole = guessTotal / currentGame;
            avgGuessRem = guessTotal % currentGame;
            avgGuess = avgGuessWhole + "." + avgGuessRem;
            // Congratulates players and asks if they wanna play again
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Congratulations! You guessed the right number of " + botGuess + "!");
            System.out.println("This game took you a total of " + (attempts) + " attempts");
            System.out.print("Will you play again? Enter Y/N");
            Scanner confirmPrompt = new Scanner(System.in);
            String playerConfirm = confirmPrompt.next(); // Turns scanner input into a String
            if (playerConfirm.equalsIgnoreCase("y") || playerConfirm.equalsIgnoreCase("e") || playerConfirm.equalsIgnoreCase("s")) {
                newGame();
            } else {
                endGame();
            }
        }
    public static void endGame() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Your score for this session");
        System.out.println("Total games played: " + currentGame);
        System.out.println("Total guesses made: " + guessTotal);
        System.out.println("Avg. # of guesses made per game: " + avgGuess);
        System.out.println("Game #" + bestGame + " was your best with a total of " + bestGameGuess + " guesses this game.");
    }
}
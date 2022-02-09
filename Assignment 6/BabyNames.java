// CS210 Assignment #6 "baby names"
// Marcus Lazaro
// This is a project that involves using the Scanner to read off tokens
// in a .txt file. In this project's context, the program will read the
// a user's input for a baby name. If it's a legitimate name, the program
// will output said name and it's popularity in a given year's interval of 10
// starting with 1920 to 2000. If not, it will return an error and quit.
import java.util.*;
import java.io.*;

public class BabyNames {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner names = new Scanner(new File("names.txt")); // reads file of names

        System.out.println("** Popularity of a baby name since year 1920 **");
        System.out.print("name? ");

        Scanner userInput = new Scanner(System.in); // reads user input
        String searchedName = userInput.next(); // saves user input as searchedName

        boolean doneSearching = false;
        while (doneSearching == false) {
            if (names.hasNext()) { // Checks if there is another name after the first token
                String currentTokenName = names.next();     //Assigns the next name to be scanned

                if (currentTokenName.equalsIgnoreCase(searchedName)){       //Passes if there is a match of inputted and scanned name

                    String outFileName = currentTokenName + ".txt";         //Creates new individual file with the matched name
                    PrintStream outFile = new PrintStream(new File(outFileName));
                    outFile.println(currentTokenName + ",");

                    for (int year = 1920; year < 2010; year += 10) { // for loop that outputs the year and ranking of baby name, added 2010 so that the program actually prints 2000's statistic
                        int rank = names.nextInt(); // rank = baby name's ranking of popularity from 1-1000, lower means more popular
                        System.out.println(year + " : " + rank);
                        outFile.println(year + " : " + rank + ",");
                    }
                    doneSearching = true; // Ends the loop and thus the program
                } // Confirms if the inputted name matches a name in names.txt
            } else {
                System.out.println("name not found :(");
                doneSearching = true;    // Ends the loop and thus the program
            }
        }
    }
}
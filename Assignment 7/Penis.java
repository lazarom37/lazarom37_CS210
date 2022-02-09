
import java.util.*;
import java.io.*;

public class Penis {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner answerReader = new Scanner(new File("personality.txt"));

        System.out.println("**  This program reports the results for Keirsey Personality Test  **");

        boolean theEnd = false;

        while (theEnd == false) {

            if (answerReader.hasNextLine()) {

                String name = answerReader.nextLine();
                System.out.println();

                System.out.println(name + ":");

                if (answerReader.hasNextLine()) {

                    String dummy = answerReader.nextLine();

                    String[] theTests = new String[10];

                    int[] results = new int[8];

                    for (int i = 0; i <= 9; i++) {

                        theTests[i] = dummy.substring(i * 7, (i * 7) + 7);

                        sets(theTests[i], results);

                    }

                    int[] percentages = new int[4];
                    int percentagesIndex = 0;

                    for (int i = 0; i < 8; i += 2) {

                        double numerator = results[i + 1];

                        double denominator = results[i] + results[i + 1];

                        int bVal = (int) Math.round((100 * numerator) / denominator);

                        percentages[percentagesIndex] = bVal;

                        percentagesIndex++;

                    }
                    System.out.print("answers: [");

                    for (int index = 0; index < 8; index += 2) {
                        System.out.print(results[index] + "A-");
                        System.out.print(results[index + 1] + "B");

                        if (index != 6) {
                            System.out.print(",");
                        }
                    }
                    System.out.println("]");

                    System.out.println("Percent: " + Arrays.toString(percentages));

                    char[] profile = new char[4];

                    for (int i = 0; i < 8; i += 2) {

                        if (i == 0) {

                            if (results[i] > results[i + 1]) {
                                profile[0] = 'E';

                            } else if (results[i] == results[i + 1]) {
                                profile[0] = 'X';

                            } else {
                                profile[0] = 'I';
                            }

                        } else if (i == 2) {

                            if (results[i] > results[i + 1]) {
                                profile[1] = 'S';

                            } else if (results[i] == results[i + 1]) {
                                profile[1] = 'X';

                            } else {
                                profile[1] = 'N';
                            }

                        } else if (i == 4) {

                            if (results[i] > results[i + 1]) {
                                profile[2] = 'T';

                            } else if (results[i] == results[i + 1]) {
                                profile[2] = 'X';

                            } else {
                                profile[2] = 'F';
                            }

                        } else {

                            if (results[i] > results[i + 1]) {
                                profile[3] = 'J';

                            } else if (results[i] == results[i + 1]) {
                                profile[3] = 'X';

                            } else {
                                profile[3] = 'P';
                            }
                        }
                    }
                    System.out.print("type: ");

                    for (int i = 0; i <= 3; i++) {
                        System.out.print(profile[i]);
                    }
                    System.out.println();
                }

            } else {

                theEnd = true;
            }
        }
    }

    public static void sets(String resultsString, int[] answerCount) {

        int locater = 0;

        while (locater < resultsString.length()) {

            char answer = resultsString.charAt(locater);

            if (locater == 0) {

                if (answer == 'B' || answer == 'b') {
                    answerCount[1]++;

                } else if (answer == 'A' || answer == 'a') {
                    answerCount[0]++;
                }

            } else if (locater == 1 || locater == 2) {

                if (answer == 'B' || answer == 'b') {
                    answerCount[3]++;

                } else if (answer == 'A' || answer == 'a') {
                    answerCount[2]++;
                }

            } else if (locater == 3 || locater == 4) {

                if (answer == 'B' || answer == 'b') {
                    answerCount[5]++;

                } else if (answer == 'A' || answer == 'a') {
                    answerCount[4]++;
                }

            } else {

                if (answer == 'B' || answer == 'b') {
                    answerCount[7]++;

                } else if (answer == 'A' || answer == 'a') {
                    answerCount[6]++;
                }

            }

            locater++;
        }
    }
}
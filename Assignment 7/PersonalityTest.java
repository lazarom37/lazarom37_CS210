
// CS210 Assignment #7 "Personality Test"
// Marcus Lazaro
import java.util.*;
import java.io.*;

public class PersonalityTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("personality.txt"));
        System.out.println("** This program reports the results for Keirsey Personality Test **");
        boolean endProgram = false;
        while (endProgram == false) {
            // Checks if there is a line to be read, person's name is expected every
            // odd-numbered line in personality.txt
            if (scan.hasNextLine()) {
                // Prints person's name
                String personName = scan.nextLine();
                System.out.println(personName + ":");
                // Checks for another line, person's test answers are expected every
                // even-numbered line in personality.txt
                if (scan.hasNextLine()) {
                    // Creates variables needed to make a single group. temp is for the answers
                    // string, personAnswers for groups, results for individual answers within group
                    String temp = scan.nextLine();
                    String[] personAnswers = new String[10];
                    int[] results = new int[8];
                    // This loop creates 10 groups of 7 for all 70 answers
                    for (int i = 0; i <= 9; i++) {
                        personAnswers[i] = temp.substring(i * 7, (i * 7) + 7);
                        groups(personAnswers[i], results);
                    }
                    // Finding percentage
                    int[] percentArray = new int[4]; // Sets up an array for each dimension's percent value
                    int percentIndex = 0;
                    for (int i = 0; i < 8; i += 2) {
                        double numerator = results[i + 1];
                        double denominator = results[i] + results[i + 1];
                        int bVal = (int) Math.round((100 * numerator) / denominator);
                        percentArray[percentIndex] = bVal;
                        percentIndex++;
                    }
                    // Prints out second line total # answers of A and B
                    System.out.print("answers: [");
                    for (int index = 0; index < 8; index += 2) {
                        System.out.print(results[index] + "A-");
                        System.out.print(results[index + 1] + "B");
                        // Adds comma for accurate formatting
                        if (index != 6) {
                            System.out.print(",");
                        }
                    }
                    // Ends of answers results, now printing third line showing percentages of
                    // answers that were B
                    System.out.println("]");
                    System.out.println("Percent B: " + Arrays.toString(percentArray));
                    // Now printing fourth line of type
                    char[] personality = new char[4]; // four-character array that represents the four letters of
                                                      // personality type
                    for (int i = 0; i < 8; i += 2) {
                        // Adds E or I for personality array, represents EXTROVERT/INTROVERT
                        if (i == 0) {
                            if (results[i] > results[i + 1]) {
                                personality[0] = 'E';
                            } else if (results[i] == results[i + 1]) {
                                personality[0] = 'X';
                            } else {
                                personality[0] = 'I';
                            }
                            // Adds S or N for personality array, represents SENSATION/INTUITION
                        } else if (i == 2) {
                            if (results[i] > results[i + 1]) {
                                personality[1] = 'S';
                            } else if (results[i] == results[i + 1]) {
                                personality[1] = 'X';
                            } else {
                                personality[1] = 'N';
                            }
                            // Adds T or F for personality array, represents THINKING/FEELING
                        } else if (i == 4) {
                            if (results[i] > results[i + 1]) {
                                personality[2] = 'T';
                            } else if (results[i] == results[i + 1]) {
                                personality[2] = 'X';
                            } else {
                                personality[2] = 'F';
                            }
                            // Adds T or F for personality array, represents JUDGING/PERCEIVING
                        } else {
                            if (results[i] > results[i + 1]) {
                                personality[3] = 'J';
                            } else if (results[i] == results[i + 1]) {
                                personality[3] = 'X';
                            } else {
                                personality[3] = 'P';
                            }
                        }
                    }
                    System.out.print("type: ");
                    for (int i = 0; i <= 3; i++) {
                        System.out.print(personality[i]);
                    }
                    System.out.println();
                }
            } else {
                endProgram = false;
            }

        }

    }

    // Method groups is used to properly identify each answer provided in a singular
    // group array holding 7 answers Per person, there are 10 groups of 7 totaling
    // to
    // 70 answers. This method should be used 10 times per person
    public static void groups(String resultsString, int[] answerCount) {
        int locater = 0;
        // Code below is active while locater is less than string length of 7 characters
        while (locater < resultsString.length()) {
            // Assigns person's single answer
            char answer = resultsString.charAt(locater);
            // Checks for EXTROVERT/INTROVERT answers
            if (locater == 0) {
                if (answer == 'B' || answer == 'b') {
                    answerCount[1]++;
                } else if (answer == 'A' || answer == 'a') {
                    answerCount[0]++;
                }
                // Checks for SENSATION/INTUITION answers
            } else if (locater == 1 || locater == 2) {
                if (answer == 'B' || answer == 'b') {
                    answerCount[3]++;
                } else if (answer == 'A' || answer == 'a') {
                    answerCount[2]++;
                }
                // Checks for THINKING/FEELING answers
            } else if (locater == 3 || locater == 4) {
                if (answer == 'B' || answer == 'b') {
                    answerCount[5]++;
                } else if (answer == 'A' || answer == 'a') {
                    answerCount[4]++;
                }
                // Checks for JUDGING/PERCEIVING answers
            } else {
                // add one to index 7 of the array if the answer is B
                if (answer == 'B' || answer == 'b') {
                    answerCount[7]++;
                    // add one to index 6 of the array if the answer is A
                } else if (answer == 'A' || answer == 'a') {
                    answerCount[6]++;
                }
            }
            locater++;
        }
    }
}
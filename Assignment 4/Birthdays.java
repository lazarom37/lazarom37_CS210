// CS210 Assignment #4 "Birthdays"
// Marcus Lazaro
// This program asks for the date and two birthdays. It gives unique dialogue when if the
// inputted date is their birthday as well as if they share the same birthdays. By default,
// it will print out how many days are left until each person's birthday
import java.util.*;
public class Birthdays {
    public static void main(String[] args) {
        //Gets today's date
        Scanner console = new Scanner(System.in);
        System.out.println("What is today's date (mm dd)?");
        int todayMonth = console.nextInt();
        int todayDay = console.nextInt();
        int numToday = countDays(todayMonth, todayDay);
        System.out.println("Today is " + todayMonth + "/" + todayDay + "/2021, which is day #" + numToday + " of the year.");

        //Gets birthdays
        int birthday1 = getBirthday("Please enter Person 1's birthday: ", numToday);
        int birthday2 = getBirthday("Please enter Person 2's birthday: ", numToday);

        //Compares birthdays
        if (birthday1 < birthday2){
            System.out.println("Persona 1's birthday is sooner than Person 2's");
        } else if (birthday1 > birthday2){
            System.out.println("Persona 2's birthday is sooner than Person 1's");
        }
            else {
                System.out.println("Wow, you share the same birthday! ^_^");
            }
        //Fun fact that prints out every time
        System.out.println("Did you know?: Several countries celebrate their Independence Day in July, such as the USA, Canada, France, Argentina, and many more!");
        }

    public static int getBirthday(String message, int numToday){
        //Assigns birthday
        Scanner day = new Scanner(System.in);
        System.out.print(message);
        int dateMonth = day.nextInt();
        int dateDay = day.nextInt();

        //Prints out date of birth and day #
        int numBirthday = countDays(dateMonth, dateDay);
        System.out.println(dateMonth + "/" + dateDay + "/2021 falls on day #" + numBirthday + " of 365");

        //Prints out how many days until next birthday
        int resultBirthday = 0;
        if (numBirthday == numToday){
            System.out.println("Happy Birthday! :)");
        } else if (numBirthday < numToday){
            resultBirthday = (365-(numToday - numBirthday));
        } else {
            resultBirthday = (numBirthday - numToday);
        }
        System.out.println("Your birthday is in " + resultBirthday + " day(s)");
        return resultBirthday;
    }

    public static int countDays(int dateMonth, int dateDay){
        String month = "KFKnKnKKnKnK"; // K = Knuckle, n = Not Knuckle, F = February, see Knuckle mnemonic 
        int numOfDays = 0;

        for (int i = 0; i < dateMonth - 1; i++){
            if(month.charAt(i) == 'K'){
                numOfDays += 31;
            } else if(month.charAt(i) == 'F'){
                numOfDays += 28;
            } else {
                numOfDays += 30;
            }
        }

        numOfDays+=dateDay;
        return numOfDays;
    }
}
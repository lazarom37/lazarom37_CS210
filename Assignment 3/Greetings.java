// CS210 Assignment #3 "Greetings"
// Marcus Lazaro

import java.util.*;

public class Greetings {

    public static void main(String[] args) {        
        Scanner s = new Scanner(System.in);
        System.out.println(getGreetings(s));
    }

    private static String getGreetings(Scanner console) {        
        // write your code to get the greetings message
        System.out.println("Please enter your first name: ");
        String first = console.next();
        System.out.println("Please enter your last name: ");
        String last = console.next();
        System.out.println("Please enter your year of birth: ");
        int age = console.nextInt();

        //Filters inputs with proper lower/uppercases and age
        first = first.toUpperCase().substring(0,1);
        last = last.toUpperCase().substring(0,1)+last.toLowerCase().substring(1);
        age = getCurrentYear() - age;

        return "Greetings, " + first + ". " + last + "! You are about " + age + " years old.";
    }
    
    // Get the current year
    // you may find this method useful when calculating the age -- feel free to use it
    private static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
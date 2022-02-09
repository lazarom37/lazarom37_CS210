// CS210 Assignment #4 "Birthdays"
// Chris Moroney
// This assignment required me to display different types of return values based on
import java.util.*;
public class benis {
    public static void main(String[] args) {

        Scanner todayScanner= new Scanner(System.in);
        System.out.print("Please enter today’s date (month day) : ");
        
        int todayMonth = todayScanner.nextInt();
        int todayDay = todayScanner.nextInt();

        int todayDOY = countDays(todayMonth, todayDay);
        
        System.out.println("Today is " + todayMonth + "/" + todayDay + "/2018, day #" + todayDOY + " of the year.");
        System.out.println();

        int reportedFirstBirthday = doBirthdays("Please enter Person #1's birthday (month day) : ", todayDOY);
        int reportedSecondBirthday = doBirthdays("Please enter Person #2's birthday (month day) : ", todayDOY);

        if ((reportedFirstBirthday) < (reportedSecondBirthday)){
            System.out.println("Person #1's birthday is sooner");
        } else if ((reportedFirstBirthday) > (reportedSecondBirthday)){
            System.out.println("Person #2's birthday is sooner");
        } else {
            System.out.println("Wow, you share the same birthday! ^_^");        }
        System.out.println();
        System.out.println("Thank you for using this free program.");
        System.out.println("Speaking of free, did you know that 11/9 is World Freedom Day?");
        System.out.println("Take some time to appreciate all of the freedoms around us.");
        System.out.println("This includes what we do to celebrate our birthdays!");
    }

    

    public static int doBirthdays(String prompt, int todayDOY){
        Scanner birthday = new Scanner(System.in);
        System.out.print(prompt);

        int BirthdayMonth = birthday.nextInt();
        int BirthdayDay = birthday.nextInt();

        int BirthdayDOY = countDays(BirthdayMonth, BirthdayDay);
        System.out.println(BirthdayMonth + "/" + BirthdayDay + "/2018 falls on day #" + BirthdayDOY + " of 365.");

        int reportedBirthday=0;
        if ((BirthdayDOY)<(todayDOY)){
            reportedBirthday = (365-(todayDOY-BirthdayDOY));
        } else {
            reportedBirthday = (BirthdayDOY - todayDOY);               
        }
        System.out.println("Your next birthday is in " + reportedBirthday + " day(s).");
        if ((BirthdayDOY-todayDOY) == todayDOY){
            System.out.println("Happy Birthday! :)");
        } else {
            
        }
        System.out.println();
        return reportedBirthday;
        
    }

    public static int countDays(int myMonth, int myDay){
        String month = "LTLSLSLLSLSL";
        int numberOfDays = 0;

        for (int i=0; i<myMonth-1; i++){
            if(month.charAt(i) == 'L'){
                numberOfDays += 31;
            } else if(month.charAt(i) == 'T'){
                numberOfDays += 28;
            } else {
                numberOfDays += 30;
            }
        }

        numberOfDays+=myDay;
        return numberOfDays;
    }
}
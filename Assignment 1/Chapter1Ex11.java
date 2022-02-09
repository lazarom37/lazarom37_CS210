//CS210 Assignment #1
//Marcus Lazaro
//This is Ch.1 Excercise 11's "Two Rockets" due 07.13.2021

public class Chapter1Ex11 {
    public static void main(String[] args) { //Outputted two rockets using the three static methods above
        rocketTri();
        rocketBody();
        rocketUSA();
        rocketBody();
        rocketTri();
    }
    public static void rocketTri(){ //Triangular sections of the rocket's tip and bottom side
        System.out.println("   /\\       /\\");
        System.out.println("  /  \\     /  \\");  
    }

    public static void rocketBody(){ //Square body sections of rocket's middle section
        System.out.println("+------+ +------+");
        System.out.println("|      | |      |");  
        System.out.println("|      | |      |");
        System.out.println("+------+ +------+");
    }

    public static void rocketUSA(){ //United States logo on the middle of the rocket
        System.out.println("|United| |United|");
        System.out.println("|States| |States|");

    }
}
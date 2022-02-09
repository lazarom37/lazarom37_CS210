// CS210 Assignment #2 "Space Needle"
// Marcus Lazaro, 07/16/2021
// This project is for Assignment 2 where the goal is to make the Space Needle using for loops and practicing against redundancy like in Chapter 1

public class SpaceNeedle {
    public static final int BASE = 4; // BASE represents general size value of space needle, default at 4
    public static void main(String[] args) { // Kept here despite being redundant for the sake of keeping the code as close to the initial version of this Java file as possible
        drawSpaceNeedle();
    }
    public static void drawSpaceNeedle(){ // Would be the REAL main method
        needlePart();
        domeUpper();
        domeMiddle();
        domeLower();
        needlePart();
        stem();
        domeUpper();
    }

    public static void needlePart() { // This prints out the needle part
        for (int i = 1; i <= BASE; i++) { // This is for creating space characters
           for (int space = 1; space <= BASE * 3; space++) { // Loops (BASE * 3) times to accomodate other values for BASE and center-alignment of other methods
              System.out.print(" ");
           }
           System.out.println("||"); // Always ends with ||
        }
     }

    public static void domeUpper(){ // This prints out the upper dome part
        for (int line = 1; line <= BASE; line++) { 
            for (int space = 1; space <= BASE - line; space++) { // This is for creating space characters, amount of spaces is reduced per line
                System.out.print("   ");
            }  
            System.out.print("__/");
            for (int i = 1; i <= line-1; i++) {
                System.out.print(":::");
            }
            System.out.print("||");
            for (int i = 1; i <= line-1; i++) {
                System.out.print(":::");
            }
            System.out.println("\\__"); // Always ends with \__
        }
    }

    public static void domeMiddle() { // This prints out the middle dome part
        System.out.print("|"); // Always begins with |
        for (int i = 1; i <= BASE; i++) {
           System.out.print("\"\"\"\"\"\""); // 6 quotation marks (") per loop 
        }
        System.out.println("|"); // Always ends with |
     }

    public static void domeLower(){ // This prints out the lower dome part
        for (int line = 1; line <= BASE; line++) {  
           for (int space = 1; space <= (line*2)-2; space++) { // This is for creating space characers, amount of spaces is increased per line
              System.out.print(" ");
           }
           System.out.print("\\_");
           for (int i = 1; i <= (((BASE * 3) + 1) - (line * 2)); i++) {
              System.out.print("/\\");
           }
           System.out.println("_/"); // Always ends with _/
        }
     }

     public static void stem() { // This prints out the stem part
        for (int line = 1; line <= BASE * BASE; line++) {
           for (int space = 1; space <= (BASE * 3) - 3; space++) { // This is for creating space characters, almost identical to needlePart method
              System.out.print(" ");
           }
           System.out.println("|%%||%%|"); // Always ends with |%%||%%|
        }
     }
  }
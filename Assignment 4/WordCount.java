// CS210 Assignment #4 "Word Count"
// Marcus Lazaro
// This is a simple Word Count Program

public class WordCount{
    public static void main (String[] args){
        System.out.println("There is a total of " + wordCount("hello") + " word(s)");
        System.out.println("There is a total of " + wordCount("how are you?") + " word(s)");
        System.out.println("There is a total of " + wordCount(" how are you?") + " word(s)");
        System.out.println("There is a total of " + wordCount("how are you? ") + " word(s)");
        System.out.println("There is a total of " + wordCount("how are you ?") + " word(s)");
        System.out.println("There is a total of " + wordCount("I am 3 years old") + " word(s)");
        System.out.println("There is a total of " + wordCount("3 x 4 = 12") + " word(s)");
        System.out.println("There is a total of " + wordCount("Characters !@#$%^&*") + " word(s)");
        System.out.println("There is a total of " + wordCount(" ") + " word(s)");
    }

    public static int wordCount(String inputString) {
        int numOfWords = 0;
        char firstChar = inputString.charAt(0);

        if (firstChar != ' '){  //If there is a real first character, then it counts as a word
            numOfWords++;
        }

        for (int i = 1; i < inputString.length(); i++){
            char secondChar = inputString.charAt(i);        //Saves what character is after firstChar
            if (firstChar == ' ' && secondChar != ' '){     //If first char is not a space and second char is a space, then another word is being said
                numOfWords++;
            }
            firstChar = secondChar; //Moves onto the next character when loop i is finished
        }
        if (inputString.length() == ' '){  //If last character has a space, -1
            numOfWords--;
        }
        return numOfWords;
    }
}
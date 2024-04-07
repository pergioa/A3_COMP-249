import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean inMenu = true;
        // Welcome Message
        System.out.println("Welcome to our Vocabulary Control Center!");
        System.out.println("Brought to you by Sergio Abreo Alvarez and Arturo Sanchez Escobar");

        do{
            switch (displayMenu()){
                case 0: inMenu = false; break;
                case 1: browseTopic(); break;
                case 2: insertNewTopicBeforeAnotherOne(); break;
                case 3: insertNewTopicAfterAnotherOne(); break;
                case 4: removeTopic(); break;
                case 5: modifyTopic(); break;
                case 6: searchTopicForAWord(); break;
                case 7: loadFromFile(); break;
                case 8: showAllWordsWithLetter(); break;
                case 9: saveToFile(); break;
                default: System.out.println("Invalid input, please try again");
            }
        }while(inMenu);


        Scanner reader = null;
        try{
            reader = new Scanner(new FileInputStream("A3_input_file.txt"));

            // CHECK IF THERE IS #

            // IF # THEN TOPIC NAME ELSE WORD

            // USE THE DATA
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }


        System.out.println("Thank you for using our program. The program has ended succesfully, have a nice day");
    }

    public static int displayMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("Vocabulary Control Center");
        System.out.println("-----------------------------------");
        System.out.println("1 Browse a topic");
        System.out.println("2 Insert a new topic before another one");
        System.out.println("3 Insert a new topic after another one");
        System.out.println("4 Remove a topic");
        System.out.println("5 Modify a topic");
        System.out.println("6 Search topics for a word");
        System.out.println("7 Load from a file");
        System.out.println("8 Show all words starting with a given letter");
        System.out.println("9 Save to file");
        System.out.println("0 Exit");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }


    // OPTION 1
    public static void browseTopic(){
        System.out.println("1");
    }
    // OPTION 2
    public static void insertNewTopicBeforeAnotherOne(){
        System.out.println("2");
    }
    // OPTION 3
    public static void insertNewTopicAfterAnotherOne(){

    }
    // OPTION 4
    public static void removeTopic(){

    }
    // OPTION 5
    public static void modifyTopic(){

    }
    // OPTION 6
    public static void searchTopicForAWord(){

    }
    // OPTION 7
    public static void loadFromFile(){

    }
    // OPTION 8
    public static void showAllWordsWithLetter(){

    }
    // OPTION 9
    public static void saveToFile(){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(new FileOutputStream("SaveToFile.txt"));

        }catch(FileNotFoundException e){
            System.out.println("File to write on was not found");
        }
    }
}
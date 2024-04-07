import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner reader = null;
        try{
            reader = new Scanner(new FileInputStream("A3_input_file.txt"));

            // CHECK IF THERE IS #

            // IF # THEN TOPIC NAME ELSE WORD

            // USE THE DATA
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }
    }
}
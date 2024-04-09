import javax.xml.soap.SOAPPart;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList vocab_list = new DoublyLinkedList();
        boolean inMenu = true;
        Scanner sc = new Scanner(System.in);
        // Welcome Message
        System.out.println("Welcome to our Vocabulary Control Center!");
        System.out.println("Brought to you by Sergio Abreo Alvarez and Arturo Sanchez Escobar");

        do{
            switch (displayMenu(sc)){
                case 0: inMenu = false; break;
                case 1: browseTopic(sc, vocab_list); break;
                case 2: insertNewTopicBeforeAnotherOne(sc, vocab_list); break;
                case 3: insertNewTopicAfterAnotherOne(sc, vocab_list); break;
                case 4: removeTopic(sc, vocab_list); break;
                case 5: modifyTopic(sc, vocab_list); break;
                case 6: searchTopicForAWord(sc, vocab_list); break;
                case 7: loadFromFile(sc, vocab_list); break;
                case 8: showAllWordsWithLetter(sc, vocab_list); break;
                case 9: saveToFile(vocab_list); break;
                default: System.out.println("Invalid input, please try again");
            }
        }while(inMenu);



        System.out.println("Thank you for using our program. The program has ended succesfully, have a nice day!");
    }

    public static int displayMenu(Scanner sc){
        System.out.println("-----------------------------------");
        System.out.println("     Vocabulary Control Center");
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
        System.out.println("-----------------------------------");
        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }


    // ********************************************* OPTION 1 *********************************************
    public static void browseTopic(Scanner sc, DoublyLinkedList dList){
        boolean inBrowse = true;
        if(dList.getSize() == 0 ){
            System.out.println("No file could be read, please load a file.");
        }else {
            do {
                System.out.println("-----------------------------------");
                System.out.println("         Pick a topic");
                System.out.println("-----------------------------------");
                // DISPLAY THE CURRENT TOPICS
                for (int i = 0; i < dList.getSize(); i++) {
                    System.out.println(i + 1 + "  " + dList.get(i).topic);
                }
                System.out.println("0  Exit");
                System.out.println("-----------------------------------");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                if (choice > dList.getSize() || choice < 0) {
                    System.out.println("Invalid input, please enter a valid choice");
                } else {
                    if (choice == 0) {
                        inBrowse = false;
                    } else {
                        Vocab v = dList.get(choice - 1);
                        System.out.println("Topic: " + v.topic);
                        for (int i = 0; i < v.words.getSize(); i++) {
                            System.out.println(i + 1 + " " + v.words.get(i));
                        }
                    }
                }
            } while (inBrowse);
        }
    }

    // ********************************************* OPTION 2 *********************************************
    public static void insertNewTopicBeforeAnotherOne(Scanner sc, DoublyLinkedList dList){
        boolean inInsert = true;
        String topicToAdd = "";
        String word = "";
        ArrayList<String> words = new ArrayList<>();
        if(dList.getSize() == 0) {
            System.out.println("There is no file to read, please load a file");
        }else{
            do {
                System.out.println("-----------------------------------");
                System.out.println("         Pick a topic");
                System.out.println("-----------------------------------");
                // DISPLAY THE CURRENT TOPICS
                for (int i = 0; i < dList.getSize(); i++) {
                    System.out.println(i + 1 + "  " + dList.get(i).topic);
                }
                System.out.println("0  Exit");
                System.out.println("-----------------------------------");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice > dList.getSize() || choice < 0) {
                    System.out.println("Invalid input, please enter a valid choice");
                } else {
                    if (choice == 0) {
                        inInsert = false;
                    } else {
                        // ASK FOR INFO
                        System.out.println("Enter a topic name:");
                        topicToAdd = sc.nextLine();
                        System.out.println("Enter a word - to quit press Enter");
                        while (!(word = sc.nextLine()).equals("")){
                            words.add(word);
                        }
                        // CREATE VOCAB AND ADD IT TO DLIST
                        Vocab v = new Vocab(topicToAdd, words.toArray(new String[0]));
                        Vocab ref = dList.get(choice-1);
                        dList.addBefore(ref, v);
                        // RESET WORDS
                        words = new ArrayList<>();
                        System.out.println("Successfully added the topic");
                    }
                }
            } while (inInsert);
        }
    }
    // ********************************************* OPTION 3 *********************************************
    public static void insertNewTopicAfterAnotherOne(Scanner sc, DoublyLinkedList dList){
        boolean inInsert = true;
        String topicToAdd = "";
        String word = "";
        ArrayList<String> words = new ArrayList<>();
        if(dList.getSize() == 0) {
            System.out.println("There is no file to read, please load a file");
        }else{
            do {
                System.out.println("-----------------------------------");
                System.out.println("         Pick a topic");
                System.out.println("-----------------------------------");
                // DISPLAY THE CURRENT TOPICS
                for (int i = 0; i < dList.getSize(); i++) {
                    System.out.println(i + 1 + "  " + dList.get(i).topic);
                }
                System.out.println("0  Exit");
                System.out.println("-----------------------------------");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice > dList.getSize() || choice < 0) {
                    System.out.println("Invalid input, please enter a valid choice");
                } else {
                    if (choice == 0) {
                        inInsert = false;
                    } else {
                        // ASK FOR INFO
                        System.out.println("Enter a topic name:");
                        topicToAdd = sc.nextLine();
                        System.out.println("Enter a word - to quit press Enter");
                        while (!(word = sc.nextLine()).equals("")){
                            words.add(word);
                        }
                        // CREATE VOCAB AND ADD IT TO DLIST
                        Vocab v = new Vocab(topicToAdd, words.toArray(new String[0]));
                        Vocab ref = dList.get(choice-1);
                        dList.addAfter(ref, v);
                        System.out.println("Succesfully added the new topic and its words");
                        // RESET WORDS
                        words = new ArrayList<>();
                    }
                }
            } while (inInsert);
        }
    }
    // OPTION 4
    public static void removeTopic(Scanner sc, DoublyLinkedList dList){
        boolean inRemove = true;
        if(dList.getSize() == 0) {
            System.out.println("There is no file to read, please load a file");
        }else{
            do {
                System.out.println("-----------------------------------");
                System.out.println("         Pick a topic");
                System.out.println("-----------------------------------");
                // DISPLAY THE CURRENT TOPICS
                for (int i = 0; i < dList.getSize(); i++) {
                    System.out.println(i + 1 + "  " + dList.get(i).topic);
                }
                System.out.println("0  Exit");
                System.out.println("-----------------------------------");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice > dList.getSize() || choice < 0) {
                    System.out.println("Invalid input, please enter a valid choice");
                } else {
                    if (choice == 0) {
                        inRemove = false;
                    } else {
                        // REMOVE THE VALUE
                        Vocab v = dList.get(choice-1);
                        //System.out.println("Vocab: " +  v.toString());
                        dList.removeValue(v);
                        System.out.println("Topic successfully removed");
                    }
                }
            } while (inRemove);

        }
    }
    // ********************************************* OPTION 5 *********************************************
    public static void modifyTopic(Scanner sc, DoublyLinkedList dList){
        boolean inModify = true;
        if(dList.getSize() == 0) {
            System.out.println("There is no file to read, please load a file");
        }else{
            do {
                System.out.println("-----------------------------------");
                System.out.println("         Pick a topic");
                System.out.println("-----------------------------------");
                // DISPLAY THE CURRENT TOPICS
                for (int i = 0; i < dList.getSize(); i++) {
                    System.out.println(i + 1 + "  " + dList.get(i).topic);
                }
                System.out.println("0  Exit");
                System.out.println("-----------------------------------");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice > dList.getSize() || choice < 0) {
                    System.out.println("Invalid input, please enter a valid choice");
                } else {
                    if (choice == 0) {
                        inModify = false;
                    } else {
                        // GET INFO
                        getInfoToModifyTopic(sc, dList, dList.get(choice-1));
                    }
                }
            } while (inModify);
        }
    }

    public static void getInfoToModifyTopic(Scanner sc, DoublyLinkedList dList, Vocab v){
        String innerChoice = "";
        System.out.println("-----------------------------------");
        System.out.println("Modify Topics Menu");
        System.out.println("-----------------------------------");
        System.out.println("a add a word");
        System.out.println("r remove a word");
        System.out.println("c change a word");
        System.out.println("0 exit");
        System.out.println("-----------------------------------");
        System.out.print("Enter your choice: ");
        innerChoice = sc.nextLine();
        switch (innerChoice){
            case "a": optionA(sc, dList, v); break;
            case "r": optionR(sc, dList, v); break;
            case "c": optionC(sc, dList, v); break;
            case "0": break;
            default:
                System.out.println("Invalid input, please enter a valid choice.");
        }

    }

    public static void optionA(Scanner sc, DoublyLinkedList dList, Vocab v){
        String word = "";
        System.out.println("Type a word and press Enter, or press Enter to end input");
        while(!(word = sc.nextLine()).equals("")){
            // GET ARRAY AND ADD THE WORDS TO IT
            if(v.words.indexOf(word) == -1){
                v.words.addAtHead(word);
            }else{
                System.out.println("Sorry, the word: '" + word + "' is already listed");
            }
        }
    }

    public static void optionR(Scanner sc, DoublyLinkedList dList, Vocab v){
        String word = "";
        System.out.println("Enter a word:");
        if(!((word = sc.nextLine()).equals("") )){
            int index = v.words.indexOf(word);
            if(index == -1){
                System.out.println("Sorry, there is no word: " + word);
            }else{
                v.words.removeValue(word);
            }
        }
    }

    public static void optionC(Scanner sc, DoublyLinkedList dList, Vocab v){
        String word = "";
        String newWord = "";
        System.out.println("Enter the word to change: ");

        if(!((word = sc.nextLine()).equals("") )){
            int index = v.words.indexOf(word);
            if(index == -1){
                System.out.println("Sorry, there is no word: " + word);
            }else{
                System.out.println("Enter the new word");
                if(!(newWord = sc.nextLine()).equals("")){
                    v.words.updateIndexValue(index, newWord);
                }
            }
        }
    }
    // ********************************************* OPTION 6 *********************************************
    public static void searchTopicForAWord(Scanner sc, DoublyLinkedList dList){
        String wordToFind = "";
        if(dList.getSize() == 0) {
            System.out.println("There is no file to read, please load a file");
        }else{
            System.out.println("Which word do you wish to find");
            wordToFind = sc.nextLine();
            // FIND THE WORD
            for(int i = 0; i<dList.getSize(); i++){
                if( (dList.get(i).words.indexOf(wordToFind)) != -1 ){
                    System.out.println("The word: " + wordToFind + " is listed in: " + dList.get(i).topic);
                    return;
                }
            }
            System.out.println("The word is not listed in any topic");
        }
    }

    // ********************************************* OPTION 7 *********************************************
    public static void loadFromFile(Scanner sc, DoublyLinkedList dList){
        System.out.println("Enter the name of the input file:");
        String path = sc.nextLine();
        Scanner reader = null;
        String topic = "";
        String temp = "";
        boolean sameTopic = false;
        ArrayList<String> words = new ArrayList<String>();
        try{
            reader = new Scanner(new FileInputStream(path));
            while(reader.hasNextLine()){
                temp = reader.nextLine();
                // CHECK IF THERE IS #
                if(!temp.equals("")){
                    if(temp.charAt(0) == '#') {
                        if( !(( temp.substring(1,temp.length()) ).equals(topic)) && !topic.equals("")){
                            addVocab(topic, words, dList);
                            words = new ArrayList<>();
                        }
                        topic = temp.substring(1, temp.length());
                    }else {
                        words.add(temp);
                    }
                }
            }
            addVocab(topic, words, dList);
            System.out.println("Done loading");
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }
    }

    private static void addVocab(String topic, ArrayList<String> words, DoublyLinkedList dList){
        Vocab v = new Vocab(topic, words.toArray(new String[0]));
        dList.addAtHead(v);
    }
    // ********************************************* OPTION 8 *********************************************
    public static void showAllWordsWithLetter(Scanner sc, DoublyLinkedList dList){
        char letter = ' ';
        // GET INFO
        ArrayList<String> wordsFound = new ArrayList<>();
        System.out.println("Which letter would you like to see the words starting with that letter");
        letter = sc.next().charAt(0);
        // GET ALL THE WORDS
        for (int i = 0; i<dList.getSize();i++){
            dList.get(i).wordsBeginningWith(letter).forEach(s -> {
                if(!wordsFound.contains(s)){
                    wordsFound.add(s);
                }
            });
        }
        // SORT THE ARRAYLIST
        String temp = "";
        boolean swapped;
        for (int i = 0; i < wordsFound.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < wordsFound.size() - i - 1; j++) {
                if (wordsFound.get(j).compareTo(wordsFound.get(j+1)) > 0) {

                    // Swap arr[j] and arr[j+1]
                    temp = wordsFound.get(j);
                    wordsFound.set(j, wordsFound.get(j+1));
                    wordsFound.set(j+1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        // DISPLAY THE ARRAY
        wordsFound.forEach(System.out::println);
        System.out.println("The words were successfully sorted.");
    }
    // ********************************************* OPTION 9 *********************************************
    public static void saveToFile(DoublyLinkedList dList){
        PrintWriter writer = null;
        Vocab v = null;
        try{
            writer = new PrintWriter(new FileOutputStream("SaveToFile.txt"));
            for(int i = 0; i < dList.getSize(); i++){
                v = dList.get(i);
                writer.println("#"+v.topic);
                for (int j=0; j<v.words.getSize(); j++){
                    writer.println(v.words.get(j));
                }
                writer.println("");
            }
            System.out.println("File was saved succesfully.");
            writer.close();
        }catch(FileNotFoundException e){
            System.out.println("File to write on was not found");
        }
    }
}
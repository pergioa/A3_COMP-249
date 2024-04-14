
// -----------------------------------------------------
// Assignment: 3, COMP249
// Parts: Voab Object
// Written by: Sergio Abreo Alvarez - 40274677 , Arturo Sanchez Escobar - 40283236
// Purpose: This class handles the creation of new Vocab objects and LinkedLists. It handles everything related to the topic of a Vocab
// and its words through the usage of the LinkedList
// Due date: April 15, 2024
// -----------------------------------------------------
import java.util.ArrayList;

/**
 * <p> Assignment 3, COMP249</p>
 * @author Arturo Sanchez - 40283236
 * @author Sergio Abreo - 40274677
 * @version 1.0.0
 * <p> This class handles the creation of new Vocab objects and LinkedLists. It handles everything related to the topic of a Vocab
 * and its words through the usage of the LinkedList</p>
 * <p>Due date: April 27, 2024</p>
 */
public class Vocab {
    String topic;
    LinkedList words;

    /**
     * Get the topic of Vocab
     * @return the topic Vocab
     */
    public String getTopic(){
        return topic;
    }

    /**
     * Sets the topic of Vocab
     * @param value is the topic of Vocab
     */
    public void setTopic(String value){
        topic = value;
    }

    /**
     * Builds the Vocab object with all of its specified values
     * @param topic is the topic of Vocab
     * @param words is the list words of Vocab
     */
    public Vocab(String topic, String[] words){
        this.topic = topic;
        this.words = new LinkedList();
        for(String s: words)
            this.words.addAtHead(s);
    }

    /**
     * This methods filters all words in the vocab for those that start with a specified letter
     * @param l is the character to filter by
     * @return the arrayList of all words found
     */
    public ArrayList<String> wordsBeginningWith(char l){
        ArrayList<String> wordsFound = new ArrayList<>();
        for(int i = 0; i<words.getSize(); i++){
            if(words.get(i).charAt(0) == l){
                wordsFound.add(words.get(i));
            }
        }
        return wordsFound;
    }

    /**
     * This method compares two Vocab ojbect to see if they are the same
     * @param obj is the object to compare with
     * @return a boolean saying if the equality is true or not
     */
    public boolean equals(Object obj){
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        if(obj == this)
            return true;
        Vocab v = (Vocab) obj;
        boolean isEqual = true;
        if(!topic.equals(v.topic))
            isEqual = false;
        for(int i = 0; i<v.words.getSize();++i){
            if(!words.get(i).equals(v.words.get(i))){
                isEqual = false;
                break;
            }
        }
        return isEqual;
    }

    /**
     * Display the attributes of the ojbect Vocab
     * @return a string of all the current Vocab attributes
     */
    @Override
    public String toString() {
        return "Vocab{ topic:'" + topic + ", words:" + words + '}';
    }
}

import java.util.ArrayList;

public class Vocab {
    String topic;
    LinkedList words;

    public String getTopic(){
        return topic;
    }

    public void setTopic(String value){
        topic = value;
    }

    public Vocab(String topic, String[] words){
        this.topic = topic;
        this.words = new LinkedList();
        for(String s: words)
            this.words.addAtHead(s);
    }

    public ArrayList<String> wordsBeginningWith(char l){
        ArrayList<String> wordsFound = new ArrayList<>();
        for(int i = 0; i<words.getSize(); i++){
            if(words.get(i).charAt(0) == l){
                wordsFound.add(words.get(i));
            }
        }
        return wordsFound;
    }

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

    @Override
    public String toString() {
        return "Vocab{ topic:'" + topic + ", words:" + words + '}';
    }
}

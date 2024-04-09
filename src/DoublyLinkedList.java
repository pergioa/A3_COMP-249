public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int counter;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }

    public Vocab get(int index){
        Node temp = head;

        if(index >= counter) {
            return null;
        }else if(head != null){
            for(int i = 0; i!=index; ++i )
                temp = temp.after;
        }
        return temp.value;
    }

    // Add at head
    public void addAtHead(Vocab value) {
        Node temp = head;
        head = new Node(value, null, head);

        if (tail == null) {
            tail = head;
        } else {
            temp.before = head;
        }

        counter++;
    }

    // Add at tail
    public void addAtTail(Vocab value) {
        Node temp = tail;
        tail = new Node(value, tail, null);
        if (head == null) {
            head = tail;
        } else {
            temp.after = tail;
        }

        counter++;
    }

    // Add after (while going from the head to tail)
    public void addAfter(Vocab referenceValue, Vocab newValue) {
        Node position = head;
        while (position != null && position.value != referenceValue) {
            position = position.after;
        }
        if (position != null && position.value == referenceValue) {
            // if the ref value is the last element
            if (position.after == null) {
                addAtTail(newValue);
            } else {
                Node n = new Node(newValue, null, null);
                n.after = position.after;
                n.before = position;
                position.after.before = n;
                position.after = n;
                counter++;
            }
        }
    }

    public void addBefore(Vocab referenceValue, Vocab newValue) {
        Node position = head;
        while (position != null && !position.value.equals(referenceValue)) {
            position = position.after;
        }
        if (position != null && position.value.equals(referenceValue)) {
            // if the ref value is the last element
            if (position.before == null) {
                addAtHead(newValue);
            } else {
                Node n = new Node(newValue, null, null);
                n.after = position;
                n.before = position.before;
                position.before.after = n;
                position.before = n;
                counter++;
            }
        }
    }

    // Remove head
    public Vocab removeHead() {
        if (head == null) {
            return null;
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            counter--;
            return temp.value;
        } else {
            Node temp = head;
            head = head.after;
            head.before = null;
            counter--;
            return temp.value;
        }
    }

    // Remove tail
    public Vocab removeTail() {
        if (tail == null) {
            return null;
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            counter--;
            return temp.value;
        } else {
            Node temp = tail;
            tail = tail.before;
            tail.after = null;
            counter--;
            return temp.value;
        }
    }

    // Remove value
    public void removeValue(Vocab value){
        Node temp = head;

        if(temp.value.equals(value)) {
            head = head.after;
        }else if(tail.value.equals(value)){
            tail = tail.before;
        }else {
            for (int i = 0; i < counter; ++i) {
                if (temp.value.equals(value)) {
                    temp.before.after = temp.after;
                    temp.after.before = temp.before;
                    break;
                }
                temp = temp.after;
            }
        }
        counter--;
    }

    // get size
    public int getSize() {
        return counter;
    }

    // Display
    public void displayFromHeadToTail() {
        if (head == null) {
            System.out.println("The list is empty");
        } else {
            System.out.println("Displaying from Head to Tail with " + counter + " element(s).");
            Node position = head;

            while (position != null) {
                System.out.println(position.value);
                position = position.after;
            }
        }
    }

    public void displayFromTailToHead() {
        if (tail == null) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Displaying from Tail to Head " + counter + " element(s).");
            Node position = tail;
            while (position != null) {
                System.out.println(position.value);
                position = position.before;
            }
        }
    }

    private class Node {
        // Data
        private Vocab value;
        // Links
        private Node after;
        private Node before;

        public Node(Vocab value, Node before, Node after) {
            this.value = value;
            this.before = before;
            this.after = after;
        }
    }

}
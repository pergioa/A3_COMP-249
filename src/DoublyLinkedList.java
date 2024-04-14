// -----------------------------------------------------
// Assignment: 3, COMP249
// Parts: Doubly LinkedList
// Written by: Sergio Abreo Alvarez - 40274677 , Arturo Sanchez Escobar - 40283236
// Purpose: This class is the model for a Doubly LinkedList, it handles all necessary manipulations of its elements
// Due date: April 15, 2024
// -----------------------------------------------------

/**
 * <p> Assignment 3, COMP249</p>
 * @author Arturo Sanchez - 40283236
 * @author Sergio Abreo - 40274677
 * @version 1.0.0
 * <p> This class is the model for a Doubly LinkedList, it handles all necessary manipulations of its elements</p>
 * <p>Due date: April 27, 2024</p>
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int counter;

    /**
     * Builds a DoublyLinkedList object with no elements
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }

    /**
     * Get the value of an element in the DoublyLinkedList through its index
     * @param index of the value to be found
     * @return value of the node at the specified index
     */
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

    /**
     * Add a node at the head of the DoublyLinkedList
     * @param value of the new head
     */
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

    /**
     * Add a node at the tail of the DoublyLinkedList
     * @param value of the new tail
     */
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

    /**
     * Add a node after the specified reference going from head to tail
     * @param referenceValue is from which we add the new node after
     * @param newValue is the value of the new node
     */
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

    /**
     * Add a node before the specified reference going from head to tail
     * @param referenceValue is from which we add the new node before
     * @param newValue is the value of the new node
     */
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

    /**
     * Remove the head of the DoublyLinkedList
     * @return the value of the deleted head
     */
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

    /**
     * Remove the tail of the DoublyLinkedList
     * @return the value of the deleted tail
     */
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

    /**
     * Remove the node with the help of the specified value within the DoublyLinkedList
     * @param value of the node remove
     */
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

    /**
     * Get the size of the DoublyLinkedList
     * @return the size of the DoublyLinkedList
     */
    public int getSize() {
        return counter;
    }

    /**
     * Display the DoublyLinkedList from head to tail
     */
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

    /**
     * Display the DoublyLinkedList from tail to head
     */
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

    /**
     * This is the basic model for all elements of the single LinkedList, it holds the necessary attributes
     */
    private class Node {
        // Data
        private Vocab value;
        // Links
        private Node after;
        private Node before;

        /**
         *Builds an object Node with its data and next and before nodes references
         * @param value of the node
         * @param before is the reference of the node before
         * @param after is the reference of the node after
         */
        public Node(Vocab value, Node before, Node after) {
            this.value = value;
            this.before = before;
            this.after = after;
        }
    }

}
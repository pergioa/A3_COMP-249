// -----------------------------------------------------
// Assignment: 3, COMP249
// Parts: Single LinkedList
// Written by: Sergio Abreo Alvarez - 40274677 , Arturo Sanchez Escobar - 40283236
// Purpose: This class is the model for a single LinkedList, it handles all necessary manipulations of its elements
// Due date: April 15, 2024
// -----------------------------------------------------

/**
 * <p> Assignment 3, COMP249</p>
 * @author Arturo Sanchez - 40283236
 * @author Sergio Abreo - 40274677
 * @version 1.0.0
 * <p> This class is the model for a single LinkedList, it handles all necessary manipulations of its elements</p>
 * <p>Due date: April 27, 2024</p>
 */
public class LinkedList {

    private Node head;

    private int counter;

    /**
     * Builds a LinkedList object with no elements
     */
    public LinkedList() {
        head = null;
        counter = 0;
    }

    /**
     * Get the value of an element in the LinkedList
     * @param index of the value to be found
     * @return value of the node at the specified index
     */
    public String get(int index) {
        Node temp = head;
        if (index >= counter){
            return null;
        }else if(head != null){
            for (int i = 0; i!=index; ++i)
                temp = temp.next;
    }
        return temp.value;
    }

    /**
     * Gets the index of a value
     * @param value of the index to be found
     * @return index of the specified value in the LinkedList
     */
    public int indexOf(String value){
        int index = -1;
        Node temp = head;
        for(int i = 0; i<counter ; i++){
            if(temp.value.equals(value)){
                index = i;
                break;
            }
            temp = temp.next;
        }
        return index;
    }

    /**
     * Add a node at the head of the LinkedList
     * @param value of the new head
     */
    public void addAtHead(String value) {
        head = new Node(value, head);
        counter++;
    }

    /**
     * Add a tail, a node at the ned of the LinkedList
     * @param value of the new node/tail to add
     */
    public void addAtEnd(String value) {
        if (head == null) {
            addAtHead(value);
        } else {
            Node position = head;
            while (position.next != null) {
                position = position.next;
            }
            Node n = new Node(value, null);
            position.next = n;

            counter++;
        }
    }

    /**
     * Add after a node after a specified value
     * @param referenceValue the value from which its next needs to added a new node
     * @param value of the new node to add
     */
    public void addAfter(String referenceValue, String value) {
        Node position = head;
        // Handle the case when referenceValue does not exist
        while (position != null && position.value != referenceValue) {
            position = position.next;
        }
        if (position == null) { // value does not exist
            return;
        } else {
            Node n = new Node(value, position.next);
            position.next = n;
            counter++;
        }
    }

    // Add before a value. WE ONLY ADD IF THE REFERENCEVALUE exists

    /**
     * Add a node before the specified value in the LinkedList
     * @param referenceValue of the node to add the new node before of
     * @param newValue is the value of the new node
     */
    public void addBefore(String referenceValue, String newValue) {
        if (head == null) {
            return;
        }
        if (head.value == referenceValue) {
            addAtHead(newValue);
        } else {
            Node position = head;

            while (position.next != null && position.next.value != referenceValue) {
                position = position.next;
            }

            if (position.next != null && position.next.value == referenceValue) {
                position.next = new Node(newValue, position.next);
                counter++;
            }
        }
    }

    /**
     * Remove the head of the LinkedList
     * @return the value of the removed head
     */
    public String removeHead() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            counter--;
            temp.next = null;
            return temp.value;
        }
        return ""; // Or throw an Exception
    }

    /**
     * Remove the tail of the LinkedList
     * @return the value of the removed tail
     */
    public String removeLast() {
        if (head == null) {
            return "";
        } else if (head.next == null) {
            return removeHead();
        } else {
            Node position = head;
            while (position.next.next != null) {
                position = position.next;
            }
            Node temp = position.next;
            position.next = null;
            counter--;
            return temp.value;
        }
    }

    /**
     * Changes the value of a node at the specified index in the LinkedList
     * @param index of the value to update
     * @param value of that needs to be aaded at the specified index
     */
    public void updateIndexValue(int index, String value){
        Node temp = head;
        for(int i = 0 ; i != index ; i++){
            temp = temp.next;
        }
        temp.value = value;
    }

    /**
     *  Remove a value in the LinkedList
     * @param value to be removed
     * @return return the next node after the removal
     */
    public String removeValue(String value) {
        if (head == null) {
            return "";
        }
        if (head.value.equals(value)) {
            return removeHead();
        } else {
            Node position = head;

            while (position.next != null) {
                if (position.next.value.equals(value)) {
                    Node temp = position.next;
                    position.next = position.next.next;
                    counter--;
                    return temp.value;
                }
                position = position.next;
            }
        }
        return "";
    }

    /**
     * Removes the node after a specified value
     * @param value and its next is to be removed
     * @return the node that comes after the one removed
     */
    public String removeAfter(String value) {
        if (head == null) {
            return "";
        } else {
            Node position = head;
            while (position != null && position.value != value) {
                position = position.next;
            }
            if (position != null && position.next != null) {
                Node temp = position.next;
                position.next = position.next.next;
                return temp.value;
            }
        }
        return "";
    }

    /**
     * Returns the size of the list
     * @return the size of the list
     */
    public int getSize() {
        return counter;
    }

    /**
     * Displays the whole list
     */
    public void display() {
        if (head == null) {
            System.out.println("Your list is empty.");
        } else {
            System.out.println("Here are your " + counter + " values from the list: ");
            Node position = head;
            while (position != null) {
                System.out.println(position.value);
                position = position.next;

            }
        }
    }

    /**
     * This is the basic model for all elements of the single LinkedList, it holds the necessary attributes
     */
    private class Node {
        // Data
        private String value;
        // Link
        private Node next;
        /**
         * Builds a object Node with its data and next node's reference
         * @param value of the node
         * @param next is the next node in the list
         */
        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int counter;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }

    // Add at head
    public void addAtHead(int value) {
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
    public void addAtTail(int value) {
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
    public void addAfter(int referenceValue, int newValue) {
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

    // Remove head
    public int removeHead() {
        if (head == null) {
            return -1;
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
    public int removeTail() {
        if (tail == null) {
            return -1;
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

    // Remove after value

    // Remove before value

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
        private int value;
        // Links
        private Node after;
        private Node before;

        public Node(int value, Node before, Node after) {
            this.value = value;
            this.before = before;
            this.after = after;
        }
    }

}
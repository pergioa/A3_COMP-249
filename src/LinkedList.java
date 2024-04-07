public class LinkedList {

    private Node head;
    private Node tail;
    // Optional
    private int counter;

    public LinkedList() {
        head = null;
        counter = 0;
    }

    // Add to head
    public void addAtHead(int value) {
        head = new Node(value, head);
        counter++;
    }

    // Add to end
    public void addAtEnd(int value) {
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

    // Add after a value
    public void addAfter(int referenceValue, int value) {

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
    public void addBefore(int referenceValue, int newValue) {
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

    // Remove head
    public int removeHead() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            counter--;
            temp.next = null;
            return temp.value;
        }
        return -1; // Or throw an Exception
    }

    // Remove tail/last one
    public int removeLast() {
        if (head == null) {
            return -1;
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

    // Remove a value
    public int removeValue(int value) {
        if (head == null) {
            return - 1;
        }
        if (head.value == value) {
            return removeHead();
        } else {
            Node position = head;

            while (position.next != null && position.next.value != value) {
                position = position.next;
            }
            if (position.next.value == value) {
                Node temp = position.next;
                position.next = position.next.next;
                counter--;
                return temp.value;
            }
        }
        return -1;
    }

    // Remove after a value
    public int removeAfter(int value) {
        if (head == null) {
            return -1;
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
        return -1;
    }

    // get size
    public int getSize() {
        return counter;
    }

    // Display
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

    private class Node {

        // Data
        private int value;
        // Link
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

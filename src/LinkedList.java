public class LinkedList {

    private Node head;

    private int counter;

    public LinkedList() {
        head = null;
        counter = 0;
    }

    public String get(int index){
        Node temp = head;
        if(index >= counter)
            return null;
        for(int i = index; i< counter;++i )
            temp = temp.next;

        return temp.value;
    }

    // Add to head
    public void addAtHead(String value) {
        head = new Node(value, head);
        counter++;
    }

    // Add to end
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

    // Add after a value
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

    // Remove head
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

    // Remove tail/last one
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

    // Remove a value
    public String removeValue(String value) {
        if (head == null) {
            return "";
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
        return "";
    }

    // Remove after a value
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
        private String value;
        // Link
        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

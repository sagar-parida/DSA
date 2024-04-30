class LinkedList {

    // Head of the LinkedList.
    private Node head;
    // Tail of the LinkedList.
    private Node tail;
    // Length of the LinkedList.
    private int length;

    // Class Representing individual Nodes of the LinkedList
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // Add a new node at the end of the list.
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Removes and returns the last node of the list.
    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node pre = head;
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
        }
        temp.next = null;
        length--;
        return temp;
    }

    // Adds a new node at the beginning of the list.
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // Removes and returns the first node of the list.
    public Node removeFirst() {
        if (length == 0)
            return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    // Returns the node present at the given index.
    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Sets the given value at the Node present at the given index.
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // Adds a new node at the given index.
    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node pre = get(index - 1);
        Node after = pre.next;
        pre.next = newNode;
        newNode.next = after;
        length++;
        return true;
    }

    // Removes and returns the Node present at the given index.
    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;
        if (index == 0)
            return removeFirst();
        if (index == length - 1)
            return removeLast();

        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    // Reverse the linked list in place.
    public void reverse() {

        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

}
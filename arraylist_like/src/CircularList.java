public class CircularList {
    private Node head;
    private Node tail;

    public CircularList() { // null
        this.head = null;
        this.tail = null;
    }

    public CircularList(Node newHead, Node newTail) {
        this.head = newHead;
        this.tail = newTail;
        this.tail.setNext(head);
        this.head.setNext(this.tail); // for now we have also to set the tail, because if not it's null
    }

    public void print() {
        if (this.head == null) {
            System.out.print("[]");
            return;
        }
        Node cursor = this.head;
        System.out.print("[");
        do { // at first I have to iterate because I print the head
            System.out.print(cursor.getValue());
            cursor = cursor.getNext();
            if (cursor != this.head) { // commas between the elements
                System.out.print(", ");
            }
        } while (cursor != this.head); // till I reach the end
        System.out.println("]"); // close 
    }

    public void printRec() { // recursive
        System.out.print("[");
        // empty
        if (this.head != null) {
            printOut(head);
        }
        System.out.println("]");
    }

    private void printOut(Node current) {
        if (current == null) return; // for being sure we control the emptiness aniway
        System.out.print(current.getValue());

        if (current.getNext() != this.head) { // if it doesn't arrive to the head
            System.out.print(", ");
            printOut(current.getNext());
        }
    }

    // I like it to return the Node I added, so if it's null I know it hasn't added anything
    public Node add(Node newNode, int index) {
        if(head == null) { // 
            if (index != 0) return null; // can't add anything
            this.head = newNode;
            newNode.setNext(newNode); // points to itself
            return newNode;
        }

        if (index == 0) { // head
            Node cursor = head;
            while (cursor.getNext() != head) {
                cursor = cursor.getNext();
            }
            cursor.setNext(newNode); // tails point at the new head
            newNode.setNext(this.head); // the new head point at the old head
            this.head = newNode; // update the head reference
            return newNode;
        }

        // iterate on the list to search the previous item
        Node current = this.head;
        int c = 0;
        while (c < index-1) {
            current = current.getNext();
            c++;
        }
        // now i have the precedent
        // set the next
        newNode.setNext(current.getNext());
        // set the precedent
        current.setNext(newNode);
        return newNode;
    }

    private int size() {
        if (this.head == null) {
            return 0;
        }
        Node cursor = this.head;
        int c = 1;
        while(cursor.getNext() != this.head) {
            c++;
            cursor = cursor.getNext();
        }
        return c;
    } 

    public boolean checkRing() {
        // if it's null
        if (this.head == null) {
            return false;
        }
        // checks if there's any null
        Node cursor = this.head;
        for(int i = 0; i < size(); i++) {
            if (cursor.getNext() == null) {
                return false;
            }
            cursor = cursor.getNext();
        }
        // no null
        return true;
    }

    public int removeRange(int start, int end) throws Exception {
        if (end < start) throw new Exception("Wrong indexes");
        if (head == null) throw new Exception("The list is null");
        if (end == start) throw new Exception("Fucking dumbuss, it doesn't" + 
        "make sense with the same index");
        int removedNodes = 0;
        Node cursor = this.head;
        int firstElement = 0;
        while (start != firstElement) {
            cursor = cursor.getNext();
            firstElement++;
        }
        // adesso cursor è il start
        Node start_Node = cursor;
        int lastElement = firstElement;
        while (end != lastElement) {
            cursor = cursor.getNext();
            lastElement++;
        }
        start_Node.setNext(cursor);
        removedNodes = end - start;
        return removedNodes;
    }

    public int cut(int last) throws Exception {
        if (last == 0) {
            head = this.tail;
        }
        int c = 0;
        Node cursor = head;
        while (c < last) {
            cursor = cursor.getNext();
            c++;
        }
        // now I know the node in index last
        this.tail = cursor;
        return (size() - c);
    }

    public Node getPrev(Node n) {
        Node cursor = head;
        while (cursor.getNext() != n) { // trovo il precedente del nodo corrente
            cursor = cursor.getNext();
        }
        // now I know the precedent
        return cursor;
    }

    public void newRing(Node n1, Node n2) {
        boolean presentePrimo = false;
        boolean presenteSecondo = false;
        Node cursor = this.head;
        // obiettivo: trovare se ci sono i due nodi
        while (cursor.getNext() != this.head) { 
            // trovo se ci sono n1 e n2
            if (cursor.getNext() == n1) {
                presentePrimo = true;
            }
            if (cursor.getNext() == n2) {
                presenteSecondo = true;
            }
            cursor = cursor.getNext();
        }
        // casi
        if (presentePrimo && presenteSecondo) {
            // tutti e due presenti
            this.head = n1;
            this.head.setNext(n2);
            this.tail = n2;
        } else if (presentePrimo && presenteSecondo == false) {
            this.head = n1;
            
        } else if (presentePrimo == false && presenteSecondo) { 
            
        } else if (presentePrimo == false && presenteSecondo == false) {
            this.tail.setNext(n1);
            n1.setNext(n2);
            n2.setNext(this.head);
            this.head = n1;
            this.tail = n2;
        }
    }





}

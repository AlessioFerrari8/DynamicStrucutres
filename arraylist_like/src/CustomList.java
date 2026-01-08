public class CustomList {
    
    // starting node structure
    private Node head;

    public CustomList() { // empty
        this.head = null;
    }

    public CustomList(Node newHead) { // starting from a node
        this.head = newHead; // the old head becomes the new
    }

    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Adds a new node at the end of the list
     * @param newNode new node to be added
     */
    public void append(Node newNode) {
        // caso base
        if (head == null) {  // vuota
            head = newNode;
        } else { 
            // chiamata ricorsiva
            appendOut(head, newNode);
        }
    }

    private void appendOut(Node current, Node newNode) {
        // caso base
        if (current.getNext() == null) { // appena trovo l'ultimo nodo
            current.setNext(newNode); // cambio il riferimento dell'ultimo nodo
            return;
        }
        
        // chiamata ricorsivo
        appendOut(current.getNext(), newNode);
    }

    public void appendInterattiva(Node newNode) {
        if (head == null) {
            this.head = newNode;
        }

        Node cursor = head;

        // last element
        while (cursor.getNext() != null) {
            cursor = cursor.getNext();
        } 

        // reached the end
        cursor.setNext(newNode);

    }

    // funzione che chiama la printOut, per stampare tutto l'array
    public void print() {
        if (head != null) { // controllo che non sia vuota
            System.out.print("[");
            printOut(head); // chiamo la printOut, partendo dalla head
            System.out.println("]");
        } else { // vuota
            System.out.println("[]");
        }
    }

    public void printIterattiva() {
        // the first node
        Node cursor = head;

        System.out.print("[");

        // till the last element
        while(cursor != null) {
            System.out.print(cursor.getValue() + " ");

            // move to the next element
            cursor = cursor.getNext();
        }

        System.out.println("]");
    }

    private void printOut(Node current) {
        // caso base
        if (current.getNext() == null) { // so già che c'è solo quello attuale
            System.out.print(current.getValue());
            return;
        }
        
        // valore inziale
        System.out.print(current.getValue() + ", "); // stampo l'attuale con separatore
        // chiamata ricorsiva
        printOut(current.getNext()); 
    }

    public void add(int index, Node newNode) throws IndexOutOfBoundsException {
        // the node is before the head
        if (index == 0) {
            newNode.setNext(head); // the next will be the actual head
            this.head = newNode; // the new node becomes the head 
        }

        // the node is added 
        else if (index > 0 && index <= size()) {
            Node prev = get(index - 1);

            newNode.setNext(prev.getNext());

            prev.setNext(newNode);
        }

        else {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        // Node current = head;
        // int i = 0;
        // while (current != null) {

        //     if (i == index - 1) {
        //         newNode.setNext(current.getNext());
        //         current.setNext(newNode);
        //         break;
        //     }

        //     if (current.getNext() == null) {
        //         append(newNode);
        //     }
                       
        //     current = current.getNext();
        //     i++;
        // }
        // head = newNode; // empty
    }

    public int size() {
        return sizeOut(head);
    }

    private int sizeOut(Node cursor) {
        // exit clause
        if (cursor == null) {
            return 0;
        } 

        // recursive call
        return sizeOut(cursor.getNext()) + 1;
    }

    public Node get(int index) throws IndexOutOfBoundsException {
        // index valid
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        return getOut(head, index);
    }

    private Node getOut(Node cursor, int index)  {
        // exit clause
        if (index == 0) {
            return cursor;
        }

        // recursive
        return getOut(cursor.getNext(), --index);
    }

    /**
     * Removes a node from the list giving its position
     * @param index position to delete
     * @returnthe the removed node
     * @throws IndexOutOfBoundsException
     */
    public Node remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node toReturn;

        // first element
        if (index == 0) {
            toReturn = head;
            head = head.getNext(); // new head
        }

        // inside
        else {
            Node prev = get(index - 1);
            toReturn = get(index);
            prev.setNext(toReturn.getNext());
        }

        return toReturn;
    }
    
    /**
     * Remove a node from the list if present
     * @param remove the node to be search and removed
     * @return true if was removed, false otherwise
     * @throws IndexOutOfBoundsException
     */
    public boolean remove(Node n) throws IndexOutOfBoundsException {
        Node current = head;
        if (n == null) return false;

        int index = indexOf(n);
        if (index < 0) return false;
        
        return remove(index) != null;
        
    }

    public int indexOf(Node n) {
        Node cursor = head;
        int index = 0;

        while (cursor != null) {
            if (cursor.equals(n)) {
                return index;
            }

            cursor = cursor.getNext();
            index++;
        }

        return -1;

    }

    /**
     * Overwrites a node with a new one, given its position
     * @param index position of the old node
     * @param newNode new node that replaces the old one
     */
    public void set(int index, Node newNode) throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index >= size()) { // out of bounds
            throw new IndexOutOfBoundsException("Invalid index");
        }

        // null
        if (newNode == null) {
            throw new NullPointerException("The Node must not be null"); // I like to consider it an "error"
        }

        // basic case
        if (index == 0) {
            newNode.setNext(head.getNext());
            head = newNode;
            return;
        }

        Node prev = get(index - 1);

        // next node becomes the current next node
        newNode.setNext(prev.getNext().getNext());
        // we set the actual newNode
        prev.setNext(newNode);
    }

    public boolean contains(Node n) {
        // if null
        if (n == null)
            return false;

        Node current = head;

        // we continue through the arraylist
        while (current != null) { // if not null
            if (current.equals(n)) 
                return true; // found it
            
            current = current.getNext();
        }

        // not found it
        return false;
        
    }

    public boolean cointainsRec(Node n) {
        return containsOut(head, n);
    }

    private boolean containsOut(Node cursor, Node n) {
        // exit clauses
        if (cursor == null) return false;
        if (cursor.equals(n)) return true;
    

        // recursive call
        return containsOut(cursor.getNext(), n);
    }




   

}

public class CustomList {
    
    // starting node structure
    private Node head;

    public CustomList() { // empty
        this.head = null;
    }

    public CustomList(Node newHead) { // starting from a node
        this.head = newHead; // the old head becomes the new
    }

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
        Node current = head;
        int i = 0;
        while (current != null) {
            if (i == index && i == 0) {
                newNode.setNext(head);
                break;
            }

            if (i >= 1 && i - 1 == index) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                break;
            }
                       
            current = current.getNext();
            i++;
        }
        head = newNode; // empty
    }

}

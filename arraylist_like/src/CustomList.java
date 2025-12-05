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
        if (head == null) { // se si parte subito con un null pointer
            head = newNode; // setto come primo il nuovo nodo
        } else { // altrimenti
            Node now = head; // metto il nodo attuale come head
            while (now.getNext() != null) { // controllo fino a quando non trovo il null pointer
                now = now.getNext(); // setto l'attuale
            }
            now.setNext(newNode); // setto il nuovo nodo
        }
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

    public void printOut(Node current) {
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
}

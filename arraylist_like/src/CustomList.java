public class CustomList {
    
    // starting node structure
    private Node head;

    public CustomList() { // empty

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
}

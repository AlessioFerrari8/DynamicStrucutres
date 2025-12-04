public class Node {
    // stored value
    private int value;

    // reference to the next node
    private Node next;

    public Node(int newValue) {
        this.value = newValue;
        this.next = null; // default
    }

    // getter
    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    // setter
    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" + value + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // myself

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Node node = (Node)obj;
        if (this.value != node.getValue()) return false;

        return true;
    }

    @Override
    public int hashCode() { // how 
        return super.hashCode();
    }

   
}
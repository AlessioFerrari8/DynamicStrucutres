public class Stack {
    // first element
    private Node top;

    public Stack() {
        this.top = null;
    }

    public Stack(Node newNode) {
        this.top = newNode;
    }

    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Reads the first element's content
     * @return content of the first node
     */
    public int head() throws NullPointerException {
        if (isEmpty()) throw new NullPointerException();
        return top.getValue();
    }

    /**
     * Removes the first element from the stack, updating the top reference
     * @return node removed
     */
    public Node pop() {
        if (isEmpty()) return null; // stack empty
        Node removed = this.top;
        this.top = top.getNext();
        return removed;
    }

    /**
     * Adds a node to the top of the stack
     * @param newNode node to be added
     */
    public void push(Node newNode) { // no need to check if it's null, since it would be the first
        newNode.setNext(top); // top becomes the next
        top = newNode; // new top
    }


}

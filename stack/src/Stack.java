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
    public int head() {
        return top.getValue();
    }

    /**
     * Removes the first element from the stack, updating the top reference
     * @return node removed
     */
    public Node pop() {
        Node removed = top;
        top = top.getNext();
        return removed;
    }

    /**
     * Adds a node to the top of the stack
     * @param newNode node to be added
     */
    public void push(Node newNode) {
        top.setNext(newNode);
        top = newNode;
    }


}

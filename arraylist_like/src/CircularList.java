public class CircularList {
    private Node head;
    private Node tail;

    public CircularList() {
        this.head = null;
        this.tail = null;
    }

    public CircularList(Node newHead, Node newTail) {
        this.head = newHead;
        this.tail = newTail;
        this.tail.setNext(head);
    }

    public void print() {
        Node cursor = this.head;
        for(int i = 0; i < size(); i++) {
            System.out.println(cursor);
            cursor = cursor.getNext();
        }
    }

    private int size() {
        if (this.head == null) {
            return 0;
        }
        Node cursor = this.head;
        int c = 0;
        while(cursor.getNext() != this.head) {
            c++;
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
        
    }






}

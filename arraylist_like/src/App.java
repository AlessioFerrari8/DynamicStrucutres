public class App {
    public static void main(String[] args) throws Exception {
        Node head = new Node(0);
        Node two = new Node(1);
        head.setNext(two);
        Node three = new Node(2);
        two.setNext(three);
        CustomList c = new CustomList(head);
        c.print();

        Node four = new Node(54);
        c.append(four);
        c.print();
        
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // Node head = new Node(0);
        // Node two = new Node(1);
        // head.setNext(two);
        // Node three = new Node(2);
        // two.setNext(three);
        // CustomList c = new CustomList(head);
        // c.print();

        // Node four = new Node(54);
        // c.append(four);
        // c.print();

        // Node added = new Node(4);
        // c.add(0, added);
        // c.print();
        
        // added = new Node(5);
        // c.add(4, added);
        // c.print();


        // c.remove(0);
        // c.print();

        // System.out.println(c.contains(new Node(57)));
        // System.out.println(c.contains(new Node(0)));
        // System.out.println(c.contains(new Node(4)));
        // System.out.println(c.contains(new Node(88)));

        // c.set(0, new Node(100));
        // c.print();

        // c.set(4, new Node(25));
        // c.print();

        // c.set(4, null);
        // c.print();

        CircularList c = new CircularList(new Node(0), new Node(54));
        c.print();
        c.printRec();

        
    }
}

import java.util.HashSet;

public class KthToLast {
    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);

        head.appendToEnd(2);
        head.appendToEnd(3);
        head.appendToEnd(4);
        head.appendToEnd(5);
        head.appendToEnd(6);
        head.appendToEnd(7);
        head.appendToEnd(8);
        head.appendToEnd(9);
        head.appendToEnd(10);

        System.out.println(kthToLast(head, 3).value);
    }

    public static Node<Integer> kthToLast(Node<Integer> head, int k) {
        Node<Integer> p1 = head;
        Node<Integer> p2 = head;

        for(int i = 0; i < k; i++) {
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
        

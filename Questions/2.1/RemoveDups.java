import java.util.HashSet;

public class RemoveDups {
    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);

        head.appendToEnd(5);
        head.appendToEnd(1);
        head.appendToEnd(2);
        head.appendToEnd(2);
        head.appendToEnd(4);
        head.appendToEnd(4);

        System.out.println("before removing duplicates:");
        printList(head);
        removeDups(head);
        System.out.println("after removing duplicates:");
        printList(head);
    }

    public static void removeDups(Node<Integer> head) {
        Node<Integer> n = head;
        HashSet<Integer> hashSet = new HashSet<Integer>();

        Node<Integer> prev = null;
        while(n != null) {
            if(hashSet.contains(n.value)) {
                prev.next = n.next;
            } else {
                hashSet.add(n.value);
                prev = n;
            }
            n = n.next;
        }
    }

    public static void printList(Node<Integer> head) {
        Node<Integer> x = head;

        while(x != null) {
            System.out.print(x.value + " ");
            x = x.next;
        }

        System.out.println();
    }
}
        

/**
 * A singly linked list which does not allow duplicates
 *
 * @author Michael Thomson
 */

public class LinkedList_No_Duplicates<K,V> {
    Node head;

    /**
     * A member of a singly linked list containing a key, value pair
     */
    class Node {
        K key;
        V value;
        Node next;
        
        /**
         * constructor for a node
         *
         * @param key key value
         * @param value value to be mapped to the key
         * @param next reference to next node in the list
         */
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * constructor for a linked list
     */
    public LinkedList_No_Duplicates() {
        head = null;
    }

    /**
     * finds the node in the linked list with the given key and returns it
     *
     * @param key key to search for
     * @return the node asociated with the given key
     */
    public Node find(K key) {
        Node x;
        for(x = head; x != null && x.key != key; x = x.next);
        return x;
    }

    /**
     * returns the value associated to the given key
     *
     * @param key key to look up
     * @return value associated to the key
     */
    public V get(K key) {
        Node x = find(key);
        return x.value;
    }

    /**
     * appends the given key, value pair to the start of the linked list
     *
     * @param key key value to be inserted
     * @param value value to be inserted with the key
     */
    public void appendToStart(K key, V value) {
        if(find(key) != null) {
            return;
        }

        if(head != null) {
            Node newNode = new Node(key, value, head);
            this.head = newNode;
        } else {
            Node newNode = new Node(key, value, null);
            this.head = newNode;
        }
    }

    /**
     * appends the given key, value pair to the end of the linked list
     *
     * @param key key value to be inserted
     * @param value value to be inserted with the key
     */
    public void appendToEnd(K key, V value) {
        if(find(key) != null) {
            return;
        }

        Node x;
        if(head != null) {
            for(x = head; x.next != null; x = x.next);
            x.next = new Node(key, value, null);
        } else {
            head = new Node(key, value, null);
        }
    }
    
    /**
     * deletes the node with the given key from the linked list
     *
     * @param key key value to be deleted from the list
     */
    public void delete(K key) {
        if(head == null) {
            return;
        } else if(head.key == key) {
            head = head.next;
            return;
        }
        
        Node x;
        for(x = head; x.next != null && x.next.key != key; x = x.next);

        x.next = x.next.next;
    }


    /**
     * returns the linked list in a string representation of the form:
     * {(k1,v1),(k2,v2),...,(kn,vn)}
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for(Node x = head;x != null; x = x.next) {
            stringBuilder.append("(" + x.key.toString() + "," + x.value.toString() + ")");
            if(x.next != null) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    /**
     * helper function to show functionality
     */
    public static void main(String[] args) {
        LinkedList_No_Duplicates<Integer, String> linkedList = new LinkedList_No_Duplicates<Integer, String>();

        linkedList.appendToEnd(1, "duplicate");
        linkedList.appendToStart(2, "foo");
        linkedList.appendToEnd(5, "lorem");
        linkedList.appendToStart(1, "duplicate");

        linkedList.delete(2);

        System.out.println(linkedList.toString());
    }

}

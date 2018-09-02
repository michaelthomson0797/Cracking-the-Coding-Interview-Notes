/**
 * A doubly linked list which allows duplicates
 *
 * @author Michael Thomson
 */

public class LinkedList_Duplicates_Double<K,V> {
    Node head;

    /**
     * A member of a doubly linked list containing a key, value pair
     */
    class Node {
        K key;
        V value;
        Node next;
        Node prev;
        
        /**
         * constructor for a node
         *
         * @param key key value
         * @param value value to be mapped to the key
         * @param next reference to next node in the list
         * @param prev reference to previous node in the list
         */
        public Node(K key, V value, Node next, Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * constructor for a linked list
     */
    public LinkedList_Duplicates_Double() {
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
        for(x = head; x.key != key && x != null; x = x.next);
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
        if(head != null) {
            Node newNode = new Node(key, value, head, null);
            head = newNode;
        } else {
            Node newNode = new Node(key, value, null, null);
            head = newNode;
        }
    }

    /**
     * appends the given key, value pair to the end of the linked list
     *
     * @param key key value to be inserted
     * @param value value to be inserted with the key
     */
    public void appendToEnd(K key, V value) {
        Node x;
        if(head != null) {
            for(x = head; x.next != null; x = x.next);
            x.next = new Node(key, value, null, x);
        } else {
            head = new Node(key, value, null, null);
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
            head.prev = null;
            return;
        }
        
        Node x = find(key);
        x.prev.next = x.next;
        x.next.prev = x.prev;
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
        LinkedList_Duplicates<Integer, String> linkedList = new LinkedList_Duplicates<Integer, String>();

        linkedList.appendToEnd(1, "duplicate");
        linkedList.appendToStart(2, "foo");
        linkedList.appendToEnd(5, "lorem");
        linkedList.appendToStart(1, "duplicate");

        linkedList.delete(2);

        System.out.println(linkedList.toString());
    }

}

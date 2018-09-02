/**
 * A member of a singly linked list containing a key, value pair
 */
public class Node<K,V> {
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

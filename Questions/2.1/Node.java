/**
 * A member of a singly linked list containing a key, value pair
 */
public class Node<T> {
    public T value;
    public Node<T> next;
        
    /**
     * constructor for a node
     *
     * @param key key value
     * @param value value to be mapped to the key
     * @param next reference to next node in the list
     */
    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Appends to the end of the list attached to this node
     *
     * @param value value of node to be inserted
     */
    public void appendToEnd(T value) {
        Node<T> x = this;

        while(x.next != null) {
            x = x.next;
        }

        x.next = new Node<T>(value);
    }
}

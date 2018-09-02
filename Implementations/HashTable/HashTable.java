import java.util.ArrayList;

public class HashTable<K,V> {
    private ArrayList<LinkedList<K,V>> table;
    private int size;

    public HashTable(int size) {
        this.table = new ArrayList<LinkedList<K,V>>(size);
        for(int i = 0; i < size; i++) {
            table.add(new LinkedList<K,V>());
        }
        this.size = size;
    }

    private int hash(K key) {
        return key.hashCode() % size;
    }

    public boolean contains(K key) {
        return table.get(hash(key)).find(key) != null;
    }

    public void insert(K key, V value) {
        int index = hash(key);

        table.get(index).appendToStart(key, value);
    }

    public V get(K key) {
        int index = hash(key);

        return table.get(index).find(key).value;
    }

    public void delete(K key) {
        int index = hash(key);

        table.get(index).delete(key);
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        for(int i = 0; i < size; i++) {
            string.append(table.get(i).toString() + "\n");
        }

        return string.toString();
    }

    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<Integer, String>(31);

        table.insert(0, "hello");
        table.insert(2, "goodbye");
        table.insert(5, "test");
        table.insert(31, "foo");

        table.delete(5);

        System.out.print(table.toString());
    }

}


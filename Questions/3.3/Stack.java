import java.util.*;

public class Stack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        if(isFull()) throw new StackOverflowError();
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

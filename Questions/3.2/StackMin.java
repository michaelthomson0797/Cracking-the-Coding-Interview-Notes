import java.util.*;

public class StackMin<T extends Comparable<T>> {
    private static class StackNode<T> {
        private T data;
        private T min;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.min = min() == null || item.compareTo(min()) < 0 ? item : min();
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

    public T min() {
        if(top == null) return null;
        else return top.min;
    }

    public static void main(String[] args) {
        StackMin<Integer> stack = new StackMin<Integer>();

        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);

        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());

    }
}

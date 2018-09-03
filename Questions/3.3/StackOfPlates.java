import java.util.*;
public class StackOfPlates<T> {
    ArrayList<Stack<T>> stacks;
    private int capacity;
    private int currentStack;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<Stack<T>>();
        stacks.add(new Stack<T>(capacity));
        currentStack = 0;
    }

    public void push(T item) {
        if(stacks.get(currentStack).isFull()) {
            currentStack++;
            stacks.add(new Stack<T>(capacity));
        }
        stacks.get(currentStack).push(item);
    }

    public T pop() {
        if (stacks.get(currentStack).isEmpty()) {
            currentStack--;
        }
        return stacks.get(currentStack).pop();
    }

    public static void main(String[] args) {
        StackOfPlates<Integer> stackOfPlates = new StackOfPlates<Integer>(5);
        
        for(int i = 0; i < 10; i++) {
            stackOfPlates.push(i);
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(stackOfPlates.pop());
        }
    }
}

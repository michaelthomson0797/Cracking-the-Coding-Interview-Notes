# Arrays and Strings

## Hash Tables
* A hash table is a data structure which maps keys to values for highly efficent lookup
* There are many ways to do this, but here is a common simple implementation:
* To insert a key and value, we do the following:
    1. First, compute the key's hash code, which will usually be an int or long.
    2. then, map the hash code to an index in the array. This could be done with something like hash(key) % array_length
    3. At this index, there is a linked list of keys and values. Store the key and value in this index. 

* To find an element, simply find the index and search the linked list
* if the number of collisions is very high, the worst case running time is O(N). Best case, with no collisions, is O(1)
* Alternitavely, we can implement the hash table with a balanced binary search tree. this would have an O(log N) lookup time

## ArrayList and Resizable Arrays
* When you need an array-like data structure that offers dynamic resizing, you would use an ArrayList.
* An ArrayList is an array that resizes itself as needed while proving O(1) access. A typical implementation is that when the array is full, the array doubles in size.
* Each doubling takes O(n) time, but happens rarely enough

```Java
ArrayList<String> merge(String[] words, String[] more) {
    ArrayList<String> sentence = new ArrayList<String>();
    for (String w : words) sentence.add(w);
    for (String w : more) sentence.add(w);
    return sentence;
}
```

* This is an essential data structure for interviews.

## StringBuilder
* Suppose you wish to concatenate a list of strings into one string, one possible solution is the following:

```Java
String joinWords(String[] words) {
    String sentence = "";
    for (String w : words) {
        sentence = sentence + w;
    }
    return sentence;
}
```

* on each concatention, a new copy is created, and the two strings are copied.
* The first iteration requires us to copy x characters, the next requires 2x and so on
* This results in a time complexity of O(xn^2)
* StringBuilder can help this problem. StringBuilder simply creates a resizeable array of strings, copying them back to a string only when necessary.

```Java
String joinWords(String[] words) {
    StringBuilder sentence = new StringBuilder();
    for(String w : words) {
        sentence.append(w);
    }
    return StringBuilder.toString();
}
```
# Stacks and Queues

## Implementing a Stack

* The stack data structure is precisely what it sounds like: a stack of data
* A stack uses LIFO (Last in first out) ordering. It uses the following operations:
    * pop(): Remove the top item of the stack
    * push(item): add an item on top of the stack
    * peek(): return the top of the stack
    * isEmpty(): return true if the stack is empty
* A sample implementation:

```java
public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next
        return item;
    }

    public void push(T item) {
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
}
```

## Implementing a Queue

* A queue implements FIFO (first-in first-out) ordering. As in a line or queue at a ticket stand
* It uses the following operations:
    * add(item): add item to the end of the list
    * remove() remove the first item in the list
    * peek(): return the top of the queue
    * isEmpty(): returns true if the queue is empty
* A queue can be implemented as a linked list:

```java
public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> t = new QueueNode<T>(item);
        if(last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
```

# Trees and Graphs

## Types of Trees
* A nice way of to understand a tree is with a recursive explanation. A tree is a data structure composed of nodes
    * each tree has a root node
    * The root node has zero or more child nodes
    * each child node has zero or more child nodes and so on
* The tree cannot contain cycles
* A very simple definition for a Node is:

```java
class Node {
    public String name;
    public Node[] children;
}
```

* Tree and graph questions are rife with ambiguous details and incorrect assumptions. Be sure to watch out for the following issues and seek clarification if necessary.

### Trees vs. Binary Trees
* A binary tree is a tree which each node has up to 2 children. Not all trees are binary trees
* Some trees use more children than 2

### Binary Tree vs. Binary Search Tree
* A bunary search tree is a binary tree in which every node fits a specific ordering property
* An example is that the left child is always less than the root and the right node is more than the root.

### Balanced vs Unbalanced
* A balanced tree is not a perfect tree (see below), but more like a "not terribly imbalanced" tree
* It is balanced enough to ensure O(log n) times for insert and find.
* Two common types of balanced trees are red-black trees and AVL trees

### Complete Binary Tree
* A binary tree in which every level of the tree is fully filled, except for perhaps the last level

### Full Binary Tree
* A binary tree in which every node has zero or two children

### Perfectly Balanced Tree
* a tree that is both full and complete

## Binary Tree Traversal
* Prior to the interview, you should be comfortable implementing an in-order, post-order, and pre-order traversal

### In-Order Traversal
* In-Order traversal means to "visit" the left branch, then the current node, then the right branch

```java
void inOrderTraversal(TreeNode node) {
    if(node != null) {
        inOrderTraversal(node.left);
        visit(node);
        inOrderTraversal(node.right);
    }
}
```

* When performing on a binary search tree, it visits the nodes in ascending order

### Pre-Order Traversal
* Pre-Order traversal visits the current node before its child nodes

```java
void preOrderTraversal(TreeNoden node) {
    if(node != null) {
        visit(node);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}
```

* in pre-order, the root is always the first node visites

### Post-Order Traversal
* Post-order traversal visits the current node after its child nodes

```java
void postOrderTraversal(TreeNode node) {
    if (node != null) {
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        visit(node);
    }
}
```

* in post-order traversal, the root is always the last node to be visited

## Binary Heaps
* A min-heap is a complete binary tree where each node is smaller than its children
* The root, therefore, is the minimum element in the tree
* We have two key operations on a min-heap: insert and min_heap

### insert
* When we insert into a min-heap, we always start by inserting the element at the bottom at the rightmost spot.
* Then we "fix" the tree by swapping the new element with its parent, until we find an appropriate spot for the element
* This takes O(log n) time, where n is the number of nodes in the tree

### Extract Minimum Element
* The minimum element of a heap is the root
* First, we remove the minimum element and swap it with the last element in the heap. Then, we bubble down this element, swapping it wit one of its children until the min-heap property is restored.
* when deciding one swapping with the left or right element, take the smaller to keep the min-heap ordering
* This takes O(log n) time

## Tries (Prefix Trees)
* A trie is a variant of an n-ary tree in which characters are stored at each node. each path down the tree may represent a word
* The * nodes (sometimes called null nodes) are often used to indicate complete words
* A node in a trie could have anywhere from 1 through ALPHABET_SIZE + 1 (1 for the null node)

## Graphs
* A Graph is simply a collection of nodes with edges between them
* Graphs can be either directed or undirected. While directed edges are like a one ways treet, undirected is likes a two way street
* The graph may consist of multiple isolated subgraphs. If there is a path between every set of vertices, it is called a connected graph
* A graph can also have cycles, otherwise it is acyclic
* In terms of programming, there are two common ways of representing a graph

### Adjacency list
* This is the most common way to represent a graph. Every vertex (or node) stores a list of adjacent vertices
* A simple class definition could look essentially the same as a tree node:

```java
class Graph {
    public Node[] nodes;
}

class Node {
    public String name;
    public Node[] children;
}
```

### Adjacency Matrix
* An adjacency matrix is an NxN matrix where a true value at matrix\[i\]\[j\] indicated an edge from node i to j
* This is generally less efficient for searching because with a list it is easy to iterate throught the neighbors, whereas a matrix must iterate through all nodes to see if they are a neighbor

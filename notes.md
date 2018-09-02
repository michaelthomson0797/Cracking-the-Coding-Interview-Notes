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

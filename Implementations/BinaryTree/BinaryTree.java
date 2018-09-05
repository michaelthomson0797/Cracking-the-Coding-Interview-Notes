class Node {
    public int id;
    public Node left;
    public Node right;

    public Node(int id) {
        this.id = id;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    public Node insert(Node root, int id) {
        if (root == null) return new Node(id);
        
        if(id < root.id) {
            root.left = insert(root.left, id);
        } else {
            root.right = insert(root.right, id);
        }

        return root;
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.id);
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(5);

        root = tree.insert(root, 3);
        root = tree.insert(root, 2);
        root = tree.insert(root, 1);
        root = tree.insert(root, 4);
        root = tree.insert(root, 8);
        root = tree.insert(root, 7);
        root = tree.insert(root, 6);
        root = tree.insert(root, 9);

        tree.inOrderTraversal(root);
    }
}


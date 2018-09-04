import java.util.*;

class Node {
    public int id;
    public boolean visited;
    public List<Edge> connections;

    public Node(int id) {
        this.id = id;
        connections = new ArrayList<Edge>();
        this.visited = false;
    }
}

class Edge {
    public Node start;
    public Node end;
    //public double weight; Activate if you need weights

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
    }
}

public class Graph {
    private Map<Integer, Node> nodes;
    int numNodes = 0;

    public Graph() {
        nodes = new HashMap<Integer, Node>();
        numNodes = 0;
    }
    
    public void addNode() {
        nodes.put(numNodes, new Node(numNodes));
        numNodes++;
    }

    public void addEdge(int start, int end) {
        if(nodes.containsKey(start) && nodes.containsKey(end)) {
            Node a = nodes.get(start);
            Node b = nodes.get(end);

            a.connections.add(new Edge(a, b));
        } else {
            throw new NullPointerException();
        }
    }

    private void visit(Node n) {
        System.out.println(n.id);
    }

    public void depthFirstSearch(int rootid) {
        Node root = nodes.get(rootid);
        if(root == null) return;
        visit(root);
        root.visited = true;
        for(Edge e : root.connections) {
            if(e.end.visited == false) {
                depthFirstSearch(e.end.id);
            }
        }

    }

    public void breadthFirstSearch(int rootid) {
        Node root = nodes.get(rootid);
        if(root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        root.visited = true;
        queue.add(root);

        while(!queue.isEmpty()) {
            Node r = queue.remove();
            visit(r);
            for(Edge e : r.connections) {
                if(e.end.visited == false) {
                    e.end.visited = true;
                    queue.add(e.end);
                }
            }
        }
    }

        

    public void printGraph() {
        for(int i = 0; i < numNodes; i++) {
            Node n = nodes.get(i);

            System.out.print(n.id + ": ");

            for(Edge e : n.connections) {
                System.out.print(e.end.id + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);

        //graph.depthFirstSearch(0);
        graph.breadthFirstSearch(0);
    }



}

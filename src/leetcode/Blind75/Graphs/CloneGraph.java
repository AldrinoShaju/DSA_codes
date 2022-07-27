package leetcode.Blind75.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with
 * val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the
 * set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a
 * reference to the cloned graph.
 */
public class CloneGraph {
    public static void main(String[] args) {

    }

    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node newNode = new Node(node.val);
        newNode.neighbors = new ArrayList<>();
        map.put(node.val, newNode);
        for(Node n: node.neighbors){
            newNode.neighbors.add(cloneGraph(n));
        }

        return newNode;
    }
}

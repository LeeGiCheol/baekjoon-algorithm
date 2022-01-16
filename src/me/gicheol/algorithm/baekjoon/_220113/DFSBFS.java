package me.gicheol.algorithm.baekjoon._220113;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSBFS {

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        graph.dfs(0);
    }

}

class Graph {

    class Node {

        int data;

        LinkedList<Node> ajacent;

        boolean marked;


        public Node(int data) {
            this.data = data;
            this.marked = false;
            ajacent = new LinkedList<>();
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i, int j) {
        Node n1 = nodes[i];
        Node n2 = nodes[j];

        if (!n1.ajacent.contains(n2)) {
            n1.ajacent.add(n2);
        }
        if (!n2.ajacent.contains(n1)) {
            n2.ajacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node node : r.ajacent) {
                if (!node.marked) {
                    node.marked = true;
                    stack.push(node);
                }
            }

            visit(r);
        }
    }

    private void visit(Node n) {
        System.out.print(n.data + " ");
    }

    void bfs() {
        bfs(0);
    }

     void bfs(int index) {
         Node root = nodes[index];
         Queue<Node> queue = new LinkedList<>();
         queue.add(root);
         root.marked = true;

         while (!queue.isEmpty()) {
             Node r = queue.poll();
             for (Node node : r.ajacent) {
                 if (!node.marked) {
                     node.marked = true;
                     queue.add(node);
                 }
             }

             visit(r);
         }

     }

     void dfsR(Node r) {
        if (r == null) return;
        r.marked = true;
        visit(r);

         for (Node node : r.ajacent) {
             if (!node.marked) {
                 dfsR(node);
             }
         }
     }

     void dfsR(int index) {
         Node r = nodes[index];
         dfsR(r);
     }

     void dfsR() {
        dfsR(0);
     }

}

package com.varmints.algos;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }


    public void bfs(int head) {
        boolean[] visitedNodes = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.print(" " + node);
            visitedNodes[node] = true;
            Iterator<Integer> it = adj[node].iterator();
            while (it.hasNext()) {
                Integer neighbours = it.next();
                if (!visitedNodes[neighbours]) {
                    visitedNodes[neighbours] = true;
                    queue.add(neighbours);
                }
            }
        }
    }

    public void DFS(int v) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (!visited[i])
                DFSUtil(it.next(), visited);
        }
    }



}

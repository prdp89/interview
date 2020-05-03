package com.interview.leetcode.graph;

import java.util.*;

public class NumOfOperationNwConnected {

    private static int[] rank;

    //https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    public static void main( String[] args ) {
        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        int n = 6;

        System.out.println(makeConnected(n, connections));
    }

    private static int makeConnected( int n, int[][] connections ) {
        //connections are edges to connect N vertices
        if (connections.length < n - 1)
            return -1;

        //Runtime: 43 ms, faster than 16.28% of Java
        // return bfs(n, connections);

        return unionFind(n, connections);
    }

    //region BFS way..
    //Runtime: 43 ms, faster than 16.28% of Java
    //similar to RedudantConnections
    private static int bfs( int n, int[][] connections ) {
        //create a graph like FlowerPlanting
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i <= connections.length; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : connections) {
            //Undirected graph
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int component = 0;
        Set<Integer> visited = new HashSet<>();

        //As compare to RedudantConnections, we are here looking for Number of N connections needed
        //so here, we are iterating for all N nodes..
        for (int i = 0; i < n; i++) {
            component += traverse(i, visited, map);
        }

        return component - 1;
    }

    private static int traverse( int i, Set<Integer> visited, HashMap<Integer, Set<Integer>> map ) {

        //if two vertices already connect, no need to traverse
        if (visited.contains(i))
            return 0;

        visited.add(i);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        while (!queue.isEmpty()) {
            int currEdge = queue.poll();

            //same as tree BFS
            for (int edge : map.get(currEdge)) {
                if (visited.contains(edge))
                    continue;

                visited.add(edge);
                queue.offer(edge);
            }
        }

        return 1; //returning one unique connection bw edge
    }
    //endregion

    //region UNION-FIND way..
    //similar to ConnectCityMinCost
    //Runtime: 4 ms, faster than 79.45% of Java
    private static int unionFind( int n, int[][] connections ) {
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = i;
        }

        int minConnections = n;
        for (int i = 0; i < n; i++) {
            rank[i] = i;
        }

        for (int[] con : connections) {
            //in this problem Vertices is Zero based index..
            if (findParent(con[0]) != findParent(con[1])) {
                union(con[0], con[1]);

                //only these number of connections needed..
                minConnections--;
            }

        }

        return minConnections - 1;
    }

    private static void union( int a, int b ) {
        rank[findParent(b)] = findParent(a);
    }

    private static int findParent( int p ) {
        if (rank[p] != p) {
            rank[p] = findParent(rank[p]);
        }

        return rank[p];
    }
    //endregion
}

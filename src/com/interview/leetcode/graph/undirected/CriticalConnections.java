package com.interview.leetcode.graph.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {

    private static int time = 0; // time when discover each vertex

    //https://leetcode.com/problems/critical-connections-in-a-network/
    public static void main( String[] args ) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0, 1));
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(2, 0));
        list.add(Arrays.asList(1, 3));

        criticalConnections(4, list).forEach(System.out::println);
    }

    //We record the timestamp that we visit each node.
    // For each node, we check every neighbor except its parent and return a smallest timestamp in all its neighbors.
    //
    // If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle.
    // Otherwise, this edge from the parent to this node is a critical connection

    //https://leetcode.com/problems/critical-connections-in-a-network/discuss/382632/Java-implementation-of-Tarjan-Algorithm-with-explanation
    private static List<List<Integer>> criticalConnections( int n, List<List<Integer>> connections ) {
        //low[u] records the lowest vertex u can reach
        //disc[u] records the time when u was discovered

        int[] disc = new int[n], low = new int[n];

        // use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();

        Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // build graph
        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, res, i);
            }
        }

        return res;
    }

    //video: https://www.youtube.com/watch?v=aZXi1unBdJA
    private static void dfs( int u, int[] low, int[] disc, List<Integer>[] graph,
                             List<List<Integer>> res, int pre ) {
        disc[u] = low[u] = ++time; // discover u

        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);

            if (v == pre) {
                continue; // if parent vertex, ignore
            }

            if (disc[v] == -1) { // if not discovered
                dfs(v, low, disc, graph, res, u);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    res.add(Arrays.asList(u, v));
                }
            } else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}

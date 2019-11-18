package com.interview.codechef.ccdsap_2.atcoder.educationalDPContest;

import java.util.ArrayList;
import java.util.Scanner;

//question  : https://atcoder.jp/contests/dp/tasks/dp_g
public class LongestPath {

    //Video : Directed Acyclic Graph and its application : https://www.youtube.com/watch?v=TXkDpqjDMHA
    //Notes : Follow axis bank diary
    //sample: https://github.com/williamfiset/Algorithms/blob/master/com/williamfiset/algorithms/graphtheory/TopologicalSortAdjacencyList.java

    //This algo. is similar to com.interview.graph.TopologicalSort

    //AtCoder sample Ref: https://atcoder.jp/contests/dp/submissions/8128802

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);

        //N vertices and M edges
        int n = in.nextInt();
        int m = in.nextInt();

        //max vertices..
        final int max_node = 100005;

        int[] dist = new int[max_node];
        ArrayList[] edges = new ArrayList[max_node];

        int[] in_degree = new int[max_node];
        boolean[] visited = new boolean[max_node];

        for (int i = 0; i < max_node; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        //collecting edges and its vertices
        for (int i = 0; i < m; ++i) {

            int x = in.nextInt();
            int y = in.nextInt();

            in_degree[y]++;

            edges[x].add(y);
        }

        LongestPath graph = new LongestPath();

        for (int i = 1; i <= n; i++) {
            if (visited[i] == false && in_degree[i] == 0) {
                graph.dfs(i, edges, visited, in_degree, dist);
            }
        }

        int answer = 0;
        for (int i = 1; i < max_node; ++i) {
            if (dist[i] > answer) {
                answer = dist[i];
            }
        }

        System.out.println(answer);
    }

    private void dfs( int node, ArrayList<Integer>[] edges, boolean[] visited, int[] in_degree, int[] dist ) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int edge : edges[node]) {

            in_degree[edge]--;

            dist[edge] = Math.max(dist[edge], dist[node] + 1);

            if (in_degree[edge] == 0) {
                dfs(edge, edges, visited, in_degree, dist);
            }
        }
    }
}
package com.interview.leetcode.graph.undirected;

import java.util.*;

public class PossibleBipartition {

    //https://leetcode.com/problems/possible-bipartition/
    public static void main( String[] args ) {
        int[][] graph = {
                {1, 2},
                {1, 3},
                {2, 4}
        };
        System.out.println(possibleBipartition(4, graph));
    }

    //Runtime: 31 ms, faster than 44.46% of Java
    //Almost same as GraphBipartite
    private static boolean possibleBipartition( int N, int[][] graph ) {
        //In GraphBipartite : Graph[i] has all neighbours of ith Node but in this problem Node is distributed
        //So we have to maintain HashMap

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        //1 based indexing bcz Node value starts from 1
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        //creating graph..
        for (int[] nodes : graph) {
            map.get(nodes[0]).add(nodes[1]);
            map.get(nodes[1]).add(nodes[0]);
        }

        //now same as GraphBipartite
        int[] visited = new int[N + 1];


        for (int i = 1; i <= N; i++) {

            if (visited[i] == 0) {

                //assign a unique color to Root node
                visited[i] = 1;

                Queue<Integer> queue = new LinkedList<>();
                //storing index for each Graph[i] = {1,2}
                //i represent ith vertex or node and Graph[i] are neighbours
                //ith node has {1,3} neighbours..
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int root = queue.poll();

                    //for each neighbour of i Node, we'll color neighbour = 2 if i = 1
                    for (int neighbour : map.get(root)) { //...............only DIFF.........................

                        //if not visited
                        if (visited[neighbour] == 0) {
                            visited[neighbour] = visited[root] == 1 ? 2 : 1;
                            queue.offer(neighbour);
                        } else { //if not and neighbour has same color
                            if (visited[neighbour] == visited[root])
                                return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

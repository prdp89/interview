package com.interview.leetcode.graph.undirected;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {

    //https://leetcode.com/problems/is-graph-bipartite/
    public static void main( String[] args ) {

        //for diagram only: https://www.youtube.com/watch?v=mVmXwFkgoJ0&t=355s
        int[][] graph = {
                {1, 3}, //zeroth vertex or node have to neighbours {1,3}
                {0, 2},
                {1, 3},//2nd vertex or node have to neighbours {1,3}
                {0, 2}
        };

        System.out.println(isBipartite(graph));
    }

    //TIME : O (V + E)
    //Runtime: 1 ms, faster than 74.68% of Java

    //THis problem is similar to FlowerPlanting , a graph coloring problem.
    //But instead, here we fill the Graph by only 2 colors : 1 or 2
    //Eg: {{1,3}, {1,2}} if 1 is a root node, it will get filled with color =1
    //    and its neighbours {3,2} should be filled with color = 2

    //If, in any case we found a Node and its neighbours having same color, then we can't bipartite a Graph
    private static boolean isBipartite( int[][] graph ) {

        // 0(not visited), 1(black), 2(white)
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (graph[i].length != 0 && visited[i] == 0) {

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
                    for (int neighbour : graph[root]) {

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

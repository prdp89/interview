package com.interview.leetcode.graph;

import java.util.*;

public class RedudantConnection {

    //https://leetcode.com/problems/redundant-connection/
    public static void main( String[] args ) {
        /*int[][] arr = {
                {1, 2},
                {1, 3},
                {2, 3},
        };*/

        int[][] arr = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5},
        };

        //System.out.println(Arrays.toString(findRedundantConnection(arr)));

        System.out.println(Arrays.toString(findRedundantConnectionBFS(arr)));
    }

    //Runtime: 23 ms, faster than 5.15% of Java
    //We can use BFS to detect cycle in an undirected graph in O(V+E) time.
    //https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-bfs/?ref=rp
    private static int[] findRedundantConnectionBFS( int[][] edges ) {

        //create a graph like FlowerPlanting
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= edges.length; i++) {
            map.put(i, new HashSet<>());
        }

        //Adding the Edges
       /* for (int[] edge : edges) {
            //Undirected graph
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }*/

        return bfs(map, edges);
    }

    private static int[] bfs( HashMap<Integer, Set<Integer>> map, int[][] edges ) {
        //for each edge checking how many edges are connected to it..
        for (int[] edge : edges) {

            int from = edge[0], to = edge[1];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(from);

            Set<Integer> visited = new HashSet<>();
            visited.add(from);

            while (!queue.isEmpty()) {

                int currEdge = queue.poll();

                /*
                //Think like this: while creating a graph we connected 1-->2 and 2-->1 undirected-ly
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);

                //Now if we find any vertices of 1 eg. (2) again connected to 1 that means a cycle.
                //Eg. : [[1,2], [1,3], [2,3]]
                //1-->2 and 1-->3
                //2-->1
                //3-->1
                //And last: 2-->3,
                            3 --->2
                //see: 2-->3 but already 3-->1 that forms a cycle.


                 */
                if (map.get(currEdge).contains(to)) {
                    return edge;
                }

                //like normal BFS, storing all connected edges of a vertex
                for (int w : map.get(currEdge)) {
                    //to prevent a cycle or duplicate work
                    if (visited.contains(w))
                        continue;

                    queue.add(w);
                    visited.add(w);
                }
            }

            //adding it later to iterate and check for each Vertex..
            map.get(from).add(to);
            map.get(to).add(from);
        }

        return new int[]{-1, -1};
    }


    //9 test cases passed out of 63
    //Bcz a Graph may be independently connected with other vertices.
    //Below algo. consider only InDegree in Directed Graph.

    //Reason : Arr = [[1,4],[3,4],[1,3],[1,2],[4,5]]
    //My Output: {3, 4}
    //Expected op: {1, 3}
    private static int[] findRedundantConnection( int[][] edges ) {

        int[] arr = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            arr[edges[i][1]]++;

            if (arr[edges[i][1]] > 1) {
                return new int[]{
                        edges[i][0], edges[i][1]
                };
            }
        }

        return new int[]{0, 0};
    }
}
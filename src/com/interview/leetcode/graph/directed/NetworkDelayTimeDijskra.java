package com.interview.leetcode.graph.directed;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTimeDijskra {

    //https://leetcode.com/problems/network-delay-time/
    public static void main( String[] args ) {
      /*  int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int N = 4, K = 2;*/

        int[][] times = {
                {1, 2, 1},
                {2, 1, 3}
        };
        int N = 2, K = 2;

        System.out.println(networkDelayTime(times, N, K));
    }

    //Runtime: 26 ms, faster than 51.94% of Java
    //This logic is similar to CheapestFlight: Dijskra Algo implementation
    private static int networkDelayTime( int[][] times, int N, int K ) {
        List<List<Pair>> graph = new ArrayList<>();
        buildGraph(graph, times, N);

        PriorityQueue<Tour> pq = new PriorityQueue<>(( a, b ) -> a.costFrmSrc - b.costFrmSrc);
        pq.offer(new Tour(K, 0));

        //this is really necessary, without it only 9/50 test case passed..
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Tour tour = pq.poll();

            int curCost = tour.costFrmSrc;
            int curNode = tour.currCity;

            if (visited[curNode])
                continue;

            visited[curNode] = true;

            N--;
            if (N == 0) {
                return curCost;
            }

            List<Pair> list = graph.get(curNode);

            if (null != list && !list.isEmpty())
                for (Pair pair : list) {
                    pq.offer(new Tour(pair.city, pair.cost + curCost));
                }
        }

        return -1;
    }

    private static void buildGraph( List<List<Pair>> graph, int[][] times, int n ) {
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] flight : times) {
            //flight[0] = src, flight[1] = dest, flight[2] = cost
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
    }

    private static class Tour {
        int currCity, costFrmSrc;

        Tour( int currCity, int costFrmSrc ) {
            this.currCity = currCity;
            this.costFrmSrc = costFrmSrc;
        }
    }

    private static class Pair {
        int city, cost;

        Pair( int city, int cost ) {
            this.city = city;
            this.cost = cost;
        }
    }
}

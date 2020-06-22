package com.interview.leetcode.graph.directed;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlight {

    //https://leetcode.com/problems/cheapest-flights-within-k-stops/
    public static void main( String[] args ) {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        int src = 0, dst = 2, k = 1, n = 3;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    //Runtime: 8 ms, faster than 66.82% of Java online
    private static int findCheapestPrice( int n, int[][] flights, int src, int dst, int K ) {
        List<List<Pair>> graph = new ArrayList<>();
        buildGraph(graph, flights, n);

        //only diff. from CourseSchedule is we are using PQ here...
        //sort acc. to min cost bw cities..
        PriorityQueue<Tour> pq = new PriorityQueue<>(( a, b ) -> a.costFrmSrc - b.costFrmSrc);
        pq.offer(new Tour(src, 0, 0));

        while (!pq.isEmpty()) {
            Tour tour = pq.poll();

            if (tour.currCity == dst) {
                return tour.costFrmSrc;
            }

            if (tour.distanceFromSrc > K) {
                continue;
            }

            //fetching adjacent neighbours and updating the cost..
            List<Pair> neighbours = graph.get(tour.currCity);
            for (Pair neighbour : neighbours) {
                //tour.distanceFromSrc + 1 : incrementing K stops
                pq.offer(new Tour(neighbour.city, tour.distanceFromSrc + 1,
                        tour.costFrmSrc + neighbour.cost));
            }
        }

        return -1;
    }

    private static void buildGraph( List<List<Pair>> graph, int[][] flights, int n ) {
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] flight : flights) {
            //flight[0] = src, flight[1] = dest, flight[2] = cost
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
    }

    private static class Tour {
        int currCity, distanceFromSrc, costFrmSrc;

        Tour( int currCity, int distanceFromSrc, int costFrmSrc ) {
            this.currCity = currCity;
            this.costFrmSrc = costFrmSrc;
            this.distanceFromSrc = distanceFromSrc;
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

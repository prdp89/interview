package com.interview.leetcode.contests._new_weekely.weekely197;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathMaxProbability {

    //https://leetcode.com/contest/weekly-contest-197/problems/path-with-maximum-probability/
    public static void main( String[] args ) {
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] prob = {0.5, 0.5, 0.2};
        int start = 0, end = 2, n = 3;

        System.out.println(maxProbability(n, edges, prob, start, end));
    }

    //This is Dijskra Implementation, as : CheapestFlight
    private static double maxProbability( int n, int[][] edges, double[] succProb, int start, int end ) {
        List<List<Pair>> graph = new ArrayList<>();
        buildGraph(graph, edges, n, succProb);

        //Without this it returns TLE
        double[] probs = new double[n];  // best prob so far for each node

        PriorityQueue<Tour> pq = new PriorityQueue<>(( a, b ) -> Double.compare(b.probFrmSrc, a.probFrmSrc));
        pq.offer(new Tour(start, 1.0)); //default probability initialize with 1.0

        while (!pq.isEmpty()) {
            Tour tour = pq.poll();

            if (tour.currCity == end) {
                return tour.probFrmSrc;
            }

            //fetching adjacent neighbours and updating the prob..
            List<Pair> neighbours = graph.get(tour.currCity);
            for (Pair neighbour : neighbours) {

                // add to pq only if: it can make a better probability
                if (probs[neighbour.city] >= tour.probFrmSrc * neighbour.probability)
                    continue;

                pq.offer(new Tour(neighbour.city,
                        tour.probFrmSrc * neighbour.probability));

                probs[neighbour.city] = tour.probFrmSrc * neighbour.probability;
            }
        }

        return 0;
    }

    private static void buildGraph( List<List<Pair>> graph, int[][] edges, int n, double[] succProb ) {
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        //since this is Undirected graph we have to link both Nodes below
        for (int i = 0; i < edges.length; i++) {
            //flight[0] = src, flight[1] = dest, succProb[2] = prob.
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
    }

    private static class Tour {
        int currCity;
        double probFrmSrc;

        Tour( int currCity, double probFrmSrc ) {
            this.currCity = currCity;
            this.probFrmSrc = probFrmSrc;
        }
    }

    private static class Pair {
        int city;
        double probability;

        Pair( int city, double probability ) {
            this.city = city;
            this.probability = probability;
        }
    }
}

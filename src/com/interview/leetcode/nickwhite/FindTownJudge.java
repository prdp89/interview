package com.interview.leetcode.nickwhite;

public class FindTownJudge {

    //https://leetcode.com/problems/find-the-town-judge/
    public static void main( String[] args ) {
       /* int[][] arr = {
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3},
        };

        int N = 4;*/

        int[][] arr = {
                {1, 2},
                {2, 3}
        };

        int N = 3;

        System.out.println(findJudge(N, arr));
    }

    /*
    Consider trust as a graph, all pairs are directed edge.
    The point with in-degree - out-degree = N - 1 become the judge.
     */
    //https://leetcode.com/problems/find-the-town-judge/discuss/242938/JavaC%2B%2BPython-Directed-Graph
    private static int findJudge( int N, int[][] trust ) {
        int[] count = new int[N + 1];
        for (int[] item : trust) {

            //this person trusting other, so his counter get decrease
            count[item[0]]--;

            //this person trusting other,so other's counter get increase
            count[item[1]]++;
        }

        //if there are N person including a Judge and,
        //Everyone trust the Judge, so Judge trust index count
        //will be N - 1 {out of N people the N-1 trusting him }

        for (int i = 1; i <= N; i++) {
            if (count[i] == N - 1)
                return i;
        }

        return -1;
    }
}
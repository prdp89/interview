package com.interview.codechef.ccdsap_2.leetcode.bfs;

import java.util.*;

public class JumpGameIII {

    //https://leetcode.com/problems/jump-game-iii/
    public static void main( String[] args ) {
       /* int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int target = 5; //op = true*/

        int[] arr = {3, 0, 2, 1, 2};
        int target = 2; //op = false

        System.out.println(bfsSolution(arr, target));
    }

    //Runtime: 1 ms, faster than 35.45% of Java o
    private static boolean bfsSolution( int[] arr, int start ) {

        //adding start point to traverse
        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));

        //visited to avoid recursive traversal
        Set<Integer> seen = new HashSet<>(q);

        while (!q.isEmpty()) {

            int cur = q.poll();

            if (arr[cur] == 0)
                return true;

            //we have 2 possible choices to traverse at each item : {index -arr[i]} and {index + arr[i]}
            for (int child : new int[]{cur - arr[cur], cur + arr[cur]}) {
                if (child >= 0 && child < arr.length && seen.add(child))
                    q.offer(child);
            }
        }

        return false;
    }
}

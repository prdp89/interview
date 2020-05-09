package com.interview.leetcode.contests.biweekly.biweekely22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CinemaSeatAllocation {

    //https://leetcode.com/problems/cinema-seat-allocation/
    public static void main( String[] args ) {
        int[][] reservedSeats = {
                {1, 2},
                {1, 3},
                {1, 8},
                {2, 6},
                {3, 1},
                {3, 10}
        };

        System.out.println(maxNumberOfFamilies(3, reservedSeats));
    }

    //similar to DiagonalTraverseII
    //https://leetcode.com/problems/cinema-seat-allocation/discuss/546445/Java-Process-rows-which-have-at-least-one-seat-reserved
    private static int maxNumberOfFamilies( int n, int[][] reservedSeats ) {
        int m = reservedSeats.length, ans = 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {

            //storing row index as Key
            if (!map.containsKey(reservedSeats[i][0]))
                map.put(reservedSeats[i][0], new HashSet<>());

            //storing each column value as allocated index for a row..
            map.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
        }

        //ans += 2 * n - 2 * map.size();

        Set<Integer> keys = map.keySet();

        for (Integer i : keys) {
            boolean flag = false;

            HashSet<Integer> reserved = map.get(i);

            //checking consecutive seats..
            if (!reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4) && !reserved.contains(5)) {
                ans++;
                flag = true;
            }

            if (!reserved.contains(6) && !reserved.contains(7) && !reserved.contains(8) && !reserved.contains(9)) {
                ans++;
                flag = true;
            }

            if (!flag && !reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6) && !reserved.contains(7))
                ans++;
        }

        return ans;
    }
}

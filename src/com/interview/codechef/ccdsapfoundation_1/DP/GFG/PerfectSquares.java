package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfectSquares {

    //https://leetcode.com/problems/perfect-squares/
    public static void main( String[] args ) {
        //Method-1
        //System.out.println(numSquares(13));

        //Method-2 -- easier recurrence to understand
        System.out.println(dfs(13, 0, 13));
    }

    private static int numSquares( int n ) {
        List<Integer> list = new ArrayList<>();

        for (int i = (int) Math.round(Math.sqrt(n)); i > 0; i--) { //same as prime-sieve of prime numbers
            if (i * i <= n)
                list.add(i * i);
        }
        return dfs(list, n, new HashMap<>());
    }

    private static int dfs( List<Integer> list, int num, Map<Integer, Integer> cache ) {

        if (num == 0) {
            return 0;
        }
        if (cache.containsKey(num))
            return cache.get(num);

        int min = Integer.MAX_VALUE;
        for (int i : list) {
            if (i > num)
                continue;

            int level = dfs(list, num - i, cache);
            if (level < min)
                min = level;
        }
        min = min == Integer.MAX_VALUE ? min : min + 1;
        cache.put(num, min);
        return min;
    }

    //This is an easiest recurrence to understand
    //This recurrence pattern is similar as : GroupSum : Hacakerrank-> recursion -> advance
    private static int dfs( int n, int level, int min ) {

        if (n == 0 || level >= min) return level; //returns only number of perfect squares

        for (int i = (int) Math.sqrt(n); i > 0; i--) {  //Math.sqrt = same as prime-sieve of prime numbers

            min = dfs(n - ((int) Math.pow(i, 2)), level + 1, min);

        }
        return min;
    }
}

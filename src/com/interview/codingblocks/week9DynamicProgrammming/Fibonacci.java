package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;
import java.util.Comparator;

public class Fibonacci {

    //this array compute 1000 fibonacci numbers
    private static int[] memo = new int[1000];

    public static void main( String[] args ) {

        Arrays.fill(memo, -1);
        System.out.println(fib(6));
    }

    //This runs in O( N )
    private static int fib( int num ) {

        if (num == 0) return 0;
        if (num == 1) return 1;

        //if number is already computed, return from Memo array
        if (memo[num] != -1)
            return memo[num];

        int ans = fib(num - 1) + fib(num - 2);

        //saving already computed Nth fibonacci number
        memo[num] = ans;
        return ans;
    }
}


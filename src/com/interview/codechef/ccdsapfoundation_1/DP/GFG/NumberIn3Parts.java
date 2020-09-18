package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class NumberIn3Parts {

    //https://www.geeksforgeeks.org/recursively-break-number-3-parts-get-maximum-sum/
    public static void main( String[] args ) {
        System.out.println(recurse(12));
    }

    private static int recurse( int num ) {

        // base conditions
        if (num == 0 || num == 1)
            return num;

        // recursively break the number and return
        // what maximum you can get

        /*
        we can get maximum sum by breaking number in parts or number is itself maximum.
         */
        return Math.max((recurse(num / 2) + recurse(num / 3) +
                recurse(num / 4)), num);
    }
}

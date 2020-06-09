package com.interview.leetcode.dp.lis;

import java.util.Arrays;

public class RussianDollEnvelopes {

    //https://leetcode.com/problems/russian-doll-envelopes/
    public static void main( String[] args ) {
        int[][] envelopes = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        System.out.println(maxEnvelopes(envelopes));
    }

    //Runtime: 242 ms, faster than 27.43% of Java
    private static int maxEnvelopes( int[][] envelopes ) {

        if (envelopes.length == 0)
            return 0;

        //After sorting, we have envelopes :
        // [2, 3] [5, 4] [6, 7] [6, 4]

        Arrays.sort(envelopes, ( a, b ) -> {
            if (a[0] == b[0]) { //if both width are same

                //from example: {{6,4} {6,7}}
                //Now both Width are same : 6 == 6
                //we have to sort acc. to Height, otherwise it will be counted as an increasing number if the order is [6, 4], [6, 7]

                //So it must be: {6,4} {6,7}
                return b[1] - a[1]; //decreasing order of height
            } else {
                return a[0] - b[0]; //increasing order of width
            }
        });

        int[] dp = new int[envelopes.length];
        int max = 1;

        //same logic as LIS
        for (int i = 0; i < envelopes.length; i++) {

            dp[i] = 1;
            for (int j = 0; j < i; j++) {

                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

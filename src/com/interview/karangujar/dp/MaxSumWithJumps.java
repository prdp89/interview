package com.interview.karangujar.dp;

public class MaxSumWithJumps {

    /*We start at index- ‘1’ of the array and strictly end our
    journey at index- ’N’ . We can make jumps of length “1” or “2” .
    We have to find a journey with maximum sum.

    Example Array :- {1,-1,100,-11,200,300}

    Our Optimal(Best) Journey :- 1 — ->(jump of length-2)100 —
            ->(jump of length-2)200 →(jump of length-1)300

    Hence, Maximum Sum=1+100+200+300=601.
    */

    public static void main( String[] args ) {
        int[] arr = {1, -1, 100, -11, 200, 300}; //op : 601
        System.out.println(bottomUpDP(arr));
    }

    private static int bottomUpDP( int[] arr ) {
        int[] dp = new int[arr.length];

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[2] + dp[1], arr[2] + dp[0]);

        for (int i = 3; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 1], arr[i] + dp[i - 2]);
        }

        return dp[arr.length - 1];
    }
}

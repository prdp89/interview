package com.interview.karangujar.dp;

public class LongestIncreasingSubseq {

    //dp-tutorial -6 in gmail : pdf file present
    public static void main( String[] args ) {
        //int[] arr = {2, 1, 3, 0, 5, 7}; //op : 4 => {1, 3, 5, 7}
        int[] arr = {5, 8, 3, 7, 9, 1}; //op = 3 => {5, 8, 9}

        System.out.println(lisBottomUp(arr));
    }

    private static int lisBottomUp( int[] arr ) {
        //{2, 1, 3, 0, 5, 7}

        //if array has only one element =>  {2} : LIS => 1 , dp[0] = 1

        //if array has only two elements =>  {2, 1} :
        //  1. if curr is smaller than previous {2, 1} : then LIS => 1
        //  2. if curr will be greater than previous {1, 2} then LIS would be => 2
        //  for now: dp[1] = 1

        //if array has 3 elements => {2, 1, 3} then :
        // 1. The longest increasing sub-sequence till index “2” of array= 1 + The
        //    longest increasing sub-sequence till index “j” of array
        // 2. We always starts with j = 0 bcz curr a[2] elements can be bigger than any of previous array elements.
        // 3. So, a[2] > a[0] => LIS will be dp[2] : dp[0] + step_to_reach_curr_element => 1 + dp[0]
        // 4. Again, a[2] > a[1] => LIS will be dp[2]: dp[1] + step_to_reach_curr_element => 1 + dp[1]

        int[] dp = new int[arr.length];

        dp[0] = 1;
        dp[1] = arr[1] > arr[0] ? 2 : 1;

        int i = 2;

        while (i < arr.length) {

            //in worst case, LIS till index i should be : 1
            int max = 1;

            int j = 0;

            dp[i] = max;

            //For each arr[i] : looping till its previous
            while (j <= i - 1) {

                //just maintaining extra max till index j.
                if (arr[i] > arr[j])
                    dp[i] = max = Math.max(max, 1 + dp[j]);

                j++;
            }

            i++;
        }

        //one edge case:
        //last array element arr[length] will be smaller than previous. We have to find longest of all
        //So , just finding max out of all dp array:

        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < dp.length; j++)
            ans = Math.max(ans, dp[j]);

        return ans;
    }
}

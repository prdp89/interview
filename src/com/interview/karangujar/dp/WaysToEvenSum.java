package com.interview.karangujar.dp;

public class WaysToEvenSum {

    //Dp tutorial - 7

    /*
    How many journeys are possible which will give you an even sum ?

    A journey is described as : You start at index- ‘0’ of the array and
    reach at index- ’N’ of the array. At each point, you are allowed to
    make jumps of length- ‘1’ or ‘2’ .

    Example-Array:- {3,3,7,2,3,4,5}

    One of the possible-journey:- { 3 →(jump of size-2) 7 →(jump of size-2)3 →(jump of size-1)4 →(jump of size-1) 5 }
     */

    public static void main( String[] args ) {

        int[] arr = {3, 3, 7, 2, 3, 4, 5};
        System.out.println(bottomUpDP(arr));
    }


    /*
    Now, lets define dp[i] as :-
    “dp[i] means number of journeys which will give an even sum if you start at index- ‘0’ and stop at index- ‘i’ ”

    Also,lets define dp1[i] as:-
    “dp1[i] means number of journeys which will give an odd sum if you start at index- ‘0’ and stop at index- ‘i’ ”
     */

    /*
    Also, remember this:-
    Odd-Number + Odd-Number = Even-Number
    Odd-Number + Even-Number = Odd-Number
    Even-Number + Even-Number = Even-Number
     */
    private static int bottomUpDP( int[] arr ) {

        int[] dp = new int[arr.length + 1];
        int[] dp_1 = new int[arr.length + 1];

        //arr = {3, 3, 7, 2, 3, 4, 5}

        //arr = {3}
        //dp[0] : means how many ways to get even sum if array has only one element. No way bcz 3 is odd, so:
        //dp[0] = 0
        //---------------------------
        //dp_1[1] : means how many ways to get odd sum if array has only one element. 1 way : use 3, so:
        //dp_1[1] = 1

        //arr = {3, 3}
        //dp[1] = number of ways to get even sum if we start at index 1 and reach till 0.
        //        see the current arr[1] = is odd and we have to make Jump of 1
        //        so odd + odd = even, we can pick the way from dp_1[i-1]
        //dp[1] = dp_1[i-1] = 1
        //------------------------------
        //dp_1[1] = number of ways to get odd sum if we start at index 1 and reach till 0.
        //          see the current arr[1] = is odd and we have to make Jump of 1.
        //          if we include 3 + 3 = this is even number only
        //          we need to pick result from dp[i-1]
        //dp_1[1] = dp[i-1]


        if (arr[0] % 2 == 0) {
            dp_1[0] = 0;
            dp[0] = 1;
        } else {
            dp_1[0] = 1;
            dp[0] = 0;
        }

        //checking for 2nd array element
        if (arr[1] % 2 == 0) {
            dp[1] = dp[0];
        }

        if (arr[1] % 2 != 0) {
            dp[1] = dp_1[0];
        }

        if (arr[1] % 2 == 0) {
            dp_1[1] = dp_1[0];
        }

        if (arr[1] % 2 != 0) {
            dp_1[1] = dp[0];
        }

        int i = 2;

        while (i < arr.length) {

            if (arr[i] % 2 == 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            if (arr[i] % 2 != 0) {
                dp[i] = dp_1[i - 1] + dp_1[i - 2];
            }
            if (arr[i] % 2 == 0) {
                dp_1[i] = dp_1[i - 1] + dp_1[i - 2];
            }
            if (arr[i] % 2 != 0) {
                dp_1[i] = dp[i - 1] + dp[i - 2];
            }

            i++;
        }

        return dp[arr.length - 1];
    }
}

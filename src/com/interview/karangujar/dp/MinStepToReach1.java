package com.interview.karangujar.dp;

public class MinStepToReach1 {

    /*
    We are given a number ‘x’, we want to reduce it to ‘1’ in minimum number of steps
    possible!! At each step, we are allowed to :

    1)Decrement the given number by ‘1’……..(i)
    2)Decrement the given number by ‘2’
    ………..(ii)
    3)Divide the given number by ‘7’ only if it is
    divisible by ‘7’……..(iii)
     */

    /*
    Explanation:
    1. how many steps does it take to reduce ‘2’ to ‘1’???
    Ans : 1 => dp[2] = 1

    2. how many steps does it take to reduce ‘3’ to ‘1’???
    Ans : 3 => 3 - 2 = 1 , dp[3] = 1

    3. how many steps does it take to reduce ‘4’ to ‘1’???
    Ans : 4 => 4 - 2 : 2, then 2 -1 : 1 , total : 2 steps , so dp[4] = 2

    4. how many steps does it take to reduce ‘5’ to ‘1’???
    Ans. Two options : a. 5 - 1 = 4 ; means jumping from 5..4 took one step and dp[4] = 2, so total => 2 + 1; how: dp[4] + 1
                       b. 5 - 2 = 3 ; means jumping from 5..3 took one step and dp[3] = 1, so total => 1 + 1; how: dp[3] + 1
    */
    public static void main( String[] args ) {

        int n = 10;

        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        for (int i = 5; i <= n; i++) {

            //one extra step to check for divide by 7
            if (i % 7 == 0) {
                dp[i] = Math.min(Math.min(dp[i / 7] + 1, dp[i - 1] + 1), dp[i - 2] + 1);
            } else {
                dp[i] = Math.min(1 + dp[i - 1], 1 + dp[i - 2]);
            }
        }

        System.out.println(dp[n]);

        //https://stackoverflow.com/questions/40695701/sort-the-array-with-absolute-value-only-and-show-real-value
    /* int[] arr = {9, -2, 10, 3, -5, 34, -22, 7};

        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            array[i] = arr[i];

        Arrays.sort(array, ( a, b ) -> (Integer.compare(Math.abs(a), Math.abs(b))));

        for (int i = 0; i < arr.length; i++)
            arr[i] = array[i];

        System.out.println(Arrays.toString(arr));*/
    }
}

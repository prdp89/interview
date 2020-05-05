package com.interview.leetcode.contests.contest179;

public class BulbSwitcherIII {

    //https://leetcode.com/problems/bulb-switcher-iii/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(numTimesAllBlue(arr));
    }

    //Step1: All bulbs are arranged in row : 1..2..3..4..5
    //arr = { 2, 1, 3, 5, 4 }
    //At moment 0: we can turn ON arr[0] = 2, check step1: 2 is in 2nd position and no Left Bulb is ON; So 2 turn yellow first.
    //At moment 1: we can turn ON arr[1] = 1, check step1: 1 is in 1st position and there's NO left bulb,
    //             so first bulb turn ON at moment = 1, parallel-y 2 can ON since left bulbs are ON already.

    //60 / 63 test cases passed. //done by me :)
    private static int numTimesAllBlue( int[] light ) {

        long sum = 0;
        int res = 0;

        for (int i = 0; i < light.length; i++) {
            sum += light[i];

            if (i > 0) {
                //if all bulbs are ON 1..N then sum will be equal to current index i formula..
                int temp = i + 1; //bcz of zero based index
                long nRangeSum = (temp * (temp + 1)) / 2;

                res += ((int) nRangeSum == sum) ? 1 : 0;
            } else if (sum == i + 1) { //if first bulb is ON and i == 0
                res++;
            }
        }

        return res;
    }

    //Runtime: 1 ms, faster than 100.00% of Java
    //Acc to @lee's logic
    private static int numTimesAllBlueOptimal( int[] A ) {
        int right = 0, res = 0, n = A.length;

        for (int i = 0; i < n; ++i) {

            right = Math.max(right, A[i]);

            //this is same as above mine logic
            //means all previous bulbs are ON if max buld maintain till now equals to index.
            if (right == i + 1)
                ++res;
        }

        return res;
    }
}
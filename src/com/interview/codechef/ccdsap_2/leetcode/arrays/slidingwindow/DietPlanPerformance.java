package com.interview.codechef.ccdsap_2.leetcode.arrays.slidingwindow;

public class DietPlanPerformance {

    //https://leetcode.com/contest/weekly-contest-152/problems/diet-plan-performance/

    /*
    A dieter consumes calories[i] calories on the i-th day. For every consecutive sequence of k days, they look at T, the total calories consumed during that sequence of k days:

    If T < lower, they performed poorly on their diet and lose 1 point;
    If T > upper, they performed well on their diet and gain 1 point;
    Otherwise, they performed normally and there is no change in points.
    Return the total number of points the dieter has after all calories.length days.

    Note that: The total points could be negative.

    Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
    Output: 0
    Explanation: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.

    calories[1] + calories[2] == upper : no point gain
     */

    public static void main( String[] args ) {
      /*  int[] calories = {1, 2, 3, 4, 5};
        int k = 1, lower = 3, upper = 3;*/

        int[] calories = {6, 13, 8, 7, 10, 1, 12, 11};
        int k = 6, lower = 5, upper = 37;

        // System.out.println(dietPlanPerformance(calories, k, lower, upper));

        System.out.println(dietPlanPerformanceOptimalSlidingWindow(calories, k, lower, upper));
    }

    //10 / 27 test cases passed.
    //Question asking for :  For every consecutive sequence of k days;
    // from each day we have to calculate for next K consecutive days.

    //brute force : https://leetcode.com/problems/diet-plan-performance/discuss/371894/Simple-java-implementation
    private static int dietPlanPerformance( int[] calories, int k, int lower, int upper ) {

        int points = 0;
        for (int i = 0; i < calories.length; ) {

            int sum = 0, temp = k;
            while (temp-- > 0 && i < calories.length) {
                sum += calories[i++];
            }

            if (sum < lower) {
                points--;
            } else if (sum > upper)
                points++;

            if (calories.length - i < k) {
                points += calories.length - i;
                break;
            }
        }

        return points;
    }


    //correct implementation for every consecutive sequence of k days
    private static int dietPlanPerformanceOptimalSlidingWindow( int[] calories, int k, int lower, int upper ) {

        int point = 0;
        int i = -1, totalCalories = 0;

        for (int j = 0; j < calories.length; ++j) {
            totalCalories += calories[j];

            //slide window from Start if number of days are greater than K
            if (j - i > k) {
                totalCalories -= calories[++i]; //++i helps in decrement first element from Start.
            }

            if (j - i < k) { // not a k sequence yet.
                continue;
            }

            //same as my logic..only execute when days == k
            if (totalCalories < lower) {
                --point;
            } else if (totalCalories > upper) {
                ++point;
            }
        }

        return point;
    }
}

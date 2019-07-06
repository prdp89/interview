package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

public class ShipPackagesWithinDDays {

    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    //This problem is same to BookAllocation

    //Detailed Explanation: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/256765/Python-Binary-search-with-detailed-explanation
    /*The intuition for this problem, stems from the fact that

    a) Without considering the limiting limiting days D, if we are to solve, the answer is simply max(a)
    b) If max(a) is the answer, we can still spend O(n) time and greedily find out how many partitions it will result in.

            [1,2,3,4,5,6,7,8,9,10], D = 5

    For this example, assuming the answer is max(a) = 10, disregarding D,
    we can get the following number of days:
            [1,2,3,4] [5] [6] [7] [8] [9] [10]

    So by minimizing the capacity shipped on a day, we end up with 7 days, by greedily choosing the packages for a day limited by 10.

    ---------------------------------------------

    Imp. LIne : To get to exactly D days and minimize the max sum of any partition,
    we do binary search in the sum space which is bounded by [max(a), sum(a)]

    Binary Search Update:
    One thing to note in Binary Search for this problem, is even if we end up finding a weight,
    that gets us to D partitions, we still want to continue the space on the minimum side,
    because, there could be a better minimum sum that still passes <= D partitions.
    In the code, this is achieved by:

            if res <= d:
                hi = mid
    */

    public static void main( String[] args ) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5; //op = 15

        /*
        A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
        1st day: 1, 2, 3, 4, 5
        2nd day: 6, 7
        3rd day: 8
        4th day: 9
        5th day: 10
         */

        System.out.println(shipWithinDays(weights, D));
    }

    private static int shipWithinDays( int[] weights, int d ) {

        int lo = getMax(weights);
        int hi = getSum(weights);

        while (lo < hi) {

            int capacity = (lo + hi) >>> 1; // avoid overflow. same as (lo + hi) / 2

            int requiredDays = getRequiredDays(weights, capacity);

            if (requiredDays <= d) {
                hi = capacity; //or mid
            } else {
                lo = capacity + 1;
            }
        }
        return lo;
    }

    private static int getRequiredDays( int[] weights, int maxCapacity ) {
        int requiredDays = 1;
        int capacity = 0;

        for (int weight : weights) {

            capacity += weight;

            if (capacity > maxCapacity) {
                requiredDays++;

                //re-initialize capacity for next set of Loads
                capacity = weight;
            }
        }

        return requiredDays;
    }

    private static int getSum( int[] arr ) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    private static int getMax( int[] arr ) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        return max;
    }
}
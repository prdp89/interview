package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Arrays;

public class PairOfRoses {

    /*
    Deepak has limited amount of money which he can spend on his girlfriend. So he decided to buy two roses
    for her. Since roses are of varying sizes, their prices are different. Deepak wishes to completely spend
    that fixed amount of money on buying roses. As he wishes to spend all the money, he should choose a pair
    of roses whose prices when summed up are equal to the money that he has. Help Deepak choose such a pair of
    roses for his girlfriend.

    NOTE: If there are multiple solutions print the solution that minimizes the difference between the prices
    i and j. After each test case you must print a blank line.

    Input Format:
    First line indicates the number of test cases. Then, in the next line, the number of available roses,
    N is given. Next line will have N integers, representing the price of each rose, a rose costs less than
    1000001. Then there is another line with an integer M, representing how much money Deepak has.
    There is a blank line after each test case.

    Sample Input
    2
    2
    40 40
    80

    5
    10 2 6 8 4
    10

    Sample Output
    Deepak should buy roses whose prices are 40 and 40.
    Deepak should buy roses whose prices are 4 and 6.
     */
    public static void main( String[] args ) {

        int[] arr = {10, 2, 6, 8, 4};
        int totalSpending = 10;

       /* int[] arr = {40, 40};
        int totalSpending = 80;*/

        Arrays.sort(arr);
        buildPairWithMinPriceDiff(arr, totalSpending, 0, arr.length - 1);
    }

    private static void buildPairWithMinPriceDiff( int[] arr, int totalSpending, int start, int end ) {

        int ans = 0, startValue = 0, endValue = 0;

        if (arr.length <= 2) {
            System.out.println("Deepak should buy roses whose prices are " + arr[start] + " and " + arr[end] + ".");
            return;
        }

        while (start <= end) {

            int mid = (start + end) / 2;
            if (arr[start] + arr[end] <= totalSpending) {

                ans = Math.abs(Math.min(ans, arr[start] - arr[end]));
                start = mid + 1;

                startValue = arr[start];
                endValue = arr[end];

            } else if (arr[start] + arr[end] > totalSpending) {
                end = mid - 1;
            }
        }

        System.out.println("Deepak should buy roses whose prices are " + startValue + " and " + endValue + ".");
    }
}

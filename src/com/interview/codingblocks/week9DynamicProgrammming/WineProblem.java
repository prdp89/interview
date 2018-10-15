package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;

public class WineProblem {

    private static int[][] memo = new int[1000][1000];

    //Given an array denoting wine bottle prices = {1, 4 ,2 , 3}
    //If we sell bottle 1 : a[0] = 1 in first year = 1; we got 1 * 1 = 1 profit
    //We have to maximize the profit by selling all wine bottles.
    //We can only sell the bottles from first and last index of array.

    // Possible combinations:
    //First year : we sell a[0] = 1 * 1 = 1 profit. NOw arr = {4, 2, 3}
    //Second year: we sell a[2] = 3(last bottle) * 2(2nd year) = 6 profit , now arr = {4, 2}
    //Third year : we sell a[1] = 2(last bottle) * 3(3rd year) = 6 profit, now arr = { 4 }
    //Fourth year: we sell a[0] = 4 (last bottle) * 4 (4th year) = 16 profit
    //Total profit : 1 + 6 + 6 + 16 = 29

    //  year        Profit      Total
    //   1            1          1 * 1
    //   2            3          3 * 2
    //   3            2          2 * 3
    //   4            4          4 * 4
    // ~~~~~~~~~~~~~~~~~~       --------
    //             Total Profit : 29
    // ~~~~~~~~~~~~~~~~~~       --------
    private static int countMemoCalls = 0;

    //region Recursive Approach
    private static int countRecursiveCalls = 0;

    //Reference: search for Wine in page
    //https://www.hackerearth.com/practice/notes/dynamic-programming-i-1/
    //Video link:
    //https://www.youtube.com/watch?v=eSDa4iauLbo
    public static void main( String[] args ) {
        // failedApproach();

        // solveRecursive();
        // solveTopDownMemoization();
    }

    //endregion

    //This first approach compares Left and Right and find minimum of two and sell it.
    //But this strategy also fails for input arr[] = {2, 3, 5 , 1, 4} = 49 = {2 * 1 + 3 * 2 + 4 * 3 + 1 * 4 + 5 * 5}
    //but answer = 50 {p1, p5, p4, p2, p3} = {2* 1 + 4 * 2 + 1 * 3 + 3 * 4 + 5 * 5 = 50 }
    private static void failedApproach() {
        //int[] arr = {1, 4, 2, 3};

        int[] arr = {2, 3, 5, 1, 4};

        //we cannot sort the array; order may change;
        //we have to sell the bottle at extreme array end(first or last)
        //Arrays.sort(arr);

        int length = arr.length - 1, year = 1, profit = 0;
        for (int i = 0; i <= length; ) {

            if (arr[i] >= arr[length]) {
                profit = profit + arr[length] * year;
                length--;
            } else {
                profit = profit + arr[i] * year;
                i++;
            }

            year++;
        }

        System.out.println(profit);
    }

    //using recursion to solve this..
    private static void solveRecursive() {
        int[] arr = {2, 3, 5, 1, 4}; //output should be 50

        System.out.println("output : " + maxProfit(arr, 0, arr.length - 1, 1) + " calls : " + countRecursiveCalls);
    }

    //we are branching two times at each level : O ( 2 ^ N )
    private static int maxProfit( int[] arr, int begining, int end, int year ) {

        ++countRecursiveCalls;

        //if begin cross the end range.
        if (begining > end)
            return 0;

        //          start selling from beg                  incr. beg. to recurse          incr. year for next rec.
        int query1 = arr[begining] * year + maxProfit(arr, begining + 1, end, year + 1);

        //          selling from end                            decr. the end     inr. the year
        int query2 = arr[end] * year + maxProfit(arr, begining, end - 1, year + 1);

        int ans = Math.max(query1, query2);
        return ans;

    }

    //region Memoization Approach : Or Top Down DP
    //Time complexity  : O( N ^ 2 )
    private static void solveTopDownMemoization() {
        int[] arr = {2, 3, 5, 1, 4}; //output should be 50

        // Fill each row with -1
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("output : " + maxProfitMemoization(arr, 0, arr.length - 1, 1) + " calls : " + countMemoCalls);
    }

    private static int maxProfitMemoization( int[] arr, int begining, int end, int year ) {

        ++countMemoCalls;

        //if begin cross the end range.
        if (begining > end)
            return 0;

        //return from Memo Array
        if (memo[begining][end] != -1)
            return memo[begining][end];

        //          start selling from beg                  incr. beg. to recurse          incr. year for next rec.
        int query1 = arr[begining] * year + maxProfitMemoization(arr, begining + 1, end, year + 1);

        //          selling from end                            decr. the end     inr. the year
        int query2 = arr[end] * year + maxProfitMemoization(arr, begining, end - 1, year + 1);

        int ans = Math.max(query1, query2);

        //save value in memo cache
        memo[begining][end] = ans;

        return ans;
    }
    //endregion

    //https://www.youtube.com/watch?v=eSDa4iauLbo
    private void solveBottomUpDp() {
        //Todo: write program after complete understanding....
    }
}

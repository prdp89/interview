package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class MaxSumNoTwoAdjacentElements {

    //https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

    //This problem is same as HouseRober: https://leetcode.com/problems/house-robber/#
    public static void main( String[] args ) {
       /* Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            int[] dp = new int[n + 1];

            Arrays.fill(dp, -1);

            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            System.out.println(maxSum(arr, n - 1, dp));
        }*/

       /* int grid[][] = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}}; //op : 24 {6, 8, 10}

        maxSumGrid(grid, 5);*/


        int grid[][] = {{1, 4, 5},
                {2, 0, 0}};

        maxSumGrid(grid, 3);
    }

    //fOR FASTER solution check : MaxSumForNonAdjacentElements
    private static int maxSum( int[] arr, int index, int[] dp ) {

        if (index == 0) {
            return arr[0];
        } else if (index == 1) {
            return Math.max(arr[0], arr[1]);
        }

        if (dp[index] != -1)
            return dp[index];

        //if we are at arr[index] the next element we pick is index - 2
        //otherwise exclude and recurse.
        return dp[index] = Math.max(maxSum(arr, index - 2, dp) + arr[index]
                , maxSum(arr, index - 1, dp));
    }


    //https://www.geeksforgeeks.org/maximum-sum-2-x-n-grid-no-two-elements-adjacent/
    private static void maxSumGrid( int grid[][], int n ) {
        //if (n == 0) return 0;

        int max_sum = 0, sum;

        //selecting Column wise
        for (int i = 0; i < n; i++) {

            sum = _maxSumGrid(grid, i, n);

            max_sum = Math.max(max_sum, sum);
        }

        System.out.println(max_sum);
    }

    private static int _maxSumGrid( int grid[][], int i, int n ) {

        //same as maxsum func above : if we reach end of grid, we have two options : 1st or 2nd row
        if (i == n - 1) return Math.max(grid[0][i], grid[1][i]);

        if (i >= n) return 0;

        //_maxSumGrid(grid, i + 2, n) + grid[0][i] : choosing current element of first row and recurse on grid[0][i+2] right element of it.
        //_maxSumGrid(grid, i + 2, n) + grid[1][i] : choosing current element of second row and recurse on grid[0][i+2] right element of it.
        return Math.max(_maxSumGrid(grid, i + 2, n) + grid[0][i]
                , _maxSumGrid(grid, i + 2, n) + grid[1][i]);
    }
}
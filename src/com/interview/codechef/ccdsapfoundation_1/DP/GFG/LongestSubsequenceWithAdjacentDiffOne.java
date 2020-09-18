package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class LongestSubsequenceWithAdjacentDiffOne {

    //https://www.geeksforgeeks.org/longest-subsequence-such-that-difference-between-adjacents-is-one/
    public static void main( String[] args ) {

        //to calculate LIS in my way
        //System.out.println(LISMine(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80, 6}, 0, 0));

        /*Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        Arrays.fill(dp, -1);

        System.out.println(LISAdjacentOne(arr, 0, 0, dp));*/

        //System.out.println(LISAdjacentOne(new int[]{10, 9, 4, 5, 4, 8, 6}, 0, 0));

        System.out.println(LISAdjacentOne(new int[]{1, 2, 3, 2, 3, 7, 2, 1}, 8));
    }

    //LIS works perfectly with inclusion-exclusion recurrence pattern
    private static int LISMine( int[] arr, int index, int prevElement ) {

        if (arr.length == index && arr[index - 1] > prevElement)
            return 1;

        if (arr.length == index)
            return 0;

        int include = arr[index] > prevElement ? 1 + LISMine(arr, index + 1, arr[index]) : 0;
        int exclude = LISMine(arr, index + 1, prevElement);

        return Math.max(include, exclude);
    }

    //This recursion pattern fails on some cases
    private static int LISAdjacentOne( int[] arr, int index, int prevElement ) {

        if (arr.length == index && Math.abs(arr[index - 1] - prevElement) == 1)
            return 1;

        if (arr.length == index)
            return 0;

        int include = Math.abs(arr[index] - prevElement) == 1 ? 1 + LISAdjacentOne(arr, index + 1, arr[index]) : 0;

        int exclude = LISAdjacentOne(arr, index + 1, prevElement);

        return Math.max(include, exclude);
    }

    /*
        This recursion pattern works fine with this problem
     */

    private static int LISAdjacentOne( int arr[], int n ) {
        int temp, m = 0;

        for (int i = 0; i < n; i++) {

            temp = _lisRecursive(arr, i);

            if (temp > m)
                m = temp;
        }
        return m;
    }

    private static int _lisRecursive( int arr[], int n ) {

        if (n == 0) return 1;

        int m = 1;

        for (int i = 0; i < n; i++) {

            //we just need to think for one case, rest recursion will come up with.
            if (Math.abs(arr[i] - arr[n]) == 1) {
                int temp = 1 + _lisRecursive(arr, i);

                if (temp > m)
                    m = temp;
            }
        }
        return m;
    }
}
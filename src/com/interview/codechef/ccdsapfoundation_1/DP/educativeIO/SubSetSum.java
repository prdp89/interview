package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

public class SubSetSum {

    //https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

    //Almost similar to https://codingbat.com/prob/p145416 except one Greater that element array element condition.
    public static void main( String[] args ) {

        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;

        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    //Add memoization for DP
    private static boolean isSubsetSum( int set[],
                                        int n, int sum ) {
        // Base Cases
        if (sum == 0)
            return true;

        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSum(set, n - 1, sum) ||
                isSubsetSum(set, n - 1, sum - set[n - 1]);
    }
}

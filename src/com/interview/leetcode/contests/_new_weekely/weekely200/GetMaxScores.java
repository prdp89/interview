package com.interview.leetcode.contests._new_weekely.weekely200;

public class GetMaxScores {

    //https://leetcode.com/contest/weekly-contest-200/problems/get-the-maximum-score/
    public static void main( String[] args ) {
        int[] a = {2, 4, 5, 8, 10};
        int[] b = {4, 6, 8, 9};

        System.out.println(maxSum(a, b));
    }

    //BAsed on LIS
    //Runtime: 3 ms, faster than 100.00% of Java
    private static int maxSum( int[] a, int[] b ) {
        long mod = (long) 1e9 + 7;

        int i = 0, j = 0, n = a.length, m = b.length;
        long sa = 0, sb = 0, ans = 0;

        // sa stores sum of segment in a
        // sb stores sum of segment in b

        // so we look for the value that is same in both the array
        while (i < n && j < m) {

            if (a[i] < b[j]) {
                // move forward in a, and add this value to sum
                sa = (sa + a[i]);
                i += 1;

            } else if (b[j] < a[i]) {
                // move forward in b and add this value to the sum
                sb = (sb + b[j]);
                j += 1;

            } else {
                // a[i] == b[j]
                // now we take the larger of the two sa, sb
                ans = ans + (Math.max(sa, sb) + a[i]);

                // sa,sb = 0 since a new segment starts after this
                sa = sb = 0;
                i += 1;
                j += 1;
            }
        }

        while (i < n) {
            // just in case the array is not completed
            sa = (sa + a[i]);
            i += 1;
        }

        while (j < m) {
            // just in case array is not completed
            sb = (sb + b[j]);
            j += 1;
        }

        // bigger of the two
        ans = (ans + Math.max(sa, sb)) % mod;
        return (int) ans;
    }
}

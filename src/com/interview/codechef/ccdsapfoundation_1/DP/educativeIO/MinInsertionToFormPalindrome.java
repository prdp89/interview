package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

public class MinInsertionToFormPalindrome {

    // Recursive function to find minimum number
    // of insertions
    private static int findMinInsertions( char str[], int l,
                                          int h ) {
        // Base Cases
        if (l > h) return Integer.MAX_VALUE;

        if (l == h) return 0;

        //if left reach to right - 1 then if both char. matches no insertion is required.
        if (l == h - 1) return (str[l] == str[h]) ? 0 : 1;

        // Check if the first and last characters
        // are same. On the basis of the  comparison
        // result, decide which sub-problem(s) to call

        return (str[l] == str[h]) ?
                findMinInsertions(str, l + 1, h - 1) : //if both char matches then move from both side

                (Integer.min(findMinInsertions(str, l, h - 1), // move from right side
                        findMinInsertions(str, l + 1, h)) + 1); // move from left sides
    }

    // Driver program to test above functions
    public static void main( String args[] ) {
        String str = "geeks";
        System.out.println(findMinInsertions(str.toCharArray(),
                0, str.length() - 1));
    }
}

package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

public class FirstStringSubseqSecond {

    //https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
    public static void main( String[] args ) {

        String str1 = "gksrek";
        String str2 = "geeksforgeeks";
        int m = str1.length();
        int n = str2.length();
        boolean res = isSubSequence(str1, str2, m, n);
        if (res)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    //One more variant of similar prob : https://www.geeksforgeeks.org/find-length-longest-subsequence-one-string-substring-another-string/

    //same as LCS the only diff. is last line where  we are just incrementing 2nd string
    private static boolean isSubSequence( String str1, String str2, int m, int n ) {
        // Base Cases
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        // If last characters of two strings are matching
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubSequence(str1, str2, m - 1, n - 1);

        // If last characters are not matching
        return isSubSequence(str1, str2, m, n - 1);
    }
}

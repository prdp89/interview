package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class HighestValuePalindrome {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String str = scanner.next();

        System.out.println(solve(str, n, k));
    }

    //https://www.geeksforgeeks.org/make-largest-palindrome-changing-k-digits/
    private static String solve( String str, int n, int k ) {

        if (str.length() == 1)
            return str;

        char palin[] = str.toCharArray();

        StringBuilder ans = new StringBuilder();

        // Iinitialize l and r by leftmost and
        // rightmost ends
        int l = 0;
        int r = str.length() - 1;

        // first try to make String palindrome
        while (l < r) {
            // Replace left and right character by
            // maximum of both
            if (str.charAt(l) != str.charAt(r)) {
                palin[l] = palin[r] = (char) Math.max(str.charAt(l),
                        str.charAt(r));
                k--;
            }
            l++;
            r--;
        }

        // If k is negative then we can't make
        // String palindrome
        if (k < 0) {
            return "-1";
        }

        l = 0;
        r = str.length() - 1;

        while (l <= r) {

            // At mid character, if K>0 then change
            // it to 9
            if (l == r) {
                if (k > 0) {
                    palin[l] = '9';
                }
            }

            // If character at lth (same as rth) is
            // less than 9
            if (palin[l] < '9') {
                /* If none of them is changed in the
            previous loop then subtract 2 from K
            and convert both to 9 */
                if (k >= 2 && palin[l] == str.charAt(l)
                        && palin[r] == str.charAt(r)) {
                    k -= 2;
                    palin[l] = palin[r] = '9';
                } /* If one of them is changed in the previous
                loop then subtract 1 from K (1 more is
                subtracted already) and make them 9 */
                else if (k >= 1 && (palin[l] != str.charAt(l)
                        || palin[r] != str.charAt(r))) {
                    k--;
                    palin[l] = palin[r] = '9';
                }
            }
            l++;
            r--;
        }

        for (char aPalin : palin) ans.append(aPalin);

        return ans.toString();
    }
}

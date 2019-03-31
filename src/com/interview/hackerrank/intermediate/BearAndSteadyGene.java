package com.interview.hackerrank.intermediate;

import java.util.Scanner;

public class BearAndSteadyGene {

    //https://www.hackerrank.com/challenges/bear-and-steady-gene/problem
    //help : https://gist.github.com/jianminchen/9b02beab326b2bfcd4b524f219d2946f

    //Nice quesiton on sliding window :
    // https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.next()));
    }

    private static int solve( String str ) {
        int[] ar = new int[26];

        for (char c : str.toCharArray()) {
            ar[c - 65]++;
        }

        int max = str.length() / 4;

        String t = "ACGT";
        boolean ok = true;
       /* foreach (char c : t) {
            if (cnt[c] > mx) {
                ok = false;
            }
        }*/

        for (Character c : t.toCharArray()) {
            if (ar[c - 65] > max) {
                ok = false;
            }
        }

        if (ok)
            return 0;

        return getMinimumLength(ar, str.length(), max, str);
    }

    private static int getMinimumLength( int[] ar, int length, int max, String str ) {
        int r = 0;
        int ans = length;
        char[] s = str.toCharArray();

        for (int l = 0; l < length; l++) //
        {
            while (ar['A' - 65] > max || ar['C' - 65] > max || ar['T' - 65] > max || ar['G' - 65] > max) {
                if (r == length) {
                    return ans;
                }

                int index = s[r] - 65;
                --ar[index];
                ++r;
            }
            ans = Math.min(ans, r - l);
            ++ar[s[l] - 65];
        }

        return ans;
    }
}

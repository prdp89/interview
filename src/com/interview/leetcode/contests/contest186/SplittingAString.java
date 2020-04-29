package com.interview.leetcode.contests.contest186;

public class SplittingAString {

    public static void main( String[] args ) {
        System.out.println(maxScore("0111101"));
        System.out.println(maxScoreOptimal("0111101"));
    }

    //33MS
    private static int maxScore( String s ) {

        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            String first = s.substring(0, s.length() - i - 1);
            String second = s.substring(s.length() - i - 1);

            if (!first.isEmpty() && !second.isEmpty()) {
                int zeros = 0, ones = 0;
                for (int j = 0; j < first.length(); j++) {
                    if (first.charAt(j) == '0')
                        zeros++;
                }

                for (int j = 0; j < second.length(); j++) {
                    if (second.charAt(j) == '1')
                        ones++;
                }


                max = Math.max(max, zeros + ones);
            }
        }

        return max;
    }

    //https://leetcode.com/problems/maximum-score-after-splitting-a-string/discuss/597740/Java-StraightForward
    private static int maxScoreOptimal( String s ) {
        int n = s.length();
        int c1 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') c1++;
        }

        int max = 0;
        int c2 = 0;

        //starting from zero index bcz 1's always on right side..
        for (int i = 0; i < n - 1; i++) { //no need to go till end; bcz we are splitting left and right..

            if (s.charAt(i) == '0') //bcz we found a zero on left side..
                c2++;
            else
                c1--; //bcz we have give 1 one on the left side

            max = Math.max(max, c1 + c2);
        }

        return max;
    }
}

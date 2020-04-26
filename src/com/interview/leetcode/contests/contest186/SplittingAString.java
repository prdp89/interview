package com.interview.leetcode.contests.contest186;

public class SplittingAString {

    public static void main( String[] args ) {
        System.out.println(maxScore("1111"));
    }

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
}

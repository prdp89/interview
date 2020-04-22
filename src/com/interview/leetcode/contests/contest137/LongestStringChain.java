package com.interview.leetcode.contests.contest137;

public class LongestStringChain {

    //https://leetcode.com/problems/longest-string-chain/
    static int max = Integer.MIN_VALUE;

    public static void main( String[] args ) {

        String[] str = {
                "a", "b", "ba", "bca", "bda", "bdca"
        };

        System.out.println(recur(str, 0, str.length - 1));
    }

    //only 11 / 71 test cases passed.
    private static int recur( String[] str, int start, int length ) {

        // Arrays.sort(str, Collections.reverseOrder());

        if (start == str.length)
            return 1;

        for (int i = start; i <= length; i++) {

            int res = LIS(str, i);
            max = Math.max(res, max);
        }

        return max;
    }

    private static int LIS( String[] str, int i ) {

        int ways = 1;
        for (int j = 0; j < i; j++) {

            if (str[i].length() - str[j].length() >= 1 && onCharApart(str[i], str[j])) {

                int temp = 1 + LIS(str, j);

                ways = Math.max(ways, temp);
            }
        }

        return ways;
    }

    private static boolean onCharApart( String s, String s1 ) {

        int[] count = new int[26];
        int[] count_1 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 97]++;
        }

        for (int i = 0; i < s1.length(); i++) {
            count_1[s1.charAt(i) - 97]++;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                diff += count[i] - count_1[i];
            }
        }

        return diff <= 1;
    }
}

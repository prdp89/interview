package com.interview.leetcode.contests.biweekly.biweekly3;

public class FindKLengthSubstrings {

    public static void main( String[] args ) {
        String s = "havefunonleetcode";
        int k = 5;

        System.out.println(solve(s, k));
    }

    private static int solve( String s, int l ) {

        int count = 0;
        for (int i = 0; i < s.length() - l + 1; i++) {

            String str = s.substring(i, i + l);

            int[] arr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }

            boolean isReated = false;
            for (int anArr : arr) {
                if (anArr > 1) {
                    isReated = true;
                    break;
                }
            }

            if (!isReated)
                count++;
        }

        return count;
    }
}

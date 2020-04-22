package com.interview.leetcode.contests.contest178;

public class RankTeamVotes {

    //https://leetcode.com/contest/weekly-contest-178/problems/rank-teams-by-votes/
    public static void main( String[] args ) {
        // String[] strings = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String[] strings = {"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};

        solve(strings);
    }

    private static void solve( String[] strings ) {

        int[][] dp = new int[26][strings[0].length()];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings[0].length(); i++) {

            int max = Integer.MIN_VALUE, maxIndex = -1;
            for (int j = 0; j < strings.length; j++) {

                int t = strings[j].charAt(i) - 'A';
                dp[t][i]++;

                if (max < dp[t][i]) {
                    max = dp[t][i];
                    maxIndex = t;
                }
            }

            sb.append(Character.valueOf((char) ('A' + maxIndex)));

        }

        System.out.println(sb.toString());

    }
}

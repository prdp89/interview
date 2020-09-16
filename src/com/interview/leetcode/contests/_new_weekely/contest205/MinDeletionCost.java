package com.interview.leetcode.contests._new_weekely.contest205;

public class MinDeletionCost {

    //https://leetcode.com/contest/weekly-contest-205/problems/minimum-deletion-cost-to-avoid-repeating-letters/
    public static void main( String[] args ) {
        int[] cost = {1, 2, 3, 4, 5};
        String str = "abaac";

        //System.out.println(minCost(str, cost));

        System.out.println(minCostOptimal(str, cost));
    }

    //couldn't think of this logic,,shame :(
    private static int minCost( String s, int[] cost ) {
        if (s.length() == 1)
            return 0;

        char[] arr = s.toCharArray();
        int res = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                res += Math.min(cost[i], cost[i - 1]);
                i--;
            }
        }

        return res;
    }

    //Runtime: 7 ms, faster than 94.65% of Java
    private static int minCostOptimal( String s, int[] cost ) {
        if (s.length() == 1)
            return 0;

        int res = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {

                //if prev cost is smaller than current; we store that cost
                if (cost[i - 1] < cost[i])
                    res += cost[i - 1];
                else { //we need to hold the cost[i-1] bcz it is greater and can compare with upcoming characters
                    res += cost[i];
                    cost[i] = cost[i - 1];//bcz cost[i-1] is greater; so we are saving it for furhter rounds
                }
            }
        }
        return res;
    }
}
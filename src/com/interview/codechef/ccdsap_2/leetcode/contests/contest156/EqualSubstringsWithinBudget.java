package com.interview.codechef.ccdsap_2.leetcode.contests.contest156;

public class EqualSubstringsWithinBudget {

    //https://leetcode.com/contest/weekly-contest-156/problems/get-equal-substrings-within-budget/
    public static void main( String[] args ) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;

        //System.out.println(equalSubstring(s, t, maxCost));
        System.out.println(equalSubstringOptimal(s, t, maxCost));
    }

    //able to pass only 20/36 test cases..
    private static int equalSubstring( String s, String t, int maxCost ) {

        int length = 0, j = 0, tempCost = maxCost;

        int[] temp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int val = Math.abs((int) s.charAt(i) - (int) t.charAt(i));

            if (maxCost >= val) {
                length++;
                maxCost -= val;
            } else {
                temp[j++] = length;
                length = 0;
                maxCost = tempCost;
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for (int k = 0; k < temp.length; k++) {
            maxLength = Math.max(maxLength, temp[k]);
        }

        return maxLength;
    }


    /*
    Maintain a window and keep accumulating the cost on hi end; if the cost is higher than maxCost, then shrink widow by removing element from lo end;
    Update the max window width during each iteration.
     */
    //https://leetcode.com/problems/get-equal-substrings-within-budget/discuss/392841/JavaPython-3-Sliding-window-space-O(1)-w-brief-explanation-and-analysis.
    private static int equalSubstringOptimal( String s, String t, int maxCost ) {
        int width = 0;

        for (int hi = 0, lo = -1; hi < s.length(); ++hi) {
            maxCost -= Math.abs(s.charAt(hi) - t.charAt(hi));

            if (maxCost < 0) {
                lo++;
                maxCost += Math.abs(s.charAt(lo) - t.charAt(lo));
            }

            width = Math.max(width, hi - lo);
        }

        return width;
    }
}

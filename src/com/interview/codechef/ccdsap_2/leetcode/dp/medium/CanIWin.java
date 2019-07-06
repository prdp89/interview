package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/can-i-win/
public class CanIWin {

    public static void main( String[] args ) {

        int end = 10, desired = 11;
        System.out.println(recurse(0, end, desired, 0, 0));
    }

    //not working at all.. :(
    private static boolean recurse( int start, int end, int desired, int player1Score, int player2Score ) {

        if (player1Score == desired)
            return true;

        if (player2Score == desired)
            return false;

        if (start < end) {
            if (recurse(start + 1, end, desired, player1Score + start + player2Score, player2Score))
                return true;

            if (recurse(start, end - 1, desired, player1Score + end + player2Score, player2Score))
                return true;

            if (recurse(start + 1, end, desired, player1Score, player2Score + start + player1Score))
                return true;

            if (recurse(start, end - 1, desired, player1Score, player2Score + end + player1Score))
                return true;
        }

        return false;
    }

    //ref : https://leetcode.com/problems/can-i-win/discuss/95294/Java-solution
    //didn't understood this properly, but recurrence seems interesting :)
    public boolean canIWin( int n, int target ) {
        if (target <= n) return true;

        int sum = (n + 1) * n / 2;

        if (sum < target)
            return false;

        return helper(new HashMap(), new boolean[n + 1], target);
    }

    private boolean helper( Map<Integer, Boolean> dp, boolean[] used, int target ) {
        if (target <= 0) return false;

        int key = hashCode(used);

        if (dp.containsKey(key))
            return dp.get(key);

        for (int i = 1; i < used.length; i++) {

            if (!used[i]) {

                used[i] = true;

                boolean pre = helper(dp, used, target - i);

                used[i] = false;

                if (!pre) {
                    dp.put(key, true);
                    return true;
                }
            }
        }

        dp.put(key, false);
        return false;
    }

    int hashCode( boolean[] used ) {
        int num = 0;
        for (boolean b : used) {
            if (b) num |= 1;
            num <<= 1;
        }
        return num;
    }
}

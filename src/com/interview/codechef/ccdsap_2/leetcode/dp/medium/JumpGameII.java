package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class JumpGameII {

    //https://leetcode.com/problems/jump-game-ii/
    public static void main( String[] args ) {

        int[] arr = {2, 3, 1, 1, 4};

        System.out.println(solve(arr));
    }

    //This is a greedy approach.. and take Runtime: 175 ms, faster than 24.08% of Java online
    /*
    From the last to the start, the easier idea.
    Find the leftmost position that can reach the current position
     */

    //ref logic : windliang : https://leetcode.com/problems/jump-game-ii/discuss/18028/O(n)-BFS-solution
    private static int solve( int[] arr ) {

        int positionToReach = arr.length - 1;
        int minSteps = 0;

        while (positionToReach != 0) {

            for (int i = 0; i <= positionToReach; i++) {

                if (i + arr[i] >= positionToReach) {
                    positionToReach = i;
                    minSteps++;
                    break;
                }
            }
        }

        return minSteps;
    }
}

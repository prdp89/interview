package com.interview.leetcode.contests._new_weekely.weekely200;

import java.util.HashMap;
import java.util.Map;

public class WinnerArrayGame {

    //https://leetcode.com/contest/weekly-contest-200/problems/find-the-winner-of-an-array-game/
    public static void main( String[] args ) {
        //int[] arr = {2, 1, 3, 5, 4, 6, 7};
        int[] arr = {3, 2, 1};
        //int[] arr = {1, 11, 22, 33, 44, 55, 66, 77, 88, 99};

        int k = 10;

        System.out.println(getWinner(arr, k));
        System.out.println(getWinner_Optimal(arr, k));
    }

    //passing 3 test cases,, shame :(
    private static int getWinner( int[] arr, int k ) {

        Map<Integer, Integer> map = new HashMap<>();

        int start = 0, end = 1;

        boolean win = false;
        for (; !win; ) {

            if (arr[start] > arr[end]) {

                map.put(arr[start], map.getOrDefault(arr[start], 0) + 1);

                if (map.containsKey(arr[end]))
                    map.remove(arr[end]);

                if (map.containsKey(arr[start]) && map.get(arr[start]) >= k) {
                    win = true;
                    return arr[start];
                }
                end++;
            } else {
                map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

                if (map.containsKey(arr[start]))
                    map.remove(arr[start]);

                if (map.containsKey(arr[end]) && map.get(arr[end]) >= k) {
                    win = true;
                    return arr[end];
                }

                start = end + 1;
            }

            start = start % arr.length;
            end = end % arr.length;
        }

        return -1;
    }


    //https://leetcode.com/problems/find-the-winner-of-an-array-game/discuss/767916/Java-or-Easy-one-or-One-pass-or-With-clear-explanation
    private static int getWinner_Optimal( int[] arr, int k ) {
        int winner = arr[0], totalWins = 0;

        for (int i = 1; i < arr.length; i++) {

            if (winner > arr[i]) {
                //one more win
                totalWins++;
            } else {
                winner = arr[i];
                totalWins = 1; // reset win
            }

            if (totalWins == k)
                //break;
                return winner;
        }

        return winner;
    }
}

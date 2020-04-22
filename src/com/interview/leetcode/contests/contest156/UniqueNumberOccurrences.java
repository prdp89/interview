package com.interview.leetcode.contests.contest156;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueNumberOccurrences {

    //https://leetcode.com/contest/weekly-contest-156/problems/unique-number-of-occurrences/
    public static void main( String[] args ) {
        int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(uniqueOccurrences(arr));
    }

    //Solved in one go : Runtime: 2 ms, faster than 100.00% of Java online
    private static boolean uniqueOccurrences( int[] arr ) {
        int[] temp = new int[2002];
        Arrays.fill(temp, -1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[Math.abs(arr[i]) + 1000]++;
            } else
                temp[arr[i]]++;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < temp.length; i++) {

            if (temp[i] != -1) {

                if (!set.contains(temp[i]))
                    set.add(temp[i]);
                else
                    return false;
            }
        }

        return true;
    }
}

package com.interview.companies.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellAfterNDays {

    //https://leetcode.com/problems/prison-cells-after-n-days/
    public static void main( String[] args ) {
        int[] arr = {0, 1, 0, 1, 1, 0, 0, 1};
        int N = 7;

        System.out.println(Arrays.toString(prisonAfterNDays(arr, N)));
    }

    //Runtime: 4 ms, faster than 40.98% of Java
    private static int[] prisonAfterNDays( int[] cells, int N ) {
        Map<String, Integer> seen = new HashMap<>();

        while (N > 0) {

            int[] cells2 = new int[8];

            seen.put(Arrays.toString(cells), N--);

            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;

            cells = cells2;

            /*
            let's say N = 1000, we know after every 14 days, same prison state will come....
            so, if I do N%14 = 6 (which means until the last 6th day, my states will repeat....)
             */

            //This prevent us recomputing..
            if (seen.containsKey(Arrays.toString(cells))) {
                N = N % (seen.get(Arrays.toString(cells)) - N);
            }
        }

        return cells;
    }
}

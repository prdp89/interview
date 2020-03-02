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

            //If current N is already seen at : 8
            //Current N = 3
            // 8 - 3 = 5 means current state repeat after each 5 steps..
            //So finally you can MOD the current N with that value to not repeat the same 5 steps./

            //This prevent us recomputing..
            if (seen.containsKey(Arrays.toString(cells))) {
                N = N % (seen.get(Arrays.toString(cells)) - N);
            }
        }

        return cells;
    }
}

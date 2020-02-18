package com.interview.codechef.ccdsap_2.leetcode.arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

    //similar to : Find out the longest length of subarrays with at most 2 different numbers?

    //https://leetcode.com/problems/fruit-into-baskets/
    public static void main( String[] args ) {
        System.out.println(totalFruit2(new int[]{1, 2, 3, 2, 2}));
    }

    private static int totalFruit2( int[] tree ) {
        Map<Integer, Integer> count = new HashMap<>();

        int res = 0, i = 0;

        for (int j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);

            while (count.size() > 2) {
                //decrement from start
                count.put(tree[i], count.get(tree[i]) - 1);

                if (count.get(tree[i]) == 0)
                    count.remove(tree[i]);

                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}

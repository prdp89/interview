package com.interview.leetcode.nickwhite;

import java.util.TreeMap;

public class HandOfStraights {

    //https://leetcode.com/problems/hand-of-straights/
    public static void main( String[] args ) {
        int[] hand = {1, 2, 3, 4, 5, 6};
        int W = 2;

        System.out.println(isNStraightHand(hand, W));
    }

    private static boolean isNStraightHand( int[] hand, int W ) {

        if (hand.length == 0 || hand.length < W)
            return false;

        if (hand.length % W != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int item : hand) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        while (map.size() > 0) {
            int firstMinValue = map.firstKey();

            //for each key, generating 3 cards out of it.
            for (int first = firstMinValue; first < firstMinValue + W; first++) {
                if (!map.containsKey(first)) {
                    return false;
                }

                int count = map.get(first);

                //remove item out of map if its occurrence is one only.
                //means we have used this item above..
                if (map.get(first) == 1)
                    map.remove(first);
                else {
                    map.put(first, count - 1);
                }
            }
        }
        return true;
    }
}

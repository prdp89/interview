package com.interview.leetcode.sorting;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickUpWithWeights {

    private int cnt = 0;
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private Random rnd = new Random();

    public RandomPickUpWithWeights( int[] w ) {
        for (int idx = 0; idx < w.length; idx++) {
            cnt += w[idx];
            map.put(cnt, idx);
        }
    }

    public static void main( String[] args ) {
        RandomPickUpWithWeights randomPickUpWithWeights = new RandomPickUpWithWeights(new int[]{1, 3});
        System.out.println(randomPickUpWithWeights.pickIndex());
        System.out.println(randomPickUpWithWeights.pickIndex());
    }

    public int pickIndex() {
        // int key= map.ceilingKey(rnd.nextInt(cnt)+1); don't forget to +1, because rand.nextInt(cnt) generate random integer in range [0,cnt-1]
        int key = map.higherKey(rnd.nextInt(cnt));
        return map.get(key);
    }
}

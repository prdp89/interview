package com.interview.companies.fb;

import java.util.Random;

public class RandomPickIndex {

    private int[] nums;
    private Random random = new Random();

    private RandomPickIndex( int[] nums ) {
        this.nums = nums;
    }

    //https://leetcode.com/problems/random-pick-index/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 3, 3};
        RandomPickIndex randomPickIndex = new RandomPickIndex(arr);

        System.out.println("3 index:" + randomPickIndex.pick(3));
        System.out.println("3 index:" + randomPickIndex.pick(3));
        System.out.println("2 index:" + randomPickIndex.pick(2));
    }

    public int pick( int target ) {
        int res = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;

            //example = 3 is at index = {2, 3, 4}
            //First iteraton : rand({0,1}) = if it choose 0 when i = 2 then res index 2 else result = 3
            if (random.nextInt(++count) == 0)
                res = i; //returning index wont work bcz we have to give each item equal probability
        }

        return res;
    }
}

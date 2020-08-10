package com.interview.leetcode.contests._new_weekely.weekely197;

public class NumOfGoodPairs {

    //https://leetcode.com/contest/weekly-contest-197/problems/number-of-good-pairs
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3};
        System.out.println(numIdenticalPairs(arr));
    }

    private static int numIdenticalPairs( int[] nums ) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
        }
        return count;
    }

    private static int numIdenticalPairs_optimal( int[] A ) {
        int res = 0, count[] = new int[101];

        for (int a : A) {
            res += count[a]++; //nice logic
        }

        return res;
    }
}

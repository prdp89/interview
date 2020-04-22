package com.interview.leetcode.contests.contest143;

public class DistributeCandies {

    public static void main( String[] args ) {

        int candies = 7;
        int people = 4;
        int[] arr = new int[people];

        int i = 0, count = 1;
        while (candies >= 1) {

            arr[i] += candies > count ? count : candies;

            i++;

            if (i >= people) {
                i = 0;
            }

            candies -= count;

            count++;
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}

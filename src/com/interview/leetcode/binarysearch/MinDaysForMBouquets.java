package com.interview.leetcode.binarysearch;

public class MinDaysForMBouquets {

    //https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
    //https://www.youtube.com/watch?v=xhzHp9I2HwA&feature=youtu.be&t=1
    public static void main( String[] args ) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;

        System.out.println(minDays(bloomDay, m, k));
    }

    //So basically, instead of checking bloomed flowers on each next day,
    // we are making binary search on 0 to INT_MAX days and trying to minimise it.

    //Runtime: 32 ms, faster than 33.33% of Java
    private static int minDays( int[] bloomDay, int totalBouquet, int requiredFlowers ) {
        int start = 0, end = Integer.MAX_VALUE - 1;

        //use when loop using start<=end
        //int ans = -1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            //here, we are try'n to minimize the ans by looking for better MID
            if (validate(bloomDay, mid, totalBouquet, requiredFlowers)) {
                end = mid; //keeping MID as Minimum
                //ans = mid;
            } else {
                start = mid + 1;
            }
        }

        //return res; //when start <= end loop
        return start == Integer.MAX_VALUE - 1 ? -1 : start; //done by me :)
    }

    private static boolean validate( int[] bloomDay, int mid, int totalBouquet, int requiredFlowers ) {
        int total = 0, req = 0;
        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= mid) {
                req++;

                if (req == requiredFlowers) {
                    total++;
                    req = 0;
                }
            } else {
                req = 0;
            }
        }

        return total >= totalBouquet;
    }
}
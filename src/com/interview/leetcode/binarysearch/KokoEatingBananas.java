package com.interview.leetcode.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {

    //https://www.youtube.com/watch?v=Sp2sRLcLND0
    //https://leetcode.com/problems/koko-eating-bananas/
    public static void main( String[] args ) {
        int[] bananas = {30, 11, 23, 4, 20};
        int H = 6;

        System.out.println(minEatingSpeed(bananas, H));
    }

    //We have to find minimum speed K such that total hours is less than or equals to K
    //eg banana = {3, 6}
    //If Speed(K) = 2, then : 3/2 = 1 + 1 (remainder) = 2 hour for eating 3 bananas
    //            and 6/2 = 3 hours to eat 6 bananas..
    //we have to minimize = {2, 3} => 2+3 = 5 as small as possible..

    //Runtime: 29 ms, faster than 20.93% of Java online
    private static int minEatingSpeed( int[] piles, int H ) {
        //we have to pick K speed anything, so we define range as:
        //min. speed start = 1, maxSpeed = Max(piles)

        int start = 1;

        //In DivideChocolate : range factor is sum of number, but here
        //Range factor is Max speed at which KOKO eat bananas..
        int end = Arrays.stream(piles).max().getAsInt();

        //if we want to loop start <= end
        //int res = -1;

        while (start < end) {

            //start from a MID speed and move left or right
            int mid = start + (end - start) / 2;

            if (validate(piles, mid, H)) {
                end = mid;
                //res = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    private static boolean validate( int[] piles, int speed, int totalHour ) {

        int hours = 0, total = 0;
        for (int item : piles) {
            //sum += item;

            int div = item / speed;
            hours += div;

            //if some remainder left, KOKO need additional Hour
            if (item % speed != 0) {
                hours++;
            }
        }

        return hours <= totalHour;
    }
}

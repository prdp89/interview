package com.interview.leetcode.contests.biweekly.biweekely27;

public class MakeTwoArraysEqual {

    public static void main( String[] args ) {
        int[] tar = {1,1,1,1,1};
        int[] arr = {1,1,1,1,1};

        System.out.println(canBeEqual(tar, arr));
    }

    private static boolean canBeEqual( int[] target, int[] arr ) {
        int[] countTar = new int[1001];
        int[] countArr = new int[1001];

        for (int item : target) {
            countTar[item]++;
        }

        for (int item : arr) {
            countArr[item]++;
        }

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] != countTar[i])
                return false;
        }

        return true;
    }
}

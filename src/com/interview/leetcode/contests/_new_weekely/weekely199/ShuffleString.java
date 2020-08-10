package com.interview.leetcode.contests._new_weekely.weekely199;

public class ShuffleString {

    //https://leetcode.com/problems/shuffle-string/
    public static void main( String[] args ) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }

    private static String restoreString( String s, int[] indices ) {
        char[] arr = new char[s.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }

        return new String(arr);
    }
}

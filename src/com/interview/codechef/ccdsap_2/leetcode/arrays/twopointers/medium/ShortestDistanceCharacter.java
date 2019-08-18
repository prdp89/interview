package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.Arrays;

public class ShortestDistanceCharacter {

    //https://leetcode.com/problems/shortest-distance-to-a-character/
    public static void main( String[] args ) {
       /* String str = "loveleetcode";
        char c = 'e';*/

       /* String str = "aaba";
        char c = 'b';
*/

        String str = "abaa";
        char c = 'b';

        solveTry(str, c);
    }

    //passing all test cases, Rumtime 3 ms
    private static void solveTry( String str, char c ) {

        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == c) {
                arr[i] = 0;
                continue;
            }

            if (i == str.length() - 1) {
                if (str.charAt(i) == c)
                    arr[i] = 0;
                else
                    arr[i] = arr[i - 1] + 1;
                continue;
            }

            //for each character going forward and checking if character found or not
            boolean isFound = false;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == c) {
                    if (i > 0)
                        arr[i] = Math.min(j - i, arr[i - 1] + 1);
                    else
                        arr[i] = j - i;

                    isFound = true;
                    break;
                }
            }

            //if not found: distance will be prev distance + 1
            if (!isFound) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    //Runtime: 1 ms, Complexity ; O ( N )
    public int[] shortestToCharSecondApproach( String s, char c ) {
        int[] distance = new int[s.length()];

        int lastPosition = -s.length();

        // going forward to calculate positions from left to right
        // creates something like { -10, -9, 0, 1, 2, 0, 1, ...}
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                distance[i] = 0;
                lastPosition = i;
            } else {
                distance[i] = i - lastPosition; //same as J - I in my solution
            }
        }

        // going backward from last known character to calculate distance in other direction
        for (int i = lastPosition; i >= 0; i--) {
            if (s.charAt(i) == c) {
                lastPosition = i;
            } else {
                distance[i] = Math.min(distance[i], lastPosition - i);
            }
        }

        return distance;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.binarysearch.easy;

public class SmallestLetterGreaterTarget {

    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/

    //Also Read : https://leetcode.com/problems/first-bad-version/
    //This also holds END to find optimal solution..

    //This pattern in binary search is similar to where we don't know which direction to move,
    //we move only one pointer 'start' and hold the END.

    public static void main( String[] args ) {

        char[] letters = "cfj".toCharArray();
        char target = 'c';

        //method_1(letters, target);
        method_2(letters, target);
    }

    //this method is smiliar to UpperBound In an array
    private static void method_2( char[] letters, char target ) {

        if (target >= letters[letters.length - 1])
            System.out.println(letters[0]);

        int start = 0, end = letters.length - 1;

        while (start < end) {

            int mid = (start + end) / 2;

            if (letters[mid] > target) { //yes, we found the number that is greater than target; now answer is atleast mid
                end = mid; //end will at at-least MID bcz this character is greater than target
                //and we are holding this END for the answer.
            } else {
                start = mid + 1; //otherwise, we have to move in right direction for search
            }
        }

        System.out.println(letters[end]);
    }

    private static void method_1( char[] letters, char target ) {
        if (target >= letters[letters.length - 1])
            System.out.println(letters[0]);

        for (Character c : letters) {
            if (c > target) {
                System.out.println(c);
                return;
            }
        }
    }
}

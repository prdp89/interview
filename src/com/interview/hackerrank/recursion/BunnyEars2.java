package com.interview.hackerrank.recursion;

public class BunnyEars2 {

    //https://codingbat.com/prob/p183649
    public static void main( String[] args ) {
        System.out.println(bunnyEars(2));
    }

    //trick by me..
    private static int optimal(int bunnies){
        return 2 * bunnies;
    }

    private static int bunnyEars(int bunnies) {

        // Base case: if bunnies==0, just return 0.
        if (bunnies == 0) return 0;

        // Recursive case: otherwise, make a recursive call with bunnies-1
        // (towards the base case), and fix up what it returns.
        return 2 + bunnyEars(bunnies-1);
    }
}

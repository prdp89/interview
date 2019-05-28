package com.interview.array;

/**
 * http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 */
public class RepeatingAndMissingNumber {

    /*
    Approach: Instead of Tushar Roy follow below easy approach :

    Create a temp array temp[] of size n with all initial values as 0.
    Traverse the input array arr[], and do following for each arr[i]
    if(temp[arr[i]] == 0) temp[arr[i]] = 1;
    if(temp[arr[i]] == 1) output “arr[i]” //repeating
    Traverse temp[] and output the array element having value as 0 (This is the missing element)
     */

    public static void main( String args[] ) {
        RepeatingAndMissingNumber rmn = new RepeatingAndMissingNumber();
        int input[] = {3, 1, 2, 4, 6, 8, 2, 7};
        System.out.println(rmn.findNumbers(input));
    }

    public Pair findNumbers( int input[] ) {
        Pair p = new Pair();
        for (int i = 0; i < input.length; i++) {
            if (input[Math.abs(input[i]) - 1] < 0) {
                p.repeating = Math.abs(input[i]);
            } else {
                input[Math.abs(input[i]) - 1] = -input[Math.abs(input[i]) - 1];
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                input[i] = -input[i];
            } else {
                p.missing = i + 1;
            }
        }
        return p;
    }

    class Pair {
        int repeating;
        int missing;

        public String toString() {
            return repeating + " " + missing;
        }
    }
}

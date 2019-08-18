package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.Arrays;

public class BoatsSavePeople {

    //https://leetcode.com/problems/boats-to-save-people/
    public static void main( String[] args ) {
       /* int[] arr = {3, 2, 2, 1};
        int limit = 3;*/

       /* int[] arr = {3, 5, 3, 4};
        int limit = 5;*/

        int[] arr = {2, 2};
        int limit = 6;

        //  solveTry(arr, limit);

        System.out.println(numRescueBoats(arr, limit));
    }

    //Using greedy 35 / 77 test cases passed.
    private static void solveTry( int[] arr, int limit ) {

        Arrays.sort(arr);

        int numOfBoats = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == limit) {
                numOfBoats++;
                sum = 0;
            } else if (sum > limit) {

                numOfBoats += sum / limit;

                if (sum % limit != 0) {
                    numOfBoats++;
                }

                sum = 0;
            }
        }

        if (sum <= limit)
            numOfBoats++;
        else {
            numOfBoats += sum / limit;

            if (sum % limit != 0)
                numOfBoats++;
        }

        System.out.println(numOfBoats);
    }

    /*
    Sort people.
    1. For the current heaviest person, we try to let him go with the lightest person.
        As all people need to get on the boat.
    2. If the sum of weight is over the limit, we have to let the heaviest go alone.
        No one can take the same boat with him.
     */
    private static int numRescueBoats( int[] people, int limit ) {

        Arrays.sort(people);

        int ans = 0, hi = people.length - 1, lo = 0;

        while (hi >= lo) {

            if (people[lo] + people[hi] <= limit) {
                ++lo;
            } // low end moves only if it can fit in a boat with high end.

            --hi;  // high end always moves

            ++ans;
        }
        return ans;
    }
}

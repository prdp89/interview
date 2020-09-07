package com.interview.leetcode.binarysearch;

import java.util.TreeSet;

public class KEmptySlots {

    //https://stackoverflow.com/questions/55084325/how-do-i-analyze-k-empty-slots-algorithm
    //https://www.programcreek.com/2012/04/leetcode-k-empty-slots-java/

    /*
    There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days.
    In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

    Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower
    will open in that day.

    For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will
    be in the range from 1 to N.

    Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
    and also the number of flowers between them is k and these flowers are not blooming.

    If there isn't such day, output -1.

    Example 1:

    Input:

    flowers: [1,3,2]

    k: 1

    Output: 2

    Explanation: In the second day, the first and the third flower have become blooming.

    Example 2:

    Input:

    flowers: [1,2,3]

    k: 1

    Output: -1

    For the first example. [1,3,2] here as explained above, on day 2 the flower will be blooming
    on slot 3 and on day 1 the flower bloomed on slot 1, so the number of slots on day 2 free is 1
    (equal to k) between them. Hence the output is day 2.
     */
    public static void main( String[] args ) {
        int[] arr = {1, 3, 2};

        System.out.println(kEmptySlots(arr, 1));
    }

    private static int kEmptySlots( int[] flowers, int k ) {
        TreeSet<Integer> set = new TreeSet<>();

        //First day: Flower bloom on slot 1
        //On Second Iteration: 3 will bloom on third day but it occurs in Array before 2
        //So set.lower(3) == 1 and flower[i] {3 - 1 - 1 == 1} returns 1+1 = 2
        for (int i = 0; i < flowers.length; i++) {
            Integer higher = set.higher(flowers[i]);
            Integer lower = set.lower(flowers[i]);

            if (lower != null && flowers[i] - k - 1 == lower) {
                return i + 1;
            }

            if (higher != null && flowers[i] + k + 1 == higher) {
                return i + 1;
            }

            set.add(flowers[i]);
        }

        return -1;
    }
}

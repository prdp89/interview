package com.interview.array;

import java.util.Arrays;

/**
 * Date 12/29/2015
 *
 * @author Tushar Roy
 * <p>
 * Given array with unique numbers and a total,  find all triplets whose sum is less than total
 * <p>
 * http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 */

//this problem is almost same as 3 sum problem. Read that first.

public class TripletSumLessThanTotal {

    public static void main( String args[] ) {
        int input[] = {5, 1, 3, 4, 7};
        TripletSumLessThanTotal tt = new TripletSumLessThanTotal();
        System.out.print(tt.findAllTriplets(input, 12));
    }

    public int findAllTriplets( int input[], int total ) {
        Arrays.sort(input);
        int result = 0;
        for (int i = 0; i < input.length - 2; i++) {
            int j = i + 1;
            int k = input.length - 1;

            while (j < k) {
                if (input[i] + input[j] + input[k] >= total) {
                    k--;
                } else {
                    result += k - j;
                    j++;
                }
            }
        }
        return result;
    }
}

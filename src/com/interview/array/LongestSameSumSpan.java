package com.interview.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 12/29/2015
 *
 * @author Tushar Roy
 * <p>
 * Give two arrays of same size consisting of 0s and 1s find span (i, j) such that
 * sum of input1[i..j] = sum of input2[i..j]
 * <p>
 * Time complexity O(n)
 * Space complexity O(n)
 * <p>
 * http://www.geeksforgeeks.org/longest-span-sum-two-binary-arrays/
 */
public class LongestSameSumSpan {

    //Really easy : just adding two ranges and check if their sum previously existed or not
    public static void main( String args[] ) {
        int input1[] = {1, 0, 0, 1, 1, 0};
        int input2[] = {0, 1, 1, 0, 1, 1};
        LongestSameSumSpan lsss = new LongestSameSumSpan();
        System.out.print(lsss.longestSpan(input1, input2));
    }

    private int longestSpan( int input1[], int input2[] ) {
        if (input1.length != input2.length) {
            throw new IllegalArgumentException("Not same length input");
        }

        Map<Integer, Integer> diff = new HashMap<>();

        int prefix1 = 0, prefix2 = 0;
        int maxSpan = 0;
        diff.put(0, -1);

        for (int i = 0; i < input1.length; i++) {

            prefix1 += input1[i];
            prefix2 += input2[i];

            int currDiff = prefix1 - prefix2;

            if (diff.containsKey(currDiff)) { //if same diff. found again; window size will be updated
                maxSpan = Math.max(maxSpan, i - diff.get(currDiff));
            } else {
                diff.put(currDiff, i);
            }
        }
        return maxSpan;
    }

}

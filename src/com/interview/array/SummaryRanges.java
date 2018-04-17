package com.interview.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date 10/19/2016
 * @author Tushar Roy
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * Solution -
 * Just check if num[i] + 1 != num[i + 1]. If its not equal means you need to add previous range to result
 * and start a new range.
 * 
 * Time complexity O(n)
 *
 * https://leetcode.com/problems/summary-ranges/
 */

//it's a simple program....


public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }
        int start = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {

            //if current : num[i]+1 is equals to next element that means a range exists so
            //below condition won't evaluate, and it loop increments to next.
            //if current+1 element not equals to next means series broke so print series from Start -- current element.
            if ((nums[i] + 1) != nums[i + 1]) {
                result.add(makeRange(nums[start], nums[i]));
                start = i + 1;
            }
        }

        // if second last element not equals to last element then
        // point start to last element. Means it helps to print last element in next statement.
        if ((nums[nums.length - 2] + 1) != nums[nums.length - 1]) {
            start = nums.length - 1;
        }
        result.add(makeRange(nums[start], nums[nums.length - 1]));
        return result;
    }

    private String makeRange(int a, int b) {
        if (a == b) {
            return String.valueOf(a);
        }
        return a + "->" + b;
    }

    public static void main( String[] args ) {
        SummaryRanges summaryRanges = new SummaryRanges();
        System.out.println(summaryRanges.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}

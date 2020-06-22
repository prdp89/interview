package com.interview.leetcode.binarysearch;

import java.util.Arrays;

public class DivideChocolate {

    //https://github.com/charles-wangkai/leetcode/blob/master/divide-chocolate/Solution.java
    /*
    You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the
    array sweetness.

    You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces
    using K cuts, each piece consists of some consecutive chunks.

    Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your
    friends.

    Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.

    Example 1:

    Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
    Output: 6
    Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]

    Example 2:

    Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
    Output: 1
    Explanation: There is only one way to cut the bar into 9 pieces.

    Example 3:

    Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
    Output: 5
    Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
     */
    public static void main( String[] args ) {
        int[] choco = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 5;

        System.out.println(maximizeSweetness(choco, k));
    }

    //As Compare to MinDaysForMBouquets, we need optimal total Sweetness
    private static int maximizeSweetness( int[] nums, int mFriends ) {

        int start = 0, res = -1;
        int end = Arrays.stream(nums).sum();

        //tried with lower bound logic; start < end, does not work
        while (start <= end) {

            //MID : denotes minimum amount of sweets we can distribute
            int mid = start + (end - start) / 2;

            if (validate(nums, mFriends, mid)) {
                res = mid;
                start = mid + 1; //bcz we have to get max chocolate as possible
            } else {
                end = mid - 1;
            }
        }

        return res;
    }

    private static boolean validate( int[] nums, int mFriends, int minimumPieceSum ) {
        int piecesForFriends = 0, sum = 0;
        for (int item : nums) {
            sum += item;

            if (sum >= minimumPieceSum) {
                piecesForFriends++;
                sum = 0;
            }
        }

        return piecesForFriends >= mFriends + 1; //why +1 : bcz we have to get a piece too.
    }
}

package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

public class VerifyPreOrderBinaryTree {

    //https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
    public static void main( String[] args ) {
        // String str = "1,#";
        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        System.out.println(isValidSerialization(str));
    }

    //If we treat null's as leaves, then the binary tree will always be full.
    //A full binary tree has a good property that # of leaves = # of non-leaves + 1.
    private static boolean isValidSerialization( String preorder ) {
        int nonleaf = 0, leaf = 0;

        for (String s : preorder.split(",")) {

            //if this condition got true within loop then it is not a binary tree.
            if (leaf == nonleaf + 1)
                return false;

            if (s.equals("#"))
                leaf++;
            else nonleaf++;
        }

        return leaf == nonleaf + 1;
    }
}

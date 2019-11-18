package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class LongestUnivaluePath {

    private static int len = 0;

    //https://leetcode.com/problems/longest-univalue-path/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(4, head);
        head = bt.addNode(5, head);
        head = bt.addNode(1, head);
        head = bt.addNode(1, head);
        head = bt.addNode(5, head);

        System.out.println(longestUnivaluePath(head, -1));
    }

    //This recursion pattern is same as : BalancedBinaryTree
    //In BBT we have to bubble up the result from each node if it's child are not balanced.
    //But in this we have to find each Node's Left/Right; preserving result  in Len
    //Count : contains max height at Left/Right.
    private static int longestUnivaluePath( Node curr, int val ) {
        if (curr == null)
            return 0;

        int l = longestUnivaluePath(curr.left, curr.data);
        int r = longestUnivaluePath(curr.right, curr.data);
        int count = 0;

        //step2:
        //Longest-Univalue-Path-Across a node is sum of left + right : see example 2.
        len = Math.max(len, l + r); //l is "valid" connecting edges to me from left

        //step1:
        if (curr.data == val)
            count = 1 + Math.max(l, r); //give it to caller max path with same number, include me

        return count;
    }
}

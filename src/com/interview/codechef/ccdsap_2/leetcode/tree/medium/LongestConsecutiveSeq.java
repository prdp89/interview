package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

public class LongestConsecutiveSeq {

    /*
    Given a Binary Tree find the length of the longest path which comprises of nodes with consecutive
    values in increasing order. Every node is considered as a path of length 1.
     */
    //Qut. Link : https://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/

    public static void main( String[] args ) {

        //Longest Consecutive  : 3 -> 4 -> 5
        Node head = Node.newNode(1);

        head.right = Node.newNode(3);

        head.right.left = Node.newNode(2);
        head.right.right = Node.newNode(4);

        head.right.right.right = Node.newNode(5);

        System.out.println(longestConsecutiveSeq(head)); //op : 3 -> 4 -> 5
    }

    private static int longestConsecutiveSeq( Node root ) {

        //to prevent global variable, taking reference types
        int[] res = {0};

        dfs(root, 0, 0, res);

        return res[0];
    }

    //Recursion pattern same as : SmallestStringLexoFromLeaf

    //PathLen : recursion param helps to find current consecutive path length
    //Target : stores root.data, it should be one less than child
    //Res : stores max path length. Instead of using global variable we are using reference type.

    //If PathLen != target : we are trying to count new path from that point in a tree.
    private static void dfs( Node root, int pathLen, int target, int[] res ) {

        if (root == null)
            return;

        if (root.data == target)
            pathLen = pathLen + 1;
        else
            pathLen = 1;

        res[0] = Math.max(pathLen, res[0]);

        dfs(root.left, pathLen, root.data + 1, res);
        dfs(root.right, pathLen, root.data + 1, res);
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class TrimBST {

    //https://leetcode.com/problems/trim-a-binary-search-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(3, head);
        head = bt.addNode(0, head);
        head = bt.addNode(4, head);
        head = bt.addNode(2, head);
        head = bt.addNode(1, head);

        trimBST(head, 1, 3);
    }

    //recursion is similar to : RangeSumBST
    private static Node trimBST( Node root, int L, int R ) {

        if (root == null)
            return null;

        //exclude left if smaller than left
        if (root.data < L)
            return trimBST(root.right, L, R);

        //exclude right if greater than right
        if (root.data > R)
            return trimBST(root.left, L, R);

        //similar to MergeBinaryTree
        //assign the remaining nodes to left and right node and traverse
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}

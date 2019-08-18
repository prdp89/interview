package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class ClosestBSTValue {

    //Given a non-empty binary search tree and a target value,
    //find the value in the BST that is closest to the target.

    private static double min = Double.MAX_VALUE;
    private static int ans = 0;

    //https://leetcode.com/problems/closest-binary-search-tree-value
    //http://buttercola.blogspot.com/2015/09/leetcode-closest-binary-search-tree.html
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(4, head);
        head = bt.addNode(7, head);
        head = bt.addNode(2, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(6, head);
        head = bt.addNode(9, head);

        closestValueHelper(head, 5);

        System.out.println(ans);
    }

    private static void closestValueHelper( Node root, double target ) {
        if (root == null) {
            return;
        }

        if (Math.abs((double) root.data - target) < min) {
            min = Math.abs((double) root.data - target);

            //answer is the node which is closest smaller than target
            ans = root.data;
        }

        //if target is greater switch to left node
        if (root.data > target) {
            closestValueHelper(root.left, target);
        } else if (root.data < target) {
            closestValueHelper(root.right, target);
        }
    }
}

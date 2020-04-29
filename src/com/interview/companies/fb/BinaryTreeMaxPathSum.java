package com.interview.companies.fb;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class BinaryTreeMaxPathSum {

    private static int max = Integer.MIN_VALUE;

    //https://leetcode.com/problems/binary-tree-maximum-path-sum/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);
        head = bt.addNode(3, head);

        maxPathSum(head);
        System.out.println(max);
    }

    //Runtime: 0 ms, faster than 100.00% of Java
    private static int maxPathSum( Node root ) {

        if (root == null)
            return 0;

        //traversing left/right to find max..
        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);

        //maintaining max at each stage
        max = Math.max(max, root.data + left + right); //pick root+left+right or max

        return root.data + Math.max(left, right); //similar to HeightOfTree recursion
    }
}

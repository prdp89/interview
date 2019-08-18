package com.interview.codechef.ccdsap_2.hackerrank.Trees.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class HeightOfTree {

    //https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(3, head);
        head = bt.addNode(2, head);
        head = bt.addNode(5, head);
        head = bt.addNode(1, head);
        head = bt.addNode(4, head);
        head = bt.addNode(6, head);
        head = bt.addNode(7, head);

        System.out.println(height(head) - 1); //bcz heightONOde number of nodes in a path - 2
    }

    public static int height( Node root ) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class UnivaluedBinaryTree {

    //https://leetcode.com/problems/univalued-binary-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(1, head);
        head = bt.addNode(1, head);
        head = bt.addNode(1, head);
        head = bt.addNode(1, head);

        System.out.println(isUnivalTree(head, head.data));
    }

    //solved in one go; great work
    private static boolean isUnivalTree( Node root, int data ) {

        if (root == null)
            return true;

        if (root.data != data)
            return false;

        return isUnivalTree(root.left, data) && isUnivalTree(root.right, data);
    }
}

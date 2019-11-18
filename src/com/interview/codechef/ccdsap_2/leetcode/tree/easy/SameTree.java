package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class SameTree {

    //https://leetcode.com/problems/same-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);
        head = bt.addNode(3, head);

        Node head1 = null;
        head1 = bt.addNode(1, head1);
        head1 = bt.addNode(1, head1);
        head1 = bt.addNode(3, head1);


        System.out.println(isSameTree(head, head1));
    }

    //solved in one attempt :)
    private static boolean isSameTree( Node p, Node q ) {

        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.data == q.data)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }
}

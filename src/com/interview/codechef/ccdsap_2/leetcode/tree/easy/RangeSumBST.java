package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class RangeSumBST {

    //https://leetcode.com/problems/range-sum-of-bst/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(5, head);
        head = bt.addNode(15, head);
        head = bt.addNode(3, head);
        head = bt.addNode(7, head);
        head = bt.addNode(18, head);

        print("", head, false);

        System.out.println(rangeSumBST(head, 7, 15));
    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    private static int rangeSumBST( Node root, int L, int R ) {
        if (root == null)
            return 0; // base case.

        if (root.data < L)
            return rangeSumBST(root.right, L, R); // left branch excluded.

        if (root.data > R)
            return rangeSumBST(root.left, L, R); // right branch excluded.

        return root.data +
                rangeSumBST(root.right, L, R) +
                rangeSumBST(root.left, L, R); // count in both children.
    }
}

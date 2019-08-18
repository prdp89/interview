package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class MergeBinaryTrees {

    //https://leetcode.com/problems/merge-two-binary-trees/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(2, head);
        head = bt.addNode(5, head);

        Node head1 = null;
        head1 = bt.addNode(2, head1);
        head1 = bt.addNode(1, head1);
        head1 = bt.addNode(3, head1);
        head1 = bt.addNode(4, head1);
        head1 = bt.addNode(7, head1);

        print("", mergeTrees(head, head1), false);
    }

    //it's like pre-order traversal : data -> left -> right
    private static Node mergeTrees( Node t1, Node t2 ) {
        if (t1 == null && t2 == null)
            return null;

        int val = (t1 == null ? 0 : t1.data) + (t2 == null ? 0 : t2.data);
        Node newNode = Node.newNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left,
                t2 == null ? null : t2.left);

        newNode.right = mergeTrees(t1 == null ? null : t1.right,
                t2 == null ? null : t2.right);

        return newNode;
    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}

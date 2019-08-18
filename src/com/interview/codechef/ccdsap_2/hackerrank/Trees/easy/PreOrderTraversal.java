package com.interview.codechef.ccdsap_2.hackerrank.Trees.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class PreOrderTraversal {

    //https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);
        head = bt.addNode(5, head);
        head = bt.addNode(3, head);
        head = bt.addNode(6, head);
        head = bt.addNode(4, head);

        preOrder(head);
        //print("", head, false);
    }

    private static void preOrder( Node root ) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);

        preOrder(root.left);
        preOrder(root.right);
    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}

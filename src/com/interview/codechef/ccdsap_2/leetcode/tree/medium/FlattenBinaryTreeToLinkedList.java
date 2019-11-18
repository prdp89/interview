package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public static void main( String[] args ) {
        Node head = Node.newNode(1);

        head.left = Node.newNode(2);
        head.right = Node.newNode(5);

        head.left.left = Node.newNode(3);
        head.left.right = Node.newNode(4);

        head.right.right = Node.newNode(6);

        //flatten(head);

        flattenUsingStack(head);
    }

    //Runtime: 1 ms, faster than 61.65% of Java.. nicely done :)
    private static void flatten( Node root ) {
        if (root == null)
            return;

        List<Node> list = new ArrayList<>();
        preOrderTraversal(root, list);

        Node temp = root;
        temp.left = null;

        for (int i = 1; i < list.size(); i++) {
            temp.right = list.get(i);
            temp.left = null;
            temp = temp.right;
        }
    }

    private static void preOrderTraversal( Node root, List<Node> list ) {

        if (root == null)
            return;

        list.add(root);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    //ref: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36991/Accepted-simple-Java-solution-iterative

    //it is DFS so u need a stack. Don't forget to set the left child to null, or we'll get TLE.

    //simply an implementation of pointer adjusting
    //inserting Right node first so Left will be on Top, then
    //setting Root -> right to Left node.

    //curr.left = null : help in deleting left link
    private static void flattenUsingStack( Node root ) {
        if (root == null)
            return;

        Stack<Node> stk = new Stack<>();
        stk.push(root);

        while (!stk.isEmpty()) {
            Node curr = stk.pop();

            if (curr.right != null)
                stk.push(curr.right);

            if (curr.left != null)
                stk.push(curr.left);

            if (!stk.isEmpty())
                curr.right = stk.peek();

            curr.left = null;  // dont forget this!!
        }
    }
}

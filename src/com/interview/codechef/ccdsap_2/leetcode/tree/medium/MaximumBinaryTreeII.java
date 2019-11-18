package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumBinaryTreeII {

    //https://leetcode.com/problems/maximum-binary-tree-ii/
    public static void main( String[] args ) {

        //TEST : 1
       /* Node head = Node.newNode(5);

        head.left = Node.newNode(2);
        head.right = Node.newNode(4);

        head.left.right = Node.newNode(1);

        Node resultNode = insertIntoMaxTree(head, 3);

        */

        //TEST : 2
        Node head = Node.newNode(5);

        head.left = Node.newNode(2);
        head.right = Node.newNode(2);

        head.left.right = Node.newNode(1);

        Node resultNode = insertIntoMaxTree(head, 4);
    }

    //ref : https://leetcode.com/problems/maximum-binary-tree-ii/discuss/242936/JavaC%2B%2BPython-Recursion-and-Iteration
    //In this progem, for any case we are not iterating to left of Tree;
    // If VAL is greater than Root then assign VAL left to the Root
    // If VAL is less then Root then iterate to Right to find next correct position for VAL; and re-structure the Tree accordingly.

    //very easy implementation... :)
    private static Node insertIntoMaxTree( Node root, int val ) {

        if (root == null)
            return Node.newNode(val);

        Node n = Node.newNode(val);

        Node curr = root, prev = null;

        Queue<Node> stack = new LinkedList<>();
        stack.offer(root);

        while (!stack.isEmpty()) {
            curr = stack.poll();

            if (val > curr.data) {

                //prev == null : when we are trying to insert at root level
                if (prev == null) {
                    n.left = root;
                    return n;
                } else { //we reach to the node where VAL is greater than curr.data
                    //prev : store prev of current node
                    //Just swapping the links with parent of current node and inserting the NEW node.
                    n.left = prev.right;
                    prev.right = n;
                }

                //after node inserted in Tree at correct position; NO need to iterate further
                break;
            } else if (curr.right == null) { //This case run for TEST-1;
                //here we reach to Rightmost node and assign curr.right to new node.
                curr.right = n;
            } else {
                stack.offer(curr.right);
                prev = curr;
            }
        }

        return root;
    }
}

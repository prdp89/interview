package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteBinaryTree {

    //https://leetcode.com/problems/check-completeness-of-a-binary-tree/

    /*
    A complete binary tree every level, except possibly the last,
    is completely filled, and all nodes in the last level are as far left as possible.
     */

    //very easy program
    public static void main( String[] args ) {
        Node head = Node.newNode(1);

        head.left = Node.newNode(2);
        head.right = Node.newNode(3);

        head.left.left = Node.newNode(4);
        head.left.right = Node.newNode(5);

        //Line 1:
        head.right.left = Node.newNode(7);

        //Line 2:
        // head.right.right = Node.newNode(7);

        //If we uncomment Line 1, and comment Line 2
        // then output : true {means if there's a single Node at last level, that should be at left child} or
        // {if there's one child leaf node at last level, it should be left child } or
        // {there cannot be multiple one child leaf node at last level}

        //If we uncomment Line 2, and comment Line 1 then output : false
        System.out.println(isCompleteTree(head));
    }

    //We are keeping track of whether we have encountered a null value.
    //If we have, then we expect all the following values to be null as well {on the same level}.

    //same as LevelOrderTraversal, just checking simple condition of left != null with current variable
    private static boolean isCompleteTree( Node root ) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean hasEncounteredNullValue = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            //step 2: if we found any left child is NULL, then all Nodes in that level should be NULL.
            if (current == null) {
                hasEncounteredNullValue = true;
            } else if (hasEncounteredNullValue) { //step3: if other child at that level is not NULL, then return false.
                return false;
            } else { //step1 : we are adding in Left and right sequence
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return true;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.PriorityQueue;

public class SmallestStringLexoFromLeaf {

    //https://leetcode.com/problems/smallest-string-starting-from-leaf/
    public static void main( String[] args ) {
        Node head = Node.newNode(0);

        head.left = Node.newNode(1);
        head.right = Node.newNode(2);

        head.left.left = Node.newNode(3);
        head.left.right = Node.newNode(4);

        head.right.left = Node.newNode(3);
        head.right.right = Node.newNode(4);

        String strRes = smallestFromLeaf(head);

        System.out.println(strRes);
    }

    //passing 'str' as recursion param helps in getting value at different Levels.
    //If we hit leaf Node with value = "dba" then "ba" can be used to generate another leaf value as "eba"

    //This recursion pattern is diff. from DistributeCoinsBinaryTree where -
    // we took local variable in recursion  to calculate answer based on each Node's value.

    private static void helper( Node root, String str, PriorityQueue<String> queue ) {
        if (root == null) {
            return;
        }

        //converting 0 -> A : 0 + 97 => a
        //1-> B : 1 + 97 : b
        char c = (char) (root.data + 'a');
        str = c + str;

        if (root.left == null && root.right == null) {
            queue.offer(str);
        }

        helper(root.left, str, queue);
        helper(root.right, str, queue);
    }

    private static String smallestFromLeaf( Node root ) {
        if (root == null)
            return "";

        PriorityQueue<String> queue = new PriorityQueue<>();

        helper(root, "", queue);

        //PriorityQueue maintains smallest at top.
        return queue.isEmpty() ? "" : queue.peek();
    }
}

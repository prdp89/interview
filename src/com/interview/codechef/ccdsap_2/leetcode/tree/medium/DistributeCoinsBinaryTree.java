package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

public class DistributeCoinsBinaryTree {

    private static int ans = 0;

    //https://leetcode.com/problems/distribute-coins-in-binary-tree/
    public static void main( String[] args ) {

        Node head = Node.newNode(0);

        head.left = Node.newNode(0);
        head.right = Node.newNode(0);

        //ans = abs(4-1) + abs(0-1)
        head.left.left = Node.newNode(4);
        head.left.right = Node.newNode(0);

        head.right.left = Node.newNode(3);
        head.right.right = Node.newNode(0);

        distribute(head);
    }

    //This recursion pattern is same as LongestUnivaluePath / BalancedBinaryTree
    //From child we are popping out the result to the parent.

    //ref : https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C%2B%2B-with-picture-post-order-traversal
    private static int distribute( Node node ) {
        if (node == null) {
            return 0;
        }

        int left = distribute(node.left);
        int right = distribute(node.right);

        //after each left right calculated, num. of moves = left + right
        ans += Math.abs(left) + Math.abs(right);

        //step: 1
        //we are assigning the return value to each node as : currval + left + right - 1
        //Example for Leaf Node = 4: 4 + 0 + 0 - 1 => 3 will be returned to the parent = 0
        return node.data + left + right - 1;
    }
}

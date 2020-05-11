package com.interview.leetcode.contests.biweekly.biweekely17;

import com.interview.tree.Node;

public class SumNodeOfEvenGrandParent {

    private static int sum = 0;

    //https://leetcode.com/contest/biweekly-contest-17/problems/sum-of-nodes-with-even-valued-grandparent/
    public static void main( String[] args ) {
        Node head = Node.newNode(6);

        head.left = Node.newNode(7);
        head.right = Node.newNode(8);

        head.left.left = Node.newNode(2);
        head.left.right = Node.newNode(7);

        head.right.left = Node.newNode(1);
        head.right.right = Node.newNode(3);

        head.left.left.left = Node.newNode(9);

        head.left.right.left = Node.newNode(1);
        head.left.right.right = Node.newNode(4);

        head.right.right.right = Node.newNode(5);

        System.out.println(sumEvenGrandparent(head));
    }

    private static int sumEvenGrandparent( Node root ) {
        if (root == null)
            return 0;

        dfs(root, null, null);

        return sum;
    }

    private static void dfs( Node root, Node parent, Node grandParent ) {
        if (root == null)
            return;

        if (grandParent != null && grandParent.data % 2 == 0) {
            sum += root.data;
        }

        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }
}

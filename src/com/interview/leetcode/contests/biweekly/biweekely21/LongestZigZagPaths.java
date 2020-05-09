package com.interview.leetcode.contests.biweekly.biweekely21;

import com.interview.tree.Node;

public class LongestZigZagPaths {

    private static int max = 0;

    //https://leetcode.com/contest/biweekly-contest-21/problems/longest-zigzag-path-in-a-binary-tree/
    public static void main( String[] args ) {
        Node head = Node.newNode(1);

        head.left = Node.newNode(1);
        head.right = Node.newNode(1);

        head.left.right = Node.newNode(1);

        head.left.right.left = Node.newNode(1);
        head.left.right.right = Node.newNode(1);

        head.left.right.left.right = Node.newNode(1);

        System.out.println(longestZigZag(head));
    }

    private static int longestZigZag( Node root ) {
        if (root == null)
            return 0;

        max = 0;

        dfs(root.left, 1, false);
        dfs(root.right, 1, true);

        return max;
    }

    private static void dfs( Node root, int depth, boolean isRight ) {

        if (root == null)
            return;

        max = Math.max(max, depth);

        if (isRight) { //if we are traversing from right
            dfs(root.left, depth + 1, false); //depth will increase if we are traversing left
            dfs(root.right, 1, true); //otherwise try again from start
        } else { //vice-versa
            dfs(root.right, depth + 1, true); //depth will increase if we are traversing left
            dfs(root.left, 1, false);
        }
    }
}

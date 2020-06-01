package com.interview.leetcode.contests.contest190;

import com.interview.tree.Node;

public class PseudoPalindromicPaths {

    private static int res = 0;

    //https://leetcode.com/contest/weekly-contest-190/problems/pseudo-palindromic-paths-in-a-binary-tree/
    public static void main( String[] args ) {
        Node head = Node.newNode(2);

        head.left = Node.newNode(3);
        head.right = Node.newNode(1);

        head.left.left = Node.newNode(3);
        head.left.right = Node.newNode(1);

        head.right.right = Node.newNode(1);

        System.out.println(pseudoPalindromicPaths(head));
    }

    private static int pseudoPalindromicPaths( Node root ) {
        int[] map = new int[10];

        dfs(root, map);
        return res;
    }

    private static void dfs( Node root, int[] map ) {

        if (root == null)
            return;

        map[root.data]++;

        if (root.left == null && root.right == null) {
            boolean isValid = checkValidPalin(map);
            if (isValid)
                res++;
        }

        dfs(root.left, map);
        dfs(root.right, map);

        //backtrack
        map[root.data]--;
    }

    private static boolean checkValidPalin( int[] map ) {
        int oddNums = 0;

        for (int i = 0; i < 10; i++) {
            if (map[i] % 2 != 0)
                oddNums++;

            if (oddNums > 1)
                return false;
        }

        return true;
    }
}

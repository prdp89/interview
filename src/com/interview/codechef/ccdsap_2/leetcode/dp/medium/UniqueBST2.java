package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {

    //https://leetcode.com/problems/unique-binary-search-trees-ii/

    public static void main( String[] args ) {

        int n = 3;
        List<TreeNode> list = genTreeListRecursive(1, n);

        System.out.println("Left----Root----Right");
        for (TreeNode node : list) {
            System.out.println(node.left + "-----" + node.val + "------" + node.right);
        }
    }

    //ref: https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution

    /*
    I start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n.

    So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1),
    and the right subtree will contain elements (i+1) to n. I use recursive calls to get back all possible
    trees for left and right subtrees and combine them in all possible ways with the root.
     */
    private static List<TreeNode> genTreeListRecursive( int start, int end ) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> leftList = genTreeListRecursive(start, i - 1); //same as UniqueBST (N - 1)
            List<TreeNode> rightList = genTreeListRecursive(i + 1, end); // (N - i)

            for (TreeNode left : leftList) {

                for (TreeNode right : rightList) {

                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode( int x ) {
            val = x;
        }
    }
}
package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    //https://leetcode.com/problems/binary-tree-postorder-traversal/
    public static void main( String[] args ) {

    }

    //ref : https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/327675/java-solution
    public List<Integer> postorderTraversal( TreeNode root ) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            root = stack.pop();

            if (root.left != null) {

                stack.push(root.left);
            }

            if (root.right != null) {
                stack.push(root.right);
            }

            //element pushed first will be move to last; so returns correct order
            list.add(0, root.val);
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


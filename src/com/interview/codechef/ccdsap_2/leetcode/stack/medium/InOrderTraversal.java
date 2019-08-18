package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    //https://leetcode.com/problems/binary-tree-inorder-traversal/
    public static void main( String[] args ) {

    }

    private static List<Integer> inorderTraversal2( TreeNode root ) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();

        //equals to : root -> left
        pushAllLeftRight(root, stack);

        while (!stack.isEmpty()) {
            //equals to : root -> data
            TreeNode cur = stack.pop();
            res.add(cur.val);

            //-----------------------

            //equals to : root -> right
            pushAllLeftRight(cur.right, stack);
        }
        return res;
    }

    private static void pushAllLeftRight( TreeNode node, Stack stack ) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
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

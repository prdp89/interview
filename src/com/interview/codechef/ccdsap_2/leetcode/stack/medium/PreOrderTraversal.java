package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    //https://leetcode.com/problems/binary-tree-preorder-traversal/
    public static void main( String[] args ) {

    }

    public List<Integer> preorderTraversal( TreeNode root ) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();

        //provide root first and iterate on Root and its Left
        pushAllLeft(root, stack, res);

        while (!stack.isEmpty()) {

            TreeNode cur = stack.pop();

            //iterate on root and its Right
            pushAllLeft(cur.right, stack, res);
        }

        return res;
    }

    private void pushAllLeft( TreeNode node, Stack stack, List res ) {
        while (node != null) {
            res.add(node.val); //data - > left -> right
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

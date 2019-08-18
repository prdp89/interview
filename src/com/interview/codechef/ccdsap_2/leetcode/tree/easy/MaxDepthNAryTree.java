package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxDepthNAryTree {

    private static int max = 0;

    //https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
    public static void main( String[] args ) {
        MaxDepthNAryTree nAryTree = new MaxDepthNAryTree();

        //region N-Ary INIT
        NAryTreePreOrder.Node head;
        List<NAryTreePreOrder.Node> child = new ArrayList<>();

        List<NAryTreePreOrder.Node> smallChild = new ArrayList<>();

        smallChild.add(new NAryTreePreOrder.Node(5, null));
        smallChild.add(new NAryTreePreOrder.Node(6, null));

        child.add(new NAryTreePreOrder.Node(3, smallChild));

        child.add(new NAryTreePreOrder.Node(2, null));
        child.add(new NAryTreePreOrder.Node(4, null));
        //endregion

        head = new NAryTreePreOrder.Node(1, child);

        System.out.println(maxDepth(head));

    }

    //calculating depth at each level.. it won't work :(
    private static int maxDepth( NAryTreePreOrder.Node root ) {

        if (root == null) return 0;

        Stack<NAryTreePreOrder.Node> stack = new Stack<>();
        stack.add(root);

        int depth = 0, max = Integer.MIN_VALUE;

        while (!stack.empty()) {
            depth++;

            for (int j = 0; j < stack.size(); j++) {

                root = stack.pop();

                if (null != root.children) {

                    for (int i = root.children.size() - 1; i >= 0; i--)
                        stack.add(root.children.get(i));
                }
            }
        }

        return depth;
    }

    private static void maxDepthRecursive( NAryTreePreOrder.Node node, int depth ) {
        if (node == null)
            return;

        max = Math.max(max, depth);

        //at each level increase the depth and calculate max.
        //similar to DiameterBinaryTree passing depth of each level as a param.
        for (NAryTreePreOrder.Node child : node.children) {
            maxDepthRecursive(child, depth + 1);
        }
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

public class BinaryTreePruning {

    //https://leetcode.com/problems/binary-tree-pruning/
    public static void main( String[] args ) {
        pruneTree(null);
    }

    //ref : https://leetcode.com/articles/binary-tree-pruning/?orderBy=most_votes
    private static Node pruneTree( Node root ) {
        if (root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        //if a node's right and left is NULL and value is zero then we don't need that Node
        if (root.data == 0 && root.left == null && root.right == null)
            root = null;

        return root;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

public class LCABinaryTree {

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public static void main( String[] args ) {

    }

    //https://www.youtube.com/watch?v=F-_1sbnPbWQ
    //Recursion Pattern is almost same as : DistributeCoinsBinaryTree; Propagating result to the parent, that's it :)
    //https://www.youtube.com/watch?v=13m9ZCB8gjw
    private static Node lca( Node root, Node n1, Node n2 ) {

        //if we reaches LEAF and node not found then NULL propagates to its parent
        //Step Base :
        if (root == null) {
            return null;
        }

        //If we reach to a Node which equals to either N1 || N2
        //Then this node propagate to its parent.

        //Step2 : If we found N1 return that node
        if (root == n1 || root == n2) {
            return root;
        }

        //Step 1 : we are iterating on Left to search for eg. N1
        Node left = lca(root.left, n1, n2);

        //Step3: we are iterating on Right to search for eg. N2
        Node right = lca(root.right, n1, n2);

        //If we found both Left and Right then current Root is LCA
        if (left != null && right != null) {
            return root;
        }

        //If anything branch returns NULL from Step Base : then return right Node.
        return left != null ? left : right;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class LCABST {

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    //check : SmallestSubtreeDeepestNode for LCA of normal tree
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(6, head);
        head = bt.addNode(2, head);
        head = bt.addNode(8, head);
        head = bt.addNode(0, head);
        head = bt.addNode(4, head);
        head = bt.addNode(7, head);
        head = bt.addNode(9, head);
        head = bt.addNode(3, head);
        head = bt.addNode(5, head);

        System.out.println(lowestCommonAncestor(head, Node.newNode(2), Node.newNode(8)).data);
    }


    //ref : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives
    private static Node lowestCommonAncestor( Node root, Node p, Node q ) {

        while (true) {

            //if root - q greater than zero then search for left side
            if (root.data - p.data > 0 && root.data - q.data > 0)
                root = root.left;
            else if (root.data - p.data < 0 && root.data - q.data < 0)
                root = root.right;
            else break;
        }

        //root is always the answer after above looping finishes
        return root;
    }

    //Recursive implementation..
    private static Node lowestCommonAncestorRecursive( Node root, Node p, Node q ) {
        if (root == null) {
            return null;
        }

        if (root.data > p.data && root.data > q.data) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        } else if (root.data < p.data && root.data < q.data) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        } else {
            return root;
        }
    }
}

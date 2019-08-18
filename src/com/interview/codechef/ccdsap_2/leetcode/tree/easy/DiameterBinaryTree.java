package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class DiameterBinaryTree {

    //https://leetcode.com/problems/diameter-of-binary-tree/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(2, head);
        head = bt.addNode(13, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(11, head);
        head = bt.addNode(15, head);

        System.out.println(diameterOfBinaryTree(head)); //op 4 : diameter between {1 - 15}
    }

    //ref: https://leetcode.com/problems/diameter-of-binary-tree/discuss/101130/C%2B%2B-Java-Clean-Code
    private static int diameterOfBinaryTree( Node root ) {

        int[] diameter = new int[1];
        height(root, diameter);

        return diameter[0];
    }

    private static int height( Node node, int[] diameter ) {
        if (node == null) {
            return 0;
        }

        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);

        //final diameter will be : ( lh + rh ) of two nodes in a tree
        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh); //similar to height of tree algo
    }
}

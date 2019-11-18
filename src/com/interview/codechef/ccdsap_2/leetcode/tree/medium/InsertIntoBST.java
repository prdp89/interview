package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class InsertIntoBST {

    //https://leetcode.com/problems/insert-into-a-binary-search-tree/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(4, head);
        head = bt.addNode(2, head);
        head = bt.addNode(7, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);

        Node node = insertIntoBST(head, 5);
    }

    //solved with little help :)
    private static Node insertIntoBST( Node root, int val ) {
        Node temp = root;

        Node temp1 = searchNode(temp, val);

        if (temp1.data > val)
            temp1.left = Node.newNode(val);
        else
            temp1.right = Node.newNode(val);

        return root;
    }

    private static Node searchNode( Node root, int val ) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;

        //This corner case I am only missing
        if (root.data < val && root.right == null) {
            return root;
        } else if (root.data > val && root.left == null) {
            return root;
        }
        //-----------------------------

        if (root.data > val)
            return searchNode(root.left, val);

        if (root.data < val)
            return searchNode(root.right, val);

        return root;
    }
}

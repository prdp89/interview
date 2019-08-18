package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class SearchInBST {

    //https://leetcode.com/problems/search-in-a-binary-search-tree/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(4, head);
        head = bt.addNode(2, head);
        head = bt.addNode(7, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);

        Node data = searchBST(head, 2);
    }

    //solved in one attempt..
    private static Node searchBST( Node root, int val ) {

        if (root == null)
            return null;

        if(root.data == val)
            return root;

        if (root.data > val)
            return searchBST(root.left, val);
        else if (root.data < val)
            return searchBST(root.right, val);

        return root;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

public class DeleteNodeBST {

    //https://leetcode.com/problems/delete-node-in-a-bst/
    public static void main( String[] args ) {

        Node head = Node.newNode(5);

        head.left = Node.newNode(3);
        head.right = Node.newNode(6);

        head.left.left = Node.newNode(2);
        head.left.right = Node.newNode(4);

        head.right.right = Node.newNode(7);

        Node res = deleteNodeTry(head, 6, null);
    }

    //*********Optimal Iterative Solution*************

    //ref : https://leetcode.com/problems/delete-node-in-a-bst/discuss/93298/Iterative-solution-in-Java-O(h)-time-and-O(1)-space
    private static Node deleteNodeOPtimal( Node root, int key ) {
        Node cur = root;
        Node pre = null;
        while (cur != null && cur.data != key) {
            pre = cur;
            if (key < cur.data) {
                cur = cur.left;
            } else if (key > cur.data) {
                cur = cur.right;
            }
        }

        //if cur not found then delete root
        if (pre == null) {
            return deleteRootNode(cur);
        }

        //same as mine logic; checking if curr is parent's left or right
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }

    private static Node deleteRootNode( Node root ) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        //min. will always be at current right -> left's
        Node next = findMin(root.right);
        //setting new smallest left to root.left : so that root.left subtree is valid further
        next.left = root.left;

        return root.right;
    }

    private static Node findMin( Node root ) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    //***********************************************

    private static Node deleteNodeTry( Node root, int key, Node prev ) {

        if (root == null)
            return null;

        if (root.data == key) {

            //I only handled the case when root has one child; replace that child with parent;
            if (prev != null && prev.left == root) {
                if (root.right != null) {
                    prev.left = root.right;
                    root.right = null;
                } else {
                    prev.left = root.left;
                    root.right = null;
                }
            } else if (prev != null && prev.right == root) {
                if (root.right != null) {
                    prev.right = root.right;
                    root.right = null;
                } else {
                    prev.right = root.left;
                    root.right = null;
                }
            }
        }

        if (key < root.data)
            root.left = deleteNodeTry(root.left, key, root);

        if (key > root.data)
            root.right = deleteNodeTry(root.right, key, root);

        return root;
    }
}

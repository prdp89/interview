package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.Stack;

public class SymmetricTree {

    //https://leetcode.com/problems/symmetric-tree/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(2, head);
        head = bt.addNode(13, head);

        //since we are creating BST here, this leads to wrong result; check in Leetcode IDE
        System.out.println(isSymmetric(head));

        System.out.println(isSymmetricIterative(head));
    }

    //explanation : https://www.youtube.com/watch?v=8t4KCaDB108
    /*

     For two trees to be mirror images, the following three
     conditions must be true :

     1 - Their root node's values of both tree have to be same
     2 - left subtree of left tree and right subtree
          of right tree have to be mirror images {all values in that path should be equal}
     3 - right subtree of left tree and left subtree
          of right tree have to be mirror images {all values in that path should be equal}
     */

    private static boolean isSymmetric( Node root ) {

        if (root == null)
            return true;

        return checkIfSymmetric(root.left, root.right);
    }

    private static boolean checkIfSymmetric( Node root, Node root1 ) {

        //step1
        if (root == null && root1 == null)
            return true;

        if (root == null || root1 == null)
            return false;

        //step 2 & 3
        if (root.data == root1.data) {

            if (checkIfSymmetric(root.left, root1.right) && checkIfSymmetric(root.right, root1.left))
                return true;
        }

        return false;
    }

    private static boolean isSymmetricIterative( Node root ) {
        if (root == null)
            return true;

        Stack<Node> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {
            Node n1 = stack.pop(), n2 = stack.pop();

            //step1: if both null then its fine
            if (n1 == null && n2 == null)
                continue;

            if (n1 == null || n2 == null || n1.data != n2.data)
                return false;

            //step 2 & 3
            //bcz left should equals to right
            stack.push(n1.left);
            stack.push(n2.right);

            //right should equals to left
            stack.push(n1.right);
            stack.push(n2.left);
        }

        return true;
    }
}

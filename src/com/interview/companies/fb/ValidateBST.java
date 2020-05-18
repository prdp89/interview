package com.interview.companies.fb;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.Stack;

public class ValidateBST {

    //https://leetcode.com/problems/validate-binary-search-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(2, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);

        System.out.println(isValidBST(head));

    }

    //similar logic as : MinABSBST
    private static boolean isValidBST( Node root ) {

        Stack<Node> stack = new Stack<>();

        Node prev = null;

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (prev != null && root.data <= prev.data)
                return false;

            prev = root;
            root = root.right;
        }

        return true;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.Stack;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestInBst {

    private static int number = 0;
    private static int count = 0;

    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(3, null);
        head = bt.addNode(1, head);
        head = bt.addNode(4, head);
        head = bt.addNode(2, head);

        //System.out.println(kthSmallest_Method_1(head, 2));

        System.out.println(kthSmallest_method_2(head, 2));
    }

    //Complexity O ( N ) //This is In-Order Recursion
    private static int kthSmallest_Method_1( Node root, int k ) {
        count = k;
        helper(root);
        return number;
    }

    private static void helper( Node n ) {

        //goto left if left not null
        if (n.left != null)
            helper(n.left);

        count--;

        if (count == 0) {
            number = n.data;
            return;
        }

        if (n.right != null)
            helper(n.right);
    }

    //DFS - ITerative approach :  O ( N )
    private static int kthSmallest_method_2( Node root, int k ) {
        Stack<Node> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            Node n = st.pop();
            k--;

            if (k == 0)
                return n.data;

            Node right = n.right;

            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }

   /* private static int countNodes( Node n ) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }*/
}

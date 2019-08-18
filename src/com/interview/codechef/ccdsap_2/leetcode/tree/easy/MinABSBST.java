package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinABSBST {

    static int minDiff = Integer.MAX_VALUE;
    static Node prev;

    //https://leetcode.com/problems/minimum-absolute-difference-in-bst/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(2, head);
        head = bt.addNode(13, head);

        //System.out.println(getMinimumDifference(head));

        System.out.println(getMinimumDifferenceRecursive(head));
    }

    //Runtime: 39 ms, faster than 5.48%
    private static int getMinimumDifference( Node root ) {

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        list.sort(Comparator.comparingInt(a -> a));

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }

        return min;
    }

    private static void inOrder( Node root, List<Integer> list ) {
        if (root == null)
            return;

        inOrder(root.left, list);

        list.add(root.data);
        inOrder(root.right, list);
    }

    private static void inorderRecursive( Node root ) {
        if (root == null) return;

        inorderRecursive(root.left);

        if (prev != null)
            minDiff = Math.min(minDiff, root.data - prev.data);

        prev = root;

        inorderRecursive(root.right);
    }

    // https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99941/Java-O(n)-Time-Inorder-Traversal-Solution
    //Logic : Since this is a BST, the inorder traversal of its nodes results in a sorted list of values.
    //Meaning: BST nodes are categorize acc. to left and right {smaller/greater than parent}
    //         So min. diff.can be calulated using = Min{root - left , right - root}
    private static int getMinimumDifferenceRecursive( Node root ) {
        inorderRecursive(root);
        return minDiff;
    }
}
package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SecondMinimumNodeBinaryTree {

    //https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(2, head);
        head = bt.addNode(2, head);
        head = bt.addNode(5, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);

        System.out.println(findSecondMinimumValue(head));
    }

    //Runtime: 35 ms, faster than 5.23% of Java online submissions
    private static int findSecondMinimumValue( Node root ) {

        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        list.sort(Comparator.comparingInt(a -> a));

        if (list.size() <= 1)
            return -1;

        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > min) {
                return list.get(i);
            }
        }

        return -1;
    }

    private static void inorderTraversal( Node root, List<Integer> list ) {

        if (root == null)
            return;

        list.add(root.data);

        inorderTraversal(root.left, list);
        inorderTraversal(root.right, list);
    }
}

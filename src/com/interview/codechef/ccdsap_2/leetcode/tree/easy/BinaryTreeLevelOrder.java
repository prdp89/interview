package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {

    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
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

        List<List<Integer>> list = levelOrderBottom(head);
        for (List<Integer> res : list) {

            res.forEach(System.out::println);
        }
    }

    //solved in one go.. :)
    private static List<List<Integer>> levelOrderBottom( Node root ) {

        if (root == null)
            return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()) {

            List<Integer> tempList = new ArrayList<>();

            int size = queue.size();

            while (size-- > 0) {

                Node node = queue.poll();
                tempList.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            list.add(0, tempList);

        }

        return list;
    }
}
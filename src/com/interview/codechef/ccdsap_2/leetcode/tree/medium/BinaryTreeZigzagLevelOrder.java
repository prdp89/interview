package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.*;

public class BinaryTreeZigzagLevelOrder {

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public static void main( String[] args ) {
        Node head = Node.newNode(3);

        head.left = Node.newNode(9);
        head.right = Node.newNode(20);

        head.right.left = Node.newNode(15);
        head.right.right = Node.newNode(7);

        zigzagLevelOrder(head).forEach(System.out::println);
    }

    //Runtime: 1 ms, faster than 96.43% of Java ; in one attempt :)
    private static List<List<Integer>> zigzagLevelOrder( Node root ) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> listList = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();
        tempList.add(root.data);

        listList.add(tempList);

        //to check tree Level for Zigzag
        int i = 1;

        while (!queue.isEmpty()) {

            tempList = new ArrayList<>();
            int size = queue.size();

            while (size-- > 0) {

                Node node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            for (Node node : queue) {
                tempList.add(node.data);
            }

            if (!tempList.isEmpty()) {
                if (i % 2 != 0) {
                    Collections.reverse(tempList);
                }

                listList.add(tempList);
            }

            i++;
        }

        return listList;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {

    //https://leetcode.com/problems/average-of-levels-in-binary-tree/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(4, head);
        head = bt.addNode(2, head);
        head = bt.addNode(7, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);

        averageOfLevels(head).forEach(System.out::println);
    }

    //solved in one go..
    private static List<Double> averageOfLevels( Node root ) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<Double> list = new ArrayList<>();

        while (!queue.isEmpty()) {

            int size = queue.size(), temp = size;

            long sum = 0;
            while (size-- > 0) {

                Node child = queue.poll();
                sum += child.data;

                if (child.left != null)
                    queue.add(child.left);

                if (child.right != null)
                    queue.add(child.right);
            }

            list.add(sum / (double) temp);
        }

        return list;
    }

    //https://leetcode.com/contest/weekly-contest-150/problems/maximum-level-sum-of-a-binary-tree/
    private static int maxOfLevelsSum( Node root ) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            int size = queue.size();

            int sum = 0;
            while (size-- > 0) {

                Node child = queue.poll();
                sum += child.data;

                if (child.left != null)
                    queue.add(child.left);

                if (child.right != null)
                    queue.add(child.right);
            }

            list.add(sum);
            max = Math.max(max, sum);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max)
                return i + 1;
        }

        return 0;
    }
}
package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestInEachTreeRow {

    //https://leetcode.com/problems/find-largest-value-in-each-tree-row/
    public static void main( String[] args ) {
        Node head = Node.newNode(1);

        head.left = Node.newNode(3);
        head.right = Node.newNode(2);

        head.left.left = Node.newNode(5);
        head.left.right = Node.newNode(3);

        head.right.right = Node.newNode(9);

        largestValues(head).forEach(System.out::println);
    }

    //Runtime: 3 ms, faster than 14.93% of Java online submissions
    private static List<Integer> largestValues( Node root ) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        res.add(root.data);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                Node node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            if (queue.size() > 0)
                res.add(findMax(queue));
        }
        return res;
    }

    private static int findMax( Queue<Node> queue ) {

        int max = Integer.MIN_VALUE;

        for (Node node : queue){
            max = Math.max(max, node.data);
        }
        return max;
    }
}

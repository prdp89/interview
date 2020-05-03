package com.interview.leetcode.thirtydayschallenge;

import com.interview.tree.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckValidSequence {

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
    public static void main( String[] args ) {
        Node head = Node.newNode(0);

        head.right = Node.newNode(0);
        head.left = Node.newNode(1);

        head.right.left = Node.newNode(0);

        head.left.left = Node.newNode(0);
        head.left.right = Node.newNode(1);

        head.left.left.right = Node.newNode(1);

        head.left.right.left = Node.newNode(0);
        head.left.right.right = Node.newNode(0);

        int[] arr = {0, 1, 1};

        System.out.println(isValidSequence(head, arr));
    }

    //Runtime: 21 ms
    //Memory Usage: 39.9 MB
    private static boolean isValidSequence( Node root, int[] arr ) {

        StringBuilder sb = new StringBuilder();
        for (int anArr : arr)
            sb.append(anArr);

        Queue<TempNOde> queue = new LinkedList<>();
        queue.add(new TempNOde(root, root.data + ""));

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TempNOde node = queue.poll();

                if (node.node.left != null) {
                    queue.offer(new TempNOde(node.node.left, node.val + "" + node.node.left.data + ""));
                }

                if (node.node.right != null) {
                    queue.offer(new TempNOde(node.node.right, node.val + "" + node.node.right.data + ""));
                }

                if (node.node.left == null && node.node.right == null) {
                    if (node.val.equals(sb.toString()))
                        return true;
                }
            }
        }

        return false;
    }

    public boolean isValidSequenceOptimal( Node root, int[] arr ) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        for (int depth = 0; !q.isEmpty() && depth < arr.length; ++depth) { // search depth level control.

            for (int sz = q.size(); sz > 0; --sz) { // search breath control.

                Node n = q.poll();

                if (n != null && n.data == arr[depth]) { // a matching node found.

                    if (depth + 1 == arr.length && n.left == null && n.right == null) {
                        // match from root to a leave hence it is a valid sequence.
                        return true;
                    }

                    q.addAll(Arrays.asList(n.left, n.right)); // add into Queue its children for next depth level.
                }
            }
        }
        return false; // No valid sequence.
    }

    private static class TempNOde {
        Node node;
        String val;

        TempNOde( Node node, String val ) {
            this.node = node;
            this.val = val;
        }
    }
}
package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumRootLeafBinaryNum {

    //https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(0, head);
        head = bt.addNode(1, head);
        head = bt.addNode(0, head);
        head = bt.addNode(1, head);
        head = bt.addNode(0, head);
        head = bt.addNode(1, head);

        print("", head, false);

        System.out.println(sumRootToLeaf(head) % 1000000007);
    }

    //solved but taken 35 MS
    //I am appending string and converting it later. But in case of binary logic is:
    // Digit_binary_to_decimal {left to right} = 101 => (1* 2 + 0)=> 2 * 2 + 1 => 5 == 101 {binary form}

    // formula is: val = val * 2 + next_val
    private static int sumRootToLeaf( Node root ) {
        Stack<Pair> stack = new Stack<>();

        stack.add(new Pair(root, root.data + ""));

        List<String> list = new ArrayList<>();

        while (!stack.isEmpty()) {

            int size = stack.size();

            while (size-- > 0) {
                Pair pair = stack.pop();

                if (pair.node.left != null) {
                    stack.add(new Pair(pair.node.left, pair.val + pair.node.left.data + ""));
                }

                if (pair.node.right != null) {
                    stack.add(new Pair(pair.node.right, pair.val + pair.node.right.data + ""));
                }

                if (pair.node.left == null && pair.node.right == null)
                    list.add(pair.val);
            }
        }

        final int[] sum = {0};
        list.forEach(item -> {
                    sum[0] += Long.parseLong(item, 2);
                }
        );

        return sum[0];
    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    static class Pair {
        public Node node;
        public String val;

        public Pair( Node node, String val ) {
            this.node = node;
            this.val = val;
        }
    }
}

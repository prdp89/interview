package com.interview.companies.amazon;

import java.util.List;

public class SubtreeMaxAverage {

    double max = Integer.MIN_VALUE;
    Node maxNode = null;

    //https://leetcode.com/discuss/interview-question/349617

    /*
    Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.

    A subtree of a tree is the node which have at least 1 child plus all its descendants.
    The average value of a subtree is the sum of its values, divided by the number of nodes.
     */
    public static void main( String[] args ) {

    }

    public Node maximumAverageSubtree( Node root ) {
        if (root == null) return null;
        helper(root);
        return maxNode;
    }

    private double[] helper( Node root ) {
        if (root == null)
            return new double[]{0, 0};

        double curTotal = root.val;
        double count = 1;

        for (Node child : root.children) {
            double[] cur = helper(child);
            curTotal += cur[0];
            count += cur[1];
        }

        double avg = curTotal / count;
        if (count > 1 && avg > max) { //taking "at least 1 child" into account
            max = avg;
            maxNode = root;
        }

        return new double[]{curTotal, count};
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node( int _val, List<Node> _children ) {
            val = _val;
            children = _children;
        }
    }
}

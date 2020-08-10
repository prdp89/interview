package com.interview.leetcode.contests._new_weekely.weekely199;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class NumberOfGoodLeafPairs {

    private static int res = 0;

    //https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
    public static void main( String[] args ) {
        Node root = Node.newNode(1);

        root.left = Node.newNode(2);
        root.right = Node.newNode(3);

        root.left.right = Node.newNode(4);

        new NumberOfGoodLeafPairs().countPairs(root, 3);
        System.out.println(res);
    }

    //Runtime: 10 ms, faster than 78.23% of Java
    //https://www.youtube.com/watch?v=hA408ZMan1Q&feature=youtu.be&t=1
    private List<Integer> countPairs( Node root, int distance ) {
        if (root == null)
            return null;

        //leaf distance is 1
        List<Integer> resList = new ArrayList<>();
        if (root.left == null && root.right == null) {
            resList.add(1);
            return resList;
        }

        List<Integer> left = countPairs(root.left, distance);
        List<Integer> right = countPairs(root.right, distance);

        //verify left and right distance within the Threshold
        if (left != null && right != null) {
            for (int x : left) {
                for (int y : right) {
                    if (x + y <= distance)
                        res++;
                }
            }
        }

        //returning left distance to its parent : doing curr + 1
        if (left != null) {
            for (int x : left) {
                if (x + 1 <= distance)
                    resList.add(x + 1); //bcz x+1 should pass back to parent.
            }
        }

        if (right != null) {
            for (int x : right) {
                if (x + 1 <= distance)
                    resList.add(x + 1); //bcz x+1 should pass back to parent.
            }
        }

        return resList;
    }
}

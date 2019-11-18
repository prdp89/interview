package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    //This Program is classic example of DP on Tree
    public static void main( String[] args ) {

        Node head = Node.newNode(3);

        head.left = Node.newNode(4);
        head.right = Node.newNode(5);

        //ans = abs(4-1) + abs(0-1)
        head.left.left = Node.newNode(1);
        head.left.right = Node.newNode(3);

        head.right.right = Node.newNode(1);

        //System.out.println(robRecursive(head));

        System.out.println(robRecursiveMemo(head, new HashMap<>()));
    }

    //ref: https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
    //Two possible ways to Rob the Tree:
    // 1. If we Rob the Root node then we have rob root.child.child { root.left.left, root.left.right, root.right.left, root.right.right }
    // 2. Or we can Rob the root.left and root.right

    //Time Complexity : O (2^N)
    private static int robRecursive( Node root ) {

        if (root == null)
            return 0;

        int val = 0;

        if (root.left != null) {
            val += robRecursive(root.left.left) + robRecursive(root.left.right);
        }

        if (root.right != null) {
            val += robRecursive(root.right.left) + robRecursive(root.right.right);
        }

        return Math.max(val + root.data,
                robRecursive(root.left) + robRecursive(root.right));
    }

    //Runtime: 4 ms, faster than 53.87% of Java online submissions
    private static int robRecursiveMemo( Node root, Map<Node, Integer> map ) {

        if (root == null)
            return 0;

        //if Map already contains key Node, return Max Rob value of it.
        if (map.containsKey(root))
            return map.get(root);

        int val = 0;

        //same as above
        if (root.left != null) {
            val += robRecursiveMemo(root.left.left, map) + robRecursiveMemo(root.left.right, map);
        }

        if (root.right != null) {
            val += robRecursiveMemo(root.right.left, map) + robRecursiveMemo(root.right.right, map);
        }

        val = Math.max(val + root.data,
                robRecursiveMemo(root.left, map) + robRecursiveMemo(root.right, map));

        map.put(root, val);

        return val;
    }

}
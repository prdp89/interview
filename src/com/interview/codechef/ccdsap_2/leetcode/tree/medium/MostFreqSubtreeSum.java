package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MostFreqSubtreeSum {

    //https://leetcode.com/problems/most-frequent-subtree-sum/

    /* Qut. Actual Meaning: consider first example
    The bottom node with a value of 2 has a subtree num of 2. Because it has 2 null sub-node and we consider
    both of them represent value of 0 which we dont consider in the final result, and 0 plus the value of itself equals to 2.
    The sum of right subnode of root is -3.

    So, now we see the root node, it has a subtree whose sum is 2 and another is -3, so the sum of root
    node is 2 - 3 + 5 = 4. So, we can get three sum from three node, each of them appear once,
    so we should return them together in a vector.
     */

    private static int maxSumFrequency = 0;

    public static void main( String[] args ) {
        Node head = Node.newNode(5);

        head.left = Node.newNode(2);
        head.right = Node.newNode(-3);

        System.out.println(Arrays.toString(findFrequentTreeSum(head)));
    }

    //We are moving to the leftmost node first then calculate sum of each subtree
    //Sum  : is propagate to parent to find its left/right sum.
    private static int postOrderTraversal( Node root, HashMap<Integer, Integer> map ) {
        if (root == null) {
            return 0;
        }

        int left = postOrderTraversal(root.left, map);
        int right = postOrderTraversal(root.right, map);

        int sum = left + right + root.data;

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        maxSumFrequency = Math.max(maxSumFrequency, map.get(sum));

        return sum;
    }

    //Runtime: 40 ms, faster than 13.33%
    private static int[] findFrequentTreeSum( Node root ) {

        //Map stores each subtree SUM's frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        postOrderTraversal(root, map);

        List<Integer> list = new ArrayList<>();

        //comparing freq. with Max. frequency of Sum and add to the list.
        for (int s : map.keySet()) {
            if (map.get(s) == maxSumFrequency)
                list.add(s);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

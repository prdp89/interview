package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumBinaryTree {

    //https://leetcode.com/problems/maximum-binary-tree/
    public static void main( String[] args ) {

        int[] arr = {3, 2, 1, 6, 0, 5};

        //constructMaximumBinaryTreeTry(arr);

        constructMaximumBinaryTreeOptimal(arr);
    }

    private static Node constructMaximumBinaryTreeOptimal( int[] nums ) {

        if (nums == null || nums.length == 0)
            return null;

        // find highest number in the array and its index
        int maxNumber = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNumber) {
                maxNumber = nums[i];
                maxIndex = i;
            }
        }

        // create node for the highest number
        Node root = Node.newNode(maxNumber);
        // recursively set the left node of the node with maximum
        // number using numbers to its left in the input array
        if (maxIndex > 0) {
            int[] leftNums = new int[maxIndex];

            for (int i = 0; i < maxIndex; i++) {
                leftNums[i] = nums[i];
            }

            root.left = constructMaximumBinaryTreeOptimal(leftNums);
        }

        // recursively set the right node of the node with maximum
        // number using numbers to its right in the input array
        if (maxIndex < nums.length - 1) {
            int[] rightNums = new int[nums.length - maxIndex - 1];

            for (int i = maxIndex + 1; i < nums.length; i++) {
                rightNums[i - maxIndex - 1] = nums[i];
            }

            root.right = constructMaximumBinaryTreeOptimal(rightNums);
        }

        return root;
    }

    //Trying with logic of SortedArrayToBST; couldn't solve
    private static Node constructMaximumBinaryTreeTry( int[] nums ) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        Queue<MyNode> queue = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;

        int[] maxIndex = new int[1];

        Node root = Node.newNode(getMaxInRange(nums, left, right, maxIndex));

        queue.offer(new MyNode(root, left, right, maxIndex[0]));

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {

                MyNode cur = queue.poll();

                int leftMaxElement = getMaxInRange(nums, cur.leftIndex, cur.maxIndex, maxIndex);
                if (maxIndex[0] != cur.maxIndex) {
                    Node leftChild = Node.newNode(leftMaxElement);

                    cur.node.left = leftChild;
                    queue.offer(new MyNode(leftChild, cur.leftIndex, cur.rightIndex, cur.maxIndex));
                }
            }
        }

        return root;
    }

    private static int getMaxInRange( int[] nums, int i, int j, int[] maxIndex ) {

        int max = Integer.MIN_VALUE;

        for (int temp = i; temp <= j; temp++) {

            if (nums[temp] > max) {
                max = Math.max(max, nums[temp]);
                maxIndex[0] = temp;
            }
        }

        return max;
    }

    private static class MyNode {
        Node node;
        int leftIndex;
        int rightIndex;
        int maxIndex;

        MyNode( Node n, int theLeft, int theRight, int maxIndex ) {
            this.node = n;
            this.leftIndex = theLeft;
            this.rightIndex = theRight;
            this.maxIndex = maxIndex;
        }
    }
}

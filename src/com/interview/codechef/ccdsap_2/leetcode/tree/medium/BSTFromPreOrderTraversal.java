package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTFromPreOrderTraversal {

    private static int nodeIdx;

    //https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
    public static void main( String[] args ) {
        int[] arr = {8, 5, 1, 7, 10, 12};

        // bstFromPreorderTry(arr);

        //bstFromPreorderRecursive(arr);

        Node result = bstFromPreorderIterative(arr);
    }

    //couldn't think of it anymore :(
    private static Node bstFromPreorderTry( int[] nums ) {

        if (nums == null || nums.length == 0)
            return null;

        int i = 0;
        Node node = Node.newNode(nums[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty() || i < nums.length) {


            i++;
        }

        return node;
    }

    private static Node bstHelper( int[] preorder, int start, int end ) {

        //if reaches end of array || left < Integer.MINVALUE
        if (nodeIdx == preorder.length || preorder[nodeIdx] < start || preorder[nodeIdx] > end) {
            return null;
        }

        int val = preorder[nodeIdx++];

        Node node = Node.newNode(val);
        node.left = bstHelper(preorder, start, val);
        node.right = bstHelper(preorder, val, end);

        return node;
    }

    //ref : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252232/JavaC%2B%2BPython-O(N)-Solution
    //solution of User : tohrah
    private static Node bstFromPreorderRecursive( int[] preorder ) {
        if (preorder == null) {
            return null;
        }

        nodeIdx = 0;

        //every node in Tree should lies between -Infinity -> +Infinity
        return bstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //THis is really easy example of Using stack for preorder traversal;
    //We use Stack bcz we need to iterate in DFS manner.
    private static Node bstFromPreorderIterative( int[] preorder ) {
        if (preorder == null) {
            return null;
        }

        Node dummyRoot = Node.newNode(Integer.MAX_VALUE);
        Stack<Node> stack = new Stack<>();

        //push a dummy node initially
        stack.push(dummyRoot);

        for (int i = 0; i < preorder.length; i++) {

            Node current = Node.newNode(preorder[i]);
            Node temp = null;

            //This condition will not run for first time; bcz first Node always inserted at left.

            //This condition evaluates when we need to insert the Node at right.
            // So we pop out until we find last smaller Node that is greater than current Preorder[i]th element.
            while (stack.peek().data < preorder[i]) {
                temp = stack.pop();
            }

            //THis Last smaller popped Node is smaller than PreOrder[i]
            //So insert it at the right.
            if (temp != null) {
                temp.right = current;
            } else { //This condition evaluate first time and whenever the Preorder[i] is less that stack top
                Node top = stack.peek();
                top.left = current; //so assigning the stack top left to the current array element.
            }

            stack.push(current);
        }

        return dummyRoot.left;
    }
}

package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {

    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

    //easy but little tricky logic
    //This program teaches how to create BST from an array.
    public static void main( String[] args ) {

        int[] arr = {-10, -3, 0, 5, 9};
        Node node = sortedArrayToBST(arr);

        print("", node, false);
    }

    //looks like level order traversal
    //same as AverageLevelsBinaryTree but here we are filling each level first before moving to the next level
    private static Node sortedArrayToBST( int[] nums ) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Queue<MyNode> queue = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;

        //getting mid value from array
        int val = nums[left + (right - left) / 2];

        //keeping a root node here...
        Node root = Node.newNode(val);

        //inserting mid into the queue
        queue.offer(new MyNode(root, left, right));

        while (!queue.isEmpty()) {
            int size = queue.size();

            //for each level nodes populating its left and right
            //If array  = { -10, -3, 0, 5 , 9}
            //Then zero 0 is root we inserted above
            //In below loop : we are taking root.left = -3 and root.right = 9
            for (int i = 0; i < size; i++) {
                MyNode cur = queue.poll();

                int mid = cur.lb + (cur.rb - cur.lb) / 2;

                //inserting left until mid become left
                if (mid != cur.lb) {
                    //Mid = 2, left = 0 then we are picking (mid - 1) for its left
                    //eg : 0 + (2 - 1 - 0) /2 = 1 => nums[1] = -3
                    Node leftChild = Node.newNode(nums[cur.lb + (mid - 1 - cur.lb) / 2]);

                    //assigning left node to the root
                    cur.node.left = leftChild;

                    //inserting left in the queue again with it left and right bound
                    //so that in next level we can populate its left/right child
                    queue.offer(new MyNode(leftChild, cur.lb, mid - 1));
                }

                if (mid != cur.rb) {
                    Node rightChild = Node.newNode(nums[mid + 1 + (cur.rb - mid - 1) / 2]);
                    cur.node.right = rightChild;
                    queue.offer(new MyNode(rightChild, mid + 1, cur.rb));
                }
            }
        }

        return root;
    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    private static class MyNode {
        Node node;
        int lb;
        int index;
        int rb;

        MyNode( Node n, int theLeft, int theRight ) {
            this.node = n;
            this.lb = theLeft;
            this.rb = theRight;
        }
    }
}

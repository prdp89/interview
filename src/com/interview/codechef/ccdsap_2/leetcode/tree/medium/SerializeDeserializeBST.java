package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST {

    //https://leetcode.com/problems/serialize-and-deserialize-bst/

    //This program can be easily Solved by Serialising to PreOrder traversal
    //Then deserialisation using BSTFromPreOrderTraversal {really easy}

    //read optimal sol here: https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/93175/Java-PreOrder-%2B-Queue-solution
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(2, head);
        head = bt.addNode(13, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(8, head);
        head = bt.addNode(15, head);

        String str = serialize(head);
        Node res = deserialize(str);
    }

    //I tried Inorder for Serialization of Tree and
    // SortedArrayToBST for deSerialization of Tree
    private static String serialize( Node root ) {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private static void inOrder( Node root, StringBuilder sb ) {

        if (root == null)
            return;

        inOrder(root.left, sb);

        sb.append(root.data).append(",");

        inOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    private static Node deserialize( String data ) {
        String[] str = data.split(",");

        return sortedArrayToBST(str);
    }

    private static Node sortedArrayToBST( String[] nums ) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Queue<MyNode> queue = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;

        //getting mid value from array
        String val = nums[left + (right - left) / 2];

        //keeping a root node here...
        Node root = Node.newNode(Integer.parseInt(val));

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
                    Node leftChild = Node.newNode(Integer.parseInt(nums[cur.lb + (mid - 1 - cur.lb) / 2]));

                    //assigning left node to the root
                    cur.node.left = leftChild;

                    //inserting left in the queue again with it left and right bound
                    //so that in next level we can populate its left/right child
                    queue.offer(new MyNode(leftChild, cur.lb, mid - 1));
                }

                if (mid != cur.rb) {
                    Node rightChild = Node.newNode(Integer.parseInt(nums[mid + 1 + (cur.rb - mid - 1) / 2]));
                    cur.node.right = rightChild;
                    queue.offer(new MyNode(rightChild, mid + 1, cur.rb));
                }
            }
        }

        return root;
    }

    private static class MyNode {
        Node node;
        int lb;
        int rb;

        MyNode( Node n, int theLeft, int theRight ) {
            this.node = n;
            this.lb = theLeft;
            this.rb = theRight;
        }
    }
}

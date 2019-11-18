package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AddOneRowInTree {

    //https://leetcode.com/problems/add-one-row-to-tree/
    public static void main( String[] args ) {
        Node head = Node.newNode(4);

        head.left = Node.newNode(2);
        head.right = Node.newNode(6);

        head.left.left = Node.newNode(3);
        head.left.right = Node.newNode(1);

        head.right.left = Node.newNode(5);

        //Node res = addOneRow(head, 1, 2);
        Node res = addOneRowOptimal(head, 1, 2);
    }

    //30 / 109 test cases passed.
    private static Node addOneRow( Node root, int v, int d ) {

        if (d == 1) {
            Node node = Node.newNode(v);
            node.left = root;
            return node;
        }

        HashMap<Node, Node> map = new HashMap<>();

        //finding each node's parent
        populateNodeToParentMap(map, root, null);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //looping until we reach required level
        while (d-- > 1) {

            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            Node parentNode = map.get(node);

            Node newNode = Node.newNode(v);

            if (parentNode.left == node) {
                parentNode.left = newNode;
                newNode.left = node;
            } else {
                parentNode.right = newNode;
                newNode.right = node;
            }
        }

        return root;
    }

    private static void populateNodeToParentMap( Map<Node, Node> nodeToParentMap,
                                                 Node root, Node parent ) {

        //   We can't add a null node to the map, return
        if (root == null) {
            return;
        }

        //  Map the node to its parent
        nodeToParentMap.put(root, parent);

        populateNodeToParentMap(nodeToParentMap, root.left, root);
        populateNodeToParentMap(nodeToParentMap, root.right, root);
    }

    //Runtime: 1 ms, faster than 52.79% of Java online
    private static Node addOneRowOptimal( Node root, int v, int d ) {

        if (d == 1) {
            Node node = Node.newNode(v);
            node.left = root;
            return node;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //looping until we reach required level prev; this helps in setting child nodes easily
        //THis also help in avoiding the parent linking with hashmap
        while (d-- > 2) {

            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        //Logic here is : we stopped at d - 1 step, this helps in linking parent -> newNode -> childNOde easily
        //queue.poll() : returns parent node, we need to set its Left and Right node -> newNode
        // node.left.left : just linking prev. child of queue.poll -> newNode -> childNode
        while (!queue.isEmpty()) {

            Node node = queue.poll();
            Node temp = node.left;

            //Node newNode = Node.newNode(v);

            //newNode is linking from 'd' parent's node
            node.left = Node.newNode(v);

            //setting newNode left to prev Node child
            //bcz setting newNode.right creating confusion in linking.
            node.left.left = temp;

            //-------same for right side of parent 'node'---------------
            temp = node.right;
            node.right = Node.newNode(v);

            //instead of newNode.right we can also use node.right.right
            node.right.right = temp;
        }

        return root;
    }
}

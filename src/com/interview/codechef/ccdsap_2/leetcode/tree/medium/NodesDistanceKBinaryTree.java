package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.*;

public class NodesDistanceKBinaryTree {

    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

    //Video Motivation:  https://www.youtube.com/watch?v=nPtARJ2cYrg
    public static void main( String[] args ) {
        Node head = Node.newNode(3);

        head.left = Node.newNode(5);
        head.right = Node.newNode(1);

        head.left.left = Node.newNode(6);
        head.left.right = Node.newNode(2);

        head.right.left = Node.newNode(0);
        head.right.right = Node.newNode(8);

        head.left.right.left = Node.newNode(7);
        head.left.right.right = Node.newNode(4);

        distanceK(head, head.left, 2).forEach(System.out::println);
    }

    //Really easy implementation.. Traversing in LevelOrder way; and tagging parent node in Queue..that's it :)
    private static List<Integer> distanceK( Node treeRoot, Node startNode, int targetDistance ) {
        Map<Node, Node> nodeToParentMap = new HashMap();

        //this help in identifying each Node's Parent
        populateNodeToParentMap(nodeToParentMap, treeRoot, null);

        /*we need a hashtable to keep track of nodes we have
        visited so that we do not go back and revisit what has already
        been processed and cause an infinite cycle*/

        Set<Node> seen = new HashSet();
        seen.add(startNode);

        /*Create the queue that we will use for the breadth first search.
        Add the start node to the queue
                */
        Queue<Node> queue = new LinkedList();
        queue.add(startNode);

        int currentLayer = 0;

        while (!queue.isEmpty()) {

            //Is this the layer we want? If so, extract and return it
            //When we hit targetDistance, queue is already having necessary Nodes.
            if (currentLayer == targetDistance) {
                return extractLayerFromQueue(queue);
            }


            //same Logic as LevelOrderTraversal
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {

                Node currentNode = queue.poll();

              /*
                Has left been touched before?
                No?
                  1.) Add it to the seen hashtable
                  2.) Add it to the search queue
              */
                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                }

              /*
                Has right been touched before?
                No?
                  1.) Add it to the seen hashtable
                  2.) Add it to the search queue
              */
                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                }

              /*
                Has this node's parent been touched before?
                No?
                  1.) Add it to the seen hashtable
                  2.) Add it to the search queue
              */

                //This logic helps to traverse back in Tree; with the help of storing Parent Node of Current Node.
                Node parentOfCurrentNode = nodeToParentMap.get(currentNode);
                if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) {
                    seen.add(parentOfCurrentNode);
                    queue.offer(parentOfCurrentNode);
                }

            }

            currentLayer++;
        }

        return new ArrayList<>();
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

    //so, this extracts all the nodes in targetDistance
    private static List<Integer> extractLayerFromQueue( Queue<Node> queue ) {
        List<Integer> extractedList = new ArrayList();
        for (Node node : queue) {
            extractedList.add(node.data);
        }
        return extractedList;
    }
}

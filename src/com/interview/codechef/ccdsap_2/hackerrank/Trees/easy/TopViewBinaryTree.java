package com.interview.codechef.ccdsap_2.hackerrank.Trees.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.*;

public class TopViewBinaryTree {

    //ref: https://www.youtube.com/watch?v=c3SAvcjWb1E
    //TOp view  = Level order traversal + Vertical order traversal
    //              1
    //               \
    //                2
    //                 \
    //                  5
    //                 /  \
    //                3    6
    //                 \
    //                  4

    //level order traversal by each level of tree : 1 2 5 3 6 4
    //Vertical order = We need to calculate horizontal distance of each node. Algo:
    //  1. For root HD = 0
    //  2. For Left child HD = HD - 1
    //  3. For Right child HD = HD + 1
    //NOw for Each NOde : 1 -> HD = 0
    //                    2 -> HD = 0 + 1 = 1
    //                    5 -> HD = 1 + 1 = 2
    //                    3 -> HD = 2 - 1 = 1
    //                    6 -> HD = 2 + 1 = 3
    //                    4 -> HD = 1 - 1 = 0

    //Align the Nodes acc. to Horizontal distance :
    //   0  |  1  |  2  |  3  |
    //   4     2     5     6
    //   1     3

    // For Top view : We will pick first node from each horizontal distance. If any HD contains 2 nodes
    //                then we'll the node which appears first in level order traversal.

    // Top view node :
    // HD -> {4, 1} -> 1 appear first in level order, we pick '1'
    // HD -> {2, 3} -> 2 appear first in level order, we pick '2'
    // HD -> {5} ->    5 only 5 is present, we pick '5'
    // HD -> {6} ->    6 only 6 is present, we pick '6'

    //Final Top view Answer = {1, 2, 5 ,6}

    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);
        head = bt.addNode(5, head);
        head = bt.addNode(3, head);
        head = bt.addNode(6, head);
        head = bt.addNode(4, head);

        topView(head);
    }

    private static void topView( Node root ) {
        Map<Integer, Queue<Node>> map = getTreeLevelOrder(root);

        List<Integer> list = levelOrder(root);
    }

    private static Map<Integer, Queue<Node>> getTreeLevelOrder( Node root ) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();

        Map<Integer, Queue<Node>> map = new HashMap<>();
        root.level = 0;

        queue.add(root);

        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            Node ptr = queue.poll();
            int ptrLevel = ptr.level;

            //assigning left and right node = the value of parent HD - 1 or HD + 1
            addIfNotNull(queue, ptr.left, ptrLevel - 1);
            addIfNotNull(queue, ptr.right, ptrLevel + 1);

            if (map.get(ptrLevel) != null) {
                map.get(ptrLevel).add(ptr);
            } else {
                Queue<Node> list = new LinkedList<>();
                list.add(ptr);
                map.put(ptrLevel, list);
            }

            //maintaining Min,MAx is not necessary here
            min = min > ptrLevel ? ptrLevel : min;
            max = max < ptrLevel ? ptrLevel : max;
        }

        //{min, max} = {0, 3}
        for (int i = min; i <= max; i++) {
            if (!map.get(i).isEmpty()) //we are only getting the first element of HD value; this may be incorrect
                System.out.print(map.get(i).poll().data + " ");
        }

        return map;
    }

    private static List<Integer> levelOrder( Node root ) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        queue.offer(root);
        while (queue.size() > 0) {
            root = queue.poll();

            list.add(root.data);

            //System.out.print(root.data + " ");
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }

        return list;
    }

    private static void addIfNotNull( final Queue<Node> queue, final Node node, final int level ) {
        if (node != null) {
            node.level = level;
            queue.add(node);
        }
    }
}

package com.interview.leetcode.graph;

import java.util.*;

public class CloneGraph {

    //https://leetcode.com/problems/clone-graph/
    public static void main( String[] args ) {

    }

    //Runtime: 27 ms, faster than 72.85% of Java
    public Node cloneGraph( Node node ) {
        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node copyNode = new Node(node.val);//where new is a copy of Graph
        map.put(node, copyNode);

        //traversing original node..
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            //checking all neighbours of Current NOde
            for (Node item : cur.neighbors) {

                //if original is not visited
                if (!map.containsKey(item)) {
                    map.put(item, new Node(item.val));
                    queue.offer(item);
                }

                //adding neighbour of Current Node as Item.
                map.get(cur).neighbors.add(map.get(item));
            }
        }

        return copyNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node( int _val ) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node( int _val, ArrayList<Node> _neighbors ) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyWithRandomPointer {

    //https://leetcode.com/problems/copy-list-with-random-pointer/
    public static void main( String[] args ) {

    }

    /*
    Deep Copy Definition:
    The variables A and B refer to different areas of memory, when B is assigned to A the values in the memory
    area which A points to are copied into the memory area to which B points. Later modifications to the contents
    of either remain unique to A or B; the contents are not shared.
     */

    //ref:https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43488/Java-O(n)-solution
    public RandomListNode copyRandomList( RandomListNode head ) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            //deep copying of RandomListNode
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);

            node = node.next;
        }

        return map.get(head);
    }

    public static class RandomListNode {
        public int val;
        public RandomListNode next;
        public RandomListNode random;

        RandomListNode( int val ) {
            this.val = val;
        }

        RandomListNode() {
        }

        public static RandomListNode newNode( int data ) {
            RandomListNode n = new RandomListNode();
            n.val = data;
            n.next = null;

            return n;
        }
    }
}

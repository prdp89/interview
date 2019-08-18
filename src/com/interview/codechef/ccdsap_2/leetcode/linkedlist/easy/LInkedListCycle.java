package com.interview.codechef.ccdsap_2.leetcode.linkedlist.easy;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

public class LInkedListCycle {

    //https://leetcode.com/problems/linked-list-cycle/

    /**
     * use faster and lower runner solution. (2 pointers)
     * the faster one move 2 steps, and slower one move only one step.
     * if there's a circle, the faster one will finally "catch" the slower one.
     * (the distance between these 2 pointers will decrease one every time.)
     * <p>
     * if there's no circle, the faster runner will reach the end of linked list. (NULL)
     */
    public static void main( String[] args ) {
        PartitionLinkedList.ListNode head = null;

        LInkedListCycle ll = new LInkedListCycle();

        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(2, head);

        System.out.println(ll.hasCycle(head));
    }

    //similar to DuplicateNumberDetection in Array.
    private boolean hasCycle( PartitionLinkedList.ListNode head ) {

        PartitionLinkedList.ListNode walker = head;
        PartitionLinkedList.ListNode runner = head;

        while (runner != null && runner.next != null) {

            walker = walker.next;
            runner = runner.next.next;

            if (walker == runner)
                return true;
        }
        return false;
    }

    public PartitionLinkedList.ListNode addNode( int data, PartitionLinkedList.ListNode head, Object... obj ) {
        PartitionLinkedList.ListNode temp = head;
        PartitionLinkedList.ListNode n;
        if (obj.length > 0) {
            n = PartitionLinkedList.ListNode.newNode(data, obj[0]);
        } else {
            n = PartitionLinkedList.ListNode.newNode(data);
        }
        if (head == null) {
            return n;
        }

        while (head.next != null) {
            head = head.next;
        }

        head.next = n;
        return temp;
    }
}

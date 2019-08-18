package com.interview.codechef.ccdsap_2.leetcode.linkedlist.easy;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

public class IntersectionTwoLinkedLists {

    //https://leetcode.com/problems/intersection-of-two-linked-lists/
    //This code doesn't return correct result at IDE but working fine and comparing in Leetcode :)
    public static void main( String[] args ) {

        PartitionLinkedList.ListNode head = null;
        PartitionLinkedList.ListNode head1 = null;

        IntersectionTwoLinkedLists ll = new IntersectionTwoLinkedLists();

        head = ll.addNode(4, head);
        head = ll.addNode(1, head);
        head = ll.addNode(8, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);

        head1 = ll.addNode(5, head1);
        head1 = ll.addNode(0, head1);
        head1 = ll.addNode(1, head1);
        head1 = ll.addNode(8, head1);
        head1 = ll.addNode(4, head1);
        head1 = ll.addNode(5, head1);

       // PartitionLinkedList.ListNode node = ll.getIntersectionNodeTricky(head, head1);
        PartitionLinkedList.ListNode node1 = ll.getIntersectionNodeEasy(head, head1);

        //ll.printSinglyLinkedList(node);
        ll.printSinglyLinkedList(node1);
    }

    //ref : https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    //Read the visualization in same thread
    private PartitionLinkedList.ListNode getIntersectionNodeTricky( PartitionLinkedList.ListNode headA, PartitionLinkedList.ListNode headB ) {

        //boundary check
        if (headA == null || headB == null)
            return null;

        PartitionLinkedList.ListNode a = headA;
        PartitionLinkedList.ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linked-list
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    //ref: https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49792/Concise-JAVA-solution-O(1)-memory-O(n)-time
    private PartitionLinkedList.ListNode getIntersectionNodeEasy( PartitionLinkedList.ListNode headA, PartitionLinkedList.ListNode headB ) {

        int lenA = length(headA), lenB = length(headB);

        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int length( PartitionLinkedList.ListNode node ) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
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

    private void printSinglyLinkedList( PartitionLinkedList.ListNode node ) {
        while (node != null) {
            System.out.println(String.valueOf(node.val));
            node = node.next;
        }
    }
}

package com.interview.codechef.ccdsap_2.leetcode.linkedlist.easy;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

public class MiddleOfLinkedList {

    //https://leetcode.com/problems/middle-of-the-linked-list/
    public static void main( String[] args ) {
        PartitionLinkedList.ListNode head = null;

        MiddleOfLinkedList ll = new MiddleOfLinkedList();

        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);
        head = ll.addNode(6, head);

        PartitionLinkedList.ListNode node = middleNode(head);

        ll.printSinglyLinkedList(node);
    }

    private static PartitionLinkedList.ListNode middleNode( PartitionLinkedList.ListNode head ) {

        int mid = countSinglyLinkedList(head) / 2;
        for (int i = 0; i < mid; i++) {
            head = head.next;
        }

        return head;
    }

    private static int countSinglyLinkedList( PartitionLinkedList.ListNode node ) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }


    private void printSinglyLinkedList( PartitionLinkedList.ListNode node ) {
        while (node != null) {
            System.out.println(String.valueOf(node.val));
            node = node.next;
        }
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

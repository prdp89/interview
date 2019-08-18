package com.interview.codechef.ccdsap_2.leetcode.linkedlist.easy;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

public class MergeSotedList {

    //https://leetcode.com/problems/merge-two-sorted-lists/
    public static void main( String[] args ) {

        PartitionLinkedList.ListNode head = null;

        MergeSotedList ll = new MergeSotedList();

        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(4, head);

        PartitionLinkedList.ListNode head1 = null;
        head1 = ll.addNode(4, head1);
        head1 = ll.addNode(5, head1);

        PartitionLinkedList.ListNode merged = ll.mergeTwoLists(head, head1);

        ll.printSinglyLinkedList(merged);
    }

    //SOLVED IN ONE ATTEMPT
    private PartitionLinkedList.ListNode mergeTwoLists( PartitionLinkedList.ListNode l1, PartitionLinkedList.ListNode l2 ) {

        PartitionLinkedList.ListNode temp = new PartitionLinkedList.ListNode(0);

        PartitionLinkedList.ListNode tail = temp;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }

        }

        if (l1 == null && l2 != null) {
            while (l2 != null) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        } else if (l1 != null) {
            while (l1 != null) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
        }

        temp = temp.next;
        return temp;
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

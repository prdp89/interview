package com.interview.codechef.ccdsap_2.leetcode.linkedlist.easy;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

public class RemoveDuplicatesSortedList {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public static void main( String[] args ) {
        PartitionLinkedList.ListNode head = null;

        RemoveDuplicatesSortedList ll = new RemoveDuplicatesSortedList();

        head = ll.addNode(1, head);
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(3, head);

        PartitionLinkedList.ListNode node = ll.deleteDuplicates(head);
        ll.printSinglyLinkedList(node);
    }

    private PartitionLinkedList.ListNode deleteDuplicates( PartitionLinkedList.ListNode head ) {

        PartitionLinkedList.ListNode head1 = head;
        while (head1 != null &&  head1.next != null) {

            if (head1.val == head1.next.val)
                head1.next = head1.next.next;
            else{
                head1 = head1.next;
            }
        }
        return head;
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

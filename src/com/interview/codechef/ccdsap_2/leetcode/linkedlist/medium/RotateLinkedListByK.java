package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class RotateLinkedListByK {

    //https://leetcode.com/problems/rotate-list/
    public static void main( String[] args ) {
        RotateLinkedListByK ll = new RotateLinkedListByK();

        int k = 2;

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);

        ll.printSinglyLinkedList(ll.rotateRight(head, k));
    }

    //great; solved by own; in one attempt
    private PartitionLinkedList.ListNode rotateRight( PartitionLinkedList.ListNode head, int k ) {

        int count = countLinkedListItems(head);

        if (count == 0 || count == 1)
            return head;

        int count1 = count <= k ? k % count : k;

        if (count1 == 0)
            return head;

        //similar to RemoveNthNodeOfLL going forward by count steps
        PartitionLinkedList.ListNode node = head;
        int tempL = count1;
        while (tempL-- > 0) {
            node = node.next;
        }

        PartitionLinkedList.ListNode slow = head;

        PartitionLinkedList.ListNode prevSlow = head;

        //after this loop slow will point to last Kth element
        while (node != null) {
            node = node.next;

            prevSlow = slow;
            slow = slow.next;
        }

        //preserving Slow head
        PartitionLinkedList.ListNode fakeHead = new PartitionLinkedList.ListNode(-1);
        fakeHead.next = slow;

        //prev slow set to last node of first part
        prevSlow.next = null;

        //take slow to end {it is the last Kth item list}
        while (slow.next != null) {

            slow = slow.next;
        }

        //linking slow end to First part of list
        slow.next = head;

        //returning slow->head as first item.
        return fakeHead.next;
    }

    private int countLinkedListItems( PartitionLinkedList.ListNode node ) {
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

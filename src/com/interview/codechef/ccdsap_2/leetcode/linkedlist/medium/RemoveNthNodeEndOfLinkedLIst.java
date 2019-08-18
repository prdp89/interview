package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class RemoveNthNodeEndOfLinkedLIst {

    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public static void main( String[] args ) {
        PartitionLinkedList.ListNode head = null;

        RemoveNthNodeEndOfLinkedLIst ll = new RemoveNthNodeEndOfLinkedLIst();

        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);
        head = ll.addNode(6, head);

        PartitionLinkedList.ListNode node = ll.removeNthFromEnd(head, 2);
        ll.printSinglyLinkedList(node);
    }

    private PartitionLinkedList.ListNode removeNthFromEnd( PartitionLinkedList.ListNode head, int n ) {

        PartitionLinkedList.ListNode start = new PartitionLinkedList.ListNode(0);

        start.next = head;

        PartitionLinkedList.ListNode slow = start, fast = start;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
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
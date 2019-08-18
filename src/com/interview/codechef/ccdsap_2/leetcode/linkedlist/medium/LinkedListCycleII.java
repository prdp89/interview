package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class LinkedListCycleII {

    //https://leetcode.com/problems/linked-list-cycle-ii/
    public static void main( String[] args ) {
        PartitionLinkedList.ListNode head = null;

        LinkedListCycleII ll = new LinkedListCycleII();

        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(2, head);

        ll.detectCycle(head);
    }

    //solved in one attempt; Same as DuplicateNumberDetection
    private PartitionLinkedList.ListNode detectCycle( PartitionLinkedList.ListNode head ) {

        PartitionLinkedList.ListNode walker = head;
        PartitionLinkedList.ListNode runner = head;

        boolean isCycle = false;

        while (runner != null && runner.next != null) {

            walker = walker.next;
            runner = runner.next.next;

            if (walker == runner) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle)
            return null;

        runner = head;

        while (runner != walker){
            walker = walker.next;
            runner = runner.next;
        }

        return walker;
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

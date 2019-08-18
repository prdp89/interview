package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class ReorderList {

    //https://leetcode.com/problems/reorder-list/

    //THe logic is same in this link too: https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps

    //This program is few test cases; will check later; logic is clear for this.
    public static void main( String[] args ) {
        ReorderList ll = new ReorderList();

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);

        ll.reorderList(head);

        ll.printSinglyLinkedList(head);
    }

    //Nice thinking Pardeep; Except Last loop two I think everything.
    private void reorderList( PartitionLinkedList.ListNode head ) {
        PartitionLinkedList.ListNode mid = getMiddleAndSplitInHalf(head);

        //reverse the list to link first to last
        PartitionLinkedList.ListNode node = reverseList(mid);

        //points to head
        PartitionLinkedList.ListNode temp = head;

        while (temp != null && node != null) {

            PartitionLinkedList.ListNode headTemp = temp.next;
            PartitionLinkedList.ListNode tailTemp = node.next;

           /* temp.next = node;
            node.next = headTemp;

            temp = headTemp;
            node = tailTemp;*/

            //setting reversed list first item next to second item of head; bcz second item of head may lost
            node.next = temp.next;

            //setting head.next node to first item of reversed list
            temp.next = node;

            //similar to reverseLinkedList last line
            temp = headTemp;
            node = tailTemp;
        }
    }

    private PartitionLinkedList.ListNode reverseList( PartitionLinkedList.ListNode head ) {
        PartitionLinkedList.ListNode prevHead = null;

        while (head != null) {

            PartitionLinkedList.ListNode recordNext = head.next;

            head.next = prevHead;

            prevHead = head;

            head = recordNext;
        }

        return prevHead;
    }

    private PartitionLinkedList.ListNode getMiddleAndSplitInHalf( PartitionLinkedList.ListNode head ) {

        PartitionLinkedList.ListNode prev = null;
        PartitionLinkedList.ListNode slow = head;
        PartitionLinkedList.ListNode fast = head;

        while (fast != null && fast.next != null) {

            prev = slow;

            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null)
            prev.next = null;

        return slow;
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

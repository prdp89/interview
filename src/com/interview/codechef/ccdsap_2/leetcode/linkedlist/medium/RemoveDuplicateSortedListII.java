package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class RemoveDuplicateSortedListII {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    public static void main( String[] args ) {

        RemoveDuplicateSortedListII ll = new RemoveDuplicateSortedListII();

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);

        //.printSinglyLinkedList(ll.deleteDuplicatesTry(head));
        ll.printSinglyLinkedList(ll.deleteDuplicatesOptimal(head));
    }

    //THis logic is smiliar to RemoveLinkedListElements
    private PartitionLinkedList.ListNode deleteDuplicatesOptimal( PartitionLinkedList.ListNode head ) {

        PartitionLinkedList.ListNode fakeHead = new PartitionLinkedList.ListNode(-1);
        fakeHead.next = head;

        PartitionLinkedList.ListNode curr = fakeHead.next;
        PartitionLinkedList.ListNode pre = fakeHead;
        pre.next = curr;

        while (curr != null) {

            //after this loop current is pointing to last duplicate node
            while (curr.next != null && curr.val == curr.next.val)
                curr = curr.next;

            //prev.next = next node address
            //curr = curr node address
            //if both are not equal {or not connected} then it means we jump some nodes from above inner loop
            if (pre.next != curr) {
                //resetting prev to the curr.next means removing all duplicates in between
                pre.next = curr.next;
            } else {
                //otherwise move the prev. node one by one;
                pre = pre.next;
            }

            curr = curr.next;
        }

        return fakeHead.next;
    }

    private PartitionLinkedList.ListNode deleteDuplicatesTry( PartitionLinkedList.ListNode head ) {
        PartitionLinkedList.ListNode fakeHead = new PartitionLinkedList.ListNode(-1);
        fakeHead.next = head;
        PartitionLinkedList.ListNode prev = fakeHead;
        PartitionLinkedList.ListNode curr = fakeHead.next;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                prev.next = curr.next.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }

        }
        return fakeHead.next;
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

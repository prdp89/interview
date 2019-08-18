package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class MergeSortLinkedList {

    //https://leetcode.com/problems/sort-list/
    public static void main( String[] args ) {
        MergeSortLinkedList ll = new MergeSortLinkedList();

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(4, head);
        head = ll.addNode(2, head);
        head = ll.addNode(1, head);
        head = ll.addNode(3, head);

        ll.printSinglyLinkedList(ll.sortList(head));
    }

    //https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/mergeSort.java
    private PartitionLinkedList.ListNode sortList( PartitionLinkedList.ListNode head ) {

          /*
            Base case, an empty list or a single item list.
            That is a sorted list, hence we just return the
            list (it is either empty or only has 1 item)
          */
        if (head == null || head.next == null) {
            return head;
        }

          /*
            Abstracting out finding the middle node
          */
        PartitionLinkedList.ListNode mid = getMiddleAndSplitInHalf(head);

          /*
            Sort the left. Sort the right. This is recursive splitting
            and handing responsibility off
          */
        PartitionLinkedList.ListNode leftHalf = sortList(head);
        PartitionLinkedList.ListNode rightHalf = sortList(mid); //returned slow point to MID

          /*
            Merge the sorted left half and sorted right half
          */
        return merge(leftHalf, rightHalf);
    }

    /*
      The merge subroutine
    */
    private PartitionLinkedList.ListNode merge( PartitionLinkedList.ListNode l1Pointer, PartitionLinkedList.ListNode l2Pointer ) {

          /*
            You will see how we use these below
          */

        PartitionLinkedList.ListNode dummyHead = new PartitionLinkedList.ListNode(0);
        PartitionLinkedList.ListNode endOfSortedList = dummyHead;

          /*
            While neither list has been exhausted keep doing
            comparisons and re-wirings
          */
        while (l1Pointer != null && l2Pointer != null) {

            if (l1Pointer.val < l2Pointer.val) {

                // Where l1 points gets the placement
                endOfSortedList.next = l1Pointer;
                l1Pointer = l1Pointer.next;

            } else {

                // Where l2 points gets the placement
                endOfSortedList.next = l2Pointer;
                l2Pointer = l2Pointer.next;

            }
            /*
              The 'endOfSortedList' is now the item we just
              tacked to the end, move the pointer there
            */
            endOfSortedList = endOfSortedList.next;
        }

          /*
            If we exhaust one list, just tack the other to the end
            of the sorted list
          */
        if (l1Pointer != null) {
            endOfSortedList.next = l1Pointer;
        }

        if (l2Pointer != null) {
            endOfSortedList.next = l2Pointer;
        }

          /*
            The head of the merged list is the .next of the dummy head,
            the dummy head helped us protect against the empty state the
            list was in to start
          */
        return dummyHead.next;
    }

    /*
      Get the middle node and split the linked list in half
    */
    private PartitionLinkedList.ListNode getMiddleAndSplitInHalf( PartitionLinkedList.ListNode head ) {

          /*
            Look below, you will see how we use each of these
          */
        PartitionLinkedList.ListNode prev = null;
        PartitionLinkedList.ListNode slow = head;
        PartitionLinkedList.ListNode fast = head;

          /*
            slow pointer, 1 hop per iteration
            fast pointer, 2 hops per iteration
            When 'fast' reaches the last element or runs
            over the list the 'slow' pointer will point
            to the middle of the list
          */
        while (fast != null && fast.next != null) {

            /*
              Keep prev 1 behind where slow will be. We
              want this for later
            */
            prev = slow;

            /*
              Move the slow and fast pointers
            */
            slow = slow.next;
            fast = fast.next.next;
        }

          /*
            Cut off the end of the first half list so it
            is no longer connected in memory to the right
            half list head
            We kept track of prev to be able to do this cutoff
          */
        if (prev != null)
            prev.next = null;

          /*
            'slow' sits at the middle of the list
          */
        return slow;
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

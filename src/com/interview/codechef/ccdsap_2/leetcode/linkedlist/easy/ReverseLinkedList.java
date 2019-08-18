package com.interview.codechef.ccdsap_2.leetcode.linkedlist.easy;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

public class ReverseLinkedList {

    //https://leetcode.com/problems/reverse-linked-list/
    /*
    Basic idea here is that there are always three pointers,
    which are represented in sequence as prevHead, head, recordNext.
    Everytime in loop just make head.next points to prevHead,
    and then move all these three pointers to one next step.

    Since when we exit the while loop, head is pointing to null,
    so prevHead points to the end node of original list, and thus we return prevHead.

     */

    public PartitionLinkedList.ListNode reverseList( PartitionLinkedList.ListNode head ) {
        PartitionLinkedList.ListNode prevHead = null;

        while (head != null) {

            //this line logic is used in ReorderList last loop.
            PartitionLinkedList.ListNode recordNext = head.next;

            head.next = prevHead;

            prevHead = head;

            head = recordNext;
        }

        return prevHead;
    }
}
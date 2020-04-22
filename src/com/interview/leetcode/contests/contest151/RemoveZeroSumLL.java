package com.interview.leetcode.contests.contest151;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumLL {

    //https://leetcode.com/contest/weekly-contest-151/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
    public static void main( String[] args ) {

        RemoveZeroSumLL ll = new RemoveZeroSumLL();

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(-3, head);
        head = ll.addNode(-2, head);

        //removeZeroSumSublists(head);
        removeZeroSumSublistsOPtimal(head);
    }

    //Trying with Logic RemoveDuplicateSortedListII; failing test cases.
    private static PartitionLinkedList.ListNode removeZeroSumSublists( PartitionLinkedList.ListNode head ) {

        PartitionLinkedList.ListNode fakeHead = new PartitionLinkedList.ListNode(-1);
        fakeHead.next = head;

        PartitionLinkedList.ListNode curr = fakeHead.next;
        PartitionLinkedList.ListNode pre = fakeHead;
        pre.next = curr;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val * -1) {
                curr = curr.next;
            }

            if (pre.next != curr) {
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }

            curr = curr.next;
        }

        return fakeHead.next;
    }

    //This logic is also a modification of RemoveDuplicateSortedListII
    private static PartitionLinkedList.ListNode removeZeroSumSublistsOPtimal( PartitionLinkedList.ListNode head ) {
        PartitionLinkedList.ListNode dummy = new PartitionLinkedList.ListNode(-1);
        dummy.next = head;

        int sum = 0;
        Map<Integer, PartitionLinkedList.ListNode> map = new HashMap<>();

        map.put(0, dummy);

        while (head != null) {
            sum += head.val;

            //If the specified key is not already associated with a value
            //else returns the current value
            map.putIfAbsent(sum, head);

            //similar to prev.next = curr.next
            if (map.containsKey(sum)) {
                map.get(sum).next = head.next;
            }

            head = head.next;
        }
        return dummy.next;
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
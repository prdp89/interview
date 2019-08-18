package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSortList {

    //https://leetcode.com/problems/insertion-sort-list/
    public static void main( String[] args ) {
        InsertionSortList ll = new InsertionSortList();

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(4, head);
        head = ll.addNode(2, head);
        head = ll.addNode(1, head);
        head = ll.addNode(3, head);

        ll.printSinglyLinkedList(ll.insertionSortList(head));
    }

    private PartitionLinkedList.ListNode insertionSortList( PartitionLinkedList.ListNode head ) {

        PartitionLinkedList.ListNode temp = head;

        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list);

        temp = new PartitionLinkedList.ListNode(0);
        PartitionLinkedList.ListNode tail = temp;
        int i = 0;
        while (i < list.size()) {

            tail.next = new PartitionLinkedList.ListNode(list.get(i));
            i++;
            tail = tail.next;
        }

        return temp.next;
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

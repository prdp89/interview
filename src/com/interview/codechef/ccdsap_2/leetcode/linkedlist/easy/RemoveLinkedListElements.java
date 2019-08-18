package com.interview.codechef.ccdsap_2.leetcode.linkedlist.easy;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

public class RemoveLinkedListElements {

    //https://leetcode.com/problems/remove-linked-list-elements/
    public static void main( String[] args ) {
        PartitionLinkedList.ListNode head = null;

        RemoveLinkedListElements ll = new RemoveLinkedListElements();

        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
       /* head = ll.addNode(6, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);
        head = ll.addNode(6, head);*/

        // PartitionLinkedList.ListNode node = ll.removeElements(head, 1);
        PartitionLinkedList.ListNode node = ll.removeElementsOptimal(head, 1);

        ll.printSinglyLinkedList(node);
    }

    //35 / 65 test cases passed.
    private PartitionLinkedList.ListNode removeElements( PartitionLinkedList.ListNode head, int val ) {

        if (head == null || (head.next == null && head.val == val))
            return null;

        PartitionLinkedList.ListNode temp = head;

        while (temp != null && temp.next != null) {

            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        if (temp == null && head.val == val)
            return null;

        return head;
    }

    //Logic is similar to PartitionLinkedList
    private PartitionLinkedList.ListNode removeElementsOptimal( PartitionLinkedList.ListNode head, int val ) {

        PartitionLinkedList.ListNode tempHead = new PartitionLinkedList.ListNode(-1);
        tempHead.next = head;

        //initially prev point to -1
        PartitionLinkedList.ListNode tail = head, prev = tempHead;

        while (tail != null) {

            if (tail.val == val) {
                prev.next = tail.next;
            } else {
                prev = prev.next;
            }

            tail = tail.next;
        }

        return tempHead.next; //temp is default set to -1 so; next will point to head
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

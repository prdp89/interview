package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class ReverseLinkedListII {

    //https://leetcode.com/problems/reverse-linked-list-ii/
    public static void main( String[] args ) {
        ReverseLinkedListII ll = new ReverseLinkedListII();

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);

        ll.printSinglyLinkedList(ll.reverseBetween(head, 2, 4));
    }

    private PartitionLinkedList.ListNode reverseBetweenTry( PartitionLinkedList.ListNode head, int m, int n ) {

        PartitionLinkedList.ListNode temp = head;

        for (int i = 1; i < m; i++) {
            temp = temp.next;
        }

        PartitionLinkedList.ListNode prevHead = null;

        PartitionLinkedList.ListNode temp_2 = temp;

        PartitionLinkedList.ListNode lastNode = temp;

        while (m <= n) {

            lastNode = lastNode.next;

            PartitionLinkedList.ListNode recordNext = temp_2.next;

            temp_2.next = prevHead;

            prevHead = temp_2;

            temp_2 = recordNext;

            m++;
        }

        PartitionLinkedList.ListNode prevLast = prevHead;
        while (prevLast != null && prevLast.next != null) {
            prevLast = prevLast.next;
        }

        temp.next = prevHead;

        if (prevHead != null)
            prevHead.next = lastNode;

        return head;
    }

    private PartitionLinkedList.ListNode reverseBetween( PartitionLinkedList.ListNode head, int m, int n ) {
        PartitionLinkedList.ListNode fakeHead = new PartitionLinkedList.ListNode(-1);
        fakeHead.next = head;

        //similar to RemoveDuplicateSortedListII
        PartitionLinkedList.ListNode prev = fakeHead;
        PartitionLinkedList.ListNode curr = fakeHead.next;

        //going from 1..M
        int i = 1;
        while (i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        //reversing m..n nodes
        PartitionLinkedList.ListNode node = prev;

        //reverse LL logic
        while (i <= n) {

            PartitionLinkedList.ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;

        }

        //{1, 2, 3, 4, 5} node = prev = 1; Then node.next.next means 2's next
        //After above loop list becomes {1, 4, 3,2, 5}; 2 reach to last before 5
        //setting 2 -> last node 5
        node.next.next = curr;

        //if list = {1, 2,3, 4, 5} m = 2, n= 4, prev = 1, {1, 4, 3 ,2, 5}
        node.next = prev; //is pointing to reversed list head;

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

package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class SwapNodesPairs {

    //https://leetcode.com/problems/swap-nodes-in-pairs/
    public static void main( String[] args ) {

        SwapNodesPairs ll = new SwapNodesPairs();

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);

        // ll.printSinglyLinkedList(ll.swapPairs(head));

        ll.printSinglyLinkedList(ll.swapPairsOptimal(head));
    }

    private PartitionLinkedList.ListNode swapPairsOptimal( PartitionLinkedList.ListNode head ) {

        if (head == null) {
            return null;
        }

        PartitionLinkedList.ListNode newhead = new PartitionLinkedList.ListNode(-1);//dummy

        newhead.next = head;

        PartitionLinkedList.ListNode temp = newhead;

        PartitionLinkedList.ListNode one;
        PartitionLinkedList.ListNode two;

        // temp points to head in the beginning.
        while (temp.next != null && temp.next.next != null) {
            // one -> 1
            one = temp.next;

            //two -> 2
            two = temp.next.next;

            // 1-> = 2.next = 3;
            one.next = two.next;

            // 2-> = 1
            two.next = one;

            //initially temp->next = head and temp.val = -1
            //giving it just a new address after above link changes
            //temp.next = points to first of two-swapped pairs.{it also helps in checking temp.next.next != null}
            temp.next = two;

            //temp was pointing to dummy
            //temp->1
            temp = one; //setting temp address to One; in next loop we can get temp.next = 3
        }

        return newhead.next;
    }

    private PartitionLinkedList.ListNode swapPairs( PartitionLinkedList.ListNode head ) {
        PartitionLinkedList.ListNode node = head;

        while (node != null && node.next != null) {

            PartitionLinkedList.ListNode temp = node;
            PartitionLinkedList.ListNode temp1 = node.next;

            node.next = node.next.next;
            temp1.next = node;

            node = node.next;

          /* temp.next = node.next;
           node.next = temp;*/
            //node = node.next;
        }

        return head;
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

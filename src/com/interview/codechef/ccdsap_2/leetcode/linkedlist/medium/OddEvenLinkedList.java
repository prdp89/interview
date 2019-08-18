package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class OddEvenLinkedList {

    //https://leetcode.com/problems/odd-even-linked-list/
    public static void main( String[] args ) {
        PartitionLinkedList.ListNode head = null;

        OddEvenLinkedList ll = new OddEvenLinkedList();

        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);

        //ll.printSinglyLinkedList(ll.oddEvenList(head));

        ll.printSinglyLinkedList(ll.oddEvenListOptimal(head));
    }

    private PartitionLinkedList.ListNode oddEvenListOptimal( PartitionLinkedList.ListNode head ) {
        if (head != null) {

            PartitionLinkedList.ListNode odd = head, even = head.next, evenHead = even;

            //this loop is like slow and fast pointer in LinkedListCycle
            while (even != null && even.next != null) {

                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;

            }

            //setting odd last to even head
            odd.next = evenHead;
        }

        return head;
    }

    //nice try; optimal logic is also similar
    private PartitionLinkedList.ListNode oddEvenList( PartitionLinkedList.ListNode head ) {

        PartitionLinkedList.ListNode temp = head;
        PartitionLinkedList.ListNode tempHead = new PartitionLinkedList.ListNode(0);
        PartitionLinkedList.ListNode tempTail = tempHead;

        while (temp != null && temp.next != null) {
            tempTail.next = temp;
            tempTail = tempTail.next;
            temp = temp.next.next;
        }

        /*temp = head;
        while (temp != null && temp.next != null) {
            tempTail.next = temp.next;
            temp = temp.next.next;
            tempTail = tempTail.next;
        }*/

        return tempHead.next;
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

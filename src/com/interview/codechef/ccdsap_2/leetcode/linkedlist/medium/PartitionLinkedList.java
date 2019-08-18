package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class PartitionLinkedList {

    //https://leetcode.com/problems/partition-list/
    public static void main( String[] args ) {
        PartitionLinkedList ll = new PartitionLinkedList();
        ListNode head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(4, head);
        head = ll.addNode(3, head);
        head = ll.addNode(2, head);
        head = ll.addNode(5, head);
        head = ll.addNode(2, head);

        ListNode node = ll.partition(head, 3);

        ll.printSinglyLinkedList(node);
    }

    private void printSinglyLinkedList( ListNode node ) {
        while (node != null) {
            System.out.println(String.valueOf(node.val));
            node = node.next;
        }
    }

    private ListNode partition( ListNode head, int x ) {

        ListNode smallerHead = new ListNode(0),
                greaterHead = new ListNode(0);  //dummy heads of the 1st and 2nd queues

        ListNode smallerLast = smallerHead, greaterLast = greaterHead; //current tails of the two queues;

        while (head != null) {
            if (head.val < x) {
                smallerLast.next = head;
                smallerLast = head; //bcz we have assign address/value or other properties as well
            } else {
                greaterLast.next = head;
                greaterLast = head;
            }
            head = head.next;
        }

        greaterLast.next = null;
        smallerLast.next = greaterHead.next; //Skipping dummy head of greater and linking next node
        return smallerHead.next; //Skipping dummy head of smaller and returning next
    }

    public ListNode addNode( int data, ListNode head, Object... obj ) {
        ListNode temp = head;
        ListNode n;
        if (obj.length > 0) {
            n = ListNode.newNode(data, obj[0]);
        } else {
            n = ListNode.newNode(data);
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

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode( int val ) {
            this.val = val;
        }

        ListNode() {
        }

        public static ListNode newNode( int data, Object... obj ) {
            ListNode n = new ListNode();
            n.val = data;
            n.next = null;
           /* if(obj.length > 0)
            {
                n.obj = obj[0];
            }*/
            return n;
        }
    }

}

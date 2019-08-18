package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class SplitLinkedListParts {

    //https://leetcode.com/problems/split-linked-list-in-parts/
    public static void main( String[] args ) {
        SplitLinkedListParts ll = new SplitLinkedListParts();

        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);
       /* head = ll.addNode(6, head);
        head = ll.addNode(7, head);
        head = ll.addNode(8, head);
        head = ll.addNode(9, head);
        head = ll.addNode(10, head);*/

        int k = 3;

        PartitionLinkedList.ListNode[] list = ll.splitListToParts(head, k);
        for (PartitionLinkedList.ListNode node : list) {
            ll.printSinglyLinkedList(node);
            System.out.print("\n");
        }
    }

    //36 / 41 test cases passed. almost solved it :)
    private PartitionLinkedList.ListNode[] splitListToParts( PartitionLinkedList.ListNode root, int k ) {

        int total = countLL(root);
        int eachPart = total / k;

        //mistake is here : instead of giving all extra (total % k) to first part, we should divide it among first parts.
        //Means if (total % k) is 2 : it should be divided among first among first two parts as {1,1}
        int firstPart = (total / k) + (total % k);

        PartitionLinkedList.ListNode arr[] = new PartitionLinkedList.ListNode[k];

        //if first part can be formed
        if (eachPart > 0) {
            PartitionLinkedList.ListNode node = new PartitionLinkedList.ListNode(0);
            PartitionLinkedList.ListNode tempHead = node;

            while (firstPart-- > 0) {
                tempHead.next = root;

                tempHead = root;
                root = root.next;
            }

            tempHead.next = null;
            arr[0] = node.next;
        }

        int end = k, start = 0;
        if (eachPart > 0) {
            end = k - 1;
            start = 1;
        } else {
            end = end - 1;
        }

        //go for remaining parts
        for (int i = start; i <= end; i++) {

            PartitionLinkedList.ListNode node = new PartitionLinkedList.ListNode(0);
            PartitionLinkedList.ListNode tempHead = node;

            if (root != null) {
                for (int j = 0; j < Math.max(eachPart, 1); j++) {
                    tempHead.next = root;

                    tempHead = root;
                    root = root.next;
                }

                tempHead.next = null;
                arr[i] = node.next;
            } else
                arr[i] = null;
        }

        return arr;
    }

    private static int countLL( PartitionLinkedList.ListNode node ) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
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

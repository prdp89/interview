package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

public class AddTwoNumbers {

    //https://leetcode.com/problems/add-two-numbers/
    public static void main( String[] args ) {

        PartitionLinkedList.ListNode head = null;

        AddTwoNumbers ll = new AddTwoNumbers();

        head = ll.addNode(2, head);
        head = ll.addNode(4, head);
        head = ll.addNode(3, head);


        PartitionLinkedList.ListNode head1 = null;

        head1 = ll.addNode(5, head1);
        head1 = ll.addNode(6, head1);
        head1 = ll.addNode(9, head1);

        //solveTry(head, head1, ll);

        ll.printSinglyLinkedList(solveOptimal(head, head1));
    }

    private static PartitionLinkedList.ListNode solveOptimal( PartitionLinkedList.ListNode l1, PartitionLinkedList.ListNode l2 ) {

        //temp nodes
        PartitionLinkedList.ListNode c1 = l1;
        PartitionLinkedList.ListNode c2 = l2;

        //taking head and tail nodes to append result
        PartitionLinkedList.ListNode head = new PartitionLinkedList.ListNode(0);
        PartitionLinkedList.ListNode tail = head;

        int sum = 0;

        while (c1 != null || c2 != null) {
            //get next digits of num
            sum /= 10;

            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }

            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }

            tail.next = new PartitionLinkedList.ListNode(sum % 10); //last digit of num
            tail = tail.next;
        }

        //on last digit : adding 3 and 9: append append to result first then if '1' remaining then append it to list now
        if (sum / 10 == 1)
            tail.next = new PartitionLinkedList.ListNode(1);

        return head.next;
    }

    private static void solveTry( PartitionLinkedList.ListNode head, PartitionLinkedList.ListNode head1, AddTwoNumbers ll ) {
        int value_1 = ll.llToInt(head1);
        int value = ll.llToInt(head);

        int total = value + value_1;

        StringBuilder sb = new StringBuilder(total + "");

        PartitionLinkedList.ListNode node = new PartitionLinkedList.ListNode(0);
        PartitionLinkedList.ListNode tail = node;

        int i = 0;
        while (i < sb.length()) {
            PartitionLinkedList.ListNode newNode = new PartitionLinkedList.ListNode(Integer.parseInt(sb.charAt(i++) + ""));
            tail.next = newNode;
            tail = tail.next;
        }

        ll.printSinglyLinkedList(node.next);
    }

    private int llToInt( PartitionLinkedList.ListNode head ) {

        int mult = head.val;
        head = head.next;

        while (head != null) {
            mult = mult * 10 + head.val;
            head = head.next;
        }

        int num = mult, reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return reversed;
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

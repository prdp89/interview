package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

import java.util.Stack;

public class AddNumbersII {

    //https://leetcode.com/problems/add-two-numbers-ii/
    public static void main( String[] args ) {

        PartitionLinkedList.ListNode head = null;

        AddNumbersII ll = new AddNumbersII();

        head = ll.addNode(7, head);
        head = ll.addNode(2, head);
        head = ll.addNode(4, head);
        head = ll.addNode(3, head);

        PartitionLinkedList.ListNode head1 = null;

        head1 = ll.addNode(5, head1);
        head1 = ll.addNode(6, head1);
        head1 = ll.addNode(4, head1);

        ll.printSinglyLinkedList(ll.addTwoNumbers(head, head1));
    }

    //In this problem we are adding number from back
    private PartitionLinkedList.ListNode addTwoNumbers( PartitionLinkedList.ListNode l1, PartitionLinkedList.ListNode l2 ) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        //stack helps to get element in reverse order
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        PartitionLinkedList.ListNode list = new PartitionLinkedList.ListNode(0);

        while (!s1.empty() || !s2.empty()) {

            if (!s1.empty())
                sum += s1.pop();

            if (!s2.empty())
                sum += s2.pop();

            //add last digit of sum to a node
            list.val = sum % 10;

            //create temp node
            PartitionLinkedList.ListNode temp = new PartitionLinkedList.ListNode(sum / 10);

            //link temp node to the LL node; to iterate from start later on.
            temp.next = list;

            //assign the list node to temp node; so that next value will be inserted in this node.
            list = temp;

            //if we add 4 + 6 = 10; '0' inserted above and 10%10 = 1 then 1 will be added to next addition of nums
            sum /= 10;
        }

        //after the loop list pointing to first element of addition.
        return list.val == 0 ? list.next : list;
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

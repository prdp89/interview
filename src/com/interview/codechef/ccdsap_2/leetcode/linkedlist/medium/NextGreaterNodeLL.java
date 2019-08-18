package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeLL {

    //https://leetcode.com/problems/next-greater-node-in-linked-list/
    public static void main( String[] args ) {

        NextGreaterNodeLL ll = new NextGreaterNodeLL();
        PartitionLinkedList.ListNode head = null;
        head = ll.addNode(2, head);
        head = ll.addNode(7, head);
        head = ll.addNode(4, head);
        head = ll.addNode(3, head);
        head = ll.addNode(5, head);

        System.out.println(Arrays.toString(ll.nextLargerNodes(head)));
    }

    //Logic is similar to DailyTemperature
    private int[] nextLargerNodes( PartitionLinkedList.ListNode head ) {

        Stack<Integer> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] ret = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {

            //Instead of Hashmap : comparing stack.peek() index of temperature array.
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {

                int idx = stack.pop();

                ret[idx] = list.get(i);
            }
            stack.push(i);
        }

        return ret;
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

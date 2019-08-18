package com.interview.codechef.ccdsap_2.leetcode.linkedlist.easy;

import com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium.PartitionLinkedList;

public class PalindromeLinkedList {

    //https://leetcode.com/problems/palindrome-linked-list/
    public static void main( String[] args ) {
        PartitionLinkedList.ListNode head = null;

        PalindromeLinkedList ll = new PalindromeLinkedList();

        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);

        //System.out.println(ll.isPalindrome(head));

        System.out.println(ll.isPalindromeOptimal(head));
    }

    //passed 22/26 test cases
    public boolean isPalindrome( PartitionLinkedList.ListNode head ) {

        if (head == null)
            return true;

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

        return reversed == mult;
    }

    //ref : https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
    private boolean isPalindromeOptimal( PartitionLinkedList.ListNode head ) {
        PartitionLinkedList.ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }

        //reverse the slow part
        slow = reverse(slow);

        //start the head from start
        fast = head;

        //if any value doesn't match return false.
        while (fast != null && slow != null) {

            if (fast.val != slow.val) {
                return false;
            }

            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    public PartitionLinkedList.ListNode reverse( PartitionLinkedList.ListNode head ) {
        PartitionLinkedList.ListNode prev = null;
        while (head != null) {
            PartitionLinkedList.ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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

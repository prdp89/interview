package com.interview.hackerrank.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class NodeFromLast {

    //https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/
    private static final Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) throws IOException {

        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int position = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = getNode(llist.head, position);
            // int result = getNodeOptimal(llist.head, position);

           /* bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();*/

            System.out.println(String.valueOf(result));
        }

        // bufferedWriter.close();
        scanner.close();
    }

    public static void printSinglyLinkedList( SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter ) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    //This pass all test case With Space O ( N )
    private static int getNode( SinglyLinkedListNode head, int positionFromTail ) {

        SinglyLinkedListNode temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null) {

            stack.push(temp.data);
            temp = temp.next;

        }

        for (int i = 0; i < positionFromTail; i++) {
            stack.pop();
        }

        return stack.peek();
    }

    /*
    This method takes two pointer, second will start when start Index cross the Goal index
     */
    private static int getNodeOptimal( SinglyLinkedListNode head, int positionFromTail ) {
        int index = 0;

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode result = head;

        while (current != null) {

            current = current.next;

            if (index++ > positionFromTail) {
                result = result.next;
            }
        }

        return result.data;
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        SinglyLinkedListNode( int nodeData ) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        void insertNode( int nodeData ) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
}

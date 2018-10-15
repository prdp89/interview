package com.interview.hackerrank.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class DeleteDuplicateValueNodes {

    //https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/
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

    private static void printSinglyLinkedList( SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter ) throws IOException {
        while (node != null) {
            System.out.println(String.valueOf(node.data));
            //bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

           /* if (node != null) {
                bufferedWriter.write(sep);
            }*/
        }
    }

    //Write code here
    private static SinglyLinkedListNode removeDuplicates( SinglyLinkedListNode head ) {

        SinglyLinkedListNode temp = head;

        while(temp != null){

            while(temp.next != null && temp.data == temp.next.data){
                temp.next = temp.next.next;
            }

            temp = temp.next;
        }

        return head;

    }

    //optimized code// no need of two loop
    SinglyLinkedListNode RemoveDuplicates(SinglyLinkedListNode head) {
        if(head==null || head.next==null) return head;

        SinglyLinkedListNode root = head;

        //checking from one previous node
        while(head.next!=null){

            if(head.data!=head.next.data){
                head = head.next;
            }else{
                head.next = head.next.next;
            }
        }
        return root;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = removeDuplicates(llist.head);

            printSinglyLinkedList(llist1, " ", null);
            //bufferedWriter.newLine();
        }

       // bufferedWriter.close();

        scanner.close();
    }
}

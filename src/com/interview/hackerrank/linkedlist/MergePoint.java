package com.interview.hackerrank.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MergePoint {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printSinglyLinkedList( SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter ) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    private static int findMergeNode( SinglyLinkedListNode head1, SinglyLinkedListNode head2 ) {

        int m = length(head1);
        int n = length(head2);

        HashMap<SinglyLinkedListNode, Integer> nodes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nodes.put(head2, i);
            head2 = head2.next;
        }

        for (int j = 0; j < m; j++) {
            if (nodes.containsKey(head1))
                return head1.data;

            head1 = head1.next;
        }

        return 0;
    }

    private static int length( SinglyLinkedListNode head1 ) {
        int count = 0;

        SinglyLinkedListNode temp = head1;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    /*

    This is optimal solution from CODeSchool

    //finds the intersection of the given linked lists version3
//The best approach to solve
struct Node* findMergePoint3(struct Node *A, struct Node *B) {
    int m = length(A);
    int n = length(B);
    int d = n - m;

    if(m > n) { //If A is greater, swap to make B greater.
        struct Node* temp = A;
        A = B;
        B = temp;
        d = m - n;
    }

    int i;

    for(i=0;i<d;i++) { //After swapping B is greater, so iterating B to d points ahead
        B = B->next;
    }

    while(A != NULL && B != NULL) { //Now A and B iterating from same points
        if(A == B) {
            return A;
        }
        A = A->next;
        B = B->next;
    }
    return NULL;
}

     */

    //Unable to generate test data for this question:
    // For test data see this.
    public static void main( String[] args ) {

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
//            int index = scanner.nextInt();

            //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedList llist1 = new SinglyLinkedList();
            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            int result = findMergeNode(llist1.head, llist2.head);

            System.out.println(result);

           /* bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();*/
        }

        //bufferedWriter.close();

        scanner.close();

    }

    //This clever solution from HackerRank.
    // It should be A1,B1,next -> A2,B3,next -> A3,A1,next -> B1,A2,next -> B3,A3  : hooray we found it
    int FindMergeNode( SinglyLinkedListNode headA, SinglyLinkedListNode headB ) {
        SinglyLinkedListNode currentA = headA;
        SinglyLinkedListNode currentB = headB;

        //Do till the two nodes are the same; This assumes there's always a Merging Point in Linked LIst.
        while (currentA != currentB) {
            //If you reached the end of one list start at the beginning of the other one
            //currentA
            if (currentA.next == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }
            //currentB
            if (currentB.next == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
        }
        return currentB.data;
    }

    //https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists

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

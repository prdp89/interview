package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/passing-the-parcel/

class Node {
    int num;
    Node next;

    public Node( int num ) {
        this.num = num;
        this.next = null;
    }
}

public class PassTheParcel {

    public void solve() {
        FastReader reader = new FastReader();
        int noOfStudents = reader.nextInt();
        int index = 0;
        char[] lyrics = reader.nextString().toCharArray();
        List<Boolean> aliveStudents = new ArrayList<>();

        for (int i = 0; i < noOfStudents; i++)
            aliveStudents.add(i, true);

        while (true) {

            if (index >= lyrics.length)
                index = 0;

            if (lyrics[index] == 'a')
                aliveStudents.set(index, true);
            else
                aliveStudents.set(index, false);

            if (!aliveStudents.get(index)) {
                aliveStudents.remove(index);
                index--;
            }

            index++;

            if (aliveStudents.size() == 1)
                break;
        }

        System.out.println(index + 1);
    }

    public void solveHackerSolution() {
        FastReader reader = new FastReader();

        String line = reader.nextString();
        int N = Integer.parseInt(line);
        Node dummy = new Node(0);
        Node start;
        Node node = dummy;
        for (int i = 0; i < N; i++) {
            node.next = new Node(i + 1);
            node = node.next;

        }
        //created a circular LL
        start = dummy.next;
        node.next = start;
        line = reader.nextString();
        int j = 0;
        while (node.next != node) {
            if (j == (line.length())) {
                j = 0;
            }
            if (line.charAt(j) == 'a') {
                node = node.next;
                //System.out.println(node.num+"  "+);
            } else if (line.charAt(j) == 'b') {
                node.next = node.next.next;
            }
            j++;
        }

        System.out.println(node.num);
    }

    /*public void removeElement( boolean[] arr, int removedIdx ) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }*/

    public static void main( String[] args ) {
        PassTheParcel passTheParcel = new PassTheParcel();
        // passTheParcel.solve();
        passTheParcel.solveHackerSolution();
    }
}

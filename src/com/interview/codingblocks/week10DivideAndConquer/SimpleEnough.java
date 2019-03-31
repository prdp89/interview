package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

public class SimpleEnough {

    /*
    "SIMPLE ENOUGH"
    For a given number n, form a list and insert the following pattern into the list at the same position
    sequentially.
    {floor(n/2) , n%2 , floor(n/2) }
    Until every element in the list is either 1 or 0. Now, calculate number of 1s in from l to r (1-indexed).

    EXPLANATION: Start from n. Then make a list with the following elements.i.e. {floor(n/2) , n%2 , floor(n/2) }.
    Now this list has three elements. Now further break down each of those 3 elements considering the new n to be
    floor(n/2) , n%2 and floor(n/2) respectively for those three elements respectively INPLACE. And this process
    will go on until the n reduces down to 1 or 0. So it will basically form a tree with 3 branches coming out of
    every node at every level starting from 1 node (n) at the root.

    Sample Input:
    9 6 9

    Sample Output:
    3
     */
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int R = scanner.nextInt();

        int count = 0, a = N, b = N, c = N, i = 0;
        int[] arr = new int[N];

        while ((a > 1 || b > 1 || c > 1) && i < N) {

            if (a > 1)
                a = (int) Math.floor((float) a / 2);
            arr[i++] = a;

            if (b > 1)
                b = (int) Math.floor((float) b % 2);

            arr[i++] = b;

            if (c > 1)
                c = (int) Math.floor((float) c / 2);

            arr[i++] = c;

        }

        for (int k = L; k < R; k++) {
            if (arr[k] == 1)
                count++;
        }

        //System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }
}

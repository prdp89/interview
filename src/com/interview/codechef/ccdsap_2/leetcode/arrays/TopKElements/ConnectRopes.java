package com.interview.codechef.ccdsap_2.leetcode.arrays.TopKElements;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectRopes {

    //https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {

            int n = scanner.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

            while (n-- > 0) {
                pq.add(scanner.nextInt());
            }

            long res = 0;

            while (pq.size() != 1) {

                int value = pq.poll();
                int value1 = pq.poll();

                pq.offer(value + value1);
                res += value + value1;
            }

            System.out.println(res);
        }
    }
}

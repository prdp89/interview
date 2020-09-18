package com.interview.codechef.ccdsapfoundation_1.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class STPAR {

    //https://www.spoj.com/problems/STPAR/
    public static void main( String[] args ) {

        try {
            Scanner scanner = new Scanner(System.in);

            for (; ; ) {
                int n = scanner.nextInt();

                if (n == 0)
                    break;

                int[] arr = new int[n];

                for (int i = 0; i < n; i++)
                    arr[i] = scanner.nextInt();

                scanner.nextInt();

                int need = 1;
                Stack<Integer> stack = new Stack<>();
                boolean state = true;

                for (int i = 0; i < arr.length; i++) {

                    while (!stack.isEmpty() && stack.peek() == need) {
                        need++;
                        stack.pop();
                    }

                    if (arr[i] == need) {
                        need++;
                    } else if (!stack.empty() && stack.peek() < arr[i]) {
                        state = false;
                        break;
                    } else {
                        stack.push(arr[i]);
                    }
                }

                if (state)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        } catch (Exception e) {
            return;
        }
    }
}

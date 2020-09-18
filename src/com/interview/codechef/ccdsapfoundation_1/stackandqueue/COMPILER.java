package com.interview.codechef.ccdsapfoundation_1.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class COMPILER {
    //https://www.codechef.com/problems/COMPILER
    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                char[] arr = scanner.next().toCharArray();
                Stack<Character> stack = new Stack<>();
                int count = 0;

                for (Character ch : arr) {

                    if (ch == '<')
                        stack.push(ch);

                    if (ch == '>') {
                        if (!stack.isEmpty()) {
                            stack.pop();
                            count += 2;
                        }
                    }
                }

                System.out.println(count);
            }
        } catch (Exception e) {
            return;
        }
    }
}

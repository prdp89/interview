package com.interview.codechef.ccdsapfoundation_1.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class AlternatingCurrent {

    //https://codeforces.com/contest/343/problem/B
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.next().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (Character ch : str) {
            if (stack.isEmpty())
                stack.push(ch);
            else {
                if (stack.peek() == ch)
                    stack.pop();
                else
                    stack.push(ch);
            }
        }

        if (stack.isEmpty())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

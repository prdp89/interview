package com.interview.codechef.ccdsapfoundation_1.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

//https://www.spoj.com/problems/ANARC09A/
public class ANARC09A {

    public static void main( String[] args ) {

        try {
            Scanner scanner = new Scanner(System.in);
            int i = 0;

            for (; ; ) {
                Stack<Character> stack = new Stack<>();
                char[] str = scanner.next().toCharArray();

                if (str[0] == '-')
                    break;

                int count = 0;

                for (Character c : str) {

                    if (c == '{')
                        stack.push(c);

                    if (c == '}') {
                        if (!stack.isEmpty())
                            stack.pop();
                        else {
                            stack.push(c);
                            count++;
                        }
                    }
                }

                System.out.println(++i + ". " + (stack.size() / 2 + count));
            }
        } catch (Exception e) {
            return;
        }
    }
}

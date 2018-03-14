package com.interview.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class TransformExpression {

    public void convertToRPM() {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        char[][] output = new char[testCases][];

        for (int i = 0; i < testCases; i++) {
            String prefixData = sc.nextLine();
            if (prefixData.length() != 0)
                output[i] = processRPM(prefixData.toCharArray());
        }

        for (int i = 0; i < output.length; i++)
            System.out.println(output[i]);
    }

    private char[] processRPM(char[] prefixString) {
        Stack<Character> stack = new Stack<>();
        char arr[] = new char[prefixString.length / 2 + 1];
        int index = 0;
        for (int i = 0; i < prefixString.length; i++) {
            if (prefixString[i] == '+' || prefixString[i] == '*' || prefixString[i] == '-' || prefixString[i] == '/' || prefixString[i] == '(') {
                stack.push(prefixString[i]);
            } else if (Character.isAlphabetic(prefixString[i])) {
                arr[index++] = prefixString[i];
            } else if (prefixString[i] == ')') {
                char c = ' ';
                for (int j = 0; j < stack.size(); j++){
                    c = stack.pop();
                    if (c == '(')
                        break;
                    arr[index++] = c;
                }

            }
        }
        return arr;
    }

    public static void main(String args[]) {
        TransformExpression lifeuniverse = new TransformExpression();
        lifeuniverse.convertToRPM();
    }
}

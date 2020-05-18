package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Objects;
import java.util.Stack;

public class DecodeString {

    //https://leetcode.com/problems/decode-string/
    public static void main( String[] args ) {
        //String str = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

        String str = "3[zk]";
        System.out.println(solveTr(str));
    }

    //passing all test cases...
    private static String solveTr( String str ) {

        Stack<String> characterStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))) {

                int num = 0;
                while (Character.isDigit(str.charAt(i))) {
                    num = (num * 10) + (str.charAt(i) - 48);
                    i++;
                }

                characterStack.push(num + "");
                i--;
            } else if (str.charAt(i) == '[') {

                characterStack.push("[");

            } else if (str.charAt(i) == ']') { //get string inside [..]

                //String bracketString = "";

                StringBuilder sb = new StringBuilder();


                //instead of reverse string append the string in inserted order
                while (!characterStack.isEmpty() && !Objects.equals(characterStack.peek(), "[")) {
                    //bracketString = characterStack.pop() + bracketString;
                    //sb.append(characterStack.pop());

                    sb = sb.insert(0, characterStack.pop());
                }

                //pop [ from the stack and get Number after that
                characterStack.pop();
                int num = Integer.valueOf(characterStack.pop());

                String val = sb.toString();

                sb = new StringBuilder();

                //repeat string num times
                while (num-- > 0) {
                    sb.append(val);
                }

                //push the repeated string again into the stack
                //This helps in nested brackets as well.
                characterStack.push(sb.toString());

            } else {

                characterStack.push(str.charAt(i) + "");

            }
        }

        String ans = "";

        //this logic is appending the last string first; equivalent to reverse of stack
        while (!characterStack.isEmpty())
            ans = characterStack.pop() + ans;

        return ans;
    }
}

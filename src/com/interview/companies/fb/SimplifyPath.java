package com.interview.companies.fb;

import java.util.Stack;

public class SimplifyPath {

    //very easy:
    //https://leetcode.com/problems/simplify-path/
    public static void main( String[] args ) {
        String str = "/../";

        System.out.println(simplifyPath(str));
    }

    //1 . dot : means current dir
    //2 .. : means move up a directory
    //3 We can ignore one slash out of double slash // if it occurs.

    //Runtime: 5 ms, faster than 62.00% of Java
    private static String simplifyPath( String path ) {
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");

        for (String str : strings) {
            if (!stack.empty() && str.equals("..")) //moving up the directory/removing last element
                stack.pop();
            else if (!str.equals("") && !str.equals(".") && !str.equals(".."))
                stack.push(str);
        }

        if (stack.size() == 0)
            return "/";

        //bcz top element of stack should come at first
        while (!stack.empty()) {
            sb.insert(0, "/" + stack.pop());
        }

        return sb.toString();
    }
}

package com.interview.hackerrank.recursion;

public class StrCount {

    //https://codingbat.com/prob/p186177
    public static void main( String[] args ) {

        System.out.println(strCount("catcowcat", "cow"));
    }

    private static int strCount(String str, String sub) {

        if(str.length() < sub.length())
            return 0;

        int sum = str.substring(0, sub.length()).equals(sub)
                ? 1 + strCount(str.substring(sub.length()), sub)
                : strCount(str.substring(1), sub);

        return sum;
    }
}

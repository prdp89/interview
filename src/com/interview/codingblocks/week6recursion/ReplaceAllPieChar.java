package com.interview.codingblocks.week6recursion;

public class ReplaceAllPieChar {

    //https://hack.codingblocks.com/contests/c/452/71
    public static void main( String[] args ) {

        String str = "xabpixx3.15x";

        StringBuilder stringBuilder = new StringBuilder(str);

        replacePie(stringBuilder, 0, str.length() - 1);

        // System.out.println(str);
    }

    private static void replacePie( StringBuilder str, int i, int length ) {

        if (i >= length) {
            System.out.println(str);
            return;
        }

        if (i < str.length() && i + 1 < str.length()) {

            if (str.charAt(i) == 'p' && str.charAt(i + 1) == 'i') {
                str.setCharAt(i, '3');
                str.setCharAt(i + 1, '.');

                str.insert(i + 2, "14");

                //length of string increased by 2
                replacePie(str, i + 2, length + 2);
                return;
            }

            replacePie(str, i + 1, length);
        }
    }
}

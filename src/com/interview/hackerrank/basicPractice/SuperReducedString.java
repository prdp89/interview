package com.interview.hackerrank.basicPractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SuperReducedString {

    public static void main( String[] args ) {
        solve();
    }


    //Failed 5 test case out of 16
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();

        /*StringBuilder builder = new StringBuilder();
        builder.append(s);

        for (int i = 1; i < builder.length(); i++) {

            if (builder.charAt(i) == builder.charAt(i - 1)) {
                builder.deleteCharAt(i);
                builder.deleteCharAt(i - 1);
            }
        }

        if (builder.toString().length() == 0)
            System.out.println("Empty String");
        else

            System.out.println(builder.toString());*/
        int[] arr = new int[26];
        for (char value : s) {
            arr[value - 97]++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & 1) != 0) { //checking if length is even
                builder.append((char)(97 + i));
            }
        }

        System.out.println(Arrays.toString(arr));

        System.out.println(builder.toString());

        //System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()).indexOf(1));
    }

    /*
    //optimal solution: delete or getting a substring and move to start of string again to check duplicate.
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                str = str.substring(0, i-1) + str.substring(i+1);
                i = 0;
            }
        }
        if (str.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println (str);

     */

}
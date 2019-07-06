package com.interview.codechef.ccdsap_2.leetcode.contests.contest140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccuranceBiagram {

    public static void main( String[] args ) {
        String str = "we will we will rock you";
        String first = "we";
        String second = "will";

        /*int count = 0;
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i - 1) == ' ' && str.charAt(i) == first.charAt(0)) {
                for (int j = 0; j < str.length(); j++) {

                    if (str.charAt(j) == first.charAt(j)) {

                    }
                }
            }
        }*/

        String[] strs = str.split(" ");
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < strs.length - 2; i++) {

            if (strs[i].equals(first) && strs[i+1].equals(second)) {
                stringList.add(strs[i + 2]);
            }
        }

        String op[] = stringList.toArray(new String[0]);

        System.out.println(Arrays.toString(op));

    }
}

package com.interview.codechef.ccdsap_2.leetcode.contests.contest172;

import java.util.ArrayList;
import java.util.List;

public class Max69Num {

    public static void main( String[] args ) {
        //solve69();
        solveVerticalString();
    }

    private static void solveVerticalString() {
        String s = "CONTEST IS COMING";

        String[] strs = s.split(" ");

        StringBuilder[] strSplit = new StringBuilder[s.length()];
        for (int i = 0; i < strs.length; i++)
            strSplit[i] = new StringBuilder(strs[i]);

        List<String> list = new ArrayList<>();

        int j = 0;
        while (s.length() > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();

            for (int i = 0; i < strSplit.length; i++) {

                if (null != strSplit[i] && strSplit[i].length() > 0) {
                    sb.append(strSplit[i].charAt(j));
                    strSplit[i].deleteCharAt(j);
                } else
                    sb.append(" ");

                if (null != strSplit[i])
                    sb1.append(strSplit[i]);
            }
            list.add(sb.toString().replaceAll(" +$", ""));
            s = sb1.toString();
        }

        list.forEach(System.out::println);
    }

    //https://leetcode.com/contest/weekly-contest-172/problems/maximum-69-number
    private static void solve69() {
        int num = 9999;

        StringBuilder sb = new StringBuilder(num + "");

        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) != '9') {

                sb.setCharAt(i, '9');
                //sb.replace(i, i, "9");
                break;
            }
            i++;
        }

        System.out.println(sb.toString());
    }
}

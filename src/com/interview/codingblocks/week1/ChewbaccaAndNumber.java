package com.interview.codingblocks.week1;

import java.util.Arrays;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/514/A
public class ChewbaccaAndNumber {

    public static void main( String[] args ) {
        solve();
    }

    public static void solve() {
        char[] a;
        Scanner s = new Scanner(System.in);

        a = s.next().toCharArray();

        int i = 0;
        //cannot minus from 9 bcz it will change to zer0
        if (a[i] == '9')
            i++;

        for (int j = i; j < a.length; j++) {

            int digit = a[j] - '0';

            // >=5 to check the mid range of number.
            if (digit >= 5) {
                digit = 9 - digit;
                a[j] = (char) (digit + '0');
            }
        }
        System.out.println(Arrays.toString(a));
    }
}

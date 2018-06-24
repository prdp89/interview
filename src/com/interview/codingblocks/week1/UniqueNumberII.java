package com.interview.codingblocks.week1;

import java.util.Scanner;

//question:https://hack.codingblocks.com/contests/c/452/463
public class UniqueNumberII {

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];

        int result = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            //taking xor of complete array
            result = result ^ a[i];
        }

        //now we get the result like 2 = 0 1 0 , so we need to find position of set bit in an array.

        int temp = result, i = 0, firstNum = 0;

        while (temp > 0) {

            //if temp last bit is set then we got that set bit position
            if ((temp & 1) != 0)
                break;

            i++;
            temp = temp >> 1;
        }

        //now we create a MASK to covert position into number
        int mask = 1 << i;

        for (int j = 0; j < n; j++) {

            //we are doing AND of MASK and a[j] to check if element at set bit position is 1 in a[l] :
            // mask = 0 1 0
            // a[j] = 1 1 0  = 1 in second position, so this value consider for XOR operation
            //        -----
            //      & 0 1 0

            if ((mask & a[j]) != 0)
                firstNum = firstNum ^ a[j];
        }

        int secondNum = result ^ firstNum; //can be seen as result - firstNum = secondNum
        System.out.println(firstNum + " " + secondNum);
    }

    public static void main( String[] args ) {
        solve();
    }
}

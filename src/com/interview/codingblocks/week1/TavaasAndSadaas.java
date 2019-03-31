package com.interview.codingblocks.week1;

//question: http://codeforces.com/contest/535/problem/B


import java.util.Scanner;

public class TavaasAndSadaas {

    //https://online.codingblocks.com/player/3880/content/42?s=1916

    //lucky number is like series; 4 , 7 , 44, 47, 74, 77
    //for input : 7 = op = 2 bcz 7 is second lucky number
    //for input : 77 = op = 6
    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        //for step 2 : (2^x) - 2 where x is length of input
        // Minus -2 means : we are not considering last digit of input number
        //eg. N = 4474 => we are taking only 447 for combinations => 2^N - 2 => 2 ^ 4 - 2 => 14
        int answerPart2 = (1 << input.length()) - 2;

        int answerPart1 = 0;

        //now to calculate for N-digits (N = 4474), we have flip each 7 and check its possible probability
        //Example : 7 4 4 7 : this loop starts for last position of 7, flip it and find 2^pos = 2^0 = 1 for ith position
        for (int i = input.length() - 1, pos = 0; i >= 0; i--, pos++) {

            if (input.charAt(i) == '7') {
                answerPart1 += (1 << pos); //convert pos into 2^pos
            }
        }

        //now Total = answerPart2 + answerPart1 + 1 [to reach the nth number bcz we are calculating number less that 7447]
        System.out.println(answerPart1 + answerPart2 + 1);
    }

    public static void main( String[] args ) {
        solve();
    }
}

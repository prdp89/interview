package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

public class MurthalParatha {

/*
https://online.codingblocks.com/player/3880/content/5058?s=1923
The coding blocks members went to the success party of their first ever online boot-camp at Murthal.
They ordered P number of paranthas.

The stall has L cooks and each cook has a rank R. A cook with a rank R
can cook 1 prata in the first R minutes 1 more prata in the next 2R minutes, 1 more prata in 3R minutes and
so on(he can only cook a complete prata) ( For example if a cook is ranked 2.. he will cook one prata in 2 minutes
one more prata in the next 4 mins an one more in the next 6 minutes hence in total 12 minutes he cooks 3 pratas
in 13 minutes also he can cook only 3 pratas as he does not have enough time for the 4th prata).

Calculate the minimum time needed to cook all the paranthas.

First line contains P, the number of pratha ordered. In the next line the first integer denotes the number of cooks
L and L integers follow in the Next line each denoting the rank of a cook.

Sample Input:
10
4
1 2 3 4

Sample Output:
12
 */

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int numberOfParathas = scanner.nextInt();

        int numberOfCooks = scanner.nextInt();

        int[] arr = new int[numberOfCooks];
        for (int i = 0; i < numberOfCooks; i++) {
            arr[i] = scanner.nextInt();
        }
    }
}

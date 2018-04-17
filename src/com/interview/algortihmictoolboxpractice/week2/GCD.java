//package com.interview.algortihmictoolboxpractice.week2;

import java.util.Scanner;

public class GCD {
    public static void main( String[] args ) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        System.out.println(euclideanGcd(a,b));
    }

    private static int euclideanGcd(int a, int b)
    {
        if(b==0)
            return a;
        else
        {
            int aComplement = a%b;
            return euclideanGcd(b, aComplement);

        }
    }
}

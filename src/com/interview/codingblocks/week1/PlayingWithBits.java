package com.interview.codingblocks.week1;

import java.util.Scanner;
/*
Prateek Bhayia gives Q queries each query containing two integers a and b.
Your task is to count the no of set-bits in for all numbers between a and b (both inclusive)
 */
public class PlayingWithBits {

    private static void countBitsInRange(){
        Scanner s = new Scanner(System.in);

        int Q = s.nextInt();

        for (int i=0; i< Q; i++){
           int a = s.nextInt();
           int b = s.nextInt();

           if(a>b)
               System.out.println(0);
           else{
               int countSetBits = 0;
               for(int j=a; j<=b; j++)
               {
                   int temp = j;
                   while (temp > 0){
                       countSetBits += (temp & 1);

                       //equals to number divide by 2
                       temp = temp >> 1;
                   }
               }
               System.out.println(countSetBits);
           }
        }
    }

    public static void main( String[] args ) {
        countBitsInRange();
    }
}

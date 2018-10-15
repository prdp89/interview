package com.interview.codingblocks.week1;

import java.util.Scanner;

//https://www.geeksforgeeks.org/print-subsequences-string/

//Time Complexity : O(n* 2^n)
public class SubsequenceWithBitMasking {

    private static void findSubsequence(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        //generating a range of numbers from 0 to 2^n-1
        int range = (1<<input.length()) - 1; // where 1<<length = 1*2^n

        for (int i=0; i <= range ; i++){
            filterChars(input, i);
        }
    }

    private static void filterChars( String a, int no ) {
        //if input = abc and no = 5 then output= ac; means : 5=101 , so we pick only set bits

        int i=0;
        while (no > 0){

            //if last bit of number is set then print the character at ith position
            if((no & 1) > 0){
                System.out.print(a.charAt(i));
            }

            i++;
            no= no>>1;
        }
        System.out.print("\n");
    }

    public static void main( String[] args ) {
        findSubsequence();
    }
}

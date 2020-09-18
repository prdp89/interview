package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Scanner;

public class RightAngledTriangle {

    //THis is the simplest one
    //https://www.codechef.com/problems/RIGHTTRI
    public static void main( String[] args ) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while (t > 0) {
            long h = scn.nextLong();
            long s = scn.nextLong();

            //hypotenis square must greater then 4*Area for right angle triangle
            /*
            Formula: Sin(2A)=4S/(H * H)

            Where H is Hypotenuse, S is Area and A is the angle between base and Hypotenuse.

            Note: Solution does not exist if 4S > H*H
             */
            if ((h * h) >= (4 * s)) {

                //The below formula is derivation of this formula:
                // l square = (h square (+-) Math.Sqrt(H square * square - 16 . Area square)) / 2
                //1. the above formula derive by solving : h square = length square + base square
                //2. Area = l.b/2 => 2A = l.b
                //Put equation 2 in 1 and apply quadratic equation : b2-4ac/2a

                System.out.println((Math.sqrt(h * h + 4 * s) - Math.sqrt(h * h - 4 * s)) / 2 + " " +
                        (Math.sqrt(h * h + 4 * s) + Math.sqrt(h * h - 4 * s)) / 2 +
                        " " + h);
            } else {
                System.out.println("-1");
            }
            t--;
        }
    }
}

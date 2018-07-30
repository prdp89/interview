package com.interview.codingblocks.week4;

import java.util.Scanner;

public class ExtendedEuclidAlgo {


    static int finalX, finalY, GCD;

    private static void extendedEuclidGCD( int a, int b ) {

        if (b == 0) {
            //This we already proved while simplifying equation in Notebook
            finalX = 1;
            finalY = 0;
            GCD = a;
            return;
        }

        //this call is similiar to Normal GCD
        extendedEuclidGCD(b, a % b);

        //Now as bottom up approach, after getting X and Y, we replace these values with previous X and Y
        int cX = finalY;
        int cY = finalX - (a / b) * finalY;

        //step by step values
        //System.out.println(cX + " " + cY);

        finalX = cX;
        finalY = cY;

    }

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        //solving for equation 18 X + 30 Y = GCD ( 18, 30 )
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        extendedEuclidGCD(x, y);

        System.out.println( finalX + " " + finalY);
        //18. 2 + 30 . -1 == 6
        //36 - 30 == 6
        //6 == 6
    }
}

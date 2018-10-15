package com.interview.hackerrank.basicPractice;

public class ModifiedKaprekarNumbers {

    //https://www.hackerrank.com/challenges/kaprekar-numbers/problem
    public static void main( String[] args ) {

        solveKaprekar();
        //System.out.println(square(256));
    }

    private static void solveKaprekar() {

        int p = 1;
        int q = 100;
        boolean isExist = false;

        do {

            long num = square(p);

            //int digitCount = String.valueOf(p).length();
            int numLenght = String.valueOf(num).length();

            String str1 = String.valueOf(num).substring(numLenght / 2);
            int right = 0;

            if (!str1.equalsIgnoreCase(""))
                right = Integer.parseInt(str1);

            int left = 0;
            if (numLenght > 1) {
                String str = String.valueOf(num).substring(0, numLenght / 2);

                if (!str.equalsIgnoreCase(""))
                    left = Integer.parseInt(str);
            }

            if (right + left == p){
                isExist = true;
                System.out.print(p + " ");
            }
        } while (p++ <= q);

        if(!isExist)
            System.out.print("INVALID RANGE");
    }

    //https://lifehacker.com/5506418/square-large-numbers-in-your-head-quickly
    private static long square( int num ) {
        int rem = num % 10;
        return (long)(num * (num - rem) + (num * rem));
    }
}

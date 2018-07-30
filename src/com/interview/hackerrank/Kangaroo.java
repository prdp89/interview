package com.interview.hackerrank;

public class Kangaroo {

    //This solution even doesn't pass all test case
    private static void solve() {
        int x1 = 0, v1 = 2, x2 = 5, v2 = 3;

        if(x2 > x1 && v2 > v1){
            System.out.println("NO");
            return;
        }

        boolean isMatched = false;
        while (x1 < 10000 || x2 < 10000) {

            if (x1 == x2) {
                isMatched = true;
            }

            x1 += v1;
            x2 += v2;
        }

        if (isMatched)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    /*
    If , they will never meet.

We just need to check if a solution exists for the following equation:

X1 + t * v1 === X2 + t * v2

This is equivalent to checking if : (x2 - x1) % (v1 - v2 ) == 0

     */
    //This solution even doesn't pass all test case
    private static void solveBest(){

        int x1 = 0, v1 = 3, x2 = 4, v2 = 2;

        if(v1 <= v2){
            System.out.println("NO");
           // return "NO";
        }
        else if(x1 < x2){

            boolean isMatched = false;
            while(x1 <= 10000){

                if (x1 == x2) {
                    isMatched = true;
                    break;
                }

                x1+=v1;
                x2+=v2;
            }

            if (isMatched)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        else if(x2 < x1){
            boolean isMatched = false;
            while(x2 <= 10000){

                if (x1 == x2) {
                    isMatched = true;
                    break;
                }

                x1+=v1;
                x2+=v2;
            }

            if (isMatched)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    //https://www.hackerrank.com/challenges/kangaroo/problem?h_r=next-challenge&h_v=zen
    public static void main( String[] args ) {
        //solve();

        solveBest();
    }
}

package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/roy-and-coding-contest/

public class RoyAndCoding {

    public static void main( String[] args ) {
        FastReader fastReader = new FastReader();

        int t = fastReader.nextInt();
        while (t-- > 0) {
            int n = fastReader.nextInt();
            int m = fastReader.nextInt();

            int c = 1;
            int i = 0;
            int time = 0;
            if (n>m){
                while (c <= m) {
                    c += i;
                    i++;
                    time++;

                }
                while (c <= n) {
                    c += m;
                    time++;
                }
            } else{
                while (c<=n){
                    c+=c;
                    time++;
                }
            }

            System.out.println(time);
        }
    }
}

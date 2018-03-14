package com.interview.basics;

import java.util.Arrays;


//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/the-great-kian/description/

public class TheGreatKian {

    public int[] greatKianSol() {
        FastReader fastReader = new FastReader();
        int testCases = fastReader.nextInt();
        long[] array = new long[testCases];
        long[] output = new long[3];

        for (int i = 0; i < testCases; i++) {
            array[i] = fastReader.nextLong();
        }

        for (int i = 0; i < 3; i++) {
            output[i] = array[i] + (i + 3 < testCases ? array[i + 3] : 0) + (i + 6 < testCases ? array[i + 6] : 0);
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(output[i] + " ");
        }

        return null;
    }

    public static void main(String args[]) {

        TheGreatKian theGreatKian = new TheGreatKian();
        theGreatKian.greatKianSol();
    }
}

//correct answer-----------------------------------------
    /*Reader s = new Reader();
    int N = s.nextInt();
    long sum1,sum2,sum3=0;
    sum1=sum2=sum3;
    int count=1;
        for (int i = 0; i < N; i++) {
        switch(count)
        {
            case 1: sum1+=s.nextLong();count++; break;
            case 2: sum2+=s.nextLong();count++; break;
            case 3: sum3+=s.nextLong(); count=1;break;
        }
    }
        System.out.println(sum1+" "+sum2+" "+sum3);
}*/

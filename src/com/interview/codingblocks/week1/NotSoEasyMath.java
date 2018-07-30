package com.interview.codingblocks.week1;

import java.util.Scanner;

/*
After the release of despicable me 3 GRU and DRU got into a fight and DRU challenged GRU to find out the
 number of numbers between 1 and n which are divisible by any of the prime numbers less than 20.
 GRU being great at maths quickly answered the question but then DRU asked him to write a program for it.
 GRU however found it quite difficult as he did not wanted to write so many lines of code.
  he knows that you are smart and can code this up easily. In return you will get one of his minions.
  Can you do it?

Input Format:
the first line consists of number of test cases t. then follow t lines which consists of number n for each test case.

Constraints:
1 <= test cases <= 10 1 <= n <= 10^18

Output Format
the answer to each test case each in different line

Sample Input
5
5 10 12 15 18

Sample Output
4 9 11 14 17

 */

public class NotSoEasyMath {

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int arr[] = {2, 3, 5, 7, 11, 13, 17, 19};

        int count = 0;
        for (int i = 2; i <= N; i++) {

            for (int anArr : arr) {
                if (i % anArr == 0) {
                    count += 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }


    /*
    You’ll have to modify the code. It counts the same number more than once.
    Say N = 10 :
    case 2 : 2, 4, 6, 8, 10
    case 3 : 3, 6, 9
    case 5 : 5, 10
    case 7 : 7
    So, you see it’ll output 5+3+2+1 = 11, because 6 and 10 are counted twice.
     */


    /*
    To solve this:

    In order to exclude 6 and 10 in the example I gave earlier, let the number of numbers divisible
    by 2 be c1 and that of 3 be c2. Now find the number of numbers that are divisible by 2*3 i.e.

    6 (say c3) and put c1 + c2 - c3 in the final result. This was just for 2 and 3,
    you need to do this for the whole array of {2, 3, 5, 7, 11, 13, 17, 19}.

     */
    private static void solveMethodTwo() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int arr[] = {2, 3, 5, 7, 11, 13, 17, 19};

        int ans = 0;
        for (int item : arr) {

            ans += numOfMultiples(1, N, item);
        }

        System.out.println(ans);
    }

    private static int numOfMultiples( int A, int B, int K ) {
        double count;
        count = Math.floor(B / K) - Math.floor(A / K);

        if (A % K == 0)
            count++;

        return (int) count;
    }

    //By using Exclusion of numbers
    //If N = 10
    //then we are calculating for prime numbers <=10 by excluding all numbers N which are not divisible by numbers less than 10 = {2,3,5,7}
    // formula is : N * 1/first_prime * 2/second_prime ..... i/(Last_prime_less_than_N)
    //Reference: https://www.youtube.com/watch?v=3985ygTPPq0

    private static void solveMethodThree() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int arr[] = {2, 3, 5, 7, 11, 13, 17, 19};

        double division = 1;
        for (int i = 0; i < arr.length; i++) {
            division *= (double) (i + 1) / arr[i];

            if (arr[i] >= N)
                break;
        }

        division = Math.ceil(N * division);

        int answer = N - (int) division;
        System.out.println(answer);
    }

    public static void main( String[] args ) {
        //solveMethodTwo();

        solveMethodThree();
    }
}

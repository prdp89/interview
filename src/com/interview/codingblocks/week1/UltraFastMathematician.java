package com.interview.codingblocks.week1;

import java.util.Scanner;

/*
One day Prateek was trying to find out if any one can possibly do calculations faster than him.
As a result he made a very great contest and asked every one to come and take part.

In his contest he gave the contestants many different pairs of numbers.
Each number is made from digits 0 or 1. The contestants should write a new number corresponding to the
 given pair of numbers. The rule is simple: The i-th digit of the answer is 1 if and only if the i-th digit
 of the two given numbers differ. In the other case the i-th digit of the answer is 0.

Prateek made many numbers and first tried his own speed. He saw that he can perform these operations on
numbers of length ∞ (length of a number is number of digits in it) in a glance! He always gives correct
answers so he expects the contestants to give correct answers, too. He is a good fellow so he won't give
anyone very big numbers and he always gives one person numbers of same length.

Now you are going to take part in Shapur's contest. See if you are faster and more accurate.

Input Format:
The first line contains an integer t , the no. of testcases. There are two inputs in each line.
Each of them contains a single number. It is guaranteed that the numbers are made from 0 and 1 only
and that their length is same. The numbers may start with 0. The length of each number doesn't exceed 100.

Constraints:
Output Format
Write t lines — the corresponding answer to the corresponding input. Do not omit the leading 0s.

Sample Input
1 10111 10000

Sample Output
00111

 */

public class UltraFastMathematician {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {

        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();
        String [] output = new String [queries];

        for(int i =0; i <= queries-1; i++) {

            char[] number2;
            char[] number;

            number = scanner.next().toCharArray();
            number2 = scanner.next().toCharArray();

            char[] op = new char[number.length];

            for (int j = 0; j < number.length; j++) {

                int digit1 = number[j] - '0';
                int digit2 = number2[j] - '0';

                op[j] = (char) ((digit1 ^ digit2) + '0');
            }

            output[i] = String.valueOf(op);
            //for (char anOp : op) System.out.print(anOp);
        }

        for (String str: output) {
            System.out.println(str);
        }
    }
}

package com.interview.codingblocks.week1;

import java.util.Scanner;

//Question link :http://www.recursionnitd.in/uploads/ckeditor/attachments/1/Paying_up___CodeChef.html
//little Help: https://github.com/abusomani/Codechef/blob/master/paying%20up(all%20subset%20problem).cpp
//suggestion: https://blog.codechef.com/2009/07/09/tutorial-for-problem-paying-up/

public class PayingUp {

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // number of inputs
        int m = scanner.nextInt(); //mugger demand value
        boolean isMugged = false;

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int range = (1 << n) - 1;//generating 2^n-1 combinations of number range

        for (int i = 1; i <= range; i++) {
            if (findSubsetSum(arr, i) == m) {
                System.out.println("YES");
                isMugged = true;
                break;
            }
        }

        if (!isMugged)
            System.out.println("NO");
    }

    private static int findSubsetSum( int[] arr, int number ) {

        int i = 0, sum = 0;
        while (number > 0) {

            //if last bit of number is set :

            /*
            If we consider that 1 means that we have selected object at that position and 0 means
            that we have not selected the object at that position, we can get all possible subsets

            of ‘n’ objects by looping over numbers from 1 to 2^n.

            In this way, we can get the sum for all possible subsets of the ‘n’ objects.
             */
            if ((number & 1) != 0) {
                sum += arr[i];
            }

            i++;

            //divide the number by 2.
            number = number >> 1;
        }
        return sum;
    }

    public static void main( String[] args ) {
        solve();
    }
}

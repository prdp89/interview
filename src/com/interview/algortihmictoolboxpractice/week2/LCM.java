//package com.interview.algortihmictoolboxpractice.week2;

import java.util.Scanner;
import java.util.Vector;

public class LCM {
    public static void main( String[] args ) {

       // int size = reader.nextInt();
        //int arr[] = reader.nextArray(size);
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b= scanner.nextLong();

        System.out.println(lcm(a,b));
    }

    //LCM of two numbers------------------

    // Recursive method to return gcd of a and b
    static long gcd(long a, long b)
    {
        if(b==0)
            return a;
        else
        {
            long aComplement = a%b;
            return gcd(b, aComplement);

        }
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }


    //-------------------------------------

    // Returns LCM of arr[0..n-1] more than two numbers
    static long lcm(int arr[], int n)
    {
        // Find the maximum value in arr[]
        int max_num = 0;
        for (int i=0; i<n; i++)
            if (max_num < arr[i])
                max_num = arr[i];

        // Initialize result
        long res = 1;

        // Find all factors that are present in
        // two or more array elements.
        int x = 2;  // Current factor.
        while (x <= max_num)
        {
            // To store indexes of all array
            // elements that are divisible by x.
            Vector<Integer> indexes = new Vector<>();

            for (int j=0; j<n; j++)
                if (arr[j]%x == 0)
                    indexes.add(j);

            // If there are 2 or more array elements
            // that are divisible by x.
            if (indexes.size() >= 2)
            {
                // Reduce all array elements divisible
                // by x.
                for (Integer index : indexes) arr[index] = arr[index] / x;

                res = res * x;
            }
            else
            {
                x++;
            }

        }

        // Then multiply all reduced array elements
        for (int i=0; i<n; i++)
            res = res*arr[i];

        return res;
    }
}

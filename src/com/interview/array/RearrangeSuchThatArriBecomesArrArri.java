package com.interview.array;

/**
 * http://www.geeksforgeeks.org/rearrange-given-array-place/
 */
public class RearrangeSuchThatArriBecomesArrArri {

    public static void main( String args[] ) {
        int arr[] = {3, 2, 0, 1};
        RearrangeSuchThatArriBecomesArrArri rss = new RearrangeSuchThatArriBecomesArrArri();
        //rss.rearrange(arr);

        rss.rearrangeGFG(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private void rearrangeGFG( int arr[], int n ) {
        // First step: Increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++)
            arr[i] += (arr[arr[i]] % n) * n;

        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }

    //By Tushar Roy
    public void rearrange( int arr[] ) {
        for (int i = 0; i < arr.length; i++) {
            int temp;
            if (arr[arr[i]] > arr.length - 1) {
                temp = arr[arr[i]] / arr.length - 1;
            } else {
                temp = arr[arr[i]];
            }
            arr[i] = temp + arr.length * (arr[i] + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % arr.length;
        }
    }
}


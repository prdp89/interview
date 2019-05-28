package com.interview.array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/find-number-of-triangles-possible/
 */
public class NumberOfTrianglesInUnsortedArray {

    public static void main( String args[] ) {
        int input[] = {3, 4, 5, 6, 8, 9, 15};
        NumberOfTrianglesInUnsortedArray not = new NumberOfTrianglesInUnsortedArray();
        System.out.println(not.numberOfTriangles(input));
    }

    //some explaination here : https://www.geeksforgeeks.org/find-number-of-triangles-possible/
    private int numberOfTriangles( int input[] ) {
        Arrays.sort(input);

        int count = 0;
        for (int i = 0; i < input.length - 2; i++) {
            int k = i + 2;

            for (int j = i + 1; j < input.length; j++) {
                while (k < input.length && input[i] + input[j] > input[k]) {
                    k++;
                }

                /*
                The number of triangles that can be formed with ‘arr[i]’ and ‘arr[j]’
                as two sides is ‘k – j’. Add ‘k – j’ to count of triangles.
                 */
                count += k - j - 1;
            }
        }
        return count;

    }
}

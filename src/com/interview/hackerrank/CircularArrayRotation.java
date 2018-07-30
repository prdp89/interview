package com.interview.hackerrank;

public class CircularArrayRotation {

    //couldn't solve with this approach
    private static void solve() {

        int a[] = {1, 2, 3};
        int k = 3;

        int temp[] = new int[a.length];

        for (int i = 0; i < k; i++) {

            int rotationElement = a[a.length - (i + 1)];

            temp[0] = rotationElement;
            int l = 0;

            for (int j = 1; j < a.length; j++) {
                temp[j] = a[l];
                l++;
            }

            /*int rotation = a.length -1;
            int temp = a[0];
            for (int j = 0; j < a.length; j++) {

                a[j] = a[rotation];
                a[j+1] = temp;
            }*/
        }

    }

    private static void solveOptimal() {

        int a[] = {1, 2, 3};
        int k = 2; //number of rotations

        //calculating final rotations requires in an array. If k > a.length means array rotated to original
        int finalRotations = k % a.length;


        //queries to find array index after rotation of an array.
        int[] queries = {0, 1, 2};


        for (int i = 0; i < queries.length; i++) {

            //if subtracting the (queries - rotations) are within the array range. Then final element can be picked from (query - rotation) index.

            if (queries[i] - finalRotations >= 0) {

                System.out.println(a[queries[i] - finalRotations]);

            } else {
                //means element is out of range(-ve), so adding length bring it in a range of rotated array value.
                //here MOD length won't work bcz element is out range.
                System.out.println(a[(queries[i] - finalRotations) + a.length]);
            }
        }

    }

    public static void main( String[] args ) {
        solve();
    }
}

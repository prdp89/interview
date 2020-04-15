package com.interview.codility;

public class Test {

    public static void main( String[] args ) {
        int[] arr = {3, 4, 5, 3, 7};
        System.out.println(solve(arr));
    }

    private static int solve( int[] arr ) {

        int[] temp = new int[arr.length];

      /*  Arrays.fill(temp, 1);

        //temp[0] = 0;*/

        if (arr.length < 2) {
            return 0;
        }

        if (arr.length == 2) {
            if (arr[0] == arr[1])
                return 1;
            return 0;
        }


        boolean isSmall = arr[1] > arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (isSmall && arr[i] > arr[i - 1])
                count++;

            if (!isSmall && arr[i] < arr[i - 1])
                count++;

            isSmall = !isSmall;
        }

        if (count == arr.length) {
            System.out.println(0);
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (isSmall && arr[j] > arr[j - 1])
                    count++;

                if (!isSmall && arr[j] < arr[j - 1])
                    count++;

                isSmall = !isSmall;
            }
        }

       /* int cur = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if(cur > temp[i])
        }*/

        return 0;
    }
}

package com.interview.codingblocks.week10DivideAndConquer;

public class SquareRoot {

    //https://online.codingblocks.com/player/3880/content/78?s=1919

    //Read this too:
    //https://www.geeksforgeeks.org/square-root-of-a-perfect-square/

    public static void main( String[] args ) {
        System.out.println(squareRoot(10, 3));
    }

    private static float squareRoot( int n, int fractionalPlaces ) {
        int start = 0, end = n;

        float ans = 0.0f;
        int mid;

        while (start <= end) {

            mid = (start + end) / 2;

            if (mid * mid == n) {
                ans = mid;
                break;
            }
            if (mid * mid < n) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }

        //for fractional part?
        //Now we have SQRT(10) = 3
        //So for each decimal digit after 3 we add = 0.1 up-to that number is greater than square of answer

        float increment = 0.1f;
        for (int i = 0; i < fractionalPlaces; i++) {

            //In this iteration we first get : 3.1 .. then 3.16 then.. 3.169....
            while (ans * ans <= n) {
                ans += increment;
            }

            //bcz after above iteration ans is one step greater precision; So decrementing 0.1 fixed it.
            ans -= increment;

            //in next iteration we have to add = 0.01 to find next decimal digit. So diving 0.1/10 = 0.001
            //example : 3.1 is calculated above now in next iteration we get 3.16
            increment = increment / 10;

        }
        return ans;
    }
}

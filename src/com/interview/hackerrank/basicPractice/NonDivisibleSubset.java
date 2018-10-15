package com.interview.hackerrank.basicPractice;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/non-divisible-subset/
public class NonDivisibleSubset {

    //This fails most of test cases.....
    private static void solve() {
        int k = 3;
        int[] S = {1, 7, 2, 4};

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < S.length; i++) {

            for (int j = i + 1; j < S.length; j++) {

                if ((S[i] + S[j]) % k != 0)
                    list.add(S[i] + S[j]);
            }
        }

     /*   for (Integer item : list) {
            System.out.println(item);
        }*/

        System.out.println(list.size());
    }


    private static void solveOptimal() {

        int k = 3;
        int[] S = {1, 7, 2, 4};

        int[] arr = new int[S.length];

        /* For given set pairs are:
        1 + 7 = 8
        1 + 2 = 3
        1 + 4 = 5
        7 + 2 = 9
        7 + 4 = 11
        2 + 4 = 6

        8,5,11 are not divisible by 3
         */

        /* Step 1 :
        for example: if k=5 then for any input, we can have 0,1,2,3,4 as remainder

        This is like a lookup table saying : in the set of numbers you have ,
        there are x counts of numbers which give remainder 0 when divided by k, y counts of
        numbers which give remainder 1 when divided by k,.. and so on.
         */
        for (int i = 0; i < S.length; i++) {
            arr[S[i] % k]++;
        }

        /* Step 2:
        Now, taking our earlier example of k=5, Number with remainder 1 cant be paired with number
        with remainder 4,Number with remainder 2 cant be paired with number with remainder 3, Number
        with remainder 0 cant be paired with number with remainder 0, Since paring them will result
        in a number divisible by 5.

        Now we find max number from Max(Start[i], End[i]) till MID = K/2 :
         */

        int result = 0;
        for (int j = 1; j <= k / 2; j++) //why k/2 : to compare every start with every end element.
            if (j != k - j)
                result += Math.max(arr[j], arr[k - j]);

        /* Step 3 :
        Also, if k is multiple of 2 then we add those numbers lying in the middle, once if(k%2==0)result++;
         */

        if (k % 2 == 0) //if K is even then Middle element will not have any pair too, so add 1 to the result
            result++;  // it will not have any conjugate pair

        /* Step 4 :
        Lastly, result = result+Math.min(arr[0],1);//If no number wholly divisible don't add it
        to pair else add once
         */
        result = result + Math.min(arr[0], 1);//If Array 0th element is not zero, means no number divided by K then add 1 in pair again

        System.out.println(result);
    }

    public static void main( String[] args ) {
        //solve();

        solveOptimal();
    }
}

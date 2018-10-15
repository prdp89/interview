package com.interview.hackerrank.InterviewPreprationKit;

import java.util.Arrays;

public class MinimumSwaps2 {

    private static void solve() {
        // int arr[] = {4, 3, 1, 2};

        int arr[] = {7, 1, 3, 2, 4, 5, 6};

        int temp[] = Arrays.copyOf(arr, arr.length);

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < temp.length; i++) {

            if (arr[i] != temp[i]) {

                int j = i + 1;
                for (; j < temp.length; j++) {
                    if (temp[j] == arr[i]) {
                        break;
                    }
                }

                int dummy = temp[i];
                temp[i] = temp[j];
                temp[j] = dummy;

                count++;
            }
        }

        System.out.println(count);
    }

    /*

    int minimumSwaps(vector<int> arr) {

    int i,c=0,n=arr.size();
    for(i=0;i<n;i++)
    {
        if(arr[i]==(i+1))
            continue;

        // { 4 , 3 , 1 , 2}
        //here we are swapping array current element with Array element index. Arr[4 - 1] = {2 , 3 , 1 , 4}
        //This logic works bcz elements are ordered from 1...N

        swap(arr[i],arr[arr[i]-1]);
        c++;
        i--;
    }
    return c;

}

     */

    public static void main( String[] args ) {
        solve();
    }
}

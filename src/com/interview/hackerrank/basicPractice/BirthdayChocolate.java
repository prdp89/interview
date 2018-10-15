package com.interview.hackerrank.basicPractice;

public class BirthdayChocolate {

    //https://www.hackerrank.com/challenges/the-birthday-bar/problem
    //this doesn;t pass all test case
    private static void solve() {
        //int[] s = {1, 2, 1, 3, 2};
        //int[] s = {1, 1, 1, 1, 1, 1};

        int[] s = {4};

        int d, m, segmentCount = 0;

        m = 1; //pair will be of m length
        d = 4; //sum of pair should be d

        if (s.length == 1 && d == s[0])
            System.out.println(1);
        else if (s.length < m)
            System.out.println(0);
        //return 1;

        for (int i = 0; i < s.length; i++) {

            int sum = 0;
            for (int j = i; j <= (m + i) - 1 && m + i < s.length; j++) {
                sum += s[j];
            }

            if (sum == d)
                segmentCount++;
        }

        System.out.println(segmentCount);
    }

    public static void main( String[] args ) {
        // solve();

        solveAgain();
    }

    //this is editorial answer
    private static void solveAgain() {

        int[] s = {1, 2, 1, 3, 2};
        int d, m, segmentCount = 0;

        m = 2; //pair will be of m length
        d = 3; //sum of pair should be d

        for (int i = 0; i < s.length; i++) {
            if (i + m - 1 < s.length) {
                int sum = 0;
                for (int j = i; j <= i + m - 1; j++) {
                    sum = sum + s[j];
                }
                if (sum == d) {
                    segmentCount++;
                }
            }
        }

        System.out.println(segmentCount);
    }

    //Most optimal solution : using sliding window technique
    /*
    int getWays(int n, int* squares, int d, int m){


    // Complete this function
    int sum[105];
    int count=0;
    sum[0]=0;
    for(int i=0;i<n;i++)sum[i+1]=sum[i]+squares[i];
    for(int i=0;i<=n-m;i++){
        if(sum[i+m]-sum[i]==d){
            count++;
        }
    }
    return count;
}
     */
}

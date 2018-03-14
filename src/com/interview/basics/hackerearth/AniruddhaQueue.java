package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/aniruddhas-queue-4/

public class AniruddhaQueue {

    public void solve() {
        FastReader r = new FastReader();

        int T = r.nextInt();

        int N, input[], lastNonZeroIndex = 0;
        long M, sum, remainder;

        for (int i = 0; i < T; i++) {
            N = r.nextInt();
            input = new int[N];
            sum = 0;

            for (int j = 0; j < N; j++) {
                input[j] = r.nextInt();
                if (input[j] > 0) {
                    sum += input[j];
                    lastNonZeroIndex = j + 1;
                }
            }

            M = r.nextLong();

            if (M != 0) {

                //this calc how many times the list need to iterate for given milestone
                remainder = M % sum;

                if (remainder > 0) {
                    for (int k = 0; k < N; k++) {
                        remainder -= input[k];
                        if (remainder < 1) {
                            System.out.println(k + 1);
                            break;
                        }
                    }
                } else {
                    System.out.println(lastNonZeroIndex);
                }
            } else {
                System.out.println("0");
            }
        }
    }

    public static void main( String[] args ) {
        AniruddhaQueue  aniruddhaQueue = new AniruddhaQueue();
        aniruddhaQueue.solve();
    }
}

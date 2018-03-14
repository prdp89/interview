package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;

public class BahubaliAndAusata {

    public void solve()
    {
        FastReader fastReader = new FastReader();
        int N = fastReader.nextInt();
        int Q = fastReader.nextInt();

        int array[] = fastReader.nextArray(N);
        int output[] = new int[Q];

        for(int i = 0; i< Q; i++)
        {
           int L = fastReader.nextInt();
           int R = fastReader.nextInt();

           int sum=0, temp = L;
           while (temp <= R)
           {
                sum += array[temp-1];
                temp++;
           }
           output[i] = sum/(R - L + 1);
        }

        for (int number : output) {
            System.out.println(number);
        }
    }

    //correct top solution
    public void solvePerfect()
    {
        FastReader in = new FastReader();

        int n = in.nextInt();
        int q = in.nextInt();
        long[] a = new long[n + 1];

        long[] cum = new long[n + 1];
        cum[0] = 0;

        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextInt();
            cum[i] = cum[i - 1] + a[i];
        }

        for (int i = 0; i < q; ++i) {
            int l = in.nextInt();
            int r = in.nextInt();
            long sum = cum[r] - cum[l] + a[l];
            System.out.println(sum / (r - l + 1));
        }
    }

    public static void main( String[] args ) {
        BahubaliAndAusata bahubaliAndAusata = new BahubaliAndAusata();
        //bahubaliAndAusata.solve();
        bahubaliAndAusata.solvePerfect();
    }
}

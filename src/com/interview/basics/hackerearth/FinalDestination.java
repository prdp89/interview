package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;

public class FinalDestination {

    public void solve() {
        FastReader fastReader = new FastReader();
        char[] input = fastReader.nextString().toCharArray();
        int i = 0, j = 0;

        for (int k = 0; k < input.length; k++) {
            if(input[k] == 'L' || input[k] == 'l')
                --i;
            else if(input[k] == 'R' || input[k] == 'r')
                ++i;
            else
                --j;
        }
        System.out.println(i + "" + j);
    }

    public static void main( String[] args ) {
        FinalDestination finalDestination = new FinalDestination();
        finalDestination.solve();
    }
}

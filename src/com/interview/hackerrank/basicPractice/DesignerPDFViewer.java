package com.interview.hackerrank.basicPractice;

public class DesignerPDFViewer {

    //https://www.hackerrank.com/challenges/designer-pdf-viewer/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
    private static void solve() {
        int[] h = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

        char[] word = "abc".toCharArray();

        int maxHeight = h[((int) word[0] % 97)];

        for (int i = 1; i < word.length; i++) {

            int height = h[((int) word[i] % 97)];

            if (height > maxHeight)
                maxHeight = height;
        }

        System.out.println(maxHeight * word.length);
    }

    public static void main( String[] args ) {
        solve();
    }
}

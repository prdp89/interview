package com.interview.hackerearth.augustcircuit2k18;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class StringProblem {

    //https://www.hackerearth.com/challenge/competitive/august-circuits-18/algorithm/string-4-d1093b86/
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        FastScan scanner = new FastScan();

        int n = scanner.nextInt();

        char[] arr = scanner.nextCharArray(n);

        if (arr.length == 0) {
            System.out.println(0);
            return;
        }

        int[] freqLower = new int[26];

        for (char c : arr) {

            int value = (int) c;
            if (value >= 97 && value <= 122)
                freqLower[c - 'a']++;
        }

        int maxFrequency = freqLower[0];

        for (int i = 1; i < freqLower.length; i++) {
            maxFrequency = Math.max(maxFrequency, freqLower[i]);
        }

        System.out.println(arr.length - maxFrequency);
    }

    static class FastScan {

        private final InputStream is = System.in;
        private final byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.is.read(this.buf);
                } catch (final IOException e) {
                    throw new InputMismatchException();
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }

        char[] nextCharArray( final int n ) {
            final char[] bf = new char[n];
            int b, p = 0;
            while (isSpaceChar(b = read())) {
            }
            while (p < n && !isSpaceChar(b)) {
                bf[p++] = (char) b;
                b = read();
            }
            return n == p ? bf : Arrays.copyOf(bf, p);
        }

        public int nextInt() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            boolean f = true;
            if (c == '-') {
                f = false;
                c = read();
            }
            int res = 0;
            do {
                /*if (c < '0' || c > '9') {
                    throw new InputMismatchException();
				}*/
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return f ? res : -res;
        }

        boolean isSpaceChar( final int c ) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}

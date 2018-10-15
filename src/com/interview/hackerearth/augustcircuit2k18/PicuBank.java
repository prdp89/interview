package com.interview.hackerearth.augustcircuit2k18;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class PicuBank {

    //https://www.hackerearth.com/challenge/competitive/august-circuits-18/algorithm/picu-bank-09e29493/
    public static void main( String[] args ) {

        solve();
    }

    private static void solve() {
        FastScan fastScan = new FastScan();

        int D = fastScan.nextInt();
        int A = fastScan.nextInt();
        int M = fastScan.nextInt();
        int B = fastScan.nextInt();
        int X = fastScan.nextInt();

        int i = 0;

        int firstTerm = (A + D) + (M - 1) * A;
        firstTerm += B;

        while (firstTerm < X) {

            firstTerm = firstTerm + M * A;
            firstTerm+=B;

            i += 5;
        }

        System.out.println(i+1);
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

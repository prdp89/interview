package com.interview.companies.fb;

import java.util.Random;

public class ReadNCharsGivenRead4Func {

    //https://leetcode.com/problems/read-n-characters-given-read4/

    /*
    The API: int read4(char *buf) reads 4 characters at a time from a file.
    The return value is the actual number of characters read.
    For example, it returns 3 if there is only 3 characters left in the file.

    By using the read4 API, implement the function int read(char *buf, int n) that reads n characters
    from the file.

    Note:
    The read function will only be called once for each test case.
     */
    public static void main( String[] args ) {
        char[] buf = new char[4];
        int n = 10;

        System.out.println(read(buf, n));
    }

    private static int read( char[] buf, int n ) {
        char[] buffer = new char[4];
        int readBytes = 0;
        boolean eof = false;

        while (!eof && readBytes < n) {

            //this return number of bytes read from file; max = 4, less than 4 if not present in file
            int sz = read4(buffer);

            if (sz < 4) eof = true;

            //return the min. character left to process..
            int bytes = Math.min(n - readBytes, sz);

            System.arraycopy(buffer, 0, buf, readBytes, bytes);

            readBytes += bytes;
        }

        return readBytes;
    }

    private static int read4( char[] buffer ) {
        int num = new Random().nextInt(4);

        for (int i = 0; i < Math.max(num, buffer.length); i++) {
            buffer[i] = 'a';
        }

        return num;
    }
}

package com.interview.basics;
//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/complete-the-syllabus/

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CompleteSyllabus {

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws IOException {

        Reader reader=new Reader();

        int t = reader.nextInt();
        while(t-->0){
            long k = reader.nextLong();
            long[] a = new long[7];
            long sum = 0;
            for(int i=0; i<7; i++){
                a[i] = reader.nextLong();
                sum+=a[i];
            }
            k%=sum;
            int i = 0;
            if(k==0){
                for(i=6; i>=0; i--){
                    if(a[i]!=0) break;
                }
            }

            while(k>0){
                k-=a[i];
                if(k<=0) break;
                i++;
                i%=7;
            }

            switch(i){
                case 0:
                    System.out.println("MONDAY");
                    break;
                case 1:
                    System.out.println("TUESDAY");
                    break;
                case 2:
                    System.out.println("WEDNESDAY");
                    break;
                case 3:
                    System.out.println("THURSDAY");
                    break;
                case 4:
                    System.out.println("FRIDAY");
                    break;
                case 5:
                    System.out.println("SATURDAY");
                    break;
                case 6:
                    System.out.println("SUNDAY");
                    break;
                default:
                    break;
            }
        }
    }

    private static String getWeekDay(int countOfDays) {
        switch (countOfDays)
        {
            case 1:
               return  "MONDAY";
            case 2:
                return  "TUESDAY";
            case 3:
                return  "WEDNESDAY";
            case 4:
                return  "THURSDAY";
            case 5:
                return  "FRIDAY";
            case 6:
                return  "SATURDAY";
            case 7:
                return  "SUNDAY";
            default:
                return "";
        }
    }
}

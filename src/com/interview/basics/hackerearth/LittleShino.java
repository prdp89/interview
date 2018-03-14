package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LittleShino {

    public void solveShinoProb()
    {
        FastReader reader = new FastReader();
        int numPlayers = reader.nextInt();

        int queries = reader.nextInt();

        int output[] = new int[numPlayers];
        int input [] = new int[numPlayers];

        List<Integer> outputIndices = IntStream.range(0, numPlayers).boxed().collect(Collectors.toList());

        //this use to fill the array of OutputIndices[]
        //IntStream.range(0, numPlayers).toArray();

        Arrays.fill(output, 1);
        if(numPlayers % 2 != 0 ){
            output[numPlayers-1] = 0;
        }

        //Arrays.setAll(outputIndices, i -> i);

        for (int i = 0; i < numPlayers ; i++) {
            int firstPlayer = reader.nextInt();
            input[i] = firstPlayer;
        }

        int length = (int)Math.ceil((output.length / (float)(output.length/2)));
        for (int i = 0; i < length ; i++) {

            for (int j = 0; j < outputIndices.size(); j+=2) {

                if(j+1 < outputIndices.size())
                {
                    if(input[outputIndices.get(j)] > input[outputIndices.get(j+1)])
                    {
                        output[outputIndices.get(j)]+=1;
                        outputIndices.set(j, outputIndices.get(j));
                        outputIndices.set(j+1, -1);
                    }
                    else
                    {
                        output[outputIndices.get(j+1)]+=1;
                        outputIndices.set(j, outputIndices.get(j+1));
                        outputIndices.set(j,-1);
                    }
                }
                else
                    outputIndices.set(j, outputIndices.get(j));
            }

            for(int k=0; k< outputIndices.size(); k++)
                if(outputIndices.get(k) == -1)
                {
                    outputIndices.remove(k);
                    --k;
                }
        }

        for (int i = 0; i < queries; i++) {
           System.out.println( output[reader.nextInt() - 1]);
        }
    }

    public static void main(String []args) throws IOException {
        InputReader in = new InputReader();
        LittleShino littleShino = new LittleShino();
        //littleShino.solveShinoProb();

        littleShino.solve();
    }

    //-----------------------Correct solution--------------------------------------

    final static class InputReader {
        InputStream in;
        protected byte[] buffer = new byte[8192];
        protected int offset = 0;
        protected int bufferSize = 0;

        public InputReader() {
            in = System.in;
        }

        public void close() throws IOException {
            in.close();
        }

        public int readInt() throws IOException {
            int number = 0;
            int s = 1;
            if (offset == bufferSize) {
                offset = 0;
                bufferSize = in.read(buffer);
            }
            if (bufferSize == -1)
                throw new IOException("No new bytes");
            for (; buffer[offset] < 0x30 || buffer[offset] == '-'; ++offset) {
                if (buffer[offset] == '-')
                    s = -1;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            for (; offset < bufferSize && buffer[offset] > 0x2f; ++offset) {
                number = (number << 3) + (number << 1) + buffer[offset] - 0x30;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            ++offset;
            return number * s;
        }

        public int[] readIntArray(int n) throws IOException {
            int[] ar = new int[n];
            for (int i = 0; i < n; i++)
                ar[i] = readInt();

            return ar;
        }
    }

    private void solve() throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader();
        int n = in.readInt(), q = in.readInt();
        int[] fighters = in.readIntArray(n);
        StringBuilder sb = new StringBuilder(q << 2);
        int[] fights = new int[n];
        boolean[] check = new boolean[n]; // active in tournament
        Arrays.fill(check, true);

        boolean active = true;
        while (active) {
            active = false;

            for (int i = 0; i < n; ) {
                while (i < n && !check[i])
                    i++;

                if (i == n)
                    break;

                int j = i + 1;
                while (j < n && !check[j])
                    j++;

                if (j == n)
                    break;

                active = true;
                fights[i]++;
                fights[j]++;
                if (fighters[i] > fighters[j]) {
                    check[j] = false;
                } else if (fighters[i] < fighters[j]) {
                    check[i] = false;
                }

                i = j + 1;
            }
        }

        while (q > 0) {
            q--;

            sb.append(fights[in.readInt() - 1]).append('\n');
        }

        out.print(sb);
    }


    //-----------------------------------------------------------------------------
}

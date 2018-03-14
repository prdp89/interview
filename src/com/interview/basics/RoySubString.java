package com.interview.basics;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/roy-and-counting-sorted-substrings-1/

public class RoySubString {

    public void generateRCombinations(char arr[], int n, int r, int index,
                                      int data[], int i) {
//        if(left == index)
//        {
//            for (int j=0; j<left; j++)
//                System.out.print(data[j]+" ");
//            System.out.println("");
//            return;
//        }
//        else
//        {
//            for(; left < right;)
//            {
//                data[index] = arr[left];
//                arr = swap(arr, left, right);
//
//                generateRCombinations(arr, left+1, right, data, index+1);
//                arr = swap(arr,left,right);
//            }
//        }


        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print((char)data[j] + " ");
            System.out.println("");
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return;

        // current is included, put next at next location

       if (index > 1 && data[index] < data[index - 1])
            data[index] = arr[i];
        generateRCombinations(arr, n, r, index + 1, data, i + 1);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        generateRCombinations(arr, n, r, index, data, i + 1);

    }

    public char[] swap(char[] a, int i, int j) {
        char temp;
        char[] charArray = a;
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return charArray;
    }

    public void solve() {
        FastReader reader = new FastReader();
        char[] input = reader.nextString().toCharArray();

        for (int r = 1; r < input.length; r++) {
            int data[] = new int[r];
            generateRCombinations(input, input.length, r, 0, data, 0);
        }
    }

    public void correctSolution()
    {
        FastReader reader = new FastReader();
        int T = reader.nextInt();
        for (int t = 0; t < T; t++) {
            reader.nextString();
            String s = reader.nextString();
            long count = 0;

            long curLen = 0;
            int prevChar = 'a' - 1;
            for (int i = 0; i < s.length(); i++) {
                char curChar = s.charAt(i);
                if (curChar >= prevChar) {
                    ++curLen;
                } else {
                    count += curLen * (curLen + 1) / 2;
                    curLen = 1;
                }
                prevChar = curChar;
            }

            count += curLen * (curLen + 1) / 2;
            System.out.println(count);
        }
    }

    public static void main(String args[]) {
        RoySubString roySubString = new RoySubString();
        //roySubString.solve();

        roySubString.correctSolution();
    }
}

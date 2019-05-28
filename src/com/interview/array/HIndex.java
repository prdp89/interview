package com.interview.array;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 * https://leetcode.com/problems/h-index/
 */

//H-index is the number of h papers, in which each paper has at least h citations.
//e.g. If there are 2 papers, and each of the 2 papers has at least 2 citations, the h-index is 2.

    //For better understanding read algo steps in below page.
//http://buttercola.blogspot.in/2015/09/leetcode-h-index.html


public class HIndex {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int c : citations) {

            //this condition checks if Paper published by researcher published more than once or not.

            // if cited more than once : then its index count will increase.
            // else : if cited paper is greater than length then we'll increase last index count

            if (c <= citations.length) {
                count[c]++;
            } else {
                count[citations.length]++;
            }
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            //we are trying to see if i is answer.
            //already everything before i has less than i citations.
            //so only thing to check is that p >= i where p is
            //total number of papers with i or more citations.
            int p = citations.length - sum + count[i];
            if (i <= p) {
                max = i;
            }
        }
        return max;
    }


    //explanation of H-Index : https://www.researchgate.net/post/How_to_calculate_h_index_for_an_author

    private int GetHIndex( int[] m )
    {
        int[] s = new int[m.length + 1];

        //this loop is similar to bucket sort.
        for (int i = 0; i < m.length; i++)
            s[Math.min(m.length, m[i])]++;

        int sum = 0;
        for (int i = s.length - 1; i >= 0; i--)
        {
            //this checks : How many total citations count are greater than 'i' element or not
            //or How many citations are qualify for H-index.

            sum += s[i];
            if (sum >= i)
                return i;
        }

        return 0;
    }

    public static void main(String args[]) {
        HIndex hi = new HIndex();

        int[] input = {4,8,1,1}; //{0, 1, 1, 1, 1, 6, 7 ,8};

        System.out.print(hi.hIndex(input));

      //  System.out.print(hi.GetHIndex(input));
    }
}

//0 1 2 6 6 6 6 7
//0 1 2 3 4 5 6 7
//0 1 1 1 3 6 7 8
//0 1 2 3 4 5 6 7

//0 1 2 5 6

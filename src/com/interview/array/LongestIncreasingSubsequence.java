package com.interview.array;

//https://www.youtube.com/watch?v=1RpMc3fv0y4

public class LongestIncreasingSubsequence {

    public static void LIS(int X[])
    {
        int parent[]= new int[X.length]; //Tracking the predecessors/parents of elements of each subsequence.

        int increasingSub[]= new int[X.length + 1]; //Tracking ends of each increasing subsequence.

        int length = 0; //Length of longest subsequence.

        for(int i=0; i<X.length; i++)
        {
            //Binary search
            int low = 1;
            int high = length;
            while(low <= high)
            {
                int mid = (int) Math.ceil((low + high)/2);

                //we are comparing with current ith value which helps to determine if
                //we need to append/replace value at current index.
                if(X[increasingSub[mid]] < X[i])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            int pos = low;

            //update parent/previous element for LIS

            //parent stores increasesub value which means : it store link to each increasing subsequence
            parent[i] = increasingSub[pos-1];

            //Replace or append

            //increasingSub: stores the index of replaced or append index element.

            increasingSub[pos] =  i;

            //Update the length of the longest subsequence.
            if(pos > length)
                length=pos;
        }

        //Generate LIS by traversing parent array
        int LIS[] = new int[length];

        //firstly we get last value from increasing sub sequence
        int k = increasingSub[length];

        //length means : final length of subsequence
        for(int j=length-1; j>=0; j--)
        {
            LIS[j] =  X[k];

            //parent[k] means: next index of linked element
            k = parent[k];
        }


        for(int i=0; i<length; i++)
        {
            System.out.println(LIS[i]);
        }


    }

    public static void main(String args[])
    {
        int X[] = {3,1,4,0}; //{3,1,5,0,6,4,9};
        LIS(X);
    }
}

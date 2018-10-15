package com.interview.hackerrank.InterviewPreprationKit;

public class MergeSortCountingInversions {

    //this code is similar to MergeSort in Week6Recursion -> codingBlocks except:
    //We are counting inversions count : https://www.hackerrank.com/challenges/ctci-merge-sort/problem
    //This video is helpful in starting :  https://www.youtube.com/watch?v=jAigdwcATNw
    private static long mergeSort( int[] a, int start, int end ) {


        //base case: if final array left with 1 or 0 elements then don't sort.
        if (start == end)
            return 0;

        long count = 0;

        //Follow 3 steps rule :

        //Step 1: Divide
        int mid = (start + end) / 2;

        //Step 2 : Recursively sort the two arrays: Ist array : s -- mid ; IInd array : mid + 1 -- end

        count += mergeSort(a, start, mid);  //counting left inversions (this is just count of stack calls to sort)
        count += mergeSort(a, mid + 1, end); //counting right inversions (this is just count of stack calls to sort)

        //Step 3 : Merge two arrays parts
        count += merge(a, start, end);

        return count;
    }

    public static void main( String[] args ) {

        // int a[] = {3, 11, 1, 0, 5, 2};
        int a[] = {2, 1, 3, 1, 2};

        long countOfInversions = mergeSort(a, 0, a.length - 1);

        System.out.println(countOfInversions);
    }

    //We merge array using two pointer rule. If first array element is less than second array; Copy Ist array element
    //into temp array and increment ist array pointer. To fill next element increment temp index too.

    //Refer this for split inversion and count : https://www.youtube.com/watch?v=PLkuid82dbc
    private static long merge( int[] a, int s, int e ) {

        int mid = (s + e) / 2;

        int i = s;
        int j = mid + 1;
        int k = 0; //to update temp array index

        long count = 0;

        int temp[] = new int[e - s + 1];

        while (i <= mid && j <= e) {

            if (a[i] > a[j]) { //split inversion only occur when a[i] < b[i]
                temp[k++] = a[j++];

                count += mid - i + 1; // Tricky part is this :
                // Count is Total number of elements remaining in ist array A[]
            } else
                temp[k++] = a[i++];
        }

        //if i doesn't reach to the mid
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        //if j doesn't reach to the end
        while (j <= e) {
            temp[k++] = a[j++];
        }

        //copy elements to the original array
        System.arraycopy(temp, 0, a, s, e - s + 1);

        return count;
    }
}

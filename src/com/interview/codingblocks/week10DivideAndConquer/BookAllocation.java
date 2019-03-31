package com.interview.codingblocks.week10DivideAndConquer;

public class BookAllocation {

    //https://www.geeksforgeeks.org/allocate-minimum-number-pages/
    //https://www.youtube.com/watch?v=Ss9ta1zmiZo

    public static void main( String[] args ) {

        int[] a = {12, 34, 67, 90};
        // System.out.println(minimumNumberOfPagesRecursive(a, a.length, 2)); //113 output

        System.out.println(minNumberOfPages(a, a.length, 2));
    }

    //this solution works in exponential time.
    //or it same as : https://www.geeksforgeeks.org/painters-partition-problem/
    private static int minimumNumberOfPagesRecursive( int[] pages, int N, int M ) {

        if (N == 1)
            return pages[0];

        if (M == 1)
            return sumOfPages(pages, 0, N - 1);

        int best = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            best = Math.min(best,
                    Math.max(minimumNumberOfPagesRecursive(pages, i, M - 1), sumOfPages(pages, i, N - 1)));
        }

        return best;
    }

    // same as : https://www.geeksforgeeks.org/painters-partition-problem-set-2/
    //Time complexity: O(N Log N)
    private static int minNumberOfPages( int[] pages, int N, int M ) {

        int lo = getMax(pages, N);
        int hi = sumOfPages(pages, 0, N - 1);

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            int requiredPainters = numberOfStudents(pages, N, mid);

            // find better optimum in lower half
            // here mid is included because we
            // may not get anything better
            if (requiredPainters <= M)
                hi = mid;

                // find better optimum in upper half
                // here mid is excluded because it gives
                // required Painters > k, which is invalid
            else
                lo = mid + 1;
        }

        // required
        return lo;
    }

    // find minimum required student for given maxlen
    // which is the maximum length of pages a student can read
    private static int numberOfStudents( int arr[], int n, int maxLen ) {
        int total = 0, numPainters = 1;

        for (int i = 0; i < n; i++) {
            total += arr[i];

            if (total > maxLen) {

                // for next count
                total = arr[i];
                numPainters++;
            }
        }
        return numPainters;
    }

    // return the maximum element from the array
    private static int getMax( int arr[], int n ) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];

        return max;
    }

    private static int sumOfPages( int[] pages, int from, int to ) {

        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += pages[i];
        }
        return sum;
    }
}
package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Scanner;

public class STRSUB {

    //https://www.codechef.com/MARCH15/problems/STRSUB#

    public static void main( String[] args ) {

        // bruteForce();
        //bruteForceImprovement();

        moreImprovement();

        //TODO: more improvement needed here.. learn more from :
        //https://discuss.codechef.com/t/strsub-editorial/10098
    }

    //This should be able to pass subtask 1, 2 and 3 in codechef
    private static void moreImprovement() {

         /*
        input:
        8 2 1
        01110000
        1 4
         */

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();

        String str = scanner.next();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Character.getNumericValue(str.charAt(i));

        int queryI = scanner.nextInt();
        int queryJ = scanner.nextInt();

        int ans = 0, j = queryI, count1 = 0, count0 = 0;

        int query[] = new int[queryJ - queryI + 1];
        for (int qu = 0; qu < queryJ - queryI + 1; qu++) {
            query[qu] = arr[queryI - 1 + qu];
        }

        if (query[j] == 1)
            count1++;
        else
            count0++;

        for (int i = 0; i < query.length; i++) {

            /*
            if S[i,j] is valid, then S[i+1,j] is also valid!. Therefore, when we process the next i
            , we don’t have to start j from i any more,
            because we already know many strings are valid from the previous i.
                  */
            while (j < queryJ && count0 <= k && count1 <= k) {

                j += 1;

                if (j >= queryJ)
                    break;

                if (query[j] == 1)
                    count1 += 1;
                else
                    count0 += 1;
            }

            //bcz at this point, we know S[i, j-1] is valid but S[i, j] is invalid
            ans += j - i;

            if (query[i] == 1)
                count1--;
            else
                count0--;
        }

        System.out.println(ans);
    }

    private static void bruteForceImprovement() {
        /*
        input:
        8 2 1
        0 1 1 1 0 0 0 0
        1 4
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        int ans = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int queryI = scanner.nextInt();
        int queryJ = scanner.nextInt();

        int query[] = new int[queryJ - queryI + 1];
        for (int qu = 0; qu < queryJ - queryI + 1; qu++) {
            query[qu] = arr[queryI - 1 + qu];
        }

        for (int i = 0; i < query.length; i++) { //starting point

            for (int j = i; j < Math.min(i + (2 * k - 1), query.length); j++) {
                // if query happening for [1, 4] and K = 2 at most 2 zero's or one's
                //then there must 2.K strings valid to verify

                int count1 = 0, count0 = 0;

                for (int l = i; l <= j; l++) { //to print group size

                    if (query[l] == 1)
                        count1++;

                    if (query[l] == 0)
                        count0++;

                    if (count0 > k || count1 > k)
                        break;

                    // System.out.print(query[l] + " - ");
                }
                // System.out.print("\n");

                if (count0 <= k && count1 <= k)
                    ans++;
            }
        }

        System.out.println(ans);
    }

    private static void bruteForce() {

        /*
        input:
        8 2 1
        0 1 1 1 0 0 0 0
        1 4
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        int ans = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int queryI = scanner.nextInt();
        int queryJ = scanner.nextInt();

        int query[] = new int[queryJ - queryI + 1];
        for (int qu = 0; qu < queryJ - queryI + 1; qu++) {
            query[qu] = arr[queryI - 1 + qu];
        }

        for (int i = 0; i < query.length; i++) { //starting point

            for (int j = i; j < query.length; j++) { //group size

                int count1 = 0, count0 = 0;

                for (int l = i; l <= j; l++) { //to print group size

                    if (query[l] == 1)
                        count1++;

                    if (query[l] == 0)
                        count0++;

                    // System.out.print(query[l] + " - ");
                }
                // System.out.print("\n");

                if (count0 <= k && count1 <= k)
                    ans++;
            }
        }

        System.out.println(ans);
    }
}

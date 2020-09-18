package com.interview.codechef.ccdsapfoundation_1.recursion;

import com.interview.basics.FastReader;

import java.util.LinkedList;

//https://www.codechef.com/problems/LFSTACK
public class LockFreeStack {

    public static void main( String[] args ) {
        try{
            FastReader sc = new FastReader();
            int t = sc.nextInt();

            while (t-- > 0) {

            /*2  n
            val1 = (2) {1 2}
            val2 = (2) {3 4}
            Total = val1 + val2 = { 4 3 2 1} 4 items*/

                int n = sc.nextInt();
                LinkedList<Integer> q[] = new LinkedList[n];
                int i;

                for (i = 0; i < n; i++) {
                    q[i] = new LinkedList();
                }

                int tot = 0;
                for (i = 0; i < n; i++) {
                    int val = sc.nextInt();

                    tot += val;

                    int j;
                    for (j = 0; j < val; j++) {
                        q[i].add(sc.nextInt());
                    }
                }

                int[] res = new int[tot];
                for (i = 0; i < tot; i++) {
                    res[i] = sc.nextInt();
                }

                if (rec(q, n, res, tot - 1) == 1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        } catch (Exception e)
        {
            return;
        }
    }

    private static int rec( LinkedList<Integer> q[], int n, int[] res, int last ) {
        if (last == 0) {
            return 1;
        }
        int i;
        for (i = 0; i < n; i++) {
            if (q[i].size() > 0 && q[i].get(0) == res[last]) {

                q[i].remove(0);

                //recur on remaining items
                if (rec(q, n, res, last - 1) == 1) {
                    return 1;
                }

                //if in any case next item of Linked-List doesn't matched, so reinserting the last removed item.
                q[i].add(0, res[last]);
            }
        }
        return 0;
    }

}

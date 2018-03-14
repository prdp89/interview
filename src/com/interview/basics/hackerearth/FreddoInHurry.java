package com.interview.basics.hackerearth;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/fredo-is-in-a-hurry/

import com.interview.basics.FastReader;

public class FreddoInHurry {

    public void solve()
    {
        final FastReader sc = new FastReader();
        int t = sc.nextInt();
        long n;
        while (t-- > 0) {
            System.out.println((n = sc.nextLong()) == 1 ? 1 : n - ((long) Math.sqrt(9 + (n << 3)) - 3 >> 1) << 1);
        }
    }

    public void solveMethodTwo()
    {
        final FastReader scn = new FastReader();
        int T = scn.nextInt();

        while (T-- > 0){
            int N = scn.nextInt();
            int time = 0;
            int fredo_current = 0;
            int lift_current = N;
            int lift_previous = -1;

            while(fredo_current<=lift_current){
                int temp = fredo_current+1;
                lift_previous = lift_current;
                lift_current-=temp;
                fredo_current++;
                time+=fredo_current;
            }

            time = time-fredo_current;
            lift_current=lift_previous;
            fredo_current--;

            int tem=lift_current-fredo_current;

            time+=tem;
            lift_current=fredo_current;
            time += N -lift_current;

            if(N==1)
                time=1;
            System.out.println(time);
        }
    }

    public static void main( String[] args ) {
        FreddoInHurry freddoInHurry = new FreddoInHurry();
        freddoInHurry.solveMethodTwo();
    }

}

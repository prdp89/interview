package com.interview.basics;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/bus-journey-3754c143/

public class BusJourney {

    public void solve() {
        FastReader reader = new FastReader();

        int numberOfStops = reader.nextInt();
        int numberOfSeats = reader.nextInt();
        int  calc = 0, standingCount = 0;
        int remain = numberOfSeats;
        for (int i = 0; i < numberOfStops - 1; i++) {

            int aIthPersonEnters = reader.nextInt();
            int aIthPersonLeft = reader.nextInt();
            calc = aIthPersonEnters-aIthPersonLeft;
            remain-=calc;

            if (remain<=0){
                standingCount++;
            }
/*
            if (i == 0)
                calc = numberOfSeats - (aIthPersonEnters - aIthPersonLeft);
            else
                calc = (calc - aIthPersonEnters) + aIthPersonLeft;

            if(calc == 0 || calc > numberOfSeats)
                standingCount++;*/
        }

        System.out.print(Math.abs(standingCount));
    }

    public static void main( String args[] ) {
        BusJourney busJourney = new BusJourney();
        busJourney.solve();
    }

    /*
    //best solution---------------------

    static class BusJourney {
        public void solve(int testNumber, InputReader sc, PrintWriter pw) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int i = 0; i < n - 1; i++) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            int curr = 0;
            int count = 0;
            int persons = 0;
            for (int i = 0; i < n - 1; i++) {
                persons = Math.max(0, persons - b[i]);
                persons += a[i];
                //pw.println(persons);
                if (persons >= m) count++;
            }
            pw.println(count);
        }

     */
}


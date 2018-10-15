package com.interview.hackerrank.basicPractice;

public class BeautifulDaysTheMovies {

    private static int sRev = 0;

    private static int reverseANumber( int n ) {
        if (n <= 0)
            return sRev;
        else {
            int rem = n % 10;
            sRev = sRev * 10 + rem;
            return reverseANumber(n / 10);
        }
    }

    //This doesn't require static variable, We are taking REV as paramater of function.
    /*int reverse(long int n, long int rev) {
        if(n == 0)
            return rev;
        return reverse(n / 10, rev * 10 + n % 10);
    }*/

    private static void solve() {
        int i = 20, j = 23, k = 6;

        int count = 0;
        for (int start = i; start <= j; start++) {

            if (Math.abs(start - reverseANumber(start)) % k == 0)
                count++;

            sRev = 0;
        }

        System.out.println(count);
    }

    public static void main( String[] args ) {
       /* reverseANumber(420);
        System.out.println(sRev);*/

       solve();
    }
}

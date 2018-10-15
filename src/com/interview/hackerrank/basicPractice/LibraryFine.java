package com.interview.hackerrank.basicPractice;

public class LibraryFine {

    //2 test case failing
    static void libraryFine( int d1, int m1, int y1, int d2, int m2, int y2 ) {

        if (d1 <= d2 && m1 <= m2 && y1 <= y2)
            System.out.println(0);
        else if (d1 > d2 && m1 <= m2 && y1 <= y2) //days fine
            System.out.println((d1 - d2) * 15);
        else if (d1 <= d2 && m1 >= m2 && y1 <= y2) //month fine
            System.out.println((m1 - m2) * 500);
        else if (d1 <= d2 && m1 <= m2 && y1 > y2) //year fine
            System.out.println(10000);
        else if (y1 > y2) {
            System.out.println(10000);
        } else if (m1 > m2) {
            System.out.println((m1 - m2) * 500);
        } else {
            System.out.println((d1 - d2) * 15);
        }
    }

    static int libraryFineOptimal( int d1, int m1, int y1, int d2, int m2, int y2 ) {

        if (y1 > y2)
            return 10000;

        if (y1 == y2) {
            if (m1 > m2)
                return (m1 - m2) * 500;
            if (m1 == m2 && d1 > d2)
                return (d1 - d2) * 15;
        }

        return 0;
    }


    public static void main( String[] args ) {

        libraryFine(9, 6, 2015,
                6, 6, 2015);
    }
}

package com.interview.javabasics;

public class FunctionalInterface {

    public static void main( String[] args ) {

        NormalInterface normal = new NormalInterface() {
            @Override
            public int add( int x, int y ) {
                return x + y;
            }

            @Override
            public int subtract( int x, int y ) {
                return x - y;
            }
        };

        System.out.println(normal.add(1, 1));

        FunctionalInter functionalInter = new FunctionalInter() {
            @Override
            public int add( int x, int y ) {
                return x + y;
            }
        };

        System.out.println(functionalInter.add(1, 1));
    }

    interface NormalInterface {
        int add( int x, int y );

        int subtract( int x, int y );
    }

    @java.lang.FunctionalInterface
    interface FunctionalInter {
        int add( int x, int y );

        //Multiple abtract method is not allowed in functional Interface
        //int subtract( int x, int y );
    }
}

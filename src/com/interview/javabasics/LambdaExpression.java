package com.interview.javabasics;

public class LambdaExpression {

    public static void main( String[] args ) {
        Dummy dummy = ( x ) -> System.out.println(2 * x);
        dummy.say(10);

        //Method - 2
        Dummy_2 dummy_2 = ( x, y ) -> x + y;
        LambdaExpression lambdaExpression = new LambdaExpression();

        System.out.println(lambdaExpression.operate(1, 2, dummy_2));
    }

    private int operate( int a, int b, Dummy_2 fobj ) {
        return fobj.say(a, b);
    }

    interface Dummy {
        void say( int x );
    }

    interface Dummy_2 {
        int say( int x, int y );
    }
}

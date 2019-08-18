package com.interview.codechef.ccdsap_2.leetcode.concurrency;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately {

    private Semaphore s = new Semaphore(0);

    //we can consider s2 a bowl that has 1 gems; so s2 is acquire first.
    private Semaphore s2 = new Semaphore(1); //has to be set to 1
    //bcz in PrintInOrder we have 3 functions that must call in sequence so release the first semaphore from first function.

    private int n;

    public PrintFooBarAlternately( int n ) {
        this.n = n;
    }

    //https://leetcode.com/problems/print-foobar-alternately/
    public static void main( String[] args ) {

    }

    public void foo( Runnable printFoo ) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            s2.acquire();

            printFoo.run();
            s.release();

        }
    }

    public void bar( Runnable printBar ) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            s.acquire();

            printBar.run();
            s2.release();

        }
    }

    //or method_2 : https://leetcode.com/problems/print-foobar-alternately/discuss/333996/JAVA-Boolean-Volatile-solution
}

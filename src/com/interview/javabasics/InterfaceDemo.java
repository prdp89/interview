package com.interview.javabasics;

public class InterfaceDemo {

    public static void main( String[] args ) {
        //works with same void type
        new DemoImpl().fun();

        new DemoImpl().hi();

        new Demo3() {

            @Override
            public void fun() {
                System.out.println("hello2");
            }
        }.fun();
    }

    interface Demo1 {
        void fun();

        default void hi() {
            System.out.println("A");
        }
    }

    interface Demo2 {
        void fun();

        //not work with boolean
        //boolean fun();

        default void hi() {
            System.out.println("B");
        }
    }

    interface Demo3 extends Demo1, Demo2 {
        default void hi() {

        }
    }

    static class DemoImpl implements Demo1, Demo2 {
        @Override
        public void fun() {
            System.out.println("hello");
        }

        @Override
        public void hi() {
            System.out.println("hi");
        }
    }
}

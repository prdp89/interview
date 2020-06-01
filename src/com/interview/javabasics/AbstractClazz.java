package com.interview.javabasics;

public class AbstractClazz {

    public static void main( String[] args ) {
        AbstractDemo impl = new AbstractImpl();
        impl.fun();
    }

    abstract static class AbstractDemo {

        AbstractDemo() {
            System.out.println("AbstractDemo");
        }

        abstract void fun();
    }

    static class AbstractImpl extends AbstractDemo {

        @Override
        void fun() {
            System.out.println("AbstractImpl");
        }
    }
}

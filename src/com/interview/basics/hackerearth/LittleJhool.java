package com.interview.basics.hackerearth;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/psychic-powers/

import com.interview.basics.FastReader;

public class LittleJhool {

    public void solve()
    {
        FastReader fastReader = new FastReader();
        String binString = fastReader.nextString();

        String a ="111111", b="000000";

        if(binString.length() < 6)
        {
            System.out.println("Good luck!");
            return;
        }

        if(binString.contains(a) || binString.contains(b))
        {
            System.out.println("Sorry, sorry!");
        }
        else{
            System.out.println("Good luck!");
        }
    }

    public static void main( String[] args ) {
        LittleJhool littleJhool = new LittleJhool();
        littleJhool.solve();
    }
}

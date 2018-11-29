package com.interview.hackerrank.recursion;

public class CountAbc {

    //https://codingbat.com/prob/p161124
    public static void main( String[] args ) {
        System.out.println(countAbc("abc"));
    }

    private static int countAbc(String str) {

        if(str.length() < 3)
            return 0;

        if((str.charAt(0) == 'a' && str.charAt(1) == 'b'
                && (str.charAt(2) == 'a' || str.charAt(2) == 'c'))){

            //return 1 + countAbc(str.substring(3)); //we can't do this bcz there may continuous pair as : "abcabc"
            return 1+ countAbc(str.substring(1)); //this count continuous pairs by incr. only by 1.
        }

        return countAbc(str.substring(1));
    }
}

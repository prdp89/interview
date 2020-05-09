package com.interview.leetcode.contests.contest176;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNums {

    //https://leetcode.com/contest/weekly-contest-176/problems/product-of-the-last-k-numbers/
    private List<Integer> list;
    private int totalProdct = 1;

    private ProductOfLastKNums() {
        list = new ArrayList<>();

        add(0);
    }

    public static void main( String[] args ) {
        ProductOfLastKNums productOfNumbers = new ProductOfLastKNums();

        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]

        System.out.println(productOfNumbers.getProduct(2));
    }

    public void add( int num ) {
        //if current num is zero then nums product before it will be zeros too..
        if (num == 0) {
            list = new ArrayList<>();
            totalProdct = 1;
            list.add(totalProdct);
        } else {
            totalProdct *= num; //this is like maintaining prefix product..
            list.add(totalProdct);
        }
    }

    //Runtime: 15 ms, faster than 50.88% of Java
    public int getProduct( int k ) {
        if (list.size() < k)
            return 0;

        //2,5,4 : 40
        int totalProdTillLast = list.get(list.size() - 1);

        //one corner case; bcz K query may be large too..
        if (list.size() - k - 1 < 0)
            return 0;

        //now we want product of last K elements
        int onePreviousOfK = list.get(list.size() - k - 1); //return: 2

        return totalProdTillLast / onePreviousOfK; // 40/2 : 20
    }

    //Returns TLE
    /*public int getProduct( int k ) {
        int res = 1;
        for (int i = stack.size() - 1; i >= stack.size() - k; i--) {
            res *= stack.get(i);
        }

        return res;
    }*/
}

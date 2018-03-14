package com.interview.basics;

public class ModularExponentiation {

    //  3^10 ⇒ (3^2) ^ 5 ⇒ 9 ^ 5
    //  9^5 ⇒ 9 * 9 ^ 4 ⇒ 9 * (9^2)^2 ⇒ 9 * (81^2) => 9 * 81 * 81 => 59049

    public int exponentiationIterativePower(int x,int n)
    {
        int result=1;
        while(n>0)
        {
            if(n % 2 ==1)
                result=result * x;
            x=x*x;
            n=n/2;
        }
        return result;
    }

    public int binaryExponentiation(int x,int n)
    {
        if(n==0)
            return 1;
        else if(n%2 == 0)        //n is even
            return binaryExponentiation(x*x,n/2);
        else                             //n is odd
            return x*binaryExponentiation(x*x,(n-1)/2);
    }


    public static void main(String args[]) {
        ModularExponentiation modularExponentiation =new ModularExponentiation();

//     System.out.println(modularExponentiation.exponentiationIterativePower(3, 10));

        System.out.println( modularExponentiation.binaryExponentiation(9, 4));
    }

}

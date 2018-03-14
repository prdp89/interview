package com.interview.basics;

public class RecursiveFunction {

    public int solve(int x , int y)
    {
        if(x == 0)
            return (y+1)%1000;
        else if(x > 0 && y == 0)
        {
            return solve(x-1, 1)%1000;
        }
        else
        {
            return solve(x-1, solve(x, y-1))%1000;
        }
    }

    public static void main(String args[])
    {
        RecursiveFunction recursiveFunction = new RecursiveFunction();
        FastReader reader = new FastReader();
        int result = recursiveFunction.solve(reader.nextInt(), reader.nextInt());
        if(result < 100)
        System.out.println("00"+result);
        else
            System.out.print(result);
    }
}

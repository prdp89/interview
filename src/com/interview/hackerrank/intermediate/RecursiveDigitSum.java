package com.interview.hackerrank.intermediate;

import java.util.Scanner;

public class RecursiveDigitSum {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.next(), scanner.nextInt()));
    }

    private static int solve( String n, int k ) {
        int sum = 0;
        while (k-- > 0) {
            sum += superDigit(n);
        }

        return superDigit(sum + "");
    }

    private static int superDigit( String string ) {

        int sum = 0;
        if (string.length() == 1)
            return Integer.parseInt(string);

        for (Character c : string.toCharArray()) {
            sum += Character.getNumericValue(c);
        }

        return superDigit(sum + "");
    }

    //optimal solution...
    /*
    static void Main(String[] args) {
        string[] inp = Console.ReadLine().Split(' ');
        string n = inp[0];
        int k = int.Parse(inp[1]);

        Console.WriteLine(super_digit(
                                (digit_sum(n)*k).ToString()));

    }

    static string super_digit(string ns){
        if(ns.Length==1)
            return ns;
        return super_digit(digit_sum(ns).ToString());
    }

    static long digit_sum(string ns){
        long sum=0;
        for(int i =0; i<ns.Length;i++){
            sum+=ns[i]-'0';
        }
        return sum;
    }
     */
}

package com.interview.basics;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//public class PrintHackerEarth {

   /* public void printHackerString() {
        Scanner sc = new Scanner(System.in);
        int arrayLength = Integer.parseInt(sc.nextLine());
        char[] arr = sc.nextLine().toCharArray();

        if (arr.length < 11 || arr.length != arrayLength) {
            System.out.println("0");
            System.exit(0);
        }

        int count = 0;
        StringBuilder temp = new StringBuilder("hackerearth");
        StringBuilder repeatedChar = new StringBuilder();

        count = countRepeatedChars(arr, temp, repeatedChar, count);

        if (count == 0)
            System.out.println("0");
        else
            System.out.println(count);

    }

    private int countRepeatedChars(char[] arr, StringBuilder temp, StringBuilder repeatedChar, int count) {
        for (char c : arr) {
            if ((temp + "").contains(c + ""))
                temp.deleteCharAt(temp.indexOf(c + ""));
            else
                repeatedChar.append(c);

            if (temp.length() == 0) {
                temp.append("hackerearth");
                ++count;
            }
        }

        if (repeatedChar.length() >= 11)
            countRepeatedChars(arr, temp, repeatedChar, count + 1);
        return count;
    }

    public static void main(String args[]) {
        PrintHackerEarth printHackerEarth = new PrintHackerEarth();
        printHackerEarth.printHackerString();
    }*/

    //-------------------Correct code-------------------

    class Hac {

      /*  *
         * @param args*/

        /*public static void main(StringProblem[] args) {
            // TODO Auto-generated method stub
            InputReader in=new InputReader(System.in);
            OutputWriter out=new OutputWriter (System.out);

            int n=in.readInt();
            StringProblem s=in.readString();
            int arr[]=new int[26];
            for(int i=0;i<n;i++){
                arr[s.charAt(i)-'a']++;
            }


            int min=Integer.MAX_VALUE;


            if(arr['h'-'a']/2<min){
                min=arr['h'-'a']/2;
            }
            if(arr['a'-'a']/2<min){
                min=arr['a'-'a']/2;
            }
            if(arr['c'-'a']<min){
                min=arr['c'-'a'];
            }
            if(arr['k'-'a']<min){
                min=arr['k'-'a'];
            }
            if(arr['e'-'a']/2<min){
                min=arr['e'-'a']/2;
            }
            if(arr['r'-'a']/2<min){
                min=arr['r'-'a']/2;
            }
            if(arr['t'-'a']<min){
                min=arr['t'-'a'];
            }

            out.printLine(min);
            out.close();

        }*/

    }

//-------------------------------------------------


package com.interview.basics;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/min-max-3/

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class MinMax {

    public void checkMinMaxListElements()
    {
        Scanner sc = new Scanner(System.in);
        int arrayLength = sc.nextInt();

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<arrayLength;i++){
            hashSet.add(sc.nextInt());
        }

        TreeSet treeSet = new TreeSet<Integer>();
        treeSet.addAll(hashSet);

        if(treeSet.size() < arrayLength || (int)treeSet.pollLast() - (int)treeSet.pollFirst() - 1  != treeSet.size() )
            System.out.println("NO");
        else
            System.out.println("YES");
    }

    public static void main(String args[]) {
        MinMax minMax =new MinMax();
        minMax.checkMinMaxListElements();
    }


    //----------------correct solution--------------------------

    /*public static void main(String[] args) throws IOException {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        int num=Integer.parseInt(bi.readLine());
        String[] strNums;

        strNums = bi.readLine().split("\\s");
        int[] n = new int[strNums.length];
        for(int i=0; i<strNums.length; i++) {
            n[i] = Integer.parseInt(strNums[i]);
        }

        int temp;
        for(int i=0; i < num; i++){
            for(int j=1; j < (num-i); j++){
                if(n[j-1] > n[j]){
                    temp = n[j-1];
                    n[j-1] = n[j];
                    n[j] = temp;
                }

            }
        }

        int start=n[0];
        for(int i=1;i<n.length;i++){
            if((start+1)==n[i]){
                start++;
                continue;
            }
            else if(start==n[i]){
                continue;
            }
            else{
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");

    }*/

    //----------------------------------------------------------
}

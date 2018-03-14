package com.interview.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class lifeuniverse {

    public void checkNumbers()
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (true)
        {
            int i = sc.nextInt();
            if(i != 42)
            {
                arr.add(i);
            }
            else
                break;;
        }

        for(int i =0 ; i< arr.size(); i++)
            System.out.println(arr.get(i));
       // Arrays.stream(arr.toArray()).forEach(num -> System.out.println(num));
    }

    public static void main(String args[])
    {
        lifeuniverse lifeuniverse = new lifeuniverse();
        lifeuniverse.checkNumbers();
    }
}

package com.interview.codechef.ccdsapfoundation_1.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FRGTNLNG {
    //https://www.codechef.com/problems/FRGTNLNG

    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();

                List<String> old = new ArrayList<>();
                while (n-- > 0) {
                    old.add(scanner.next());
                }

                HashMap<Integer, String> map = new HashMap<>();
                int key = 0;
                while (k-- > 0) {
                    int len = scanner.nextInt();
                    while (len-- > 0) {
                        map.put(key++, scanner.next());
                    }
                }

                map.forEach((key_1,value)-> System.out.println("Item : " + key_1 + " Count : " + value));

                for (int i = 0; i < old.size(); i++) {
                    if (map.containsValue(old.get(i)))
                        System.out.print(i+1 == old.size() ? "YES" : "YES ");
                    else
                        System.out.print(i+1 == old.size() ? "NO" : "NO ");
                }
            }
        } catch (Exception e) {
            return;
        }
    }
}

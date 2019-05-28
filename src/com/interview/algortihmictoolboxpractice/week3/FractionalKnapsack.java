package com.interview.algortihmictoolboxpractice.week3;

//view this video first.....................
//https://www.youtube.com/watch?v=_08myilrxq8

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    static double fractionalKnapsack( Item[] arr, int length, int maxKnapsackWeight ) {

        Arrays.sort(arr);
       //or // Arrays.sort(arr, ( a, b ) -> Integer.compare(b.value / b.weight, a.value / a.weight));

        int curWeight = 0;  // Current weight in knapsack
        double finalValue = 0.0; // Result (value in Knapsack)

        // Looping through all Items
        for (int i = 0; i < length; i++) {
            // If adding Item won't overflow, add it completely
            if (curWeight + arr[i].weight <= maxKnapsackWeight) {
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            }

            // If we can't add current Item, add fractional part of it
            else {
                int remainWeight = maxKnapsackWeight - curWeight;

                //arr[i].value * an item weight that is required to fill knapsack = actual value of item; means 2 * weight of an item
                finalValue += arr[i].value * ((double) remainWeight / arr[i].weight);
                break;
            }
        }

        // Returning final value
        return finalValue;
    }

    public static void main( String[] args ) {
        // int W = 50;   //    Weight of knapsack


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt(); //capacity of knapsack

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }

        // Item arr[] = new Item[]{new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        //Item arr[] = new Item[]{new Item(3,1), new Item(5,3), new Item(8,5), new Item(6,6), new Item(1,3), new Item(2,10)};

        System.out.println(fractionalKnapsack(items, items.length, capacity));
    }

    static class Item implements Comparable<Item> {
        int value, weight;

        // Constructor
        Item( int value, int weight ) {
            this.value = value;
            this.weight = weight;
        }

        //this helps to sort in descending order by Density = value/weight;
        @Override
        public int compareTo( Item b ) {
            double r1 = (double) this.value / this.weight;
            double r2 = (double) b.value / b.weight;
            if (r1 > r2)
                return -1;
            else if (r1 < r2)
                return 1;
            return 0;
        }
    }
}

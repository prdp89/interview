package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class STACKS {

    //https://www.codechef.com/problems/STACKS
    public static void main( String[] args ) {

        //bruteForce();
        solution();
    }

    private static void solution() {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {

                int n = scanner.nextInt();
                int[] arr = new int[n];

                int size = 0;
                int num;
                for (int i = 0; i < n; ++i) {

                    num = scanner.nextInt();
                    int idx = binarySearch(arr, num, size);

                    //if element is smaller then overriding the previous stored element
                    //This helps to generate top stack elements
                    arr[idx] = num;

                    //if previous value reach limit of array size.
                    if (idx == size)
                        ++size;
                }
                System.out.print(size + " ");

                for (int i = 0; i < size; ++i) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            return;
        }
    }

    public static int binarySearch( int[] arr, int value, int size ) {
        int low = 0;
        int high = size - 1;
        int mid;
        int ans = size;

        while (low <= high) {
            mid = (low + high) / 2;

            //little change in this part, bcz we need to search in left part for first occurrence
            /*if(arr[mid] == value){
                ans = mid;
                high = mid - 1;
            }
            else*/

            if (arr[mid] > value) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    //this result TLE 4.01 sec
    private static void bruteForce() {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                int[] arr = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = scanner.nextInt();

                //int avgStacks = n / 2;
                List<Stack<Integer>> stackList = new ArrayList<>();

                Stack<Integer> stack = new Stack<>();
                stack.push(arr[0]);

                stackList.add(stack);

                for (int i = 1; i < arr.length; i++) {

                    if (arr[i] > arr[i - 1] && !tryFitInStack(arr[i], stackList)) {
                        Stack<Integer> st = new Stack<Integer>();
                        st.push(arr[i]);
                        stackList.add(st);
                    } else {
                        tryFitInStack(arr[i], stackList);
                    }
                }

                System.out.print(stackList.size() + " ");

                for (Stack<Integer> stack1 : stackList) {
                    System.out.print(stack1.peek() + " ");
                }

                System.out.print("\n");

            }
        } catch (Exception e) {
            return;
        }
    }

    private static boolean tryFitInStack( int item, List<Stack<Integer>> stackList ) {
        for (Stack<Integer> s : stackList) {
            if (s.peek() > item) {
                s.push(item);
                return true;
            }
        }
        return false;
    }
}

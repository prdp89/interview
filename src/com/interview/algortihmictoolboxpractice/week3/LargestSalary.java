//package com.interview.algortihmictoolboxpractice.week3;

import java.util.*;

/*
As the last question of a successful interview, your boss gives you a few pieces of paper
with numbers on it and asks you to compose a largest number from these numbers.
The resulting number is going to be your salary, so you are very much interested in
maximizing this number. How can you do this?
 */

//reference : https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
public class LargestSalary {

    private static String largestNumberSingleDigit( ArrayList<Integer> digitList ) {
        StringBuilder result = new StringBuilder();

        Integer maxDigit;

        while (!digitList.isEmpty()) {

            maxDigit = Integer.MIN_VALUE;

            for (Integer digit : digitList) {
                if (digit > maxDigit)
                    maxDigit = digit;
            }
            result.append(maxDigit);

            digitList.remove(maxDigit);
        }
        return result.toString();
    }

    // The main function that prints the
    // arrangement with the largest value.
    // The function accepts a vector of strings
    static void printLargest( String[] arr ) {

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare( String X, String Y ) {
                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;


               double r1 = Double.parseDouble(XY);
               double r2 = Double.parseDouble(YX);

                if (r1 > r2)
                    return -1;
                else if (r1 < r2)
                    return 1;
                return 0;
            }
        });

        for (String str: arr) {
            System.out.print(str);
        }
    }

    public static void main( String[] args ) {
       /* Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        System.out.println(largestNumberSingleDigit((ArrayList<Integer>) a));*/

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        /*Vector<StringProblem> vector = new Vector<>();*/
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        printLargest(strings);
    }
}


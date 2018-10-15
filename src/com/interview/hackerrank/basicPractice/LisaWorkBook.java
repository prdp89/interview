package com.interview.hackerrank.basicPractice;

public class LisaWorkBook {

    //https://www.hackerrank.com/challenges/lisa-workbook/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        int k = 3;
        int[] arr = {4, 2, 6, 1, 10};

        int pageNum = 1, luckyIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            int quotuient = arr[i] / k;
            boolean isLucky = false;

            if (pageNum <= quotuient) {
                luckyIndex++;
                pageNum++;

                quotuient--;
                isLucky = true;
            }

            int remainingPages = arr[i] % k + quotuient;

            int remainingQuestions = arr[i];
            if (isLucky) {
                isLucky = false;
                remainingQuestions = arr[i] - k;
            }

            if (remainingPages == 1) {
                if (pageNum == (arr[i] - remainingQuestions) + 1)
                    luckyIndex++;
            }

            int l = 1;
            while (remainingPages > 1) {

                pageNum++;
                int totalQuestions = (remainingQuestions - k) * l;

                if (totalQuestions > 0)
                    totalQuestions = remainingQuestions;

                if (pageNum <= totalQuestions)
                    luckyIndex++;

                remainingPages--;
                l++;
            }
        }

        System.out.println(luckyIndex);
    }
}

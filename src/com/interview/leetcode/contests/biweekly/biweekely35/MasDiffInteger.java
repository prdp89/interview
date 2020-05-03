package com.interview.leetcode.contests.biweekly.biweekely35;

public class MasDiffInteger {

    public static void main( String[] args ) {
        int n = 123456;

        System.out.println(maxDiff(n));
    }

    //Runtime: 6 ms
    //Memory Usage: 36.6 MB
    private static int maxDiff( int num ) {
        char[] firstNum = (num + "").toCharArray();
        char found = ' ';
        boolean isFound = false;


        for (int i = 0; i < firstNum.length; i++) {
            if (firstNum[i] != '9') {
                found = firstNum[i];
                isFound = true;
                break;
            }
        }

        //creating max Number
        for (int i = 0; i < firstNum.length; i++) {
            if (isFound && firstNum[i] == found)
                firstNum[i] = '9';
        }

        //creating min num..
        char[] secondNum = (num + "").toCharArray();
        isFound = false;
        found = ' ';

        char changeToChar = ' ';

        if (secondNum[0] != '1') {
            found = secondNum[0];
            isFound = true;
            changeToChar = '1';
        } else {
            for (int i = 1; i < secondNum.length; i++) {

                //if 1 is present at zero'th index we can't change it to make it zero; num will be invalid
                //secondNum[i] != '0' : we cannot
                if (secondNum[i] != '1' && secondNum[i] != '0') {
                    found = secondNum[i];
                    isFound = true;
                    changeToChar = '0';
                    break;
                }
            }
        }

        for (int i = 0; i < secondNum.length; i++) {
            if (isFound && secondNum[i] == found)
                secondNum[i] = changeToChar;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        //converting to number..
        for (int i = 0; i < secondNum.length; i++) {
            sb1.append(firstNum[i]);
            sb2.append(secondNum[i]);
        }

        return Integer.parseInt(sb1.toString()) - Integer.parseInt(sb2.toString());
    }
}

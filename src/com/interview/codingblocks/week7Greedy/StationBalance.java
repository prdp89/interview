package com.interview.codingblocks.week7Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class StationBalance {

    //Sample input :
    //3 5
    //51 19 27 14 33
    //Sample output :
    //6.00000

    //Sample input 2:
    //2 3
    //6 3 8
    //Sample output 2:
    //1.00000
    public static void main( String[] args ) {
        solve();
    }

    //Our task is to balance the specimen in each number of chamber such that:
    // Average weight of all given chambers(may be 2 or 3) - each chamber weight is minimum.
    // Finally sum all the average - each chamber weight.

    // Input : 3 5
    //        51 19 27 14 33

    //we have to divide 5 items in 3 chambers such that each chamber has almost equal weight :

    // Chamber 1 : 14 33  |  Chamber 2 : 27 19 | Chamber 3 : 51
    // chamber1 weight : 47 | chamber2 weight : 46 | Chamber3 weight : 51
    // Average weight of all chamber is : (47 + 46 + 51) / 3 = 48
    // 48 - 47(CW1) + 48 - 46(CW2)  + ABS(48 - 51)(CW3) = 1 + 2 + 3 = 6 = output

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int numOfChambers = scanner.nextInt();
        int numOfSpecimen = scanner.nextInt();

        int chambers[] = new int[numOfChambers];
        int arr[] = new int[numOfSpecimen];

        for (int i = 0; i < numOfSpecimen; i++) {

            int specimenWeight = scanner.nextInt();
            arr[i] = specimenWeight;
        }

        //Now our task is to balance specimen weight acc to chambers
        //So we first sort the specimen weight, then to balance the specimen :
        //assign last specimen to first -> seconlast to second and so on..
        Arrays.sort(arr);

        //But, what if number of specimens are odd, so to match the last to first we have add 0 at start.
        int numOfZeros = 2 * numOfChambers - numOfSpecimen;

        int[] arrNew = new int[numOfSpecimen + numOfZeros];
        for (int i = numOfZeros; i < arrNew.length; i++) {
            arrNew[i] = arr[i - numOfZeros];
        }
        //--------------or--------------------------------
        // System.arraycopy(arr, numOfZeros, arrNew, numOfZeros, numOfSpecimen - numOfZeros);

        //assigning values to each chamber by picking : First & Last -> Second & Second Last.....
        int sumOfChambers = 0;
        for (int i = 0; i < arrNew.length; i++) {
            if (i >= chambers.length)
                break;

            chambers[i] = arrNew[i] + arrNew[arrNew.length - i - 1];
            sumOfChambers += chambers[i];
        }

        //Now calculate the average of 3 chambers.
        float averageWeightOfChambers = (float) sumOfChambers / numOfChambers;

        //Now Apply formula : Summation of (  | chamber[i] - averageWeightOfChambers |)

        float balanceSum = 0;
        for (int i = 0; i < numOfChambers; i++) {

            balanceSum = balanceSum + Math.abs(chambers[i] - averageWeightOfChambers);
        }

        System.out.println(balanceSum);
    }
}

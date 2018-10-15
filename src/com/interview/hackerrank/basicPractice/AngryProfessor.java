package com.interview.hackerrank.basicPractice;

public class AngryProfessor {

    //https://www.hackerrank.com/challenges/angry-professor/
    private static void solve(){
        int k = 2, presentStudents = 0;
        int[] a = {0, -1, 2, 1};

        for (int anA : a) {

            if (anA <= 0) {
                presentStudents++;
            }
        }

        if(presentStudents < k)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void main( String[] args ) {
        solve();
    }
}

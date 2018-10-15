package com.interview.hackerrank.InterviewPreprationKit;

public class MakingAnagrams {

    //https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        //StringProblem a = "showman", b = "woman";
        String a = "cde", b = "abc";

        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();

        int countStrA[] = new int[256];
        int countStrB[] = new int[256];

        for (char aStrA : strA) {
            countStrA[aStrA]++;
        }

        for (char aStrB : strB) {
            countStrB[aStrB]++;
        }

        int sum = 0;
        for (int i = 0; i < 256; i++) {
            if (countStrA[i] != countStrB[i]) {
                sum += Math.abs(countStrA[i] - countStrB[i]);
            }
        }

        System.out.println(sum);
    }

    /*
    //This is optimal bcz of using only one Frequency array
    public static int numberNeeded(StringProblem first, StringProblem second) {
		int[] lettercounts = new int[26];
		for(char c : first.toCharArray()){
			lettercounts[c-'a']++;
		}
		for(char c : second.toCharArray()){
			lettercounts[c-'a']--;
		}
		int result = 0;
		for(int i : lettercounts){
			result += Math.abs(i);
		}
		return result;
	}

     */
}

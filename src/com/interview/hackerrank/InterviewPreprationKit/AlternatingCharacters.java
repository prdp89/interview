package com.interview.hackerrank.InterviewPreprationKit;

public class AlternatingCharacters {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        //String s = "ABABABAB";
        //String s = "BABABA";
        // String s = "AAABBB";
        String s = "ABBABBAA";

        StringBuilder stringBuilder = new StringBuilder(s);

        char c;
        int total = 0;
        for (int i = 0; stringBuilder.length() > 1 && i + 1 < stringBuilder.length(); ) {

            c = stringBuilder.charAt(i + 1);

            if (stringBuilder.charAt(i) == c) {
                stringBuilder.deleteCharAt(i);
                total++;
            } else
                i++;
        }

        System.out.println(total);
    }

    /*

    static int alternatingCharacters(string s){
	int count = 0;
    for(int i = 0; i < s.Length - 1; i++) {
    	if(s[i] == s[i + 1])
        	count++;
    }

	return count;
    }

     */
}

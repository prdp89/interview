package com.interview.hackerrank.basicPractice;

import java.util.*;

public class VideoConference {

    public static void main( String[] args ) {
        solve();
    }

    //https://www.youtube.com/watch?v=uOG3QyxIjso&feature=youtu.be
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        String[] names = new String[N];
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            names[i] = scanner.next();
        }

        //stores all substring of name {e.g SAM = s, sa, sam}
        HashSet<String> subString = new HashSet<>();

        //stores repeated names count
        HashMap<String, Integer> nameRepeat = new HashMap<>();

        //stores the final output list
        List<String> list = new ArrayList<>();

        for (String name : names) {

            //if same name repeats; put name 1 , name 2 etc.
            if (nameRepeat.containsKey(name)) {
                int n = nameRepeat.get(name);
                nameRepeat.put(name, n + 1);

                //add repeated name in ouput list too..
                list.add(name + " " + Integer.toString(n + 1));
            } else {

                //otherwise name repeat only once
                nameRepeat.put(name, 1);

                StringBuilder t = new StringBuilder();

                //flag to check if element inserted
                boolean isInserted = false;

                for (char c : name.toCharArray()) {

                    t.append(c);

                    if (!isInserted && !subString.contains(t.toString())) {

                        //true to insert only once in output list
                        isInserted = true;

                        list.add(t.toString());
                    }
                    subString.add(t.toString());
                }

                //if no element inserted
                if (!isInserted)
                    list.add(t.toString());
            }
        }

        for (String str : list) {
            System.out.println(str);
        }
    }

}
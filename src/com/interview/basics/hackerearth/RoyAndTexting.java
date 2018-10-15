package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;
import java.util.HashMap;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/roy-and-texting-robot-2/

public class RoyAndTexting {

    public void solve() {
        FastReader fastReader = new FastReader();
        int testCases = fastReader.nextInt();

        char[][] wordsArray = {
                {'_'},
                {'.',',','?','!'},
                {'a','b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        HashMap<Integer, char[]> hashMap = new HashMap<>();
        for(int i=0; i < 10; i++)
        {
            hashMap.put(i, wordsArray[i]);
        }

        /*for (Map.Entry<Integer, char[]> entry : hashMap.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + Arrays.toString(entry.getValue()));
        }*/

        while (testCases-- > 0) {
            String input = fastReader.nextString();
        }
    }

    //solve using recursive approach
  /*  StringProblem[] cellPhoneButton = {"_0",".,?!1","abc2","def3","ghi4","jkl5","mno6","pqrs7","tuv8","wxyz9"};
    int noOfTestCases;
		if(int.TryParse(Console.ReadLine(),out noOfTestCases)) {
        StringProblem[] testcases = new StringProblem[noOfTestCases];
        for(int i=0;i<noOfTestCases;i++)
        {
            testcases[i] = Console.ReadLine() ;
        }
        foreach(StringProblem testcase in testcases)
        {
            int pointer = 1;
            int val=0;
            foreach(char c in testcase) {
            //	Console.WriteLine(cellPhoneButton[2].IndexOf(c));
            for(int i=0;i<10;i++)
            {
                if(cellPhoneButton[i].IndexOf(c)!=-1) {
                    if(i==pointer) {
                        val = val + cellPhoneButton[i].IndexOf(c)+1 ;
                    }
                    else {
                        val = val + cellPhoneButton[i].IndexOf(c)+2 ;
                        pointer = i;
                    }
                }
            }
        }
            Console.WriteLine(val);
        }
    }*/

    public void solveReAttempt()
    {
        String input;
        int time;

        FastReader fastReader = new FastReader();
        int T = fastReader.nextInt();

        for(int i = 0; i < T; i++){
            input = fastReader.nextString();
            time = 0;
            prevRow = 0;
            prevCol = 0;
            for(int j = 0; j < input.length(); j++){
                time += pressTime(input.charAt(j));
            }
            System.out.print(time);
        }
    }

    static int pressTime(char c){
        int index, moveTime;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                index = pad[i][j].indexOf(c);
                if(index != -1){
                    moveTime = (prevRow == i && prevCol == j) ? 0 : 1;
                    prevRow = i;
                    prevCol = j;
                    return index + moveTime + 1;
                }
            }
        }
        return 0;
    }

    static String[][] pad = {{".,?!1", "abc2", "def3"}, {"ghi4", "jkl5", "mno6"}, {"pqrs7", "tuv8", "wxyz9"}, {"", "_0", ""}};
    static int prevRow, prevCol;

    public static void main( String[] args ) {
        RoyAndTexting royAndTexting = new RoyAndTexting();
        royAndTexting.solveReAttempt();
    }
}

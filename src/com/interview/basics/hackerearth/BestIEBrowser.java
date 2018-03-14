package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;

public class BestIEBrowser {

    public void solve()
    {
        FastReader fastReader = new FastReader();
        int T = fastReader.nextInt();

        while (T-- > 0)
        {
            char [] input = fastReader.nextLine().toCharArray();
            int count = 0;
            for (int i =4; i < input.length; i++) {

                if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u' ||
                        input[i] == 'A' || input[i] == 'E' || input[i] == 'I' || input[i] == 'O' || input[i] == 'U');
                  else  count++;
            }
            System.out.println(count + 1 + "/" + input.length);
        }

        System.out.println(Math.sqrt(-4));
    }

    public static void main( String[] args ) {
        BestIEBrowser bestIEBrowser = new BestIEBrowser();
        bestIEBrowser.solve();
    }
}

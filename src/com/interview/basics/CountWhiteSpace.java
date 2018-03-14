package com.interview.basics;

public class CountWhiteSpace {

    public void solve()
    {
        FastReader reader = new FastReader();
        char [] s = reader.nextString().toCharArray();
        int length = s.length;

        int count=0;

        while (length -- > 0)
        {
            if(s[length] == ' ')
                count++;
        }

        String a;
        
        System.out.print(count);
    }

    public static void main(String arg[])
    {
        CountWhiteSpace countWhiteSpace = new CountWhiteSpace();
        countWhiteSpace.solve();
    }
}

package com.interview.basics.hackerearth;


import com.interview.basics.FastReader;

//https://www.hackerearth.com/challenge/competitive/january-circuits-18/algorithm/congruence-relation-ddd2b5cc/
public class CongruenceRelation {

    public void solve() {
        try
        {
            FastReader reader = new FastReader();

            long number = reader.nextInt(), totalPairs = 0;
            long divisor = reader.nextInt();

          //  HashMap<Long, Long> remainders = new HashMap<>();

          /*  while (number >= 1) {
                remainders.put(number-1 , number % divisor);
                --number;
            }*/

            String remaindersString = "";
            while (number >= 1)
            {
                remaindersString += number % divisor;
                --number;
            }

            char [] remainderArrayString = remaindersString.toCharArray();
            for (int i=0; i < remainderArrayString.length; i++)
            {
                for (int j = i+1; j< remainderArrayString.length; j++)
                    if (remainderArrayString[i] == remainderArrayString[j])
                        totalPairs++;
            }

             System.out.println(totalPairs);
        }
        catch (Exception e)
        { }
    }

    public void solveAttemptTwo()
    {
        FastReader reader = new FastReader();

        int number = reader.nextInt();
        int divisor = reader.nextInt();

        int evenRemainders = ((number-1) / divisor) + 1;
        int oddRemainders = number / divisor;

        //factorial method
        //System.out.println(getFact(evenRemainders)/(getFact(evenRemainders - 2)*2) + getFact(oddRemainders)/(getFact(oddRemainders - 2)*2));

        //(n*(n-1))/2
        //System.out.println(((evenRemainders * (evenRemainders -1))/2)  + ((oddRemainders * (oddRemainders -1))/2));
    }

    /*public static long getFact(int n)
    {
        long f=1;

        for(int i=n;i>=1;i--)
        {
            f*=i;
        }

        return f;
    }*/

    public static void main( String[] args ) {
        CongruenceRelation congruenceRelation = new CongruenceRelation();
        //congruenceRelation.solve();
        congruenceRelation.solveAttemptTwo();
    }
}

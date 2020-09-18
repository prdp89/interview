package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

public class AvoidRoads {

    //https://community.topcoder.com/stat?c=problem_statement&pm=1889
    public static void main( String[] args ) {
    }

    /*
    Description:

    Each path must use exactly width+heightONOde blocks implies that you can only go to right or up(try to prove this).

    Now it seems like a standard DP. Let's denote by DP(i, j) number of ways to reach point (i, j).

    Now, this will be addition of two cases:

    DP(i, j) =
     //if block (i,j, i-1, j) is not blocked
     DP(i-1, j) +

     //if block (i,j, i, j-1) is not blocked
     DP(i, j-1)
     */

    //C# code to solve the problem......................................
    /*
    public long numWays(int X, int Y, string[] bad) {

    long[,] res = new long[X+1,Y+1];
    int N=bad.Length;
    int[,] b = new int[N,4];
    for (int i=0; i<N; i++)
     {
     string[] ss = bad[i].Split();
     b[i,0] = Convert.ToInt32(ss[0]);
     b[i,1] = Convert.ToInt32(ss[1]);
     b[i,2] = Convert.ToInt32(ss[2]);
     b[i,3] = Convert.ToInt32(ss[3]);
     }

    for (int y=Y; y>=0; y--)
    for (int x=X; x>=0; x--)
     if (x==X&&y==Y) res[x,y]=1;
     else
      {
      if (x<X && OK(x,y,x+1,y,N,b)) res[x,y] += res[x+1,y];
      if (y<Y && OK(x,y,x,y+1,N,b)) res[x,y] += res[x,y+1];
      }

    return res[0,0];
    }

    bool OK(int x, int y, int a, int b, int N, int[,] B)
    {
    for (int i=0; i<N; i++)
     {
     if (x==B[i,0] && y==B[i,1] && a==B[i,2] && b==B[i,3]) return false;
     if (a==B[i,0] && b==B[i,1] && x==B[i,2] && y==B[i,3]) return false;
     }
    return true;
    }
     */
}
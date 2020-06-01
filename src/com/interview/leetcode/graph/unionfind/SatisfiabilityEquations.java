package com.interview.leetcode.graph.unionfind;

public class SatisfiabilityEquations {

    //https://leetcode.com/problems/satisfiability-of-equality-equations/
    public static void main( String[] args ) {
        String[] equations = {"a==b", "b!=a"};
        System.out.println(equationsPossible(equations));
    }

    //Runtime: 0 ms, faster than 100.00% of Java
    //little clue: https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/234486/JavaC%2B%2BPython-Easy-Union-Find
    //video for clubbing equation:https://www.youtube.com/watch?v=aJYISj0n1so&feature=youtu.be
    private static boolean equationsPossible( String[] equations ) {
        //there are 26 chars, total graph nodes will be 26 only
        int[] rank = new int[26];

        for (int i = 0; i < rank.length; i++)
            rank[i] = i;

        //Consider equation given = { 'a==b', 'b==c', 'g != c', 'b == g' }
        //so we are clubbing the equation acc. to group as : {a,b,c} and {g}

        //First, we will group equation acc. to equality and create disjoint set out of it.
        for (String equation : equations) {

            if (equation.charAt(1) == '=') {

                //now we will group {a,b,c} to a disjoint set
                if (findParent(equation.charAt(0) - 'a', rank) != findParent(equation.charAt(equation.length() - 1) - 'a', rank)) {
                    union(equation.charAt(0) - 'a', equation.charAt(equation.length() - 1) - 'a', rank);
                }
            }
        }

        //Second, we'll find contradictory equation such as {'g != c'}
        //see above {a,b,c,g} now in same group, bcz {b== g}
        //if we are saying {'g != c'} then this is incorrect; return false
        for (String equation : equations) {

            if (equation.charAt(1) == '!') {

                //now we are finding any contradictory statement; {'g != c'}
                //again disjoint set will help in finding the same patent or group

                if (findParent(equation.charAt(0) - 'a', rank) == findParent(equation.charAt(equation.length() - 1) - 'a', rank)) {
                    return false;
                }
            }
        }

        return true;
    }

    //rank (b) = a; where {b,a} => findParent(,)
    private static void union( int a, int b, int[] rank ) {
        rank[findParent(b, rank)] = findParent(a, rank);
    }

    private static int findParent( int p, int[] rank ) {
        if (p != rank[p]) {
            rank[p] = findParent(rank[p], rank);
        }

        return rank[p];
    }
}

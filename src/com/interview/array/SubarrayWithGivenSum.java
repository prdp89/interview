package com.interview.array;

/**
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */
public class SubarrayWithGivenSum {

    class Pair{
        int start;
        int end;
        
        public String toString(){
            return start + " " + end;
        }
    }

    //just a thought about sliding window tech https://www.geeksforgeeks.org/window-sliding-technique/
    //We can calc. sum of First K element upto we get SUM or less than sum.
    //While start loop from kth element and ignore from start if windows sum exceeds.


    public Pair findSubArray(int input[],int sum){
        int currentSum = 0;
        Pair p = new Pair();
        p.start = 0;
        for(int i=0; i < input.length; i++){

            currentSum += input[i];
            p.end = i;

            if(currentSum == sum){
                return p;
            }
            else if(currentSum > sum){  //if current sum greater than required then decrement the currentSum.
                int s = p.start;

                while(currentSum  > sum){
                    currentSum -= input[s];
                    s++;
                }

                //set start to the new calculated index after decrementing currentSum
                p.start = s;

                //if currentSum equals to required sum then return P object
                if(currentSum == sum){
                    return p;
                }
            }
        }
        return null;
    }
    
    public static void main(String args[]){
        SubarrayWithGivenSum sgs = new SubarrayWithGivenSum();
        int input[] = {6,3,9,11,1,3,5};
        System.out.println(sgs.findSubArray(input,15));
    }
}

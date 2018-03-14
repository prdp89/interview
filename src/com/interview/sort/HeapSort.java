package com.interview.sort;

/**
 * Date 04/03/2015
 * @author tusroy
 * 
 * Heap Sort
 * Given an array sort it using heap sort
 * 
 * Solution :
 * First convert the original array to create the heap out of the array
 * Then move the max element to last position and do heapify to recreate the heap
 * with rest of the array element. Repeat this process
 * 
 * Time complexity
 * O(nlogn)
 * 
 * Test cases
 * Null array
 * 1 element array
 * 2 element array
 * sorted array
 * reverse sorted array
 */
public class HeapSort {

    public void sort(int arr[]){
        for(int i=1; i < arr.length; i++){
            heapAdd(arr, i);
        }
        
        for(int i = arr.length-1; i > 0 ; i--){
            swap(arr, 0, i);
           // heapify(arr, i-1);
            min_heapify(arr, i, arr.length-1);
        }
    }
    
    private void heapify(int arr[], int end){
        int i = 0;
        int leftIndex;
        int rightIndex;
        while(i <= end){
            leftIndex = 2*i + 1;
            if(leftIndex > end){
                break;
            }
            rightIndex = 2*i + 2;
            if(rightIndex > end){
                rightIndex = leftIndex;
            }
            if(arr[i]  >= Math.max(arr[leftIndex], arr[rightIndex])){
                break;
            }
            if(arr[leftIndex] >= arr[rightIndex]){
                swap(arr, i, leftIndex);
                i = leftIndex;
            }else{
                swap(arr, i, rightIndex);
                i = rightIndex;
            }
        }
    }
    
    private void swap(int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    private void heapAdd(int arr[], int end){
        int i = end;
        while(i > 0){
            if(arr[i] > arr[(i-1)/2]){
                swap(arr, i, (i-1)/2);
                i = (i - 1)/2;
            }else{
                break;
            }
        }
    }

    void build_minheap (int Arr[ ])
    {
        for( int i = (Arr.length-1)/2 ; i >= 1 ; i--)
            min_heapify (Arr, i, (Arr.length-1));
    }

    void min_heapify (int Arr[ ] , int i, int N)
    {
        try
        {
            int left  = 2*i;
            int right = 2*i+1;
            int smallest;
            if(left <= N && Arr[left] < Arr[ i ] )
                smallest = left;
            else
                smallest = i;
            if(right <= N && Arr[right] < Arr[smallest] )
                smallest = right;
            if(smallest != i)
            {
                swap (Arr , Arr[ i ], Arr[ smallest ]);
                min_heapify (Arr, smallest,N);
            }
        }
        catch (Exception e)
        {}

    }
    
    public static void main(String args[]){
        HeapSort hs = new HeapSort();
        int arr[] = {-1,5,8,2,-6,-8,11,5};
//        hs.sort(arr);

        hs.build_minheap(arr);
        for(int a : arr){
            System.out.println(a);
        }
    }
}

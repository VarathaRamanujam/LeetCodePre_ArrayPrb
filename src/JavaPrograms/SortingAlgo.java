package JavaPrograms;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingAlgo {
    public static void main(String[] args) {
        int[] arr = {3,2,4,9,8,1,0};

        //bubbleSort(arr);
        //bubbleSortUsingRec(arr, arr.length-1, 0);

        //selectionSort(arr);
        selectionSortUsingRec(arr, arr.length-1,1, 0);

        //insertionSort(arr);
        //insertionSortUsingRec(arr, 1);

        //mergeSort(arr, 0, arr.length-1);//Using a recurssion

        //quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSortUsingRec(int[] arr, int n) {
        if(n == arr.length-1) return;
        for (int i=n;i>0;i--){
            if (arr[i] <  arr[i-1]) swapTheIndex(arr, i, i-1);
        }
        insertionSortUsingRec(arr, n+1);
    }

    private static void selectionSortUsingRec(int[] arr, int row, int col, int max) {
        if (row==0) return;
        //int lastIn = row;
        //int max = findMaxIndex(arr, 0, lastIn);
        //swapTheIndex(arr, lastIn, max);
       // selectionSortUsingRec(arr, n-1);
        if(row >= col){
            if (arr[max] < arr[col]) max = col;//swapTheIndex(arr, max, col);
            selectionSortUsingRec(arr, row, col+1, max);
        }else {
            swapTheIndex(arr, max, row);
            selectionSortUsingRec(arr, row-1, 1, 0);
        }
    }

    private static void bubbleSortUsingRec(int[] arr, int row, int col) {
        if(row==0) return;
       if(row>col){
           if(arr[col] > arr[row]) swapTheIndex(arr,row, col);
           bubbleSortUsingRec(arr, row, col+1);
       } else {
           bubbleSortUsingRec(arr, row - 1, 0);
       }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pivot = findThePivot(arr, low, high);
              quickSort(arr, low, pivot-1);
              quickSort(arr, pivot+1, high);
        }
    }

    private static int findThePivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i=low; int j=high;
        while (i<j){
            while (arr[i] <= pivot && i<=high-1)i++;
            while (arr[j] > pivot && j>=low+1)j--;
            if(i<j) swapTheIndex(arr, i, j);
        }
        swapTheIndex(arr, low, j);
        return j;
    }

    private static void mergeSort(int[] arr, int low, int high) {
            if(low == high) return;
            int mid = low + (high-low)/2 ;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merger(arr, low, mid, high);
    }

    private static void merger(int[] arr, int low, int mid, int high) {
        int i = low; int j = mid+1;//0,2,3 0,2
        ArrayList<Integer> temp = new ArrayList<>();
        while ( i<=mid && j <= high){
             if(arr[i] <= arr[j]){
                 temp.add(arr[i]); i++;
             }else {
                 temp.add(arr[j]);j++;
             }
        }
        while (i<=mid){
            temp.add(arr[i]); i++;
        }
        while (j<=high){
            temp.add(arr[j]);j++;
        }
        int k=0;
        for (int l=low;l<=high;l++){
            arr[l] = temp.get(k++);
        }
    }

    static void insertionSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
              if(arr[j] < arr[j-1]) swapTheIndex(arr, j, j-1);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length-1-i;
            int maxIndex = findMaxIndex(arr, 0, lastIndex);
            swapTheIndex(arr, lastIndex, maxIndex);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static int findMaxIndex(int[] arr, int i, int lastIndex) {
        int max = arr[i];int maxInd = i;
        for (int j = i+1; j <=lastIndex; j++) {
            if(max<arr[j]){
                max = arr[j]; maxInd=j;
            }
        }
        return maxInd;
    }

    static void bubbleSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[j-1] > arr[j]) swapTheIndex(arr, j-1, j);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void swapTheIndex(int[] arr, int st, int en){
        int temp = arr[st];
        arr[st] = arr[en];
        arr[en] = temp;
    }
}

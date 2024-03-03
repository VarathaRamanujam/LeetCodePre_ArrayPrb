package JavaPrograms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class BinarySearchPrb {
    public static void main(String[] args) {
//        int arr[] = {1,44,58,67,70,90,100};
//        System.out.println( binarySearch(arr,1000));

//          int arr[][] = {
//                  {1,2,3,4},
//                  {5,6,7,8},
//                  {9,10,11,12},
//                  {13,14,15,16}
//          };
//        System.out.println(Arrays.toString(binarySearch2D(arr,113)));


//        int arr[][]={
//                        {10,20,30,40},
//                        {15,25,35,45},
//                        {20,40,60,80},
//                        {30,60,90,120}
//                    };
//        System.out.println(Arrays.toString(binarySearch2DAlternative(arr,1220)));

        //System.out.println(search(new int[]{3,4,5,6,7,1,2},4));

       // System.out.println(searching(new int[]{1,0,1,1,1}, 0));//need to complete

        //System.out.println(upperBound(new int[]{5 ,12 ,12 ,15 ,18 ,21 ,35 ,37 ,38 ,46 ,47 ,48 ,48 ,50  },45));

        //System.out.println(lowerBound(new int[]{1,1,1,1,1}, 1));

        System.out.println(findMedian(new int[][]{{ 1, 5, 7, 9, 11 },
                { 2, 3, 4, 8, 9 },
                { 4, 11, 14, 19, 20 },
                { 6, 10, 22, 99, 100 },
                { 7, 15, 17, 24, 28 }}, 5, 5));
    }

    public static int findMedian(int matrix[][], int m, int n) {
//        int total = 0;int mid = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            total += matrix[i].length;
//        }
//        mid = total/2;int cal = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            if(cal + matrix[i].length >= mid){
//                for (int j = 0; j < matrix[i].length; j++) {
//                    cal++;
//                    if(cal == mid)return matrix[i][j];
//                }
//            }else {
//                cal += matrix[i].length;
//            }
//        }

        int[] temp = new int[m*n]; int ind = 0;
        //PriorityQueue tr = new PriorityQueue<>();
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                temp[ind++]=matrix[i][j];//tr.offer(matrix[i][j]);
            }
        }
        int mid = (m*n)/2 ;
//        for (int i = 0; i < mid; i++) {
//            tr.poll();
//       }
        //return  tr.peek();
        //System.out.println(tr);
        Arrays.sort(temp);
        //System.out.println(Arrays.toString(temp));
        return temp[mid];
    }

    public static int lowerBound(int []arr, int x) {
        int st = 0;
        int en = arr.length-1;
        while(st<=en){
            int md = st+(en-st)/2;
            if(arr[md] == x){
                int i = md;
                while(i>=0 && arr[i] == x)i--;
                return i+1;
            }else if(arr[md] > x){
                en = md-1;
            }else st = md+1;
        }
        return st;
    }
    public static int upperBound(int []arr, int x){
        int st = 0;
        int en = arr.length-1;
        while(st<=en){
            int md = st+(en-st)/2;
            if(arr[md] == x){
                int i = md;
                while(i<arr.length && arr[i] == x)i++;
                return i;
            }else if(arr[md] > x){
                en = md-1;
            }else st = md+1;
        }
        return arr.length;
    }

    public static boolean searching(int[] nums, int t) {
        if(nums.length ==1) return nums[0] == t;
        int md = midFind(nums);
        boolean fr = findingSource(nums, 0, md, t);
        if(fr) return true;
        return findingSource(nums, md+1, nums.length-1, t);
    }

   static boolean findingSource(int[] nums, int st, int en, int t){
        while(st<=en){
            int mid=st+(en-st)/2;
            if(nums[mid] == t) return true;
            else if(nums[mid] < t) st=mid+1;
            else en=mid-1;
        }
        return false;
    }

    static int midFind(int[] nums){
        int st=0;
        int en=nums.length-1;
        while(st<en){
            int mid=st+(en-st)/2;
            if(nums[mid] < nums[mid-1]) return mid-1;
            else if (nums[st] == nums[mid] && nums[mid] > nums[en]) return mid;
            else if(nums[st] > nums[mid]) en=mid-1;
            else if(nums[mid] > nums[mid+1]) return mid;
            else st=mid+1;
        }
        return st;
    }

    public static int search(int[] nums, int t) {
        if(nums.length == 1) return nums[0] == t ? 0 : -1;
        int mid = findMid(nums);
        int first = findTheTarget(nums, t, 0, mid);
        if(first != -1) return first; mid = mid >= nums.length-1 ? mid : mid+1;
        return findTheTarget(nums, t, mid, nums.length-1);
    }

    static int findTheTarget(int[] nums, int t, int st, int en){
        boolean isAsc = nums[st] < nums[en];
        while(st<=en){
            int mid = st+(en-st)/2;
            if(nums[mid] == t) return mid;
            else {
                if(isAsc){
                    if(nums[mid] < t){
                        st=mid+1;
                    }else{
                        en=mid-1;
                    }
                }else {
                    if(nums[mid] > t){
                        st=mid+1;
                    }else{
                        en=mid-1;
                    }
                }
            }
        }
        return -1;
    }

    static int findMid(int[] nums){
        int st = 0;
        int en = nums.length-1;
        while(st<en){
            int mid = st+(en-st)/2;
            if(nums[mid]>nums[mid+1]){
                en=mid;
            }else{
                st=mid+1;
            }
        }
        return st;
    }

    private static int[] binarySearch2DAlternative(int[][] arr, int i) {
        int row = 0; int col = arr[0].length-1;//i=30 ,
        while (true){
            if(row >= arr.length || col>= arr[row].length || col<0 || row<0) return new int[]{-1,-1};
            if(arr[row][col] == i) return new int[]{row,col};
            else if (arr[row][col] > i ) {
                col--;
            } else if (arr[row][col] < i) {
                row++;
            }
        }
    }

    private static int[] binarySearch2D(int[][] arr, int i) {
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int rowMid = start +(end-start)/2;
            int startInner = 0;
            int endInner = arr[rowMid].length -1;
            boolean flag = true;
            while (startInner<=endInner){
                int mid = startInner+(endInner-startInner)/2;
                if(i==arr[rowMid][mid]) return new int[]{rowMid,mid};//2,2 => 1,1
                else if(i<arr[rowMid][mid]){
                    endInner = mid-1;//1
                    flag = false;
                }else{
                    startInner = mid+1;//3
                    flag = true;
                }
            }
            if(!flag){
                end = rowMid-1;//1
            }else {
                start = rowMid+1;
            }
        }
        return new int[]{-1,-1};
    }


    private static int binarySearch(int[] arr, int i) {
        int s = 0;
        int e = arr.length-1;
        boolean isAsc = arr[s] < arr[e];
        while (s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid] == i){
                return mid;
            }else {
                if(isAsc){
                    if(arr[mid] < i){
                        s=mid+1;
                    }else{
                        e=mid-1;
                    }
                }else {
                    if(arr[mid] > i){
                        s=mid+1;
                    }else{
                        e=mid-1;
                    }
                }
            }
        }
        return -1;
    }
}

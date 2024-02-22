package JavaPrograms;

import java.util.Arrays;

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

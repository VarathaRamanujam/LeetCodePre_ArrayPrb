package JavaPrograms;

import java.util.*;

public class ArrayprbLeetcode {
    public static void main(String[] args) {
//        int arr[] = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
//        plusOnePrb(arr);

//        int nums[] = {3,2,3};
//        System.out.println( majorityElement(nums));

//        String arr[] = {"eat","tea","tan","ate","nat","bat"};
//        System.out.println(groupAnagrams(arr));

//        String arr[] = {"abba","baba","bbaa","cd","cd"};
//        System.out.println(removeAnagrams(arr));

//        String s = "leetcode"; String ss ="coats";
//        System.out.println( minSteps(s,ss));

//        String s = "abab"; String ss ="ab";
//        System.out.println(findAnagrams(s,ss));

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
//                {10,20,30,40},
//                {15,25,35,45},
//                {20,40,60,80},
//                {30,60,90,120}
//        };
//        System.out.println(Arrays.toString(binarySearch2DAlternative(arr,113)));

//        int [] arr = {2,2,3,2};
//        System.out.println(singleNumber(arr));

//        int arr[] = {4,2,3,0,3,1,2};
//        System.out.println(rec1306(arr,0));

//          int arr[] = {4,3,1,1,3,3,2};
//          System.out.println(findLeastNumOfUniqueInts(arr, 4));

//          int arr[] ={1,1,1,1,1};
//          System.out.println(jumpMediumGame(arr));

//        int[] nums = {1,3,4,8,7,9,3,5,1};
//        int[][] arr = divideArray(nums,2);
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

//        int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        System.out.println(Arrays.asList(spiralOrder(matrix)));

//        int[] values = {3,0,2,6,8,1,7,9,4,2,5,5,0};
//        ListNode head = new ListNode(values);
//        int arr[][] = spiralMatrix(3,5, head);
//          for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

//        int nums1[]={1,3};
//        int nums2[]={2};
//        findMedianSortedArrays(nums1,nums2);

        spiralMatrix(1,2);//need to finish


    }

    private static void spiralMatrix(int col, int row) {
        int[][] matrix = new int[4][4];
        HashSet<List<Integer>> ls = new HashSet<>();
        List<int[]> arr= new ArrayList<>();
        int count = 1; int i=0;
        matrix[col][row]=count++;
        char c = 'r'; row++;
        while(count<=matrix.length*matrix.length){
            switch (c){
                case 'r':{
                    arr.add(new int[]{col,row});
                    if(!ls.contains(arr.get(i))){
                       matrix[col][row] = count++;
                       if(col>=0 && col<matrix.length-1) col++;
                        i++;
                       c='d';
                    }else {


                        //arr.remove(i);
                    }
                    break;
                }
                case ('d'):{
                    arr.add(new int[]{col,row});
                    if(!ls.contains(arr.get(i))){
                        i++;
                        matrix[++col][row] = count++;
                        c='l';
                    }else {
                        arr.remove(i);
                    }
                    break;
                }
                case 'l':{
                    arr.add(new int[]{col,row});
                    if(!ls.contains(arr.get(i))){
                        i++;
                        matrix[col][--row] = count++;//1,0
                        c='u';
                    }else {
                        arr.remove(i);
                    }
                    break;
                }
                case ('u'):{
                    arr.add(new int[]{col,row});
                    if(!ls.contains(arr.get(i))){
                        i++;
                        matrix[++col][row] = count++;
                        c='l';
                    }else {
                        arr.remove(i);
                    }
                    break;
                }
            }
        }

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;String s = new String(Arrays.toString(nums1));
        if(s.indexOf(s.charAt(0)) - s.lastIndexOf(s.charAt(0)) == 0){

        }
        int[] arr = new int[len];
        int j=0; int k=0;
        for(int i=0;i<arr.length;i++){
            int temp1=Integer.MAX_VALUE;
            int temp2=Integer.MAX_VALUE;
            if(nums1.length > j) temp1 = nums1[j];
            if(nums2.length > k) temp2 = nums2[k];

            if(temp1<temp2){
                arr[i] = temp1;
                j++;
            }else{
                arr[i] = temp2;
                k++;
            }
        }
        System.out.println(Arrays.toString(arr));
        if(len%2!=0){
            int temp = arr[arr.length/2];
            double d = (double)temp;
            System.out.println(d);
            return d;
        }else{
            double temp = (double) (arr[arr.length / 2] + arr[(arr.length / 2) - 1]) / 2;
            double d = (double)temp;
            System.out.println(temp);
            return d;
        }
    }
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int count = 1;
        int i = 0;
        char c = 'l';
        int col = 0;
        int row = 0;
        while (count<=matrix.length*matrix[0].length){
            switch (c){
                case 'l' :{
                    for ( col=col ;col < matrix[row].length-i; col++) {
                        matrix[row][col]=head.val ;
                        count++;
                        head = head.next == null ? new ListNode(-1) : head.next;
                    }
                    row++;
                    col--;
                    c='d';
                    break;
                } case 'd':{
                    for (int j = row; row < matrix.length-i; row++) { //5
                        matrix[row][col]=head.val ;
                        count++;
                        head = head.next == null ? new ListNode(-1) : head.next;
                    }
                    c='r';
                    row--;
                    col--;
                    break;
                } case 'r':{
                    for ( col=col ;col>=i; col--) {
                        matrix[row][col]=head.val ;
                        count++;
                        head = head.next == null ? new ListNode(-1) : head.next;
                    }
                    row --;
                    col ++;
                    c='u';
                    i++;
                    break;
                } case  'u':{
                    for ( row=row ;row>=i; row--) {
                        matrix[row][col]=head.val ;
                        count++;
                        head = head.next == null ? new ListNode(-1) : head.next;
                    }
                    row++;
                    col++;
                    c='l';
                    break;
                }
            }
        }
        return matrix;
    }

    public static List<Integer> spiralOrder(int matrix[][]) {
        List<Integer> ls = new ArrayList<>();
        int count = 1;
        int i = 0;
        char c = 'l';
        int col = 0;
        int row = 0;
        while (count<=matrix.length*matrix[0].length){
            switch (c){
                case 'l' :{
                    for ( col=col ;col < matrix[row].length-i; col++) {
                        ls.add(matrix[row][col]);
                        matrix[row][col]=count++;
                    }
                    row++;
                    col--;
                    c='d';
                    break;
                } case 'd':{
                    for (int j = row; row < matrix.length-i; row++) { //5
                        ls.add(matrix[row][col]);
                        matrix[row][col]=count++;
                    }
                    c='r';
                    row--;
                    col--;
                    break;
                } case 'r':{
                    for ( col=col ;col>=i; col--) {
                        ls.add(matrix[row][col]);
                        matrix[row][col]=count++;
                    }
                    row --;
                    col ++;
                    c='u';
                    i++;
                    break;
                } case  'u':{
                    for ( row=row ;row>=i; row--) {
                        ls.add(matrix[row][col]);
                        matrix[row][col]=count++;
                    }
                    row++;
                    col++;
                    c='l';
                    break;
                }
            }
        }
        return ls;
    }

    public static int[][] divideArray(int[] nums, int k) {
        int[][] arr = new int[nums.length/3][3];
        if(nums.length % 3 != 0) return new int[][]{};
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();int col =0;
        for(int i=0;i<=nums.length-3;i +=3){
            if(nums[i+2] - nums[i] <= k){
                arr[col][0] = nums[i];
                arr[col][1] = nums[i+1];
                arr[col][2] = nums[i+2];col++;
            }else{
                return new int[][]{{}};
            }
        }
        return arr;
    }

    private static int[] binarySearch2DAlternative(int[][] arr, int i) {
        return  new int[]{-1,-1};
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        int unique = count.size();
        int[] countArray = new int[100000];
        for(Integer key : count.keySet()) {
            int keyCount = count.get(key);
            countArray[keyCount]++;
        }
        for (int i = 1; i < 100000; i++) {
            if (countArray[i]!= 0) {
                int remove = k / i;
                if (remove == 0) {
                    break;
                } else {
                    remove = Math.min(remove, countArray[i]);
                    unique -= remove;
                    k -= remove * i;
                }
            }
        }
        return unique;
    }

  static   boolean rec1306(int arr[], int k){
        if(arr[k] == 0) return true;
        if(arr[k] == -1) return false;
        int temp = arr[k];
        if(k+temp >= arr.length){
            arr[k] = -1;
            int big = Math.max(k,temp);
            int small = Math.min(k,temp);
            int dif = big - small;
            return rec1306(arr, dif);
        }else{
            arr[k] = -1;
            return rec1306(arr, k+temp);
        }
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> ls = new HashMap<>();
        if(nums.length == 1) return nums[0];
        for(int i =0;i<nums.length;i++){
            ls.put(nums[i],ls.getOrDefault(nums[i],0)+1);
        }

        for(int i : nums){
            if(ls.get(i) == 1) return i;
        }
        return 0;
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

    private static int jumpMediumGame(int[] arr) {
        int jump = 1;
        int last = 0;
        int max = 0;
        for (int i=0;i< arr.length;i++){
            max = Math.max(max,i+arr[i]);
            if(i==last) {
                last=max;
                jump++;
                if (max >= arr.length - 1) return jump;
            }
        }
        return jump;
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

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        char c[] = p.toCharArray();
        Arrays.sort(c);
        String ps = new String(c);
        for(int i=0;i<=s.length()-p.length();i++){
            char cc[] = s.substring(i,i+p.length()).toCharArray();
            Arrays.sort(cc);
            String ss = new String(cc);
            if(ss.equals(ps)) ls.add(i);
        }
        return ls;
    }

    private static void plusOnePrb(int[] arr) {
        int sum = 0;
        int check = 0;
        for(int i=arr.length-1;i>=0;i--){
            sum = sum * 10 + arr[i];
            if(arr[i]<9) i = -1;
        }
        int reSum =0;
        while(sum>0){
            reSum = (reSum*10)+(sum % 10);
            sum/=10;
        }
        check = reSum;
        reSum = reSum+1;
        if(String.valueOf(check).length() != String.valueOf(reSum).length()){
            int ar[] = new int[arr.length+1];
            for(int i =ar.length-1;i>=0;i--){
                ar[i] = reSum%10;
                reSum/=10;
            }
            System.out.println(Arrays.toString(ar));
        }else{
            for(int i =arr.length-1;i>=0 && reSum > 0;i--){
                arr[i] = reSum%10;
                reSum/=10;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])>nums.length/2)
                return nums[i];
        }
        return 0;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ls = new ArrayList<>();
        List<String> ar = new ArrayList<>();
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char [] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            ar.add(strs[i]);
            List<String> list = hmap.getOrDefault(s, new ArrayList<>()); // Get the list associated with the key or create a new list if it doesn't exist
            list.addAll(Arrays.asList(strs[i])); // Add values to the list
            hmap.put(s, list);
        }
        for (List<String> values : hmap.values()) {
            ls.add(values); // Add values to the main list
        }
        return ls;
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> ls = new ArrayList<>();
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            char c[] = words[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(!hmap.containsKey(s)){
                List<String> list = hmap.getOrDefault(s, new ArrayList<>());
                list.add(words[i]);
                hmap.put(s,list);
                ls.add(words[i]);
            }
        }

//        for (List<String> values : hmap.values()) {
//            ls.add(values.get(0)); // Add values to the main list
//        }
        return ls;
    }

    public static int minSteps(String s, String t) {
        int ch[] = new int[26];
        for(int i=0;i<s.length();i++){
            ch[s.charAt(i)-'a']++;
            ch[t.charAt(i)-'a']--;
        }
        int count =0 ;
        for(int i:ch){
            if(i>0)count=count+i;
            else if(i<0) count = count + (-i);
        }
        return count/2;
    }

}

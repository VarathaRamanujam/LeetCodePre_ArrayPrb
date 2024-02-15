package JavaPrograms;

import java.util.*;

public class ArrayprbLeetcode {
    public static void main(String[] args) {
        //int arr[] = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        //plusOnePrb(arr);

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

       // spiralOrder();// need to finish

//        int arr[] = {1,44,58,67,70,90,100};
//        System.out.println( binarySearch(arr,1000));


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

    public static List<Integer> spiralOrder() {
        List<Integer> ls = new ArrayList<>();
        int[][] matrix = {{}};
        int count = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(count++);
            }
            System.out.println();
        }
        return new ArrayList<>();
    }
}

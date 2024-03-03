package JavaPrograms;

import java.util.HashMap;
import java.util.Stack;

public class LeetCodePrbEasy {
//    public static void main(String[] args) {
//       int [] nums = {0,0,1,1,1,2,2,3,3,4};
//        //System.out.println( removeDuplicates(nums));
//
//        //reverseInt();
//
//        //stringToInt();
//
//        int [] num ={7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
//        //int [] num = {3,2,1,0,4};
//        //System.out.println(canJump(num));
//        //System.out.println(jump(num));
//
//        myAtoi("5024S");//need to complete
//
//        //System.out.println( firstNonRepeatedChar("manbfkjymuyfuyfyf"));
//
////        int arr[]={9,2,11};
////        Stack list = new Stack<>();
////        recSubArray(0,arr,list);
//
//       // System.out.println(longestPalindrome("ababad"));
//
//
//        //System.out.println(longestPalindromeLen("abccccdd"));
//    }

    public static void main(String[] args) {
        myAtoi("5024S");
    }

    public static int longestPalindromeLen(String s) {
        if(s.isEmpty()) return 0;
        if(s.length()<=2) return s.length();

        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
        }
        int count =0;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
           if(hmap.containsKey(s.charAt(i)) ) {
               if (hmap.get(s.charAt(i)) % 2 == 0) {
                   count = count + hmap.get(s.charAt(i));
                   hmap.remove(s.charAt(i));
               }else if (hmap.get(s.charAt(i)) == 1) flag = false;
           }

        }

        return flag ? count : count+1;
    }
    public static String longestPalindrome(String s) {
        StringBuilder returnStr = new StringBuilder();
        StringBuilder maxStr =new StringBuilder();
        recString(0,s,returnStr,maxStr);
        return maxStr.toString();
    }

    static void recString(int i, String s, StringBuilder returnStr, StringBuilder maxStr){
        if(i==s.length()){
           String temp = returnStr.toString();
            if(temp.contentEquals(returnStr.reverse()) && returnStr.length() > maxStr.length()){
                maxStr.setLength(0);
                maxStr.append(temp);
            }
            return ;
        }
        returnStr.append(s.charAt(i));
        recString(i+1,s,returnStr,maxStr);
        returnStr.reverse();
        returnStr.deleteCharAt(returnStr.length()-1);
        recString(i+1,s,returnStr,maxStr);

    }

    private static void recSubArray(int i, int[] arr, Stack list) {

        if(i==arr.length){
            System.out.println(list);
            return ;
        }
        list.push(arr[i]);
        recSubArray(i+1,arr,list);
        list.pop();
        recSubArray(i+1,arr,list);

    }

    private static int firstNonRepeatedChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) ==1){
                return i;
            }
        }
        return -1;
    }

    public static void  myAtoi(String s) {
        int val=0;
        s = s.trim();
        if (s.isEmpty()) {
            val = 0;
        }
        int i = 0;
        boolean check = true;
       if(s.charAt(i) == '-') {
           check = false;
           i++;
       } else if (s.charAt(i) == '+') i++;

       while (s.length()>i && Character.isDigit(s.charAt(i))){
           int add = (s.charAt(i) - '0');
           if(val>Integer.MAX_VALUE/10) val = Integer.MAX_VALUE;
           val = val*10+add;
           i++;
       }
        System.out.println(val);
    }

    public static int jump(int[] nums) {
        int jumps = 0;
        int curr = 0;
        int farthest = 0;

        for(int i=0; i<nums.length -1; i++){
            farthest = Math.max(farthest,nums[i]+i);

            if(i==curr){
                curr = farthest;
                jumps++;
            }
        }
        return jumps;
    }

    public static boolean canJump(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length && max > 0; i++){
            //if(max ==0 && i!= nums.length-1) return false;
            if(nums[i] >= max){
                max = nums[i]+1;
            }
            // if(max ==0) return false;
            if(nums.length -i <= max) return true;
            max--;
        }
        return false;
    }


    private static void stringToInt() {
       String s = "words and 987";
           int val=0;
           boolean check = true;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) >= 48 && s.charAt(i) < 58){
                    val=(val*10)+((int)s.charAt(i)-48);
                }
                if(s.charAt(i) == 45){
                    check = false;
                }
            }
            if(!check) val = (-1*val);
        int c='4';
        System.out.println(val);
    }

    private static void reverseInt() {
        Integer x = 1534236469;
        boolean check = false;
        if(x<0) {
            check = true;
            x= -(x);
        }
        Integer temp =0;
        while(x>0){
            temp=(temp*10)+(x%10);
            x=x/10;
            if(temp >(Integer.MAX_VALUE )) {
                temp =0;break;
            }
        }x=0;
        if(check){
            x = (-temp);
        }else {
            x=temp;
        }
        System.out.println(x);
    }


    public static int removeDuplicates(int[] nums) {
        int arr[] = new int[nums.length];
        int k=Integer.MAX_VALUE;
//        for(int i=0;i<nums.length;i++){
//            int count = 0;
//            for(int j= i+1 ; j<nums.length;j++){
//                if(nums[i] == nums[j]){
//                    count++;
//                }
//                if(count>0) j=10;
//            }
//            if(count == 0){
//                arr[k++]=nums[i];
//            }
//        }//for(int i:arr) System.out.println(i);
//        k=0;
//        for (int i : arr) {
//            nums[k++]=i;
//        }
        int count =0;
for(int i=0;i<nums.length;i++){
    if(k != nums[i]){
        k=nums[i];
        nums[count++] = k;
    }
}
        return k;

    }
}

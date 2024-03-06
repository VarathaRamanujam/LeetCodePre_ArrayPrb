package JavaPrograms;

import java.util.*;

public class RecurringArrayPrb {
    public static void main(String[] args) {
       // System.out.println( numSubseq(new int[]{3,5,6,7}, 9));

        //System.out.println(reverseNum(12345678, 0));

        //System.out.println(findStrpalimdrome("maggdam", new StringBuilder(""), 6));

        //printThePatterUsingRec(0,5);
//        int v = (int) Math.log10(1234567890) + 1;
//        System.out.println(v);

       // print2ThePatterUsingRec(1, 5);

        //System.out.println(Arrays.toString(new List[]{letterCombinations("22", "")}));

        //System.out.println( linearSearchRec(new int[]{1,2,2,3,2,4,2}, 2, 0));

        //System.out.println(findTheElementInRotateArray(new int[]{5,6,7,8,9,1,2,3}, 1, 0, 7));

       // print3ThePatterUsingRec(1, 0);

//        System.out.println(diceCombination(new int[]{10,1,2,7,6,1,5},"", 8) );
//        System.out.println(count);

//        List<List<Integer>> result = subsets(new int[]{4,2,2,2,4,4,2,2});
//        System.out.println(result);

 //       System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));

//        List<List<Integer>> result = combinationSum(0,new int[]{2,3,6,7}, 7, new ArrayList<>());
//        System.out.println(result);

        nextPermutation(new int[]{3,2,1});

    }

    public static void nextPermutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        for(int i : nums) curr.add(i);
        System.out.println(curr);
        Arrays.sort(nums);
        findThePermutations(curr, nums, new ArrayList<>(), result);
        int k = 0;
        //for (int i: result.get(0)) nums[k++]=i;
        System.out.println(result);
    }
    static  boolean check = false;
    static void findThePermutations(ArrayList<Integer> cur, int[] nums, ArrayList<Integer> ls, List<List<Integer>> result){
        if(ls.size() == nums.length){
            if(check){
                result.add(new ArrayList<>(ls));
                check = false;
            }
            if(ls.equals(cur)) check = true;
        }else{
            for(int i=0;i<nums.length;i++){
                if(ls.contains(nums[i])) continue;
                ls.add(nums[i]);
                findThePermutations(cur, nums, ls, result);
                ls.remove(ls.size()-1);
            }
        }
    }

    static int max = 0;
    public static int longestSubarray(int[] nums, int limit) {//4,2,2,2,4,4,2,2  0
        int i = 0;int j = 0;
        while(i<nums.length){
            int sum = findTheDiffMaxAndMin(nums, i, j);
            if( sum <= limit){
                max = Math.max(max,i-j+1);
                i++;
            } else {
                j++;
            }
        }
        return max;
    }

    private static int findTheDiffMaxAndMin(int[] nums, int i, int j) {
        int mn = nums[j];
        int mx = nums[i];
        int[] temp = new int[1+(i-j)];int index = 0;
        for (int k = j; k <= i; k++) {
            temp[index++] = nums[k];
        }
        Arrays.sort(temp);
        return temp[temp.length-1]-temp[0];
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
       // subSetsOfInteger(nums, new ArrayList<>(), ls);
        subSetsOfDuplicateInteger(nums, new ArrayList<>(), ls, 0);
        return ls;
    }

    static void subSetsOfDuplicateInteger(int[] nums,List<Integer> res, List<List<Integer>> ls, int index){
            List<Integer> tem = new ArrayList<>(res);
            ls.add(tem);
        for (int i = index; i <nums.length ; i++) {
            if(index != i && nums[i] == nums[i-1]) continue;
            res.add(nums[i]);
            subSetsOfDuplicateInteger(nums, res, ls, i+1);
            res.remove(res.size() - 1);
        }
    }

    static void subSetsOfInteger(int[] nums,List<Integer> res, List<List<Integer>> ls){
        if(nums.length ==0){
            List<Integer> tem = new ArrayList<>(res);
            ls.add(tem);
            return;
        }
        int[] temp = new int[nums.length-1];int k = 1;
        for (int i = 0; i <temp.length ; i++) {
            temp[i] = nums[k++];
        }
        subSetsOfInteger(temp, res, ls);
        res.add(nums[0]);
        subSetsOfInteger(temp, res, ls);
        res.remove(res.size()-1);
    }

    public static List<List<Integer>> combinationSum(int index, int[] candidates, int target, List<Integer> ls) {
//        if(target == 0){
//            Set<List<Integer>> result = new HashSet<>();
//            ArrayList<Integer> temp = new ArrayList<>(ls);
//            Collections.sort(temp);
//            result.add(temp);
//            return result;
//        }
//        Set<List<Integer>> result = new HashSet<>();
//        for (int i = 0; i < candidates.length && i<=target; i++) {
//            ls.add(candidates[i]);
//            result.addAll(combinationSum(candidates, target-candidates[i], ls));
//            ls.remove(ls.size()-1);
//        }
        if(index == candidates.length){
            ArrayList<List<Integer>> result = new ArrayList<>();
            if (target==0){
                ArrayList<Integer> temp = new ArrayList<>(ls);
                result.add(temp);
            }
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        if (candidates[index] <= target){
            ls.add(candidates[index]);
            result.addAll(combinationSum(index,candidates,target-candidates[index],ls));
            ls.remove(ls.size()-1);
        }result.addAll(combinationSum(index+1,candidates,target,ls));
        return result;
    }

    static int count = 0;
    static List<String> diceCombination(int[] candidates, String ans, int target){
        if (target==0){
            List<String> ls = new ArrayList<>();
            ls.add(ans);
            count++;
            return ls;
        }List<String> ls = new ArrayList<>();
        for (int i = 0; i < candidates.length && i<=target; i++) {
           ls.addAll(diceCombination(candidates,ans+candidates[i], target-candidates[i]));
        }
        return ls;
    }

    private static void print3ThePatterUsingRec(int row, int col) {
        if(6 == row) return;

        if(row>col) {
            System.out.print("*");
            print3ThePatterUsingRec(row, col+1);
        }else {
            System.out.println();
            print3ThePatterUsingRec(row+1, 0);
        }
    }

    private static int findTheElementInRotateArray(int[] arr, int t, int st, int en) {
        int mid = st + (en-st)/2;
        if(st>en) return -1;
        if(arr[mid] == t) return mid;
        else if (arr[st] < arr[mid] && t >= arr[st] && arr[mid]>=t) {
            return findTheElementInRotateArray(arr, t, st, mid-1);
        } else if (arr[mid] < arr[en] && t>= arr[mid] && t<=arr[en]) {
            return findTheElementInRotateArray(arr, t, mid+1, en);
        } else if(arr[mid] > arr[en] && arr[en] < t){
            return findTheElementInRotateArray(arr, t, st, mid-1);
        }else if(arr[st] > arr[mid] && arr[st] <= t){
            return findTheElementInRotateArray(arr, t, st, mid-1);
        } else  return findTheElementInRotateArray(arr, t, mid+1,en);
    }

    private static ArrayList<Integer> linearSearchRec(int[] arr, int t, int index) {
          ArrayList<Integer> ls = new ArrayList<>();
          if(index == arr.length) return ls;
          if(arr[index] == t) ls.add(index);
          ls.addAll(linearSearchRec(arr, t, index+1));
      return ls;
    }

    public static List<String> letterCombinations(String p, String up ) {
        ArrayList<String> ans = new ArrayList<>();
        if (p.isEmpty()) {
            ans.add(up);
            return ans;
        }
        int digit = p.charAt(0)-'0';
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char c = (char)('a'+i);
            ans.addAll(letterCombinations(p.substring(1),up+c));
        }
        return  ans;
    }

    private static List<String> returnLetterCombination(Map<String, String> map, ArrayList<String> ans, String digits, int i) {
        if(i>digits.length()) return  ans;
        return returnLetterCombination(map, ans, digits, i+1);
    }

    private static void print2ThePatterUsingRec(int row, int col) {
        if(row > col) return;

        print2ThePatterUsingRec(row+1, col);
        for (int i = 1; i <= row ; i++) {
            System.out.print(" ");
        }for (int i = row; i <=col; i++) {
            System.out.print("* ");
        }
        System.out.println();

    }

    private static void printThePatterUsingRec(int row, int col) {
        if(col == row){
            for (int i = 0; i < col; i++) {
                System.out.print("* ");
            }
            System.out.println();
            return;
        }
        printThePatterUsingRec(row+1, col);
        for (int i = 0; i < row; i++) {
            System.out.print("* ");
        }
        System.out.println();

    }

    private static String findStrpalimdrome(String s, StringBuilder str, int index) {
        if (index==0) return str.append(s.charAt(index)).toString();
        str.append(s.charAt(index));
        findStrpalimdrome(s, str, index-1);
        return str.toString();
    }

    static int reverseNum(int n, int sum){
        if(n < 10) {
            sum = (sum*10)+n;
            return sum;
        }
         sum = (sum*10)+n%10;
        return reverseNum(n/10, sum);
    }

    public static int numSubseq(int[] nums, int target) {
        int count =0;
        return recSub(0, nums, target, 0, count);
    }
    static int recSub(int i, int[] nums, int target, int sum, int count){
       if(i==nums.length){
        return count;
       }
       sum = nums[i];
        for (int j = i+1; j <nums.length ; j++) {
            if(sum <=target) count++;
           sum +=nums[j];
        }
        return recSub(i+1, nums, target, sum, count);
    }
}

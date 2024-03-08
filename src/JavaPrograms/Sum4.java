package JavaPrograms;

import java.util.*;

public class Sum4 {
    public static void main(String[] args) {
//        List<List<Integer>> res = fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, 8);
//        System.out.println(res);

        System.out.println(maxFrequencyElements(new int[]{1,17,12,7,17,3}));
    }

    public static int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums);//1,1,2,2,3,4
        int maxCount = 1; int maxFreq = 1;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] == nums[i]) count++;
            else if (count>maxFreq){
                maxFreq = count;
                maxCount = count;
                count = 1;
            }else if (count == maxFreq   ){
                maxCount += count;
                count = 1;
            }else count=1;

        }
        if(maxCount<count || (count>1 && maxFreq ==1)){
            maxCount = count;
        } else if (count == maxFreq && maxFreq != 1) {
            maxCount += count;
        }
        return  maxCount;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<=3) return result;
        Set<List<Integer>> ls = new HashSet<>();
        Arrays.sort(nums);//-2,-1,0,0,1,2
        int i = 0;
        int j = i+1;
        int lf = j+1;
        int rt = nums.length - 1;

        while(i<nums.length && lf < nums.length && lf<=rt){
            long sum = nums[i]+nums[j];
                sum += nums[lf]+nums[rt];
            if(sum>target){
                while(lf<rt && nums[rt] == nums[rt-1]) --rt;
                rt--;
            }else if(sum<target){
                while(lf<rt && nums[lf] == nums[lf+1]) ++lf;
                lf++;
            }else if (lf<rt){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[lf]);
                temp.add(nums[rt]);
                Collections.sort(temp);
                ls.add((temp));
                j++;
                lf = j+1;
                rt = nums.length-1;
            }

            if(lf>=rt){
                j++;
                lf=j+1;
                rt=nums.length - 1;
            }
            if(j>=lf || j>= nums.length-1 || lf>=rt){
                i++;
                j=i+1;
                lf=j+1;
                rt=nums.length - 1;
            }
        }
        result.addAll(ls);
        return result;
    }

}

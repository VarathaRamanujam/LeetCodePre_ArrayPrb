package JavaPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubSetsPrb {
    public static void main(String[] args) {
        BinarySubsetSum(new int[]{1,2,3,2,4,3,3,2,3,3});//Sliding window concept

    }

    public static void BinarySubsetSum(int[] num) {
        System.out.println(findTheSubSetsSumsCount(num, 6));//-findTheSubSetsSumsCount(num, 5));
    }

    static int findTheSubSetsSumsCount( int[] nums, int sum){
//        if(sum < 0){
//            return 0;
//        }
//        int count = 0;int j = 0;
//        for(int i = 0; i<nums.length ; i++){
//            sum -= nums[i];
//            while(sum<0){
//                sum += nums[j++];
//            }
//            count += i-j+1;
//        }
//        return count;

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int count = 0;int s = 0;
        for (int i:nums ){
            s += i;
            count += mp.getOrDefault(s-sum,0);
            mp.put(s, mp.getOrDefault(s,0)+1);
        }
        return count;
    }


    static void findTheSubSetsSums(int index, ArrayList<Integer> res, int[] num, int sum){
        res.add(sum);
        for(int i =index; i<num.length; i++){
            sum += num[i];
            findTheSubSetsSums(i+1, res, num, sum);
            sum -= num[i];
        }
    }
}

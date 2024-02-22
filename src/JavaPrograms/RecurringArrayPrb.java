package JavaPrograms;

public class RecurringArrayPrb {
    public static void main(String[] args) {
        System.out.println( numSubseq(new int[]{3,5,6,7}, 9));
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

package JavaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        //System.out.println(generate(5));
        //System.out.println(Arrays.deepToString(pascalTriangle(5)));
        //System.out.println(triangularSum(new int[]{1,2,3,4,5}));
        //System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{1, 2})));
        System.out.println(minMaxGame(new int[]{9048,9224,3930,8626,4102,7783,9537,5414,3854,1465,4071,7350,326,6485,7401,3449}));
    }

    static public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1; j<=i; j++){
                temp.add(findingTheElement(i, j));
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

   static int findingTheElement(int row, int col){
        int ans = 1;
        for(int i=0; i<col; i++){
            ans *= (row-i);
            ans /= i+1;
        }
        return ans;
    }

    public static int[][] pascalTriangle(int N) {
        int[][] res = new int[N][];
        for(int i = 0; i < N; i++) {
            res[i] =  new int[i + 1];
            res[i][0] = 1;
            for(int j = 1; j <= i; j++) {
                res[i][j] = findingTheElement(i, j);
            }
        }
        return res;
    }

    static public int triangularSum(int[] nums) {
        int ch = 0;
        for (int i = 1; i < nums.length; i++) { //1 2 3 4 5
            int k = 0;
            for (int j = 1; j < nums.length-ch ; j++) {
                int pre = nums[j-1];
                int cur = nums[j];
                int val = pre+cur > 9 ? (pre+cur)%10 : pre+cur;
                nums[k++] = val;
            }ch++;
            System.out.println(Arrays.toString(nums));
        }
        return nums[0];
    }

   static public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> ls = new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                ls.add(nums1[i]);
                while (j+1< nums2.length && nums2[j] == nums2[j+1]) j++;
                while (i+1< nums1.length && nums1[i] == nums1[i+1]) i++;
                i++; j++;
            }else if (nums1[i] > nums2[j]){
                while (j+1< nums2.length && nums2[j] == nums2[j+1]) j++;
                j++;
            }
            else {
                while (i+1< nums1.length && nums1[i] == nums1[i+1]) i++;
                i++;
            }
        }
        int[] res = new int[ls.size()];
        i=0;
        for(int num:ls )res[i++] = num;
        return res;
    }

    static public int minMaxGame(int[] nums) {
        int len = nums.length;boolean temp = true;
        while (1<len) {
            int k = 0;
            for(int j=1; j<len; j += 2){
                if(temp){
                    nums[k] = Math.min(nums[j-1], nums[j]);
                    temp=false;
                }else{
                    nums[k] = Math.max(nums[j-1], nums[j]);
                    temp=true;
                }
                k++;
            } len /= 2;
        }
        return nums[0];
    }
}

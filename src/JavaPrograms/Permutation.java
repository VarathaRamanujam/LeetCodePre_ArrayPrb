package JavaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
//        List<List<String>> res = new ArrayList<>();
//        permutationForStrings("12340", new ArrayList<>(), res);
//        boolean[] check = new boolean[3];
//       // permutationForDuplicateStrings("123", new ArrayList<>(), res, check);
//         System.out.println(res);

       // System.out.println(permutationOfKth("",4 , 1, new int[]{0}));

        nextPermutation(new int[]{1,3,2});
    }

    public static void nextPermutation(int[] nums) {
        //1.find the pivot like 4<5,  2.find the largest of index element and swap it.   3.reverse the remaining element index+1.
        int index = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){ // if last index is greater
            int i=0; int j= nums.length-1;
            while (i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
            System.out.println(Arrays.toString(nums));
            return;
        }

        // Second largest number
        for (int i = nums.length-1; i >index ; i--) {
            if (nums[i] > nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        //reversse the remaining
        int i=index+1; int j=nums.length-1;
        while (i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(nums));
    }

        static String permutationOfKth(String p, int n, int k, int[] counter){
        if(n == p.length()){
            counter[0] += 1;
            if(counter[0] == k) return p;
            return "";
        }else{
            StringBuilder res = new StringBuilder();
            for(int i=1; i<=n && counter[0]<=k; i++){
                if(p.contains(i+"")) continue;
                res.append(permutationOfKth(p+i, n, k, counter));
            }
            return res.toString();
        }
    }

    static void permutationForDuplicateStrings(String s, ArrayList<String>ls, List<List<String>> res, boolean[] check){
        if (ls.size() == s.length()){
            res.add(new ArrayList<String>(ls));
            return;
        }else {
            for (int i = 0; i < s.length(); i++) {
                if(check[i] || i>0 && s.charAt(i) == s.charAt(i-1) && !check[i-1]) {
                   continue;
                }
                ls.add(s.charAt(i)+"");
                check[i]=true;
                permutationForDuplicateStrings(s, ls, res, check);
                check[i]=false;
                ls.remove(ls.size()-1);
            }
        }
    }

    static void permutationForStrings(String s, ArrayList<String>ls, List<List<String>> res){
        if (ls.size() == s.length()){
            res.add(new ArrayList<String>(ls));
            return;
        }else {
            for (int i = 0; i < s.length(); i++) {
               if(ls.contains(s.charAt(i)+"") )continue;
                ls.add(s.charAt(i)+"");
                permutationForStrings(s, ls, res);
                ls.remove(ls.size()-1);
            }
        }
    }
}

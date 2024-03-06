package JavaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
       // permutationForStrings("abc", new ArrayList<>(), res);
        boolean[] check = new boolean[3];
       // permutationForDuplicateStrings("123", new ArrayList<>(), res, check);
       //  System.out.println(res);

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

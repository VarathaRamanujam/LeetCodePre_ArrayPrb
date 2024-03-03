package JavaPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecStringPrb {
    public static void main(String[] args) {
        //List<String> ls = new ArrayList<>();
        //stringSubset("adef", "", ls);

        letterCombinations("23");

        //stringSubSetASCII("abc","",ls);
        //System.out.println(ls);
    }

    private static void stringSubSetASCII(String s, String temp, List<String> ls) {
        if (s.isEmpty()) {
            ls.add(temp);
            return;
        }
        char c = s.charAt(0) ;
        stringSubSetASCII(s.substring(1), temp+c, ls );
        stringSubSetASCII(s.substring(1), temp, ls);
        stringSubSetASCII(s.substring(1), temp+(c+0), ls);
    }

    static List<String> stringSubset(Map<Character,String> map, String digits, String up, List<String> ls){
        if (digits.isEmpty()) {
           if(!up.isEmpty()) ls.add(up);
           return ls;
        }
        String charac = map.get(digits.charAt(0));
        for (int i = 0 ; i < charac.length() ; i++) {
            char c = charac.charAt(i);
            stringSubset(map, digits.substring(1), up+c, ls);
        }
        return ls;
     }

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        String firStr = map.get(digits.charAt(0));
        if(digits.length() == 1){
            for (int i = 0; i < firStr.length(); i++) {
                ans.add(firStr.charAt(i)+"");
            }
            return ans;
        }

        stringSubset(map, digits, "",  ans );
        System.out.println(ans);//["aa","ab","ac","ba","bb","bc","ca","cb","cc"]
        return ans;
    }
}

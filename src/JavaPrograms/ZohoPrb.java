package JavaPrograms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ZohoPrb {
    public static void main(String[] args) {
        //prb2();
       // System.out.println(stackPrb());
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }

    public static int minimumLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(true){
            int lf = 0;
            int rt = sb.length()-1;
            if (sb.charAt(lf) == sb.charAt(rt) && lf != rt){
                while (sb.length() > lf+1 && sb.charAt(lf) == (sb.charAt(lf+1))){
                    sb.deleteCharAt(lf);
                    lf = 0;
                }
                sb.deleteCharAt(lf);
                rt = sb.length()-1;
                if(rt<0) break;
                while (rt-1>=0 && sb.charAt(rt) == sb.charAt(rt-1)){
                    sb.deleteCharAt(rt--);
                    rt = sb.length()-1;
                }
                sb.deleteCharAt(rt);
            } else {
                break;
            }
        }
        return sb.length();
    }

    private static boolean stackPrb() {
        String var = "()";
        Stack<Character> list = new Stack();
        boolean boo = true;

        for (int i=0;i<var.length();i++){
            if(var.charAt(i)=='(' || var.charAt(i)=='[' || var.charAt(i) =='{') {
                list.push(var.charAt(i));
            }else{
                char c=list.pop();
                switch (var.charAt(i)) {
                    case ')':
                        if(c!='('){
                            boo = false;
                            return false;
                        }break;
                    case '}':
                        if(c!='{'){
                            boo = false;
                            return false;
                        }break;
                    case ']':
                        if(c!='['){
                            boo = false;
                            return false;
                        }break;
                }
            }
        }
        if(boo){
            return true;
        }else
            return false;
    }


    static void prb2(){
       int var1=0;// 00,   10, 01,    20, 11, 02,   21, 12,   22
       int var2=0;
       int var3=1;
       int arr[][] = new int[4][4];
        for(int i=0;i<4;i++){
            var1=0; var2 = i;
            for(int j=0;j<4 && var1 >= 0 && var2 >= 0 ;j++){

                arr[var2--][var1++] = var3++;
            }
        }
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        Map<Character,Integer> list = new HashMap<>() ;
        list.put('I',1);
        list.put('V',5);
        list.put('X',10);
        list.put('L',50);
        list.put('C',100);
        list.put('D',500);
        list.put('M',1000);

        int sum = 0;
        String s = "MCMXCIV";
        for(int i=0;i<s.length();i++){
            sum += list.get(s.charAt(i));
        }
        System.out.println(sum);

    }

    static void prb1(){
        int [] s={64,2,61,34,9,8,0};
        String result ="";

        for(int i=0;i<s.length-1;i++){
            int temp =0;
            for(int j=i+1;j<s.length;j++){
                int a = s[i]/10 == 0 ? s[i] : s[i]/10 ;
                int b = s[j]/10 == 0 ? s[j] : s[j]/10 ;
                if(a == b && s[i] < s[j]){
                   // if(s[i] < s[j]){
                        temp = s[i];
                        s[i] = s[j];
                        s[j] = temp;
                   // }
                }else if (a < b){
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        for(int ss : s)
           result +=ss;

            System.out.println(result);

    }
}

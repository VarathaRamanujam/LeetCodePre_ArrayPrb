package JavaPrograms;

import java.util.*;

public class ZohoPrb {
    public static void main(String[] args) {
         //prb2();
         // System.out.println(stackPrb());
         //System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));

//        reverseTheAlphaAndNumber("i brought 3 items : a pen, a notebook, and a scale");

//        char[] ch = "string".toCharArray();
//        Arrays.sort(ch);
//        int[] len = {0,0};
//        boolean[] check = new boolean[ch.length];
//        Arrays.fill(check, false);
//        permutation(new String(ch),"", "string", len, check);
//        System.out.println(len[1]);

//        checkReverseSame("azdcbeabaf", "fabaedcbza");

//        digitsPrb(new int[]{3,4,70,15,118});

//        System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));

//        System.out.println(customSortString("exv","xwvee"));

//        System.out.println(pivotInteger(49));

//        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));

//        containsSubArr(new int[]{2,5,3,8,9,1,0,5,8,3}, new int[]{3,8,5});
//          anandPrb("122", "", 0);//need to work

    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];
        left[0] = 1;int pro = nums[0];
        for(int i=1; i<n; i++){
            left[i] =  pro;
            pro *= nums[i];
        }
        right[n-1] =  1; pro = nums[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] =  pro;
            pro *= nums[i];
        }
        for(int i=0; i<n; i++){
            result[i] = left[i]*right[i];
        }
        return result;
    }

    public static int pivotInteger(int n) {
        if(n == 1)return 1;
        int y = n*(n+1)/2;
        int x = (int)Math.sqrt(y);
        System.out.println((int) Math.sqrt(y));
        if(x*x==y) return x;
        else return -1;

//        int sum1 = 1;
//        int sum2 = (n/2) + 1;
//        int i = 1, fr = 1, sd = (n/2)+1;
//        while(i<n/2){
//            sum1 += (++fr);// 1 2 3
//            sum2 += (++sd);
//            i++;
//        } if(n%2 != 0) sum2 += n;
//        while(sum1 <= sum2){
//            sum1 += ++fr;
//            if(sum1 == sum2) return fr;
//            else if( sum1 == (sum1-fr) ){// 15
//                sum2 -= fr;
//                return fr;
//            }else
//                sum2 -= fr;
//        }
//        return -1;
    }

    public static String customSortString(String order, String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder(new String(ch));
        int st = 0;
        int i = 0; int j = 0;
        while(i<order.length() && j<sb.length()){
            char o = order.charAt(i);
            char str = sb.charAt(j);
            if(o == str){
                while(j+1 < sb.length() && sb.charAt(j) == sb.charAt(j+1)){
                    ch[st] = sb.charAt(j);
                    sb.deleteCharAt(j);
                    st++;
                }
                ch[st] = sb.charAt(j);
                sb.deleteCharAt(j);
                st++;
                i++;
                j=-1;
            }
            j++;
        }
        for (int k = 0; k < sb.length(); k++) {
            ch[st++] = sb.charAt(k);
        }
        return new String(ch);
    }

    static void containsSubArr(int[] arr, int[] sub){
        int i = 0; int j = 0;
        while (arr[i] != sub[j]) i++;
         j++;
         if(arr[i-1] == sub[j]){
                j++;
         } else if (arr[i+1] == sub[j]) {

         }

    }

    public static int maxProfit(int[] prices) {
        int preMax = 0;
        int max = 0;
        int min = prices[0];
        int count = 0;
        for(int i=1;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }else{
                int tempMax = 0;
                while(i<prices.length && prices[i]>=min && tempMax<=prices[i]) {
                    tempMax = prices[i];
                    i++;
                }
                --i;
                if(count<2){
                    preMax = max;
                    max = prices[i] - min;
                    min = prices[i];
                    count++;
                    continue;
                }
                preMax = Math.max(max, preMax);
                max = Math.max(max, prices[i] - min);
                min = prices[i];
            }
        }
        return preMax+max;
    }

    static  void digitsPrb(int[] arr){
        Arrays.sort(arr);
        int maxDigit = (int)(Math.log10(arr[arr.length-1])+1);
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int sum = arr[i];
            int temp = 0;
            while (count<maxDigit){
                temp = (temp*10)+(sum%10);
                sum /= 10;
                count++;
            }
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    static  void checkReverseSame(String a, String b){
        int i0 = 0; int j0 = a.length()-1;
        int i1 = 0; int j1 = b.length()-1;
        while (a.charAt(i0) == b.charAt(j1)){
            i0++;
            j1--;
        }
        while (b.charAt(i1) == a.charAt(j0)){
            i1++;
            j0--;
        }
        System.out.println(a.substring(i0, j0+1));
        char[] ch = a.toCharArray();
        while (i0 < j0){
            char temp = ch[i0];
            ch[i0] = ch[j0];
            ch[j0] = temp;
            i0++;
            j0--;
        }
        a = new String(ch);
        System.out.println(a);
        System.out.println(b);

    }

    static void permutation(String s , String op, String res, int[] len, boolean[] check){
        if(op.length() == s.length()){
           len[0] += 1;
            System.out.println(op);
           if (res.equals(op)) {

               len[1] = len[0];
           }
           return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(check[i] || i>0 && (s.charAt(i) == s.charAt(i-1) && check[i] && !check[i-1]))continue;

            check[i] = true;
            char c = s.charAt(i);
            permutation(s, op+c, res, len, check);
            check[i] = false;
        }
    }

    static void reverseTheAlphaAndNumber(String s){
        int i = 0;
        int j = s.length()-1;
        char[] ch = s.toCharArray();
        while (i<j){
            while (!Character.isAlphabetic(ch[i]) && !Character.isDigit(ch[i])) i++;
            while (!Character.isAlphabetic(ch[j]) && !Character.isDigit(ch[j])) j--;

            if (i<j){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println(new String(ch));
    }

    private static void anandPrb(String number, String p, int index) {
        if (p.length() == number.length()){
            System.out.println(p);
            return;
        }else {
            for (int i = index; i < number.length(); i++) {
                char c = number.charAt(i);
                anandPrb(number,p+c, i+1);
            }
        }
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

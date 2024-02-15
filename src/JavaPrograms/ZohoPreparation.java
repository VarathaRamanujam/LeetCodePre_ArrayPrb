package JavaPrograms;

import java.util.ArrayDeque;
import java.util.Stack;

public class ZohoPreparation {

public static void main(String[] args) {
    //parathensis();
    //l2LeftRightSum();

    int arr[][] = {
            {-1,1,0,0},
            {1,1,0,0},
            {0,0,1,-1}
    };
    arr = miniSweeper(arr,0,2);

    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
}

    private static int[][] miniSweeper(int[][] arr, int i, int j) {
        ArrayDeque<Integer[]> ls = new ArrayDeque<>();
        if(arr[i][j] != 0) return arr;
        else {
            arr[i][j] = -2;
            ls.add(new Integer[]{i, j});
            while (!ls.isEmpty()) {
             Integer temp [] =  ls.remove();
             i = temp[0];
             j = temp[1];
                for (int col = i - 1; col < i + 2; col++) {
                    for (int row = j - 1; row < j + 2; row++) {
                        if (col >= 0 && col < arr.length && row >= 0 && row < arr[col].length && arr[col][row] == 0) {
                            ls.add(new Integer[]{row, col});
                            arr[col][row] = -2;
                        }
                    }
                }
            }
        }
        return arr;
    }

    private static void l2LeftRightSum() {
        String s = "40032";
        int sumLeft = 0;
        int sumRight = 0;
        int i = 0;
        int startLeft = 0;
        int endLeft = (s.length()/2 )- 1;
        int startRight = (s.length()/2 ) + 1;
        int endRight = s.length()-1;
        while(i<=s.length()/2){
            if(startLeft<=endLeft) {
                sumLeft +=s.charAt(startLeft)+s.charAt(endLeft);
                startLeft ++;
                endLeft --;
            }
            if(startRight<=endRight){
                sumRight += s.charAt(startRight)+s.charAt(endRight);
                startRight ++;
                endRight --;
            }
            i++;
        }
//        if(sumLeft - sumRight == 0) System.out.println(true);
//        else System.out.println(false);


        int num = 4190732;
        int digit = String.valueOf(num).length();
        int count = digit/2;
        int left = 0;
        int right = 0;
        while(num>0){
            if(count > 0){
                right += num%10;
            } else if (count < 0) {
                left += num%10;
            }
            num/=10;count--;
        }
        System.out.println(right-left ==0);


    }
// @Override
// public void run(){
//   for(int i=0;i<3;i++){
  //      parathensis();
//       //  Thread.sleep(1000);
//   }
// }

public void patternPriting(){
   
    for(int i=1;i<=8;i++){
        for(int j=1;j<=7;j++){
            System.out.print("* ");
        }System.out.println();
    }
}


public static void parathensis(){
   String var = "((";
   Stack<Character> list=new Stack<Character>();
   
    for (int i=0;i<var.length();i++){
        if(var.charAt(i)=='(' || var.charAt(i)=='[' || var.charAt(i) =='{') {
            list.push(var.charAt(i));
        }else{
             char c=list.pop();
            switch (var.charAt(i)) {
                case ')':
                  if(c!='('){
                    System.out.println("Invalid");i=10;
                  }break;
                case '}':
                  if(c!='{'){
                    System.out.println("Invalid");i=10;
                  }break;
                case ']':
                  if(c!='['){
                    System.out.println("Invalid");i=10;
                  }break;
            }
        }
    }
}

}


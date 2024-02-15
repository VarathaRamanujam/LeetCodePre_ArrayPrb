package JavaPrograms;

import java.util.Stack;

public class ZohoPreparation {

public static void main(String[] args) {
    parathensis();
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


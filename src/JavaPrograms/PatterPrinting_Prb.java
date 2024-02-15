package JavaPrograms;

public class PatterPrinting_Prb {
    public static void main(String[] args) {
     /* https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/ */
        //patern1();
        //patern2();
        //patern3();
        //patern4();
        //patern5();
        // patern6();
        //patern7();
        //patern8();
        //patern9();
        //patern10();
        //patern11();
        //patern12();
        //patern13();
        //patern14();
        patern15();
    }

    private static void patern15() {
        int n =10;
        for (int i = 1; i <=n; i++) {
            if(i<=n/2) {
                for (int j = n/2; j >= i; j--) {
                    System.out.print("* ");
                }
                for (int j = 2 ; j <= i; j++) {
                    System.out.print("    ");
                }
                for (int j = n/2; j >= i; j--) {
                    System.out.print("* ");
                }
            }else{
                for (int j = n/2+1 ; j <= i; j++) {
                    System.out.print("* ");
                }
                for (int j = n ; j > i; j--) {
                    System.out.print("    ");
                }
                for (int j = n/2+1 ; j <= i; j++) {
                    System.out.print("* ");
                }
            }System.out.println();
        }
    }

    private static void patern14() {
        int n =10;
        for (int i = 1; i <n; i++) {
            if(i<=n/2) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                for (int j =  n/2 ; j > i; j--) {
                    System.out.print("    ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
            }else{
                for (int j =  n ; j > i; j--) {
                    System.out.print("* ");
                }
                for (int j = n/2+1; j <= i; j++) {
                    System.out.print("    ");
                }
                for (int j =  n ; j > i; j--) {
                    System.out.print("* ");
                }
            }System.out.println();
        }
    }

    private static void patern13() {
        int n =4;
        for (int i = 0; i <2*n-1; i++) {
            for (int j =0 ; j <2*n-1 ;j++) {
               int top = i;
               int left = j;
               int down = (2*n-2)-i;
               int right = (2*n-2)-j;
               int min = Math.min(Math.min(left,right), Math.min(top,down));
                System.out.print(n-min+" ");
            }
            System.out.println();
        }
    }

    private static void patern12() {
        int n =5;
        for (int i = 1; i <=n; i++) {
            char c = (char) ('A'+n-i);
            for (int j =1 ; j <=i ;j++) {
                System.out.print(c++ +" ");
            }
            System.out.println();
        }
    }

    private static void patern11() {
        int n =5;
        for (int i = 1; i <=n; i++) {
            char c ='A';
                for (int j = n; j >= i; j--) {
                    System.out.print("  ");
                }
                for (int j =1 ; j <=2*i-1; j++) {
                    System.out.print(c+" ");
                    if((2*i-1) /2 >= j) c++;
                    else c--;
                }
           System.out.println();
        }
    }

    private static void patern10() {
        int n =5;
        for (int i = 1; i <=n; i++) {
           int start = 1;
            for (int j = 1; j <=i ; j++) {
                System.out.print(start+" ");start++;
            }start--;
            for (int j = n; j >i ; j--) {
                System.out.print("   ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print(start-- +" ");
            }
            System.out.println();
        }
    }

    private static void patern9() {
        int n =5; int start = 0;
        for (int i = 1; i <=n; i++) {
          if(i%2==0) start=1;
          else start=0;
            for (int j = 1; j <=i ; j++) {
                start = 1-start;
                System.out.print(start+" ");
            }
           System.out.println();
        }
    }

    private static void patern8() {
        int n =10;
        for (int i = 1; i <=n; i++) {
            if(i<=n/2) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
            }else{
                for (int j =  n ; j > i; j--) {
                    System.out.print("* ");
                }
            }System.out.println();
        }
    }

    private static void patern7() {
        int n =10;
        for (int i = 1; i <=n; i++) {
            if(i<=n/2) {
                for (int j = 5; j >= i; j--) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= 2*i-1; j++) {
                    System.out.print("* ");
                }
            }else{
                for (int j = 6; j <= i; j++) {
                    System.out.print("  ");
                }
                for (int j = 2 * n - i; j >= i; j--) {
                    System.out.print("* ");
                }
            }System.out.println();
        }
    }

    private static void patern6() {
        int n =5;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("  ");
            }
            for (int j = 2*n-i; j >=i ; j--) {
                System.out.print("* ");
            } System.out.println();
        }
    }

    private static void patern5() {
        int n =5;
        for (int i = 1; i <=n; i++) {
            for (int j = 5; j >=i ; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            } System.out.println();
        }
    }

    private static void patern4() {
        int n =1;
        for (int i = 5; i >=n; i--) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+" ");
            } System.out.println();
        }
    }

    private static void patern3() {
        int n =5;
        for (int i = 1; i <=n; i++) {
            for (int j = 5; j >=i ; j--) {
                System.out.print("* ");
            } System.out.println();
        }
    }

    private static void patern2() {
        int n =5;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+" ");
            } System.out.println();
        }
    }

    private static void patern1() {
        int n =5;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+" ");
            } System.out.println();
        }
    }

}

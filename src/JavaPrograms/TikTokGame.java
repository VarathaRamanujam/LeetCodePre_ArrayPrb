package JavaPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class TikTokGame {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // Loop through each row
        for (int i = 0; i < board.length; i++) {
            // Loop through each column in the current row
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' '; // Set the value to space
            }
        }

        displayTheBoard(board);
        boolean isGameOver = false;
        Scanner sc = new Scanner(System.in);
        char p = 'X';
        while (!isGameOver){
            System.out.println("Your Time Player "+ p+" : ");
            int row = sc.nextInt();
            int col = sc.nextInt();
           if( placeTheInputOnBoard(board, row, col, p) ){
               isGameOver =  checkWinOrContinue(board, row, col, p);
               if(!isGameOver) p = p == 'X' ? '0' : 'X';//switch the player
           }else {
               System.out.println("Enter a Valid Place ...");
           }
        }
        if (isGameOver) System.out.println("The Winner is : "+p);
    }

    private static boolean placeTheInputOnBoard(char[][] board, int row, int col, char p) {
        if( board[row][col] == ' '){
            board[row][col] = p;
            displayTheBoard(board);
            return true;
        }else  return false;
    }

    private static boolean checkWinOrContinue(char[][] board, int row, int col, char p) {
        int count1 = 0;int count2 = 0;int count3 = 0;int count4 = 0;
        //check row wise
        //check col wise
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == p )count1++;
            if(board[i][col] == p )count2++;
        }
        if(count1 == board.length || count2 == board.length) return true;
        //check Diagonal wise
        for (int j = 0; j < board.length ; j++) {
            for (int i = 0; i < board.length; i++) {
                if ( i==j && board[j][i] == p) count3++;
                if ( i+j == board.length && board[j][i] == p) count4++;
            }
        }
        if(count3 == board.length || count4 == board.length) return true;
        return  false;
    }

    static void   displayTheBoard(char[][] board){
        for (int j=0;j<board.length;j++){
            for (int i=1; i>=1;i--){
                System.out.println("-------------");
            }
            for (int i=0;i<board[j].length;i++){
                System.out.print("| "+board[j][i]+" ");
                if (i == board.length-1) System.out.print("|");
            }
            System.out.println();
            if (j == board.length-1) System.out.println("-------------");
        }
    }
}

package JavaPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nth_Queen {
    public static void main(String[] args) {
//        int n = 4;
//        List<List<String>> res = new ArrayList<>();
//        boolean[][] board = new boolean[n][n];
//        List<String> ls = new ArrayList<>();
//        QueenAssemble(board, 0, 0, res, ls);
//        System.out.println(res);

        int n = 4;
        List<List<String>> res = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        kNightAssemble(board, 0, 0, res, ls, 4);
        System.out.println(res);
    }

    static void kNightAssemble(boolean[][] board, int row, int col, List<List<String>> res, List<String> ls, int count){
        if (row == 4) return;
        if(count == 0){
            //".Q..","...Q","Q...","..Q."
            for (boolean[] booleans : board) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if(booleans[j])  sb.append("K");
                    else sb.append(".");
                }
                ls.add(sb.toString());
            }
            System.out.println(ls);
            //res.add(new ArrayList<>(ls));
            ls.clear();
            return;
        }if(col == board.length){
            row += 1;
            col = 0;
            Set<List<Integer>> re = new HashSet<>();
        }
        for (int i = col; i < board.length; i++) {
            if (row == 4) return;
            if(kNightChecker(board, row, i)){
                board[row][i] = true;
                kNightAssemble(board, row, col+1, res, ls, count-1);
                board[row][i] = false;
            }kNightAssemble(board, row, col+1, res, ls, count);
        }
    }

    static boolean kNightChecker(boolean[][] board, int row , int col){
        int len = board.length;int rw = row; int cl = col;
        if (row-2 >= 0 && col+1 < len) {
            if(board[row-2][col+1]) return false;
        }
        if (row-2 >= 0 && col-1 >= 0) {
            if(board[row-2][col-1]) return false;
        }
        if (row+2 < len && col+1 < len) {
            if(board[row+2][col+1]) return false;
        }
        if (row+2 < len && col-1 >= 0) {
            if(board[row+2][col-1]) return false;
        }

        if (row-1 >= 0 && col+2 < len) {
            if(board[row-1][col+2]) return false;
        }
        if (row+1 < len && col-2 >= 0) {
            if(board[row+1][col-2]) return false;
        }
        if (row+1 < len && col+2 < len) {
            if(board[row+1][col+2]) return false;
        }
        if (row-1 >= 0 && col-2 >= 0) {
            return !board[row - 1][col - 2];
        }
        return true;
    }

   static void QueenAssemble(boolean[][] board, int row, int col, List<List<String>> res, List<String> ls){
        if(row == board.length ){
            //".Q..","...Q","Q...","..Q."
            for (boolean[] booleans : board) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if(booleans[j])  sb.append("Q");
                    else sb.append(".");
                }
                ls.add(sb.toString());
            }
            res.add(new ArrayList<>(ls));
            ls.clear();
            return;
        }
        for(int i=0;i<board.length;i++){
            if(checker(board, row, i)){
                board[row][i] = true;
                QueenAssemble(board, row+1, col, res, ls);
                board[row][i] = false;
            }
        }
    }
    static boolean checker(boolean[][] board, int row , int col){
        for(int i=row; i>=0; i--){
            if(board[i][col]) return false;
        }
        int leftCh = Math.min(row,col);int lf = row, up = col;
        for(int i=0;i<=leftCh;i++){
            if(board[lf--][up--]) return false;
        }
        int rightCh = Math.min(row, board.length-1-col);lf = row; up = col;
        for(int i=0;i<=rightCh;i++){
            if(board[lf--][up++]) return false;
        }
        return true;
    }
}

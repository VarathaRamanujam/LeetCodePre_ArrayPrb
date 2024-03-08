package JavaPrograms;

import java.util.*;

public class BackTracking {
    public static void main(String[] args) {
       //System.out.println(mazeGameCount(3, 3));

       List<List<String>> res = new ArrayList<>();
//       mazeGamePath(3, 3, res,new ArrayList<>());
//       System.out.println(res);

       //mazeGamePathWithDiagonal(0, 0, res,new ArrayList<>());
        boolean[][] game = new boolean[][]{{true,true,true},{true,true,true},{true,true,true}};
//        mazeGameWithObstract(2,2, res, new ArrayList<>(), game);
//        System.out.println(res);

        //mazePath_UD_LR(0,0, res, new ArrayList<>(), game);

//        mazePath_UD_LR_steps(0,0, res, new ArrayList<>(), game, 1, new int[3][3]);
//        System.out.println(res);

        List<Integer> ls = new ArrayList<>();
        int[][] totalSum = new int[18][16];
        for (int i = 0; i < totalSum.length; i++) {
            Arrays.fill(totalSum[i],-1);
        }
        System.out.println(minPath(new int[][]{{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}}, 0, 0, 0, ls, totalSum));
        //System.out.println(ls);
    }

   static int minPath(int[][] grid, int row, int col, int sum, List<Integer> ls, int[][] totalSum){
        if (row>=grid.length || col>=grid[0].length) return  Integer.MAX_VALUE;
        if(row == grid.length-1 && col == grid[0].length-1){
          return  grid[row][col];
        }
           if (totalSum[row][col] != -1) return totalSum[row][col];
           int  down = minPath(grid, row+1, col, sum, ls, totalSum);
           int  right = minPath(grid, row, col+1, sum, ls, totalSum);
           int ans = Math.min(down,right);
           totalSum[row][col]=ans;
           return ans;
    }

    static void mazePath_UD_LR_steps( int row, int col, List<List<String>> res, ArrayList<String> ls, boolean[][] game, int step, int[][] p){
        if(row == game.length-1 && col == game.length-1 ) {
            p[row][col] = step;
            for (int[] i: p)
             System.out.println(Arrays.toString(i));
            System.out.println(new ArrayList<>(ls));
            System.out.println();
            return ;
        }
        if (!game[row][col]){
            return;
        }
        game[row][col] = false;
        p[row][col] = step;
        if (col<game.length-1) {
            ls.add("R");
            mazePath_UD_LR_steps(row, col + 1, res, ls, game, step+1, p);
            ls.remove(ls.size() - 1);
        }
        if(row<game.length-1) {
            ls.add("D");
            mazePath_UD_LR_steps(row + 1, col, res, ls, game, step+1, p);
            ls.remove(ls.size() - 1);
        }
        if(row>0){
            ls.add("U");
            mazePath_UD_LR_steps(row - 1, col, res, ls, game, step+1, p);
            ls.remove(ls.size() - 1);
        }
        if (col>0){
            ls.add("L");
            mazePath_UD_LR_steps(row , col-1, res, ls, game, step+1, p);
            ls.remove(ls.size() - 1);
        }
        p[row][col] = 0;
        game[row][col] = true;
    }

    static void mazePath_UD_LR( int row, int col, List<List<String>> res, ArrayList<String> ls, boolean[][] game){
        if(row == game.length-1 && col == game.length-1 ) {
            res.add(new ArrayList<>(ls));
            return ;
        }
        if (!game[row][col]){
            return;
        }
        game[row][col] = false;
        if (col<game.length-1) {
            ls.add("R");
            mazePath_UD_LR(row, col + 1, res, ls, game);
            ls.remove(ls.size() - 1);
        }
        if(row<game.length-1) {
            ls.add("D");
            mazePath_UD_LR(row + 1, col, res, ls, game);
            ls.remove(ls.size() - 1);
        }
        if(row>0){
            ls.add("U");
            mazePath_UD_LR(row - 1, col, res, ls, game);
            ls.remove(ls.size() - 1);
        }
        if (col>0){
            ls.add("L");
            mazePath_UD_LR(row , col-1, res, ls, game);
            ls.remove(ls.size() - 1);
        }
        game[row][col] = true;
    }

    static void mazeGameWithObstract( int row, int col, List<List<String>> res, ArrayList<String> ls, boolean[][] game){
        if(row == 0 && col == 0 ) {
            res.add(new ArrayList<>(ls));
            return ;
        }
        if (col>=0 && row>=0 && !game[row][col]) return;
        if (col>0) {
            ls.add("D");
            mazeGameWithObstract(row, col - 1, res, ls, game);
            ls.remove(ls.size() - 1);
        }
        if(row>0) {
            ls.add("R");
            mazeGameWithObstract(row - 1, col, res, ls, game);
            ls.remove(ls.size() - 1);
        }
    }

    static void mazeGamePathWithDiagonal( int row, int col, List<List<String>> res, ArrayList<String> ls){
        if(row == 2 && col == 2) {
            res.add(new ArrayList<>(ls));
            return ;
        }

        if (col<3) {
            ls.add("D");
            mazeGamePathWithDiagonal(row, col + 1, res, ls);
            ls.remove(ls.size() - 1);
        }
        if(row<3) {
            ls.add("R");
            mazeGamePathWithDiagonal(row + 1, col, res, ls);
            ls.remove(ls.size() - 1);
        }
        if (row<3 && col<3){
            ls.add("X");
            mazeGamePathWithDiagonal(row+1, col+1, res, ls);
            ls.remove(ls.size()-1);
        }
    }

    static void mazeGamePath( int row, int col, List<List<String>> res, ArrayList<String> ls){
        if(row == 1 && col == 1) {
            res.add(new ArrayList<>(ls));
            return ;
        }

        if (col>1) {
            ls.add("D");
            mazeGamePath(row, col - 1, res, ls);
            ls.remove(ls.size() - 1);
        }
        if(row>1) {
            ls.add("R");
            mazeGamePath(row - 1, col, res, ls);
            ls.remove(ls.size() - 1);
        }
    }

    static int mazeGameCount( int row, int col){
        if(row == 1 || col == 1) {
            return 1;
        }
        int count = 0;
        count += mazeGameCount(row, col-1);
        count += mazeGameCount(row-1, col);
        return count;
    }
}


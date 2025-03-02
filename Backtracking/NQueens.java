package Backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println(Queens(board,0));
    }
    public static int Queens(boolean[][] board, int r){
        if(r == board.length){
            displayQueens(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for(int i = 0 ; i < board[0].length ; i++){
            if(isSafe(board , r, i)){
                board[r][i] = true;
                count+=Queens(board,r+1);
                board[r][i] = false;
            }
        }
        return count;
    }
    public static boolean isSafe(boolean[][] board , int r , int c){
        for(int i = 0 ; i < r ; i ++){
            if(board[i][c]){
                return false;
            }
        }
        int maxLeft = Math.min(r,c);
        for(int i = 0 ; i <= maxLeft ; i++){
            if(board[r-i][c-i]) return false;
        }
        int maxRight = Math.min(r,board.length - c - 1);
        for(int i = 0 ; i <= maxRight ; i++ ){
            if(board[r-i][c+i]) return false;
        }
        return true;
    }
    public static void displayQueens(boolean[][] board){
        for(boolean[] row : board){
            for (boolean elements : row){
                if(elements){
                    System.out.print('Q'+" ");
                }
                else{
                    System.out.print('X'+" ");
                }
            }
            System.out.println();
        }
    }
}
